package com.dcits;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.MalformedJsonException;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.streaming.Seconds;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.elasticsearch.spark.rdd.api.java.JavaEsSpark;
import org.elasticsearch.spark.sql.api.java.JavaEsSparkSQL;
import org.elasticsearch.spark.streaming.api.java.JavaEsSparkStreaming;
import org.spark_project.guava.collect.ImmutableList;
import org.spark_project.guava.collect.ImmutableMap;

import scala.Tuple2;

/**
 * <h1>Use Spark to get and write elasticsearch data.</h1>
 * <p>
 * <b>Note:</b>This class use spark and spark streaming method, which will be
 * split to two class later.
 * 
 * @author kongxw@dcits.com
 * @version 1.0.0
 * @since 2019-10-19
 */
public class SparkES {

    private Map<String, String> sparkProperties;
    private SparkConf conf;
    private JavaSparkContext sc;
    private String sparkMaster;
    private String appName;
    private String esHost;
    private static Double sumDur = 0.0;
    public void init() {

        sparkMaster = "local[*]";
        appName = "SparkFileSumApp";
        esHost = "10.7.19.116:30963";
        sparkProperties = new LinkedHashMap<>();
        conf = new SparkConf().setMaster(sparkMaster).setAppName(appName);

        sparkProperties.put("spark.ui.enabled", "false");
        // don't die if there are no spans
        sparkProperties.put("es.index.read.missing.as.empty", "true");
        // sparkProperties.put("es.nodes.wan.only", "false");
        sparkProperties.put("es.net.ssl.keystore.location", "");
        sparkProperties.put("es.net.ssl.keystore.pass", "");
        sparkProperties.put("es.net.ssl.truststore.location", "");
        sparkProperties.put("es.net.ssl.truststore.pass", "");

        conf.set("es.nodes", esHost);
        conf.set("es.nodes.discovery", "false");
        conf.set("es.nodes.client.only", "false");
        conf.set("es.nodes.wan.only", "true");
        sc = new JavaSparkContext(conf);

    }

    /**
     * This method is used to test spark. This is a the simplest form of a class
     * method, just to show the usage spark within elasticsearch.
     */
    public void sparkTest() {

        // JavaRDD<Map<String, Object>> links =
        // JavaEsSpark.esJsonRDD(sc, "zipkin:span-2019-10-16/span")
        // .groupBy(JSON_TRACE_ID)
        // .flatMapValues(new TraceIdAndJsonToDependencyLinks(logInitializer,
        // SpanBytesDecoder.JSON_V2))
        // .values()
        // .mapToPair(l -> Tuple2.apply(Tuple2.apply(l.parent(), l.child()), l))
        // .reduceByKey((l, r) -> DependencyLink.newBuilder()
        // .parent(l.parent())
        // .child(l.child())
        // .callCount(l.callCount() + r.callCount())
        // .errorCount(l.errorCount() + r.errorCount())
        // .build())
        // .values()
        // .map(DEPENDENCY_LINK_JSON);
        JavaRDD<String> input = sc.textFile("/Users/kongxiangwen/dev/big-data-arch/spark-learn/data.txt");
        JavaRDD<String> numberStrings = input.flatMap(s -> Arrays.asList(s.split(" ")).iterator());
        JavaRDD<String> validNumberString = numberStrings.filter(string -> !string.isEmpty());
        JavaRDD<Long> numbers = validNumberString.map(numberString -> Long.valueOf(numberString));
        Long finalSum = numbers.reduce((x, y) -> x + y);

        System.out.println("Final sum is: " + finalSum.toString());

    }

    /**
     * This method is used to query elasticsearch data.
     */
    public void queryES() {

        try {

            JavaPairRDD<String, Map<String, Object>> esRDD = JavaEsSpark.esRDD(sc, "spark/docs");
            esRDD.foreach(m -> {
                System.out.println(m);
                System.out.println(m._1());
                System.out.println(m._2());
            });

            JavaRDD<Map<String, Object>> esRDD2 = JavaEsSpark.esRDD(sc, "spark/docs").values();

            esRDD2.foreach(m -> {
                m.forEach((k, v) -> {
                    System.out.println(k + "----");
                    System.out.println(v);
                });
                System.out.println(m);
            });

            JavaPairRDD<String, String> ses = JavaEsSpark.esJsonRDD(sc, "spark/docs");
            ses.foreach(m -> {
                System.out.println(m);
                System.out.println(m._1());
                System.out.println(m._2());
            });

        } finally {
            sc.stop();
        }
    }

