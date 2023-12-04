## [Main title](/README.md)


# Observability and Monitoring Loggings
+ [Why do we need Observability and Monitoring Loggings?](#why-do-we-need-observability-and-monitoring-loggings)
+ [What is Observability?](#what-is-observability)
+ [What is difference between Metrics, Logs and Traces in Observability?](#what-is-difference-between-metrics-logs-and-traces-in-observability)
+ [What is the best Practices in Distributed Logging?](#what-is-the-best-practices-in-distributed-logging)
+ [What is the Metrics?](#what-is-the-metrics)
+ [What is the Five (Golden) Types of Signals in Metrics?](#what-is-the-five-golden-types-of-signals-in-metrics)


## Logback
+ [What is difference between SLF4J, Logback and Log4j?](#what-is-difference-between-slf4j-logback-and-log4j)
+ [What is difference between springProfile, appender, và encoder in Logback?](#what-is-difference-between-springprofile-appender-và-encoder-in-logback)



## Sumo Logic
+ [What is Sumo Logic?](#what-is-sumo-logic)
+ [What is difference between Sumo Logic and another tools?](#what-is-difference-between-sumo-logic-and-another-tools)
+ [What is difference Ingestion Path and The Search Path?](#what-is-difference-ingestion-path-and-the-search-path)
+ [What is Metadata Tab?](#what-is-metadata-tab)
+ [What is "Log Message Inspector"?](#what-is-log-message-inspector)




----

### Why do we need Observability and Monitoring Loggings?
- Debuging problem microservices
    + How do we trace transactions across multiple services, containers and try to Find where exactly the problem or bug is?
    + How do we combine all the logs from multiple services into a central location where they can be indexed, searched, filtered, and grouped to 
    + Find bugs that are contributing to a problem? 

- Monitoring performance of service calls
    + How can we track the path of a specific chain service call through our microservices network, and see how
long it took to complete at each microservice?

- Monitoring services metric and health
    + How can we easily and efficiently monitor the metrics like CPU usage, JVM metrics, etc. For all the microservices applications in our network?
    + How can we monitor the status and health of all of our microservices applications in a single place, and create alerts and notifications For any abnormal behavior of the services?

[Table of Contents](#observability-and-monitoring-loggings)


### What is Observability?
- **Observability** is the ability to understand the internal state of a system by observing its outputs. In the context of microservices, observability is achieved by collecting and analyzing data from a variety of sources, such as metrics, logs, and traces.

![Alt text](./images/Observability.png)

[Table of Contents](#observability-and-monitoring-loggings)

### What is difference between Metrics, Logs and Traces in Observability? 

+ **Logs**: Logs are a record of events that occur in a system. They can be used to track things like errors, exceptions, and other unexpected events.
+ **Metrics**: Metrics are quantitative measurements of the health of a system. 
    + Regularly sampled data
    + Numerical values
        o Counters 
        o Distributions 
        o Gauges 
    + Examples: 
        o Request/min 
        o Errors/hour 
        o Latency distribution 
        o Current CPU utilization
        o Memory usage 
+ **Traceing**: Traces are a record of the path that a request takes through a system. They can be used to track the performance of arequest and to identify bottlenecks.
    + Time each microService took to process it
    + May include:
        + Request headers
        + Response status code

![Alt text](./images/What%20is%20difference%20between%20Metrics,%20Logs%20and%20Traces%20in%20Observability.png)

[Table of Contents](#observability-and-monitoring-loggings)


### What is the best Practices in Distributed Logging? 
 + **Centralized Logging System**
![Alt text](.//images/Centralized%20Logging%20System.png)
+ **Predefined Structure**
![Alt text](.//images/Predefined%20Structure.png)
+ **Log Level / Log Severity**
![Alt text](./images/Log%20Level.png)
+ **Correlation Id**
![Alt text](./images/Correlation%20Id.png)
 + **Contextual Information - Considerations**
 ![Alt text](./images/ontextual%20Information-1.png)
 ![Alt text](./images/ontextual%20Information.png)

 + **Note:**
    1. Log only necessary data 
    2. Do NOT log: 
        + Sensitive data
        + PII (Personally Identifiable Information) 


[Table of Contents](#observability-and-monitoring-loggings)


### What is the Metrics? 
- Measurable or Countable signals of software that help us
monitor the system's health and performance
- The Five (Golden) Types of Signals
    + Traffic
    + Errors
    + Latency
    + Saturation
    + Utilization

![Alt text](./images/What%20is%20the%20Metrics.png)

[Table of Contents](#observability-and-monitoring-loggings)


### What is the Five (Golden) Types of Signals in Metrics?
+ **Traffic**: Amount of demand being placed on our system per unit of time
    + Examples:
        + HTTP requests/sec
        + Queries/sec
        + Transactions/sec
        + Events received/sec
        + Events delivered/sec
        + Incoming requests + outgoing requests/sec

+ **Errors**: Error Rate and Error Types
    + Examples: 
        +  Number of application exxceptions 
        +  HTTP response status codes (4XX, 5XX)
        +  Response exceeding latency thresholds
        +  Failed Events 
        +  Failed Delivery 
+ **Latency**: Time it takes for a service to process a request
    + Important considerations: 
        + Latency distribution vs average 
        + Separate successful operations from failed operations
    ![Alt text](./images/Latency.png)
    ![Alt text](./images/Latency2.png)
+ **Saturation**: saturation có thể ám chỉ đến sự quá tải của một số thành phần cụ thể hoặc một số dịch vụ. Điều này có thể xảy ra khi một dịch vụ nhận được một lượng lớn yêu cầu từ các thành phần khác trong hệ thống, và do đó không thể xử lý tất cả các yêu cầu đó một cách hiệu quả. Khi một dịch vụ bị quá tải, nó có thể dẫn đến việc giảm hiệu suất hoặc thậm chí là sự cố trong toàn bộ hệ thống.
![Alt text](./images/Saturation.png)


+ **Utilization**
    - How busy a resource is [0 - 100%]
    ![Alt text](./images/Utilization.png)

[Table of Contents](#observability-and-monitoring-loggings)


### What is Distributed Tracing?
- Not enough on its own
- Helps narrow down the:
    + Faulty component 
    + Communication problem 
- We can use logs and metrics to debug further 


![Alt text](./images/Distributed%20Tracing.png)
![Alt text](./images/Distributed%20Tracing-2.png)
![Alt text](./images/Distributed%20Tracing-3.png)


[Table of Contents](#observability-and-monitoring-loggings)


# Logback

### What is difference between SLF4J, Logback and Log4j?
+ SLF4J (Simple Logging Facade for Java), Logback và Log4j đều là các công cụ logging trong Java, nhưng chúng có thể được sử dụng trong các trường hợp khác nhau dựa trên yêu cầu cụ thể của dự án và sở thích cá nhân:
    + `SLF4J` khi bạn muốn viết mã logging không ràng buộc với một framework logging cụ thể.

    + `Log4j`: Log4j là một trong những framework logging đầu tiên và được sử dụng rộng rãi trong Java. Phiên bản Log4j 2 đã được cải tiến với khả năng linh hoạt và cải thiện hiệu suất so với phiên bản trước đó. Nó cũng cung cấp các thành phần giống như Logback, cho phép định dạng và quản lý log một cách linh hoạt.

    + `Logback`: Logback là một framework logging mạnh mẽ và linh hoạt, được coi là sự thay thế nâng cấp từ Log4j. Nó cung cấp hiệu suất tốt, khả năng cấu hình linh hoạt và hỗ trợ nâng cao cho logging trong Java. Logback cũng đi kèm với các thành phần như Logger, Appender, Encoder để quản lý và định dạng log.

![Alt text](./images/What%20is%20difference%20between%20SLF4J,%20Logback%20and%20Log4j.png)


[Table of Contents](#observability-and-monitoring-loggings)

### What is difference between springProfile, appender, và encoder in Logback?
- Các thành phần cơ bản trong cấu hình Logback (một framework logging được sử dụng trong Java) như springProfile, appender, và encoder có các mục đích khác nhau trong việc quản lý và định dạng các log.
    + `springProfile`: Trong Logback, springProfile là một đặc tính được sử dụng để kích hoạt cấu hình log dựa trên các profile Spring.
        + Khi sử dụng với Spring Framework, bạn có thể chỉ định cấu hình log riêng biệt dựa trên các profile khác nhau trong ứng dụng của mình. Điều này có thể hữu ích khi bạn muốn log khác nhau trong các môi trường như Development, Testing, Production, vv.
    + `appender`: Trong Logback, appender là thành phần quan trọng được sử dụng để định nghĩa nơi mà log sẽ được gửi đến (ví dụ: console, file, database).
        + Mỗi appender định nghĩa cách mà log được xử lý và gửi đến một nguồn cụ thể. Ví dụ, có thể có appender dành cho việc ghi log vào file và một appender khác để gửi log đến console.
    + `encoder`: encoder trong Logback xác định cách mà thông điệp log được định dạng trước khi nó được gửi đến appender.
        + encoder có thể được sử dụng để định dạng log theo các định dạng như JSON, XML hoặc các định dạng văn bản thông thường khác. Nó có thể xác định cách mà thông tin như thời gian, cấp độ log, tên class, và thông điệp log được bố trí và biểu diễn

```xml
<configuration>
    <!-- Sử dụng springProfile để xác định profile Spring -->
    <springProfile name="dev">
        <!-- Cấu hình log cho môi trường Development -->
        <appender name="CONSOLE" class="ch.qos.logback.core.ConsoleAppender">
            <!-- Encoder để định dạng log -->
            <encoder>
                <pattern>%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</pattern>
            </encoder>
        </appender>
        <!-- Gán appender cho root logger -->
        <root level="debug">
            <appender-ref ref="CONSOLE" />
        </root>
    </springProfile>
    
    <springProfile name="prod">
        <!-- Cấu hình log cho môi trường Production -->
        <appender name="FILE" class="ch.qos.logback.core.FileAppender">
            <file>logs/app.log</file>
            <encoder>
                <!-- Sử dụng định dạng JSON cho log -->
                <pattern>{"timestamp": "%d{yyyy-MM-dd HH:mm:ss.SSS}", "level": "%level", "logger": "%logger", "message": "%msg"}%n</pattern>
            </encoder>
        </appender>
        <!-- Gán appender cho root logger -->
        <root level="info">
            <appender-ref ref="FILE" />
        </root>
    </springProfile>
</configuration>

```

[Table of Contents](#observability-and-monitoring-loggings)




# Sumo Logic

## What is Sumo Logic?
- **Sumo Logic** is a cloud-based machine data analytics platform and log management solution that helps organizations gain real-time insights into their applications, infrastructure, and security. It is commonly used for monitoring and troubleshooting various aspects of IT systems, including applications, servers, networks, and security events.

![Alt text](images/Sumo%20Logic.png)


[Table of Contents](#observability-and-monitoring-loggings)


## What is difference between Sumo Logic and another tools?
- Sumo Logic is a cloud-based log and machine data analytics platform that helps organizations collect, manage, and analyze machine-generated data. It is often compared to other log management and analytics tools like Splunk, ELK Stack (Elasticsearch, Logstash, Kibana), and Graylog. 

![Alt text](images/difference%20between%20Sumo%20Logic%20and%20another%20tools.png)

[Table of Contents](#observability-and-monitoring-loggings)


### What is difference Ingestion Path and The Search Path?
- **Ingestion Path:** Before logs can be searched, the data has to be ingested by Sumo Logic.
Data arrives at The receiver where a pile of messages is created.

- **Search Path:** A search event starts when services ask to execute a query. Sumo Logic uses Kafka Stream to find indexes matching time range
and executes the query and parts of the operator pipeline.


![Alt text](.//images/difference%20Ingestion%20Path%20and%20The%20Search%20Path.png)


[Table of Contents](#observability-and-monitoring-loggings)

### What is Metadata Tab?
- Sumo Logic has several metadata fields that are automatically tagged to ingested data.
    - **_collector**:  Name of the collector (set when the Collector was installed) that received the log message
    - **_sourceHost**: Hostname of the Source
    - **_sourceName**: The name of the log file, determined by the path you entered when you configured the Source 
    - **_source**: Name of the source this data came through
    - **_SourceCategory**: The category of the Source that collected the log message. Can be
freely configured. Main metadata tag

![Alt text](images/Metadata%20Tab.png)


[Table of Contents](#observability-and-monitoring-loggings)

### What is "Log Message Inspector"?
- **The Log Message Inspector** is a feature in Sumo Logic that allows you to quickly identify the type of each log message, raw log message, message time, receipt time, and the parameter values associated with the query in one pop-up screen 
![Alt text](.//images/Log%20Message%20Inspector.png)

[Table of Contents](#observability-and-monitoring-loggings)


# Dashboard


### What is Dashboard in Sumo Logic?
- **Dashboard** tab gives the option to create different types of panels like time series, honeycomb, categorical, single value and other types of visualizations which can be added to the dashboard. 
- The dashboard tab also gives the option to select time range to narrow down search results for the requested data.

``` javascript
[10/Oct/2000:13:55:36 -0700] “GET /apache_pb.gif HTTP/1.1” 204 2326
```

```javascript
(_source=”CW Collector 01")
| parse “HTTP/1.1* * “ as data,StatusCode 
| fields StatusCode, logGroup, logStream
| where StatusCode!= “200”
| where StatusCode!= “host:”
| timeslice 15m
| count by StatusCode, logGroup, _timeslice
```

![Alt text](.//images/Dashboard%20in%20Sumo%20Logic.png)

![Alt text](.//images/Dashboard%20in%20Sumo%20Logic-1.png)

[Table of Contents](#monitoring--logging)


### What is difference between Sumo Logic and Cloud Watch?
- **Task01**: 
    - **Sumo Logic**:
    ```javascript
    _sourceCategory=Prod/*/importantAPI “17409”
    | json “correlationId”
    ```

    ```javascript
    _sourceCategory=Prod/*/importantAPI (“correlationId1” or "correlationId2")
    ```

    - **Cloudwatch Insights**

    ``` javascript
    fields @timestamp, @message
    | filter @message like /17409/
    | sort @timestamp desc
    | display correlationId
    | limit 200
    ```

    ``` javascript
    fields @timestamp, @message
    | filter @message like /correlationId1/ or @message like /correlationId2/
    | sort @timestamp desc
    | limit 20
    ```


