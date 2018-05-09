# spring-cloud-arch
--------------------------------------------


## Introduction
banking micro-service architecture powered by Spring Cloud

## Preparation
  1. **JDK** version `1.8.0_102` or later
  2. **maven** version `Apache Maven 3.3.9` or later
  3. Use `eclipse` or `IntelliJ IDEA` as Java IDE

## Install

```mvn clean install```

## How to use

### 1. Run eureka server
```
cd eureka-server/target
java -jar eureka-server-1.0-SNAPSHOT.jar
```

### 2. Run service supplier
```
cd hello-service/target
java -jar hello-service-1.0-SNAPSHOT.jar --server.port=2001
java -jar hello-service-1.0-SNAPSHOT.jar --server.port=2002
```
Then you can access service at:
```
http://localhost:2001/hello
http://localhost:2001/getbook
```

### 3. Run service ribbon consumer
```
cd ribbon-consumer/target
java -jar ribbon-consumer-1.0-SNAPSHOT.jar --server.port=3001
```
Then you can access ribbon consumer service 
```
http://localhost:3001/ribbon-consumer
http://localhost:3001/ribbon-consumer-book
```

### 4. Run service feign consumer
```
cd feign-consumer/target
java -jar feign-consumer-1.0-SNAPSHOT.jar
```
Then you can access feign consumer service 
```
http://10.88.2.102:3501/feign-consumer
```

### 5. Run hystrix dashboard
```
cd hystrix-dashboard/target
java -jar hystrix-dashboard-1.0-SNAPSHOT.jar
```
Then you can access hystrix dashboard service 
```
http://localhost:4001/hystrix
```
You can input stream url ` http://localhost:3001/hystrix.stream ` to monitor ribbon-consumer service hystrix status

### 6. Run turbine service to monitor consumer service at multi-host
```
cd turbine/target
java -jar turbine-1.0-SNAPSHOT.jar
```
Then you can monitor ribbon-consumer service hystrix status by inputting turbine stream url ```http://localhost:5001/turbine.stream``` to hystrix dashboard

### 7. Run api gateway zuul
```
cd zuul/target
java -jar zuul-1.0-SNAPSHOT.jar
```
Then you can access service routed by zuul url
`http://localhost:6001/hello-service/hello?login=a`, this service will be routed to `http://localhost:2001/hello`

If you access `http://localhost:6001/hello-service/hello`, this service will be validated by zuul and you will get "invalid access" response.

### 8. Run config server service

```
cd config-server/target
java -jar config-server-1.0-SNAPSHOT.jar
```

Config service runs at `http://10.88.2.101:6100/`, you can get configuration info  at `http://10.88.2.101:6100/config-client/dev`.
    This config-server service use `https://gitee.com/kswapd/spring-cloud-config.git` as configuration files repository, all configuration files are stored in folder `config-repo.`



### 9. Run config client service
```
cd config-client/target
java -jar config-client-1.0-SNAPSHOT.jar
```

Then access url `http://10.88.2.101:6200/sang`, you will get property `sang` value.

#### configuration refreshing test

First open `https://gitee.com/kswapd/spring-cloud-config.git/config-repo/config-client-dev.properties` to edit this file, modify `sang` value,  and then Open software **Postman** to send post request `POST 
 http://localhost:6200/refresh` to notify config-client service to refresh property, re-open url `http://10.88.2.101:6200/sang`, you will find the property `sang` value has been updated as git repository.



## Development Instructions
**MUST** follow the instructions of **NOTE** section.
* Please install `JDK 1.8` before build the project.
* **MUST NOT** add any domain logics to this project.
* **MUST NOT** push any jar files, use maven dependency instead.
* **MUST NOT** push any unnecessary binary files.
* **MUST** push source code with meaningful message `git commit -m "meaningful message"`.
* **MUST** import `codequality/codestyle-formatter.xml`, and **format source code** (CTRL+SHIFT+F) and **organize imports** (CTRL+SHIFT+O) before commit.
* **MUST** use standard `JavaDoc Tags` on all java source code.
* **SHOULD** use `English` in JavaDoc, comments and any source code related resources **as possible**.
* **SHOULD** follow [Java Coding Conventions](http://www.oracle.com/technetwork/java/codeconventions-150003.pdf) and [Java Style Guide](https://google.github.io/styleguide/javaguide.html) if you haven't to improve code quality.


## Contributor

### 1. Fork by kongxw@dcits.com
### 2. Pull Request


## Pre-acquisition 


## Problems
 1. If meet dependency problem, run `mvn clean install`


## Other resource

* [Spring Cloud learning](https://blog.csdn.net/u012702547/article/details/78717512 "learning")