    static final Function<Tuple2<String, String>, String> JSON_TRACE_ID = new Function<Tuple2<String, String>, String>() {
        /** returns the lower 64 bits of the trace ID */
        @Override public String call(Tuple2<String, String> pair) throws IOException {
          JsonReader reader = new JsonReader(new StringReader(pair._2));
          reader.beginObject();
          while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("traceId")) {
              String traceId = reader.nextString();
              return traceId.length() > 16 ? traceId.substring(traceId.length() - 16) : traceId;
            } else {
              reader.skipValue();
            }
          }
          throw new MalformedJsonException("no traceId in " + pair);
        }
    
        @Override public String toString() {
          return "pair._2.traceId";
        }
      };

    /**
     * This method is used to query span data of hystrix generated by zipkin and use elasticsearch as storage.
     * <b>Note:</b> Combinekey defination:
     * <pre>
     * {@code 
     *  def combineByKey[C](createCombiner: V => C, mergeValue: (C, V) => C, mergeCombiners: (C, C) => C)
     *  RDD[(K, C)] = {
     *  combineByKey(createCombiner, mergeValue, mergeCombiners, defaultPartitioner(self))
     *   }
     * }
     * </pre>
     */
    public void queryZipkinHystrix() {

        try {
            
            SQLContext sqlc = new SQLContext(sc);  
            Dataset<Row> spans  = sqlc.read().format("org.elasticsearch.spark.sql").load("zipkin:span-*");
            spans.registerTempTable("spans");
            //spans.printSchema();
            Dataset<Row> spans_ret = sqlc.sql("SELECT duration from spans where name='hystrix'"); 
            JavaRDD<Long> intermediateRet = spans_ret.toJavaRDD()
                            .map(r -> r.toString())
                            .filter(s -> !s.isEmpty())
                            .map(s -> s.substring(1,s.length()-1))
                            .filter(s -> !s.isEmpty())
                            .map(numberString -> Long.valueOf(numberString));
            long sumNum = intermediateRet.reduce((x, y)->x+y);
            long avgNum = intermediateRet.mapToPair(n ->  new Tuple2<>("hystrix", n))
                            .combineByKey(v -> new Tuple2<>(v, 1),  
                                (t, v) -> new Tuple2<>(t._1() + v, t._2() + 1),
                                (a, b) -> new Tuple2<>(a._1() + b._1(), a._2() + b._2()))   
                            .mapToPair(info -> new Tuple2<>(info._1(), info._2()._1()/info._2()._2()))
                            .collect()
                            .get(0)._2();
            // System.out.println("Final result: "+finalNum);  
                //spans_ret.foreach(s->Arrays.asList(s));   
                // for (Row row : spans_ret.collectAsList()) {  
                //         System.out.println(row.toString());  
                //     }
            System.out.println("Final result: sum:"+sumNum + " avg:"+ avgNum+" count:"+intermediateRet.count());
            spans.printSchema();     
        } finally {
            sc.stop();
        }
    }


    /**
     * This method is used to query span data of http generated by zipkin and use elasticsearch as storage.
     * <b>Note:</b> Combinekey defination:
     * <pre>
     * {@code 
     *  def combineByKey[C](createCombiner: V => C, mergeValue: (C, V) => C, mergeCombiners: (C, C) => C)
     *  RDD[(K, C)] = {
     *  combineByKey(createCombiner, mergeValue, mergeCombiners, defaultPartitioner(self))
     *   }
     * }
     * </pre>
     */
    public void queryZipkinHttp() {

       String queryStr = "{"+
       " \"query\": { "+
        "       \"bool\": {"+
            "       \"must\" : ["+
            "        {\"term\":{\"_q\":\"http.method\"}}"+
            "       ]"+
            "    }"+
            "  }"+
            "}";
            
        try {
            JavaPairRDD<String, String> rdd = JavaEsSpark.esJsonRDD(sc, "zipkin-span-2020-07-04", queryStr);
            
            JavaRDD<Double> interRet = rdd.map(tu -> {
                //JSONObject jsonObj = (JSONObject)(new JSONParser().parse(tu._2()));
                Gson gson = new Gson();
                Map map = gson.fromJson(tu._2(), Map.class);
                Double duration = (Double)map.get("duration");
                return duration;
            }).filter(m-> m != null);
            Double sumDur = interRet.reduce((x,y)->(x+y));


            Double avgDur = interRet.mapToPair(n ->  new Tuple2<>("http", n))
            .combineByKey(v -> new Tuple2<>(v, 1),  
                (t, v) -> new Tuple2<>(t._1() + v, t._2() + 1),
                (a, b) -> new Tuple2<>(a._1() + b._1(), a._2() + b._2()))   
            .mapToPair(info -> new Tuple2<>(info._1(), info._2()._1()/info._2()._2()))
            .collect()
            .get(0)._2();

            // JavaRDD<Double> rdd2  = rdd.map(tu -> {
            //     //JSONObject jsonObj = (JSONObject)(new JSONParser().parse(tu._2()));
            //     Gson gson = new Gson();
            //     Map map = gson.fromJson(tu._2(), Map.class);
            //     Double duration = (Double)map.get("duration");
            //     return duration;
            // });

            //Double sumDur = rdd2.reduce((x,y)->x+y);
            
            // rdd2.foreach(m -> {
            //     //System.out.println(m);
            //     if(m != null){
            //         sumDur += m;
            //     }
            // }); 
            
            System.out.println("Final result: sum:"+sumDur + " avg:"+ avgDur+" count:"+interRet.count());
        } finally {
            sc.stop();
        }
    }


    /**
     * This method is used to save es data to elasticsearch by sql syntax.
     */
    public void saveToESBySql() {

        try {
            
            SQLContext sqlc = new SQLContext(sc);  
  
            List<People> data = new ArrayList<People>();  
            data.add(new People(1, "Micheal", "Mike", 18));  
            data.add(new People(2, "Flowaters", "fw", 18));  
           // sqlc.cre

            Dataset<Row> people = sqlc.createDataFrame(data, People.class);  
  
            JavaEsSparkSQL.saveToEs(people, "person/test");  

        } finally {
            sc.stop();
        }
    }


    /**
     * This method is used to query es data to elasticsearch by sql syntax.
     */

    public void queryESBySql() {

        try {
            
            SQLContext sqlc = new SQLContext(sc);  
  
            Dataset<Row> people  = sqlc.read().format("org.elasticsearch.spark.sql").load("person/test");
            //Dataset<Row> people  = sqlc.read().format("org.elasticsearch.spark.sql").load("zipkin:span-*");
            
            //people.filter(condition)
            //people.filter(people("arrival").equalTo("OTP").and(df("days").gt(3))
            people.registerTempTable("people");
            people.printSchema();
           
            Dataset<Row> people2 = sqlc.sql("SELECT * from people where surname='Mike'"); 
           
            for (Row row : people2.collectAsList()) {  
                System.out.println(row.toString());  
            }
            
        } finally {
            sc.stop();
        }
    }

    /**
     * This method is used to save elasticsearch data by spark.
     */
    public void saveToES() {

        try {

            Map<String, ?> numbers = ImmutableMap.of("one", 1, "two", 2);
            Map<String, ?> airports = ImmutableMap.of("OTP", "Otopeni", "SFO", "San Fran");

            JavaRDD<Map<String, ?>> javaRDD = sc.parallelize(ImmutableList.of(numbers, airports));
            JavaEsSpark.saveToEs(javaRDD, "spark/docs");

        } finally {
            sc.stop();
        }
    }

    /**
     * <b>Save data to elasticsearch by Spark Streaming.</b>
     */
    public void saveToESStreaming() {

        JavaStreamingContext jssc = new JavaStreamingContext(sc, Seconds.apply(1));

        Map<String, ?> numbers = ImmutableMap.of("one", 1, "two", 2);
        Map<String, ?> airports = ImmutableMap.of("OTP", "Otopeni", "SFO", "San Fran");

        JavaRDD<Map<String, ?>> javaRDD = sc.parallelize(ImmutableList.of(numbers, airports));
        Queue<JavaRDD<Map<String, ?>>> microbatches = new LinkedList<>();
        microbatches.add(javaRDD);
        JavaDStream<Map<String, ?>> javaDStream = jssc.queueStream(microbatches);

        JavaEsSparkStreaming.saveToEs(javaDStream, "spark-streaming/docs");

        jssc.start();
        try {
            jssc.awaitTermination();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * <b>Query data to elasticsearch by Spark Streaming</b>
     * Todo, elasticsearch-spark module do not supports this feature now.
     */
    public void queryESStreaming() {

        JavaStreamingContext jssc = new JavaStreamingContext(sc, Seconds.apply(1));

        Map<String, ?> numbers = ImmutableMap.of("one", 1, "two", 2);
        Map<String, ?> airports = ImmutableMap.of("OTP", "Otopeni", "SFO", "San Fran");

        JavaRDD<Map<String, ?>> javaRDD = sc.parallelize(ImmutableList.of(numbers, airports));
        Queue<JavaRDD<Map<String, ?>>> microbatches = new LinkedList<>();
        microbatches.add(javaRDD);
        JavaDStream<Map<String, ?>> javaDStream = jssc.queueStream(microbatches);

        JavaEsSparkStreaming.saveToEs(javaDStream, "spark-streaming/docs");




        //JavaPairRDD<String, String> ses = JavaEsSpark.esJsonRDD(sc, "spark/docs");
        //microbatches.add(ses);
       // JavaEsSparkStreaming.
        // ses.foreach(m -> {
        //     System.out.println(m);
        //     System.out.println(m._1());
        //     System.out.println(m._2());
        // });

        jssc.start();
        try {
            jssc.awaitTermination();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}