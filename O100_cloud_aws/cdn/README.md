## [Main title](/README.md)

![Alt text](images/cdn.png)

# CDN
+ ## AWS CloudFront
    + [What is AWS CloudFront?](#what-is-aws-storage)
    + [What is AWS CloudFront Origin?](#what-is-aws-cloudfront-origin)
    + [What is Origin Access Identity (OAI)?](#what-is-origin-access-identity-oai)
    + [What is difference between CloudFront and S3 Cross Region Replication?](#what-is-difference-between-cloudfront-and-s3-cross-region-replication)

----

## AWS CloudFront



### What is AWS CloudFront?
- Content Delivery Network (CDN)
- Improves read performance, content is cached at the edge
- Improves users experience
- 216 Point of Presence globally (edge locations)
- DDoS protection (because worldwide), integration with Shield, AWS Web Application Firewall



[Table of Contents](#cdn)


### What is AWS CloudFront Origin?

* **S3 bucket**
    * For distributing files and caching them at the edge
    * Enhanced security with CloudFront Origin Access Control (OAC)
    * OAC is replacing Origin Access Identity (OAl)
    * CloudFront can be used as an ingress (to upload files to S3)
- **Custom Origin (HTTP)**
    * Application Load Balancer
    * EC2 instance
    * S3 website (must first enable the bucket as a static S3 website)
    * Any HTTP backend you want


![Alt text](./images/AWS%20CloudFront%20Origin.png)

[Table of Contents](#cdn)

### What is Origin Access Identity (OAI)?
Origin Access Identity (OAI) là một tính năng trong dịch vụ Amazon CloudFront, và nó liên quan đến kiểm soát quyền truy cập đến các nguồn gốc (origins) của CloudFront. OAI giúp cải thiện tính bảo mật của các nguồn gốc bằng cách hạn chế quyền truy cập trực tiếp từ Internet vào các nguồn gốc này.

![Alt text](./images/Origin%20Access%20Identity%20(OAI).png)

[Table of Contents](#cdn)

### What is difference between CloudFront and S3 Cross Region Replication?

- **CloudFront:**
    * Global Edge network
    * Files are cached for a TTL (maybe a day)
    * Great for static content that must be available everywhere
* **S3 Cross Region Replication:**
    * Must be setup for each region you want replication to happen
    * Files are updated in near real-time
    * Read only
    * Great for dynamic content that needs to be available at low-latency in few regions

    ![Alt text](./images/S3%20Cross%20Region%20Replication.png)

- **CloudFront** is primarily focused on optimizing content delivery for web applications and websites, while **S3 Cross-Region Replication** is used for replicating data between S3 buckets in different AWS regions to ensure data redundancy and availability

[Table of Contents](#cdn)
