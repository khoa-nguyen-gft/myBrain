## [Main title](/README.md)

# AWS
## Command:
+ [What is statement `aws sts get-caller-identity`?](#what-is-statement-aws-sts-get-caller-identity)
+ [What is statement `export | grep AWS`?](#what-is-statement-export--grep-aws)
+ [How to get load balancer url http?](#how-to-get-load-balancer-url-http)


## What is statement `aws sts get-caller-identity`?
- Lệnh aws sts get-caller-identity được sử dụng để truy vấn dịch vụ AWS Security Token Service (STS) để lấy thông tin về người dùng hoặc thực thể đang thực hiện yêu cầu API trong ngữ cảnh hiện tại. Cụ thể, lệnh này trả về thông tin về Amazon Resource Name (ARN) của người dùng hoặc thực thể đó.

```bash
$ aws sts get-caller-identity
```
```json
{
    "Account": "123456789012",
    "UserId": "ABCDEFGHIJKLMOPQRSTU:your-username",
    "Arn": "arn:aws:iam::123456789012:user/your-username"
}

```

[Table of Contents](#aws)

## What is statement `export | grep AWS`?


**export | grep AWS**: This command displays all environment variables using the export command and then pipes the output to grep to filter only the lines containing "AWS". This will show you all environment variables related to AWS configuration.

```bash
$ export | grep AWS
```
```bash
us-west-2
declare -x AWS_REGION="us-west-2"
declare -x AWS_ACCESS_KEY_ID="YOUR_ACCESS_KEY_ID"
declare -x AWS_SECRET_ACCESS_KEY="YOUR_SECRET_ACCESS_KEY"
declare -x AWS_DEFAULT_REGION="us-west-2"
```

```bash
$ export | grep PROFILE
```
```bash
declare -x SPRING_PROFILES_ACTIVE="vndev/services/accounts-microservice"
```

[Table of Contents](#aws)


## How to get load balancer url http?
- To obtain the URL (HTTP endpoint) of an AWS Elastic Load Balancer (ELB), you can use the AWS Command Line Interface (CLI) to retrieve information about the load balancer and extract its DNS name. Here's how you can do it:



```bash
aws <service> <operation> --query "<JMESPath expression>" --output text

```

```bash
# BankFast-master-LoadBalancer-363616156.eu-central-1.elb.amazonaws.com   
# BankFast-mr335-LoadBalancer-140827827.eu-central-1.elb.amazonaws.com   
# BankFast-vndemo-LoadBalancer-1878538582.eu-central-1.elb.amazonaws.com  
# BankFast-vndev-LoadBalancer-1110061762.eu-central-1.elb.amazonaws.com

aws elbv2 describe-load-balancers --query "LoadBalancers[?starts_with(DNSName, 'BankFast')].DNSName" --output text
```
**NOTE:**
- **[?starts_with(DNSName, 'bankfast-mr335')]**: Filters the list of load balancers based on the condition that their DNSName starts with the specified prefix.

- **--query**: option in the AWS CLI allows you to use JMESPath expressions to filter and manipulate the output of AWS CLI commands. JMESPath is a query language for JSON-like data structures, and it helps you extract specific data from the output in a flexible and powerful way.