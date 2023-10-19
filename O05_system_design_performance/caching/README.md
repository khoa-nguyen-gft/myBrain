## [Main Title](/README.md)

![Alt text](.//images/Pasted%20Graphic%2019.png)


# Caching
+ [What is Caching?](#what-is-caching)
+ [What is Caching strategie?](#what-is-caching-strategie)
+ ## Caching strategies:
    + [What is Cache Aside?](#what-is-cache-aside)
    + [What is Read Through?](#what-is-read-through)
    + [What is difference Write Through and Write Behind?](#what-is-difference-write-through-and-write-behind)
+ [What is difference between LRU(Least Recently Used) and LFU(LFU) in Eviction Policies?](#what-is-difference-between-lruleast-recently-used-and-lfulfu-in-eviction-policies)
+ [How Caches Work?](#how-caches-work)
+ [What is A Few Caching Technologies?](#what-is-a-few-caching-technologies)

## Redis
+ [What is Redis?](#what-is-redis)
+ [What is difference between Redis and Memcached?](#what-is-difference-between-redis-and-memcached)

---
### What is Caching?

- **Pros**:
    + Improve read performance (aka Latency)
    + Reduce the load (aka Throughput)
- **Cons**: 
    + Increases complexity
    + Consumes resources
- Cache store elements in Linked list

![Alt text](.//images/What%20is%20Eviction%20Policies.png)

[Table of Contents](#main-title)

### What is Caching strategie?

+ Cache Aside
+ Read Through
+ Write Through
+ Write Behind

![Alt text](./images//Caching%20strategies.png)


[Table of Contents](#main-title)

### What is Cache Aside?
**Pros:**
+ Cache only what’s needed

**Cons:**
+ Cache misses are expensive
+ Data staleness
+ Implementation complexity

![Alt text](images/What%20is%20Cache%20Aside.png)


**NOTE:**
- **"Cached misses are expensive"** có nghĩa là khi một hệ thống hoặc chương trình không thể tìm thấy dữ liệu hoặc thông tin cần thiết trong bộ nhớ cache (bộ nhớ nhanh), thì việc truy xuất dữ liệu từ nguồn chính (ví dụ: bộ nhớ chính hoặc ổ đĩa cứng) sẽ mất thời gian và tài nguyên đáng kể. Điều này thường xảy ra trong các hệ thống máy tính khi cache không thể giữ toàn bộ dữ liệu hoặc khi dữ liệu trong cache bị hết hạn.

- **Data staleness:** Dữ liệu stateless không phụ thuộc vào bất kỳ trạng thái nào, do đó nó không thay đổi theo thời gian hoặc tình trạng hiện tại của hệ thống.

[Table of Contents](#main-title)


### What is Read Through?

**Read Through**
+ **Pros:**
    + Cache only what’s needed
    + Transparent

+ **Cons:**
    + Cache misses are expensive
    + Data staleness
    + Reliability


![Alt text](images/What%20is%20Read%20Through.png)


[Table of Contents](#main-title)


### What is difference write Through and write behind?

**Write Through**
+ **Pros**
    + Up-to-date data
+ **Cons:**
    + Writes are expensive
    + Redundant data

**Write Behind**

+ **Pros**
    + No write penalty
    + Reduced load on storage
+ **Cons:**
    + Reliability
    + Lack of consistency

![Alt text](.//images/Write%20Through.png)

![Alt text](.//images/Write%20Behind.png)

[Table of Contents](#main-title)



### What is difference between LRU(Least Recently Used) and LFU(LFU) in Eviction Policies?
+ Most caches use LRU as the default
+ LRU is faster and cheaper 1in terms on memory than LFU
+ LFU suffers less from false cache eviction
+ **FIFO**: First In First Out


![Alt text](.//images/What%20is%20difference%20between%20LRU(Least%20Recently%20Used)%20and%20LFU(LFU)%20in%20Eviction%20Policies.png)

[Table of Contents](#main-title)

### How Caches Work?
- Horizontally scaled servers
- Clients hash requests to a given server
- In-memory (fast)
- Appropriate for applications with more reads than writes
- The expiration policy dictates how long data is cached. Too long and your data may go stale; too short and the cache won't do much good.


![Alt text](.//images/How%20Caches%20Work.png)

[Table of Contents](#main-title)

### What is A Few Caching Technologies?

![Alt text](.//images/What%20is%20A%20Few%20Caching%20Technologies.png)

[Table of Contents](#main-title)


# Redis 
### What is Redis?
- In-Memory
- Key-Value Store
- Limited by RAM
    - Biggest servers are around 500GB RAM at the moment
- Supports 100K+ requests per second on a single node
- Stores data to disk, but can loose recent data
- Type in Redis

![Alt text](.//images/What%20is%20type%20in%20Redis.png)

[Table of Contents](#redis)


### What is difference between Redis and Memcached?
- **Redis**
    + Data replication is supported.
    + It is a single-threaded architecture.	
- **Memcached**
    + Data replication is NOT supported.
    + It is a multi-threaded architecture.

[Table of Contents](#redis)
