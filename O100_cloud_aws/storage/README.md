## [Main title](/README.md)

![Alt text](./images/Pasted%20Graphic%2058.png)


# AWS Storage 
+ [What is AWS Storage?](#what-is-aws-storage)
+ [What is difference between Block, File and Object Store?](#what-is-difference-between-block-file-and-object-store)
+ ## Block Storage
    + [What is difference between Instance Store and Amazon Elastic Block Store (EBS)?](#what-is-difference-between-instance-store-and-amazon-elastic-block-store-ebs)

+ ## File Storage
    + [What is AWS File Storage?](#what-is-aws-file-storage)
    + [What is difference between Amazon EFS (Elastic File System) and Amazon FSx?](#what-is-difference-between-amazon-efs-elastic-file-system-and-amazon-fsx)
    + [What is difference between Amazon FSx for Lustre, Amazon FSx for Windows, Amazon FSx for NetApp ONTAP and Amazon FSx for OpenZFS?](#what-is-difference-between-amazon-fsx-for-lustre-amazon-fsx-for-windows-file-server-amazon-fsx-for-netapp-ontap-and-amazon-fsx-for-openzfs)

+ ## Object Storage
    + [What is S3 Stogage Classes Comparison?](#what-is-s3-stogage-classes-comparison)
    + [What is difference between Standard Bucket And Requester Pays Bucket in S3?](#what-is-difference-between-standard-bucket-and-requester-pays-bucket-in-s3)
    + [What is Event Notification in S3?](#what-is-event-notification-in-s3)
    + [What is Audit Access Logs in S3?](#what-is-audit-access-logs-in-s3)
    + [What is S3 Presigned URL?](#what-is-s3-presigned-url)
    + [What is S3 Glacier Vault Lock?](#what-is-s3-glacier-vault-lock)
    + [What is S3 Object Lock?](#what-is-s3-object-lock)
    + [What is  Amazon S3 Access Points?](#what-is-amazon-s3-access-points)
    + [What is Amazon S3 Object Lambda?](#what-is-amazon-s3-object-lambda)
    + [What is S3 Performance?](#what-is-s3-performance)
    + [What is S3 Batch Operation?](#what-is-s3-batch-operation)
    + [What is S3 Lifecycle Policy?](#what-is-s3-lifecycle-policy)

+ ## On-Premises Storage
    + [What is AWS Storage Gateway (File Gateway)?](#what-is-aws-storage-gateway-file-gateway)
    + [What is difference Volume Gateway, File Gateway and Tape Gateway in AWS Storage Gateway?](#what-is-difference-volume-gateway-file-gateway-and-tape-gateway-in-aws-storage-gateway)
    + [What is difference between SAN (Storage Area Network) and NAS (Network Attached Storage)?](#what-is-difference-between-san-storage-area-network-and-nas-network-attached-storage)
    + [What is difference between NFS(Network File System), DFSR (Distribute File System Replication), SMB (Server Message Block) and SAM (Security Account Manager)?](#what-is-difference-between-nfsnetwork-file-system-dfsr-distribute-file-system-replication-smb-server-message-block-and-sam-security-account-manager)


+ ## AWS Data & Analytics
    + [What is AWS Athena?](#what-is-aws-athena)
    + [What is AWS Redshift?](#what-is-aws-redshift)
    + [What is AWS OpenSearch?](#what-is-aws-opensearch)
    + [What is AWS EMR?](#what-is-aws-emr)


----

### What is AWS Storage?
- AWS (Amazon Web Services) provides various storage services that allow businesses and developers to store, manage, and retrieve data in the cloud. These storage services cater to a wide range of use cases and requirements. 

![Alt text](.//images/Pasted%20Graphic%2058.png)

### What is difference between Block, File and Object Store?

+ **Block** provides block-level storage, which means that it is used to create virtual disks that can be used by EC2 instances to store data. 
+ **File** provides file-level storage, which means that it is used to create a file system that can be accessed by multiple EC2 instances.
+ **Object** is designed for storing and retrieving large volumes of data with high durability, availability, and security.f

![Alt text](images/What%20is%20difference%20between%20block,%20File%20and%20Object%20Store.png)


[Table of Contents](#aws-storage)


## Block Store
### What is difference between Instance Store and Amazon Elastic Block Store (EBS)?
- **Instance Stores** are physically attached to the EC2 instance and provide high-performance, low-latency local storage. 
    + The data stored on an instance store volume is ephemeral, which means that it will be lost if the instance is stopped or terminated. 

- **Amazon Elastic Block Store (EBS)** volumes provide durable block-level storage that can persist independently of the EC2 instance
    + EBS volumes can be detached from one EC2 instance and attached to another, allowing for data mobility and disaster recovery. 
    + EBS volumes are ideal for storing persistent data that needs to survive an instance failure or be shared across multiple instances.
    + EBS is not going to provide as much I/O performance as an instance store volume so is not the best choice for this use case.


![Alt text](./images/1.png.webp)


[Table of Contents](#aws-storage)


### What is AWS File Storage?
+ EFS is designed for applications that require shared file storage with concurrent access from multiple EC2 instances and high I/O performance.
    + Amazon EFS (Elastic File System) 
    + Amazon FSx
![Alt text](./images/efs-ec2-how-it-works-Regional.png)

[Table of Contents](#aws-storage)



### What is difference between Amazon EFS (Elastic File System) and Amazon FSx?

- **EFS (Elastic File System):** EFS is a scalable network-attached storage service designed for use with AWS cloud services and on-premises servers. It's suitable for a wide range of use cases, including content management systems, big data analytics, database backups, and development/test environments.

- **FSx (Amazon FSx for Windows or FSx for Lustre)**: FSx is a managed file storage service designed for specific use cases. FSx for Windows is for Windows-based workloads, including Windows file shares and Windows applications, while FSx for Lustre is designed for high-performance computing and data analytics.
![Alt text](images/FSx.png)


### What is difference between Amazon FSx for Lustre, Amazon FSx for Windows file server, Amazon FSx for NetApp ONTAP and Amazon FSx for OpenZFS?


+ **Amazon FSx for Windows File Server** supports DFS namespaces and DFS replication. This is the best solution for replacing the on-premises infrastructure. 

+ **Amazon FSx for Lustre (Linux + Cluster):** Lustre is a type of parallel distributed file system, for large-scale computing
    ![Alt text](images/Lustre.png)

+ **Amazon FSx for NetApp ONTAP**:
    + **Amazon FSx for NetApp ONTAP**: Yêu cầu hiệu suất cao: Bạn cần hiệu suất cao và độ trễ thấp cho ứng dụng quan trọng với yêu cầu I/O đặc biệt.
    + Storage shrinks or grows automatically
    + Snapshots, replication, low-cost, compression and data de-duplication

    ![Alt text](images/NetApp.png)

+ **Amazon FSx for OpenZFS** 
    + **Amazon FSx for OpenZFS**: OpenZFS cung cấp một giải pháp tương đối tiết kiệm cho nhu cầu lưu trữ dữ liệu tổng quan 
    + Up to 1,000,000 IOPS with < 0.5ms latency
    + Snapshots, compression and low-cost 
    + Point-in-time instantaneous cloning (helpful for testing new workloads)

    ![Alt text](images/OpenZFS.png)

- **NOTE:**
    - **HPC (High Performance Computing)**: 

[Table of Contents](#aws-storage)


## Object Storage

### What is S3 Stogage classes Comparison?
* You can transition objects between storage classes 
* For infrequently accessed object, move them to Standard IA
* For archive objects that you don't need fast access to, move them to Glacier or Glacier Deep Archive
* Moving objects can be automated using a Lifecycle Rules


![Alt text](./images/S3%20Stogage%20classes%20Comparison.png)
![Alt text](./images/Pasted%20Graphic%2011.png)

[Table of Contents](#aws-storage)

### What is difference between Standard Bucket And Requester Pays Bucket in S3?

* **Standard Bucket:** bucket owners pay for all
Amazon S3 storage and data transfer costs associated with their bucket
* **Requester Pays Buckets**: the
requester instead of the bucket owner
pays the cost of the request and the
data download from the bucket
    * Helpful when you want to share large datasets with other accounts
    * The requester must be authenticated in AWS (cannot be anonymous)


![Alt text](.//images/Requester%20Pays%20Buckets.png)


[Table of Contents](#aws-storage)



### What is Event Notification in S3?
* S3 event notifications typically deliver events in seconds but can sometimes take a minute or longer

![Alt text](./images/What%20is%20S3%20Notification.png)

[Table of Contents](#aws-storage)


### What is Audit Access Logs in S3?

* For audit purpose, you may want to log all access to S3 buckets
* Any request made to S3, from any account, authorized or denied, will be logged into another S3 bucket
* That data can be analyzed using data analysis tools...
* The target logging bucket must be in the same AWS region

![Alt text](.//images/S3%20Access%20Logs.png)

[Table of Contents](#aws-storage)


### What is S3 presigned URL?

- An S3 presigned URL (also known as a presigned link) is a time-limited URL that provides temporary access to objects in an Amazon S3 bucket. Presigned URLs are often used to allow temporary access to private objects in an S3 bucket, without requiring the requestor to have AWS credentials.

![Alt text](./images/What%20is%20S3%20presigned%20URL.png)

[Table of Contents](#aws-storage)

### What is S3 Glacier Vault Lock?

* Adopt a WORM (Write Once Read Many) model
* Create a Vault Lock Policy
* Lock the policy for future edits (can no longer be changed or deleted)
* Helpful for compliance and data retention

![Alt text](./images/S3%20Glacier%20Vault%20Lock.png)

[Table of Contents](#aws-storage)


### What is S3 Object Lock?

* Adopt a WORM (Write Once Read Many) model
* Block an object version deletion for a specified amount of time
+ **Retention Mode:**
    * **Retention mode - Compliance:**
        + Object versions can't be overwritten or deleted by any user; including the root user
        * Objects retention modes can't be changed, and retention periods can't be shortened
    + **Retention mode - Governance:**
        * Most users can't overwrite or delete an object version or alter its lock settings
        * Some users have special permissions to change the retention or delete the object

+ **Retention Period:** protect the object for a fixed period, it can be extended

+ **Legal Hold:** protect the object indefinitely, independent from retention period 

![Alt text](./images/S3%20Object%20Lock.png)

[Table of Contents](#aws-storage)


### What is Amazon S3 Access Points?

- Amazon S3 Access Points are a feature of Amazon Simple Storage Service (S3) that simplify managing data access at scale for your S3 buckets. They are a way to make it easier to access data in your S3 buckets by providing a unique hostname for each access point.

![Alt text](./images/Amazon%20S3%20Access%20Points.png)

**Note**: You must create a VPC Endpoint to access the
Access Point (Gateway or Interface Endpoint)

![Alt text](./images/Amazon%20S3%20Access%20Points%202.png)

[Table of Contents](#aws-storage)


### What is Amazon S3 Object Lambda?

- Use AWS Lambda Functions to change the object before it is retrieved by the caller application.
- Only one S3 bucket is needed, on top of which we create S3 Access Point and S3 Object Lambda Access Points.
- **Use Cases:**
    * Redacting personally identifiable information (PII) for analytics or non-production environments. 
    + Converting across data formats, such as converting XML to JSON.
    * Resizing and watermarking imaﬁes on the fly using caller-specific details, such as the user who requested the object.

![Alt text](./images/Amazon%20S3%20Object%20Lambda.png)

[Table of Contents](#aws-storage)


### What is S3 Performance?
- **Upload Files:**
    -  **Multi-Part Upload:**
        + recommended for files > 100MB,  must use for files > 5GB
        + Can help parallelize uploads (speed up transfers)
    ![Alt text](.//images/Multi-Part Upload.png)
    - **S3 Transfer Acceleration**
        * Increase transfer speed by transferring the file to an AWS edge location which will forward the data to the S3 bucket in the target region
        * Compatible with multi-part upload
    ![Alt text](.//images/S3%20Transfer Acceleratio.png)

- **Download Files:**
    - Parallelize GETs by requesting specific byte ranges
    - Better resilience in case of failures
    - Can be used to retrieve only partial
    - Can be used to speed up downloads data (for example the head of a file)
![Alt text](.//images/Pasted%20Graphic%204.png)

[Table of Contents](#aws-storage)


### What is S3 Batch Operation?
- A job consists of a list of objects, the action to perform, and optional parameters
- S3 Batch Operations manages retries, tracks progress, sends completion notifications, generate reports ... 
- You can use S3 Inventory to get object list and use S3 Select to filter your objects 

![Alt text](.//images/S3%20Batch%20Operation.png)

[Table of Contents](#aws-storage)


### What is S3 Lifecycle Policy?

[Table of Contents](#aws-storage)


## On-Premises Storage

### What is AWS Storage Gateway (File Gateway)?
- "AWS Storage Gateway" is primarily used for connecting on-premises storage to cloud storage.
- It consists of a software device installed on-premises and can be used with SMB shares but it actually stores the data on S3. It is also used for migration. However, in this case the company need to replace the file server farm and Amazon FSx is the best choice for this job.

![Alt text](./images/AWS%20Storage%20Gateway.png)


[Table of Contents](#aws-storage)



### What is difference between SAN (Storage Area Network) and NAS (Network Attached Storage)?
- SAN (Storage Area Network) and NAS (Network Attached Storage) are both storage solutions used in IT environments, but they have different architectures and serve distinct purposes. 
    + **SAN (Storage Area Network):** A SAN is a dedicated, high-speed network that connects storage devices, such as disk arrays and tape libraries, to servers. It operates at the block level, meaning it presents storage to servers as if it were direct-attached storage. 
    + **NAS (Network Attached Storage)**: NAS, on the other hand, is a file-level storage system. It consists of a storage device (often referred to as a NAS appliance) that is connected to a network, and it uses file protocols like NFS (Network File System) for Unix/Linux environments or SMB/CIFS (Server Message Block/Common Internet File System) for Windows environments. NAS devices have their own file systems and handle file-level data storage.



![Alt text](./images/What%20is%20difference%20between%20SAN%20(Storage%20Area%20Network)%20and%20NAS%20(Network%20Attached%20Storage).png)

[Table of Contents](#aws-storage)

### What is difference Volume Gateway, File Gateway and Tape Gateway in AWS Storage Gateway?
- AWS Storage Gateway là một dịch vụ của Amazon Web Services (AWS) cho phép bạn kết nối các ứng dụng và máy chủ của bạn với lưu trữ đám mây của AWS một cách dễ dàng. Storage Gateway cung cấp nhiều loại cổng (gateway) khác nhau, bao gồm cổng dựa trên tệp (file gateway) và cổng dựa trên khối (volume gateway). Dưới đây là giải thích về hai loại cổng này:
    ![Alt text](./images/What%20is%20difference%20Volume%20Gateway,%20File%20Gateway%20and%20Tape%20Gateway%20in%20AWS%20Storage%20Gateway.png)
    + **Volume Gateway (Cổng Dựa Trên Khối):** Volume Gateway cho phép bạn liên kết ổ đĩa ảo (volumes) với dữ liệu lưu trữ đám mây của AWS.
    + **File Gateway (Cổng Dựa Trên Tệp):** File Gateway là một cổng dựa trên tệp cho phép bạn kết nối các ứng dụng và máy chủ với lưu trữ đám mây của AWS bằng cách sử dụng các giao thức tệp như NFS (Network File System) hoặc SMB (Server Message Block).
    + **Tape Gateway (Cổng Băng)**: cho phép bạn kết nối các ứng dụng và máy chủ với lưu trữ dựa trên băng từ Amazon Web Services (AWS).
-  Volume Gateway dựa trên khối cho phép liên kết ổ đĩa ảo với lưu trữ đám mây, File Gateway dựa trên tệp cho phép kết nối với lưu trữ đám mây thông qua giao thức tệp, và Tape Gateway dựa trên băng cho phép tạo và quản lý các băng ảo trên lưu trữ dựa trên băng của AWS. Các loại cổng này phục vụ các mục tiêu và tình huống sử dụng khác nhau trong việc tích hợp lưu trữ đám mây với các ứng dụng và hệ thống hiện có.

![Alt text](./images/What%20is%20difference%20Volume%20Gateway,%20File%20Gateway%20and%20Tape%20Gateway%20in%20AWS%20Storage%20Gateway2.png)

[Table of Contents](#aws-storage)

### What is difference between NFS(Network File System), DFSR (Distribute File System Replication), SMB (Server Message Block) and SAM (Security Account Manager)?

- **SAM (Security Account Manager):** SAM is not a file-sharing protocol like NFS or SMB. It is a database that stores user account information, including usernames and password hashes. SAM is used for local user authentication on Windows systems.

- **SMB (Server Message Block):** SMB is a network-based file-sharing protocol developed by Microsoft and widely used in Windows environments for sharing files, printers, and other resources.

- **NFS(Network File System)/DFSR(Distribute Network File System):** NFS is a network-based file-sharing protocol primarily used in UNIX/Linux environments for sharing files and directories across a network.

![Alt text](./images/What%20is%20difference%20between%20Block,%20File%20and%20Object%20Store2.png)


[Table of Contents](#aws-storage)




## AWS Data & Analytics
### What is AWS Athena?

* Serverless query service to analyze data stored in Amazon S3 
+ Uses standard SQL language to query the files (built on Presto) 
* Supports CSV, JSON, ORC, Avro, and Parquet 
* Pricing: $5.00 per TB of data scanned 
+ Commonly used with Amazon Quicksight for reporting/dashboards 
+ Use cases: Business intelligence / analytics / reporting, analyze & query VPC Flow Logs, ELB Logs, CloudTrail trails, etc... 
+ Partition datasets in S3 for easy querying on virtual columns
```
    s3//yourBucket/pathToTable
        /<PARTITION_COLUMN_NAME>=<VALUE>
        /<PARTITION_COLUMN_NAME>=<VALUE>
        /<PARTITION_COLUMN_NAME>=<VALUE>
        etc...
```

 Example: s3:/athena-examples/flight/parquet/year=199 | /month= | /day=1/

![Alt text](./images/What%20is%20AWS%20Athena.png)

[Table of Contents](#aws-storage)


### What is AWS Redshift?
* Redshift is based on PostgreSQL, but it's not used for OLTP
* It's OLAP — online analytical processing (analytics and data warehousing)
* 10x better performance than other data warehouses, scale to PBs of data
* Columnar storage of data (instead of row based) & parallel query engine
* Pay as you go based on the instances provisioned
* Has a SQL interface for performing the queries
* Bl tools such as Amazon Quicksight or Tableau integrate with it
* vs Athena: faster queries / joins / aggregations thanks to indexes

![Alt text](./images/What%20is%20AWS%20Redshift.png)

[Table of Contents](#aws-storage)


### What is AWS OpenSearch?
* Amazon OpenSearch is successor to Amazon ElasticSearch
* In DynamoDB, queries only exist by primary key or indexes...
* With OpenSearch, you can search any field, even partially matches
* It's common to use OpenSearch as a complement to another database
* Two modes: managed cluster or serverless cluster
* Does not natively support SQL (can be enabled via a plugin)
* Ingestion from Kinesis Data Firehose, AWS loT, and CloudWatch Logs
* Security through Cognito & IAM, KMS encryption, TLS
* Comes with OpenSearch Dashboards (visualization)

![Alt text](./images/What%20is%20AWS%20OpenSearch.png)

[Table of Contents](#aws-storage)



### What is AWS EMR?
* EMR stands for “Elastic MapReduce” 
* EMR helps creating Hadoop clusters (Big Data) to analyze and process vast amount of data 
* The clusters can be made of hundreds of EC2 instances 
* EMR comes bundled with Apache Spark, HBase, Presto, Flink... 
* EMR takes care of all the provisioning and configuration 
* Auto-scaling and integrated with Spot instances 
* Use cases: data processing, machine learning, web indexing, big data... 

[Table of Contents](#aws-storage)


### What is AWS QuickSight?
- Serverless machine learning-powered business intelligence service to create interactive dashboards 
- Fast, automatically scalable, embeddable, with per-session pricing
- Use cases: 
    * Business analytics
    * Building visualizations 
    * Perform ad-hoc analysis
    * Get business insights using data
* Integrated with RDS, Aurora, Athena, Redshift, S3... 
* in-memory computation using SPICE engine if data is imported into QuickSight
* Enterprise edition: Fosshoikty to setup Column-Level security (CLS) 

![Alt text](./images/What%20is%20AWS%20QuickSight.png)

[Table of Contents](#aws-storage)


### What is AWS Glue?
* Managed extract, transform, and load (ETL) service 
* Useful to prepare and transform data for analytics 
* Fully serverless service 

![Alt text](./images/What%20is%20AWS%20Glue.png)
![Alt text](./images/%20What%20is%20AWS%20Glue2.png)

[Table of Contents](#aws-storage)
