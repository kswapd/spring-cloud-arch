package com.dcits;

import java.util.Arrays;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;

/**
 * <h1>Elasticsearch data processing by Spark</h1>
 *<p>
 * @author kongxw@dcits.com
 * @version 1.0.0
 * @since 2019-10-17
 */
public class App 
{
    public static void main( String[] args )
    {

        SparkES ses = new SparkES();
        ses.init();
       //ses.sparkTest();
        //ses.queryES();
       // ses.queryZipkin();

        //ses.saveToES();
        //ses.saveToESStreaming();
       //ses.saveToESBySql();
        //ses.queryESBySql();
        ses.queryZipkinHttp();
    }
}

