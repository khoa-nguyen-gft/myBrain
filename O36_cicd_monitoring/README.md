## [Main title](/README.md)


# Observability and Monitoring Loggings
+ [Why do we need Observability and Monitoring Loggings?](#why-do-we-need-observability-and-monitoring-loggings)
+ [What is Observability?](#what-is-observability)

+ ## Cloud Watch


+ ## Sumo Logic
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

[Table of Contents](#monitoring--logging)


### What is difference between Observability and Monitoring?
- **Observability** is the ability to understand the internal state of a system by observing its outputs. In the context of microservices, observability is achieved by collecting and analyzing data from a variety of sources, such as metrics, logs, and traces.
    + **Metrics**: Metrics are quantitative measurements of the health of a system. They can be used to track things like CPU usage, memory usage, and response times.
    + **Logs**: Logs are a record of events that occur in a system. They can be used to track things like errors, exceptions, and other unexpected events.
    + **Traces**: Traces are a record of the path that a request takes through a system. They can be used to track the performance of arequest and to identify bottlenecks.



## What is Sumo Logic?
- **Sumo Logic** is a cloud-based machine data analytics platform and log management solution that helps organizations gain real-time insights into their applications, infrastructure, and security. It is commonly used for monitoring and troubleshooting various aspects of IT systems, including applications, servers, networks, and security events.

![Alt text](images/Sumo%20Logic.png)



[Table of Contents](#monitoring--logging)


## What is difference between Sumo Logic and another tools?
- Sumo Logic is a cloud-based log and machine data analytics platform that helps organizations collect, manage, and analyze machine-generated data. It is often compared to other log management and analytics tools like Splunk, ELK Stack (Elasticsearch, Logstash, Kibana), and Graylog. 

![Alt text](images/difference%20between%20Sumo%20Logic%20and%20another%20tools.png)

[Table of Contents](#monitoring--logging)


### What is difference Ingestion Path and The Search Path?
- **Ingestion Path:** Before logs can be searched, the data has to be ingested by Sumo Logic.
Data arrives at The receiver where a pile of messages is created.

- **Search Path:** A search event starts when services ask to execute a query. Sumo Logic uses Kafka Stream to find indexes matching time range
and executes the query and parts of the operator pipeline.


![Alt text](.//images/difference%20Ingestion%20Path%20and%20The%20Search%20Path.png)


[Table of Contents](#monitoring--logging)

### What is Metadata Tab?
- Sumo Logic has several metadata fields that are automatically tagged to ingested data.
    - **_collector**:  Name of the collector (set when the Collector was installed) that received the log message
    - **_sourceHost**: Hostname of the Source
    - **_sourceName**: The name of the log file, determined by the path you entered when you configured the Source 
    - **_source**: Name of the source this data came through
    - **_SourceCategory**: The category of the Source that collected the log message. Can be
freely configured. Main metadata tag

![Alt text](images/Metadata%20Tab.png)


[Table of Contents](#monitoring--logging)

### What is "Log Message Inspector"?
- **The Log Message Inspector** is a feature in Sumo Logic that allows you to quickly identify the type of each log message, raw log message, message time, receipt time, and the parameter values associated with the query in one pop-up screen 
![Alt text](image.png)

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


