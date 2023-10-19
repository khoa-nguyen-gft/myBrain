## [Main title](/README.md)

# System Design

+ [What is Software Development Life Cycle (SDLC)?](#what-is-software-development-life-cycle-sdlc)
+ [What is System Design?](#what-is-system-design)
+ [What is Components of System Design?](#what-is-components-of-system-design)
+ [What is difference between System Design and System Analysis?](#what-is-difference-between-system-design-and-system-analysis)
+ [What are the steps system design?](#what-are-the-steps-system-design)
    ## Step: Gathering Functional Requirement
    - [What is Gathering functional requirement?](#what-is-gathering-functional-requirement)
    - [What is difference between Use Cases, User Flows and Sequence Diagram?](#what-is-difference-between-use-cases-user-flows-and-sequence-diagram)
    ## Step: Gathering Non-Functional Requirement
    - [What is Non-Functional Requirements ( Quality attribute requirements)?](#what-is-non-functional-requirements--quality-attribute-requirements)
    + [What is focus mainly in Non-Functional Requirements?](#what-is-focus-mainly-in-non-functional-requirements)

---

### What is Software Development Life Cycle (SDLC)?
- SDLC specifies the task(s) to be performed at various stages by a software engineer/developer. It ensures that the end product is able to meet the customer’s expectations and fits in the overall budget. 

![Alt text](images/What%20is%20System%20Development%20Life%20Cycle.png)

[Table of Contents](#main-title)

### What is System Design?
- System Design is the core concept behind the design of any distributed systems. System Design is defined as:
    + A process of creating an architecture for different components, interfaces, and modules of the system
    + Providing corresponding data helpful in implementing such elements in systems.
- Objectives of System Design
![Alt text](images/What%20is%20Objectives%20of%20System%20Design.png)

[Table of Contents](#main-title)


### What is Components of System Design?
- **Load balancer**s: Most crucial component for scalability, availability, and performance measures for systems. 
- **Rate Limiters:** These set the maximum number of requests a service can fulfill (Rate limiting, CDN, Cache, API gateway).

- **Storage**:
    - **Databases**: It is an organized collection of data so that they can be easily accessed and modified. 
    - **Key Value Stores**: It is a storage system similar to hashtables where key-value stores are distributed in hash tables.
    - **Blob Storage**: Blob stands for binary large objects, as the name suggests is storage for unstructured data such as YouTube, and Netflix. 

- **Distributed**:
    - **Distributed System Messaging Queue**: Transaction medium between producers and consumers.
    - **Distributed Unique ID generator:** In the case of large distributed systems, every moment multiple tasks occur so in order to distinguish it assign a tag corresponding to every event (Idempotency, Efficient Indexing and Retrieval, Auditing and Tracing, Partitioning).  
    - **Distributed Search:** Over every website, crucial information that visitors will seek is put into the search bar.
    - **Distributed Logging Services:** Tracing sequences of events from end to end.
    - **Distributed Task Scheduler:**  Computational resources such as CPU, memory, storage, etc. 
- **Monitoring**: 
    - **Monitoring System:** These are basically software where system administrators monitor infrastructures such as bandwidth, CPU, routers, switches, etc. 


    ![Alt text](images/What%20is%20Components%20of%20System%20Design.png)


[Table of Contents](#main-title)

### What is difference between System Design and System Analysis? 
- **System analysis** focuses on understanding and defining what the system should do
- **System Design** focuses on how the system will be implemented to meet those requirements. 
- These two phases are interdependent, as the analysis phase provides the foundation for the design phase. 

[Table of Contents](#main-title)

### What are the steps system design?
- Gathering functional requirement
- Gathering Non-Functional Requirements
- Defining System's API and Sequence of Events(Sequence of Diagram)
- Designing for Functional Requirements
- Addressing Non-Functional Requirements

[Table of Contents](#main-title)

## Step: Gathering Functional Requirement

### What is Gathering functional requirement?
- More powerful method of gathering requirements:
    - **Use Cases**: Situation / Scenario in which our system is used
    - **User Flows:** Step-By-Step / Graphical representation of each use case
- The three steps in the process are:
    - Identifying all the users and the actors
    - Gathering all the use cases
    - Expanding each use case with a flow of interactions between actors in our system

[Table of Contents](#main-title)

### What is difference between Use Cases, User Flows and Sequence Diagram? 

- **Use Cases** là các tình huống hoặc kịch bản mô tả cách người dùng hoặc hệ thống sử dụng sản phẩm hoặc ứng dụng trong các tình huống khác nhau. 

    <img src="images/Use%20Cases.png" width=50% height=50%>

-  **User Flows** là sự mô tả hướng dẫn chi tiết về cách người dùng sẽ tương tác với sản phẩm hoặc ứng dụng trong quá trình thực hiện một nhiệm vụ. 

    <img src="images/User%20Flows.png" width=50% height=50%>


- **Sequence Diagram** - Diagram that represents interactions between actors and objects.

    <img src="images/Sequence%20Diagram.png" width=50% height=50%>

- Tóm lại, Use Cases tập trung vào mô tả cách người dùng sử dụng sản phẩm trong các tình huống khác nhau, trong khi User Flows tập trung vào việc hướng dẫn người dùng qua từng bước cụ thể để đạt được mục tiêu. 


[Table of Contents](#main-title)


## Step: Gathering Non-Functional Requirement

### What is Non-Functional Requirements ( Quality attribute requirements)?
- Quality attribute requirements are essentially the same as non-functional requirements in the context of system design. Both terms refer to the characteristics and qualities that a system should exhibit beyond its functional capabilities. 
- These requirements define how a system should perform, behave, and interact under various conditions to meet user expectations and provide a positive experience.

[Table of Contents](#main-title)

### What is focus mainly in Non-Functional Requirements?
- **Scalability**
- **Performance**:
    - Throughput
    - Latency
- **Availability**:
    - Fault Tolerance
- **Durability**:
    - Redundancy
    - Replication
- **Another key concept**:
    - Time
    - CAP ('**C**'onsistency, '**A**'vailability, '**P**'artition Tolerance) Theorem
    - Lamport’s Logical Clock Theorem

<img src="images/What%20is%20key%20concepts%20of%20system%20design%20and%20performance.png" width=50% height=50%>

- **NOTE**:
  + **Availability (Khả dụng)**: Khả dụng bao gồm khả năng của hệ thống để luôn sẵn sàng và hoạt động, kể cả khi gặp sự cố. Bạn cũng đề cập đến tính khả dụng và khả năng chống chịu lỗi (Fault Tolerance) như một phần của Availability, vì chúng liên quan chặt chẽ đến việc hệ thống có thể tiếp tục hoạt động trong điều kiện khẩn cấp hoặc khi gặp sự cố.
      + **Fault Tolerance (Khả năng chống chịu lỗi)**: Xây dựng ứng dụng để xử lý lỗi một cách an toàn và đảm bảo tính toàn vẹn của dịch vụ trong trường hợp lỗi.
    
  + **Durability (Tính bền vững)**: Tính bền vững đề cập đến bảo vệ dữ liệu khỏi mất mát hoặc hỏng hóc trong trường hợp sự cố. Redundancy và Replication là các yếu tố quan trọng trong việc đảm bảo tính bền vững của dữ liệu.
      + **Redundancy (Sự dự phòng)**: Sử dụng các máy chủ dự phòng và tài nguyên dự phòng để đảm bảo tính khả dụng của hệ thống khi các thành phần gốc gặp sự cố.
      + **Replication (Sao chép)**: Lưu trữ dữ liệu và dịch vụ trên nhiều nút hoặc máy chủ để phân phối tải và tăng tính khả dụng.

  + **Lamport's Logical Clock Theorem** hoặc đồng hồ logic Lamport là một khái niệm trong lý thuyết hệ thống phân tán và đồng bộ hóa. Nó được sử dụng để ghi lại và xác định thứ tự của các sự kiện trong hệ thống phân tán mà không cần phụ thuộc vào đồng hồ thời gian thực. Điều này có nhiều ứng dụng quan trọng trong việc đảm bảo tính nhất quán, theo dõi thứ tự sự kiện và đồng bộ hóa trong các hệ thống phân tán.
 
    
[Table of Contents](#main-title)








