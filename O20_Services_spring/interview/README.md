## [Main title](/README.md)

# Spring
+ [What is Spring?](#what-is-spring)
    ## Spring Bean
    + [What are IOC (Inversion of Control) and DI (Dependency Injection)?](#what-is-ioc-and-di)
    + [What is the difference between BeanFactory and ApplicationContext?](#what-is-difference-between-beanfactory-and-applicationcontext)
    + [What is Spring Bean?](#what-is-spring-bean)
    + [What is Spring Autowiring?](#what-is-spring-autowiring)
    + [What are the different bean scopes?](#what-are-the-different-bean-scope)
    + [What is difference between @Configuration and @Component?](#what-is-difference-between-configuration-and-component)
    + [What is difference between @Primary and @Qualifier?](#what-is-difference-between-primary-and-qualifier)
    + [What is difference between @Inject, @Autowired and @Resource?](#what-is-difference-between-inject-autowired-and-resource)

    ## Spring AOP
    + [What is AOP(Aspect Oriented Programming)?](#what-is-aop)
    + [What is the difference between Aspect and Advice?](#what-is-difference-between-aspect-and-advice)
    + [What is the difference between JoinPoint and Pointcut?](#what-is-defference-between-joinpoint-and-pointcut)

    # Spring MVC
    + [What is DispatcherServlet?](#what-is-dispatcherservlet)
    # Spring Boot
    + [What is Spring Boot?](#what-is-spring-boot)
    + [What is the difference between Spring and Spring Boot?](#what-is-difference-between-spring-and-spring-boot)
    + [What is the difference between Spring MVC and Spring Boot?](#what-is-difference-between-spring-mvc-and-spring-boot)
    + [What is Spring Boot Annotations?](#what-is-spring-boot-annotations)
    + [What is Spring Boot dependency management?](#what-is-spring-boot-dependency-management)
    + [What are the Spring Boot Starters?](#what-are-the-spring-boot-starters)
    + [What is Spring Boot Actuator?](#what-is-spring-boot-actuator)

    # Spring JPA
    + [What is the Java Persistence API?](#what-is-the-java-persistence-api)
    + [What is the ORM(Object-Relational-Mapping)?](#what-is-the-ormobject-relational-mapping)
    + [What is difference between JPA && Spring Data JPA && Hibernate?](#what-is-difference-between-jpa--spring-data-jpa--hibernate)
    + [What is difference between JpaRepository && CrudRepository?](#what-is-difference-between-jparepository--crudrepository)
    + [What is difference between FetchType and FetchMode?](#what-is-difference-between-fetchtype-and-fetchmode)
    + [What is difference between Cascade and OrphanRemoval?](#what-is-difference-between-cascade-and-orphanremoval)
    + [Explain persistence life cycle of an object?](#explain-persistence-life-cycle-of-an-object)
    + [What is @GeneratedValue?](#what-is-generatedvalue)
# Test
+ [What is Test Pyramid?](#what-is-test-pyramid)
+ [What is difference between BDD (Behavior-Driven Development) and TDD (Test-Driven Development)?](#what-is-difference-between-bdd-behavior-driven-development-and-tdd-test-driven-development)
    ## Junit
    + [What is JUnit?](#what-is-junit)
    + [What is the test suit?](#what-is-the-test-suit)
    + [What does Assert class?](#what-does-assert-class)
    + [What is difference between Junit4 and Junit5?](#what-is-difference-between-junit4-and-junit5)

    ## Mockito
    + [What is mockito?](#what-is-mockito)
    + [What is difference between @Mock && @Spy && @InjectMock?](#what-is-difference-between-mock--spy--injectmock)
    + [What is @MockBean in JUnit 5?](#what-is-mockbean-in-junit-5)

    ## Spring Framwork Testing 
    + [What is Integration Testing with JUnit 5?](#what-is-integration-testing-with-junit-5)
    + [What is Testcontainers in JUnit 5?](#what-is-testcontainers-in-junit-5)


    ## Wiremock
    + [What is Wiremock?](#what-is-wiremock)



-----
### What is Spring?
- It is a lightweight, loosely coupled, and integrated framework for developing enterprise applications in Java.

![Alt text](./images//What%20is%20Spring.png)

[Table of Contents](#spring-boot)

# Spring Bean
### What is IOC and DI?
- **IOC (Inversion of Control) and DI (Dependency Injection)** is a design pattern to provide loose coupling. It removes the dependency from the program.
- There are 2 types of IoC containers:
    - BeanFactory 
    - ApplicationContext 


![Alt text](images/What%20is%20Spring%20IoC%20(Inversion%20of%20Control)%20Container.png)

[Table of Contents](#spring-boot)

## What is difference between BeanFactory and ApplicationContext?
- BeanFactory is the basic container whereas ApplicationContext is the advanced container. 
- ApplicationContext extends the BeanFactory interface. ApplicationContext provides more facilities than BeanFactory such as integration with spring AOP, message resource handling for i18n etc.

![Alt text](images/What%20is%20difference%20between%20Spring%20BeanFactory%20and%20Spring%20ApplicationContext.png)

[Table of Contents](#spring-boot)

## What is Spring Bean?
- A bean is a managed object that is created, configured, and managed by the Spring framework. 
- Bean promotes loose coupling and modularity, making your code more maintainable and testable.

[Table of Contents](#spring-boot)

### What is Autowiring in Spring? 
- Autowiring enables the programmer to inject the bean automatically. We don't need to write explicit injection logic.

![Alt text](images/What%20is%20Spring%20Autowiring.png)

[Table of Contents](#spring-boot)


### What are the different bean scope?

![Alt text](./images/What%20are%20the%20different%20bean%20scope.png)

[Table of Contents](#spring-boot)

## What is difference between @Configuration and @Component?

- @Configuration is used to define configuration classes where you can declare beans using @Bean methods, while @Component is a generic annotation used to mark any Spring-managed component.

![Alt text](images/What%20is%20difference%20between%20@Configuration%20and%20@Component.png)

[Table of Contents](#spring-boot)


## What is difference between @Primary and @Qualifier?
- **@Primary**: In some cases, we need to register more than one bean of the same type.

- **@Qualifier** indicates specific bean should be autowired when there are multiple candidates.

[Table of Contents](#spring-boot)


## What is difference between @Inject, @Autowired and @Resource?

- **@Resource** annotation is part of the JSR-250 annotation collection and is packaged with Jakarta EE. This annotation has the following execution paths, listed by precedence:

- **@Inject** annotation belongs to the JSR-330 annotations collection. This annotation has the following execution paths

- **@Autowired** annotation is similar to the @Inject annotation. The only difference is that the @Autowired annotation is part of the Spring framework. This annotation has the same execution paths as the @Inject annotation

![Alt text](images/The%20table%20below%20summarizes%20our%20discussion..png)


[Table of Contents](#spring-boot)

## Spring AOP
### What is AOP?

- AOP is an acronym for Aspect Oriented Programming. It is a methodology that divides the program logic into pieces or parts or concerns.
- AOP enables you to dynamically add or remove concern before or after the business logic. It is pluggable and easy to maintain.

![Alt text](images/What%20is%20AOP.png)

[Table of Contents](#spring-boot)

### What is difference between Aspect and Advice?
- **Aspect** is a class in spring AOP that contains advices and joinpoints.

- **Advice**
    - Advice represents action taken by aspect.
    - There are 5 types of advices in spring AOP.
        + Before Advice
        + After Advice
        + After Returning Advice
        + Throws Advice
        + Around Advice

![Alt text](.//images/What%20is%20difference%20between%20Aspect%20and%20Advice.png)


[Table of Contents](#spring-boot)

### What is defference between JoinPoint and Pointcut?
- **JoinPoint** is any point in your program such as field access, method execution, exception handling etc.
- **Pointcut** is expression language of Spring AOP.

![Alt text](.//images/JoinPoint.png)

[Table of Contents](#spring-boot)

## Spring MVC
## What is DispatcherServlet?
- The DispatcherServlet class works as the front controller in Spring MVC.
- DispatcherServlet handles an incoming HttpRequest, delegates the request, and processes that request according to the configured HandlerAdapter interfaces

![Alt text](images/Handler%20Interceptors.jpg)

[Table of Contents](#spring-boot)



## Spring Boot
## What is Spring Boot?
- Spring Boot is a Spring module which provides RAD (Rapid Application Development) feature to Spring framework.

- It is used to create stand alone spring based application that you can just run because it needs very little spring configuration.

- The advantages of Spring Boot?
    - It allows to avoid heavy configuration of XML which is present in spring
    - It provides easy maintenance and creation of REST end points
    - It includes embedded Tomcat-server.
    - It automatically configure Spring whenever possible.
    - Microservice Based Architecture
    - Deployment is very easy, war and jar file can be easily deployed in the tomcat server.

[Table of Contents](#spring-boot)




## What is difference between Spring and Spring Boot?


![Alt text](images/What%20is%20difference%20between%20Spring%20and%20Spring%20Boot.png)

[Table of Contents](#spring-boot)


## What is difference between Spring MVC and Spring Boot?

- Spring Boot and Spring MVC are both frameworks within the Spring ecosystem that are commonly used for building Java-based web applications. While they are related, they serve different purposes and can be used together to create robust web applications.


![Alt text](images/What%20is%20difference%20between%20Spring%20MVC%20and%20Spring%20Boot.png)

[Table of Contents](#spring-boot)

## What is Spring Boot Annotations?
- Spring Annotations are a form of metadata that provides data about a program. Annotations are used to provide supplemental information about a program. It does not have a direct effect on the operation of the code they annotate. It does not change the action of the compiled program.
- Some of the annotations that are available in this category are:
    - @SpringBootApplication
    - @SpringBootConfiguration
    - @EnableAutoConfiguration
    - @ComponentScan
    - Auto-Configuration Conditions(@Conditional,  @ConditionalOnClass..)


![Alt text](images/What%20is%20Spring%20Boot%20Annotations.png)

[Table of Contents](#spring-boot)

### What is Spring Boot dependency management?
- Spring Boot manages dependencies and configuration automatically. You don't need to specify version for any of that dependencies.

- Spring Boot upgrades all dependencies automatically when you upgrade Spring Boot.


[Table of Contents](#spring-boot)

### What are the Spring Boot Starters?
- Starters are a set of convenient dependency descriptors which we can include in our application.

- Spring Boot provides built-in starters which makes development easier and rapid. 

[Table of Contents](#spring-boot)


## What is Spring Boot Actuator?
- Developing and Managing an application are the two most important aspects of the application’s life cycle. It is very crucial to know what’s going on beneath the application. Also when we push the application on production, managing it gradually becomes critically important.
- Spring Boot’s ‘Actuator’ dependency is used to monitor and manage the Spring web application.
- We can use it to monitor and manage the application with the help of HTTP endpoints or with the JMX.

![Alt text](images/What%20is%20Spring%20Boot%20Actuator.png)

[Table of Contents](#spring-boot)


# Spring JPA

### What is the Java Persistence API?
- **The Java Persistence API (JPA)** is the specification of Java that is used to persist data between Java object and relational database. JPA acts as a bridge between object-oriented domain models and relational database systems. 

![Alt text](./images/spring_data_overview_small.jpg.webp)

[Table of Contents](#spring-jpa)

### What is the ORM(Object-Relational-Mapping)?
- **The object-relational mapping** is a mechanism which is used to develop and maintain a relationship between an object and the relational database by mapping an object state into the database column.

![Alt text](./images/spring-boot-jpa3.png)

[Table of Contents](#spring-jpa)


### What is difference between JPA && Spring Data JPA &&  Hibernate?

1. **JPA (Java Persistence API):** is a specification, It specifies the specifications for persisting, reading and managing Java objects mapped to database tables.
2. **Spring Data JPA:** is a JPA Data Access Abstraction. With Spring Data, you may use Hibernate, Eclipse Link or any other JPA provider.
3. **Hibernate**: is a JPA implementation

![Alt text](.//images/Depends%20on.png)

[Table of Contents](#spring-jpa)


### What is difference between JpaRepository && CrudRepository?

![Alt text](./images/Repository.webp)

[Table of Contents](#spring-jpa)


### What is difference between FetchType and FetchMode?

- In Spring Data JPA, FetchMode and FetchType are used to control the fetching behavior of associations between entities. Let's understand each of them:	
    - **FetchType(Lazy/Eager):** It defines WHETHER hibernate will fetch the data or not.
    - **FetchMode (Select/Join)** tells whether we want our entitity to be loaded with additional select or in one query with join or subselect.

![Alt text](./images//Pasted%20Graphic%2037.png)


[Table of Contents](#spring-jpa)


### What is difference between Cascade and OrphanRemoval?

- In Spring Data JPA, cascade and orphanRemoval are two related features that can be used together to manage the lifecycle of related entities. 
    + **Cascade[PERSIST, MERGE, REMOVE]:**
	The cascade attribute, available in @OneToMany, @OneToOne, and @ManyToMany annotations, allows you to specify which operations on the owner entity should be cascaded to the associated entities. When an operation is performed on the owner entity, the same operation will be applied to the associated entities based on the specified cascade types

    ![Alt text](./images/Pasted%20Graphic%20362.png)

    + **Orphan Removal:**
	The orphanRemoval attribute, available in @OneToOne and @OneToMany annotations, works in conjunction with cascade operations to automatically remove associated entities when they are no longer referenced by the owner entity. It is useful when you want to ensure that associated entities are deleted from the database when they become orphaned.

    ![Alt text](./images/Pasted%20Graphic%20372.png)

- By combining the cascade and orphanRemoval features, you can define the behavior of related entities when performing operations on the owner entity. Cascade operations propagate the specified operations to associated entities, while orphanRemoval ensures that orphaned entities are automatically removed from the database.

[Table of Contents](#spring-jpa)


### Explain persistence life cycle of an object?
- **Transient** - The object is called to be in the transient state when it is just declared by using the new keyword. When an object remains in the transient state, it doesn't contain any identifier(primary key) in the database.
- **Persistence** - In this state, an object is associated with the session and either saved to a database or retrieved from the database. When an object remains in the persistence state, It contains a row of the database and consists of an identifier value. We can make an object persistent by associating it with the hibernate session.

- **Detached** - The object enters into a detached state when the hibernate session is closed. The changes made to the detached objects are not saved to the database.

![Alt text](./images/Explain%20persistence%20life%20cycle%20of%20an%20object.png)

[Table of Contents](#spring-jpa)


### What is @GeneratedValue?
-  **@GeneratedValue** annotation is used to specify the generation strategy for the values of primary key columns in an entity. It works in conjunction with the @Id annotation to automatically generate unique primary key values when entities are persisted.

![Alt text](./images/IDENTITY.png)

[Table of Contents](#spring-jpa)

# Test
### What is Test Pyramid?
+ **Unit Testing Framework:** Choose a unit testing framework that supports your programming language. Some popular options include JUnit for Java

+ **Integration Testing Framework**: Use an integration testing framework to test the interaction between multiple microservices. Examples include Spring Boot for Java, RestAssured for REST APIs

+ **Contract Testing**: Implement contract testing to ensure compatibility and agreement between microservices. Tools like Pact or Spring Cloud Contract

![Alt text](./images/What%20is%20Test%20Pyramid.png)


[Table of Contents](#test)


### What is difference between BDD (Behavior-Driven Development) and TDD (Test-Driven Development)?
+ BDD (Behavior-Driven Development) and TDD (Test-Driven Development) are both software development methodologies that emphasize testing and collaboration. 

![Alt text](./images/What%20is%20difference%20between%20BDD%20(Behavior-Driven%20Development)%20and%20TDD%20(Test-Driven%20Development).png)

[Table of Contents](#test)

### What is JUnit?
- JUnit is the testing framework, it is used for unit testing of Java code.

[Table of Contents](#test)

### What is unit testing?
- The process of testing individual functionality (known as a unit) of the application is called unit testing.

[Table of Contents](#test)

### What is the test suit?
- The test suit allows us to group multiple test cases so that it can be run together. TestSuit is the container class under junit.framework.TestSuite package.

[Table of Contents](#test)

### What does Assert class?
- Assert class provides methods to test the test cases.
![Alt text](./images/Pasted%20Graphic%2020.png)

[Table of Contents](#test)


### What is difference between Junit4 and Junit5?
- JUnit 4 is a monolithic testing framework, whereas JUnit 5 has a modular architecture.
- Annotations JUnit 4:
    + @Test
    + @Before
    + @After
    + @BeforeClass
    + @AfterClass
    + @Ignore
    + @RunWith(MockitoJUnitRunner.class) 
- Annotations JUnit 5:
    + @Test
    + @BeforeEach
    + @AfterEach
    + @BeforeAll
    + @AfterAll
    + @Disable
    + @ExtendWith(MockitoExtension.class)

[Table of Contents](#test)




## Mockito

### What is mockito?

- **Mockito** is a widely-used Java framework that allows developers to create and use mock objects in unit testing. Mock objects are objects that simulate the behavior of real objects in a controlled way, making it easier to test the interactions between different components of an application. Mockito is particularly popular for its simplicity and ease of use in creating mock objects and setting expectations on them.

![Alt text](./images/What%20is%20mockito.png)

[Table of Contents](#test)
 ### What is difference between @Mock && @Spy && @InjectMock?
- In Java testing frameworks like JUnit and Mockito, @Mock, @Spy, and @InjectMocks are annotations used for creating and configuring mock objects. These annotations are commonly used in combination to set up test scenarios, but they serve different purposes. 

![Alt text](images/What%20is%20difference%20between%20@Mock%20&&%20@Spy%20&&%20@InjectMockskhi.png)

[Table of Contents](#test)

### What is @MockBean in JUnit 5?
- When writing tests, you may want to isolate certain dependencies of the component under test by replacing them with mock objects. The @MockBean annotation allows you to create a mock object and register it as a bean in the Spring application context for the duration of the test.

[Table of Contents](#test)



# Spring Boot Integration
### What is Integration Testing with JUnit 5?
- In JUnit 5, integration testing in Spring Boot can be performed using the following annotations:

![Alt text](./images/Pasted%20Graphic%2025.png)

[Table of Contents](#test)


### What is Testcontainers in JUnit 5?

- Testcontainers is particularly useful in scenarios where you need to perform integration testing with external dependencies or services.

[Table of Contents](#test)


# Wiremock
### What is Wiremock?
- **WireMock** is an open-source library for creating HTTP-based mock web services. It allows developers to simulate the behavior of real web services by defining HTTP response behaviors for specific requests. WireMock is particularly useful for testing applications that depend on external APIs or services, as it enables you to isolate your application from the real services during testing.


![Alt text](.//images/What%20is%20Wiremock.png)

[Table of Contents](#test)
