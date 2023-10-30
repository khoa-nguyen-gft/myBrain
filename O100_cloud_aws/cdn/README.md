## [Main title](/README.md)

![Alt text](images/cdn.png)

# CDN
+ ## AWS CloudFront
    + [What is AWS CloudFront?](#what-is-aws-storage)
    + [What is Origin in AWS CloudFront?](#what-is-origin-in-aws-cloudfront)
    + [ What is Edge Location and Regional Edge Caches in AWS CloudFront?](#what-is-edge-location-and-regional-edge-caches-in-aws-cloudfront)
    + [What is difference between CloudFront and S3 Cross Region Replication?](#what-is-difference-between-cloudfront-and-s3-cross-region-replication)


+ # Advanced
    + [What is OCSP (Online Certificate Status Protocol) and OCSP stapling?](#what-is-ocsp-online-certificate-status-protocol-and-ocsp-stapling)
    + [What is Origin Access Identity (OAI)?](#what-is-origin-access-identity-oai)
    + [What is Lambda@Edge?](#what-is-lambdaedge)




----

## AWS CloudFront

### What is AWS CloudFront?
- Content Delivery Network (CDN)
- Improves read performance, content is cached at the edge
- Improves users experience
- 216 Point of Presence globally (edge locations)
- DDoS protection (because worldwide), integration with Shield, AWS Web Application Firewall

[Table of Contents](#cdn)

### What is Origin in AWS CloudFront?
- Trong dịch vụ AWS CloudFront, "origin" đề cập đến nguồn dữ liệu hoặc máy chủ nơi CloudFront lấy dữ liệu để phân phối đến các máy khách cuối. Một "origin" có thể là một máy chủ web, một tập tin S3 bucket, hoặc một nguồn dữ liệu khác mà CloudFront sẽ tải và phân phối đến người dùng cuối thông qua Content Delivery Network (CDN).
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


### What is Edge Location and Regional Edge Caches in AWS CloudFront?
- **Edge location** là một phần quan trọng của hệ thống CDN (Content Delivery Network) như AWS CloudFront hoặc các dịch vụ tương tự. Edge location là các trung tâm dữ liệu phân tán trên khắp thế giới, mục tiêu chính của chúng là cung cấp nội dung cho người dùng cuối một cách nhanh chóng và hiệu quả.

- **Regional Edge Caches**:
    + Regional edge caches là một tầng trung gian giữa edge locations và máy chủ gốc hoặc origin server. Chúng thường đặt ở một phạm vi địa lý lớn hơn so với edge locations, có thể bao gồm nhiều edge locations trong một khu vực hoặc lãnh thổ nhất định.
    + Nhiệm vụ của regional edge caches là cải thiện hiệu suất bằng cách lưu trữ và phục vụ nội dung cho khu vực cụ thể. Chúng có thể lưu trữ nội dung phổ biến trong khu vực và cung cấp cho người dùng trong khu vực đó, giúp giảm trễ và tải trên máy chủ gốc cho người dùng ở cùng một khu vực.

    ![Alt text](./images/Edge%20location.png)

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

**CloudFront** is primarily focused on optimizing content delivery for web applications and websites, while **S3 Cross-Region Replication** is used for replicating data between S3 buckets in different AWS regions to ensure data redundancy and availability

[Table of Contents](#cdn)



### What is OCSP (Online Certificate Status Protocol) and OCSP stapling?

- OCSP (Online Certificate Status Protocol) và OCSP stapling là hai khía cạnh liên quan đến xác thực chứng chỉ SSL/TLS trên web, nhưng chúng có một số khác biệt quan trọng
    + OCSP là một giao thức dùng để kiểm tra trạng thái hiệu lực của một chứng chỉ SSL/TLS.
    ![Alt text](images/OCSP.png)

- OCSP là giao thức kiểm tra trạng thái chứng chỉ, trong khi **OCSP stapling** là một kỹ thuật cải tiến trong việc sử dụng OCSP bằng cách cho phép máy chủ web tự mình thực hiện kiểm tra OCSP và gửi thông tin ký và kết quả OCSP đến trình duyệt máy khách, giúp cải thiện hiệu suất và tính bảo mật.
![Alt text](./images/OCSP%20stapling.png)

[Table of Contents](#advanced)

### What is Origin Access Identity (OAI)?
Origin Access Identity (OAI) là một tính năng trong dịch vụ Amazon CloudFront, và nó liên quan đến kiểm soát quyền truy cập đến các nguồn gốc (origins) của CloudFront. OAI giúp cải thiện tính bảo mật của các nguồn gốc bằng cách hạn chế quyền truy cập trực tiếp từ Internet vào các nguồn gốc này.

![Alt text](./images/Origin%20Access%20Identity%20(OAI).png)

[Table of Contents](#advanced)

### What is Lambda@Edge?
- **Lambda@Edge** là một dịch vụ trong Amazon Web Services (AWS) cho phép bạn thực thi mã Lambda (AWS Lambda) trực tiếp tại các edge location của AWS CloudFront, một dịch vụ CDN (Content Delivery Network) của AWS. Điều này cho phép bạn thực hiện logic tùy chỉnh và xử lý trên nội dung trước khi nó được phân phối đến người dùng cuối từ các edge location gần họ.


![Alt text](./images/Lambda@Edge.png)

[Table of Contents](#advanced)
