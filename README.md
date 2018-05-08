# spring-cloud-arch

#### Introduce
banking micro-service architecture powered by Spring Cloud

#### Architecture



#### Install

```mvn clean install```

#### How to use

1. Start eureka server
```
cd eureka-server/target
java -jar eureka-server-1.0-SNAPSHOT.jar
```

2. Start service supplier
```
cd hello-service/target
java -jar hello-service-1.0-SNAPSHOT.jar --server.port=2001
java -jar hello-service-1.0-SNAPSHOT.jar --server.port=2002
```
then you can access service at:
```
http://localhost:2001/hello
http://localhost:2001/getbook
```

3. Start service ribbon consumer
```
cd ribbon-consumer/target
java -jar ribbon-consumer-1.0-SNAPSHOT.jar --server.port=3001
```
then you can access ribbon consumer service 
```
http://localhost:3001/ribbon-consumer
http://localhost:3001/ribbon-consumer-book
```

4. Start service feign consumer
```
cd feign-consumer/target
java -jar feign-consumer-1.0-SNAPSHOT.jar
```
then you can access feign consumer service 
```
http://10.88.2.102:3501/feign-consumer
```

5. Start hystrix dashboard
```
cd hystrix-dashboard/target
java -jar hystrix-dashboard-1.0-SNAPSHOT.jar
```
then you can access hystrix dashboard service 
```
http://localhost:4001/hystrix
```
you can input stream url:``` http://localhost:3001/hystrix.stream ``` to monitor ribbon-consumer service hystrix status

6. Start turbine service to monitor consumer service at multi-host
```
cd turbine/target
java -jar turbine-1.0-SNAPSHOT.jar
```
then you can monitor ribbon-consumer service hystrix status by inputting turbine stream url ```http://localhost:5001/turbine.stream``` to hystrix dashboard

7. Start api gateway zuul
```
cd zuul/target
java -jar zuul-1.0-SNAPSHOT.jar
```
then you can access service routed by zuul
```http://localhost:6001/hello-service/hello?login=a```, this service will be routed to ```http://localhost:2001/hello```




#### Contributor

1. Fork by kongxw@dcits.com
2. 
3. Pull Request


### Notice
1. If meet dependency problem, use command: mvn clean install
