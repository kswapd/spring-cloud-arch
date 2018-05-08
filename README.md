# spring-cloud-arch

#### Introduce
bank micro-service architecture powered by Spring Cloud

#### Archetecture



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
then you can access consumer service 
```
http://localhost:3001/ribbon-consumer
http://localhost:3001/ribbon-consumer-book
```



#### Contributor

1. Fork by kongxw@dcits.com
2. 
3. Pull Request


### Notice
1. If meet dependency problem, use command: mvn clean install
