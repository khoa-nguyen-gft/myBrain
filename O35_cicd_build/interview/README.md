## [Main title](/README.md)

![Alt text](images/Build%20Tool.png)


# Build Tool

+ [What is a Build Tool?](#what-is-a-build-tool)

+ ## Gradle
    + [What is Gradle?](#what-is-gradle)

    + [What is difference between `settings.grandle.kts` and file `build.gradle`?](#what-is-difference-between-settingsgrandlekts-and-file-buildgradle)
    + [What is difference between buildscript, plugin, implementation in gradle?](#what-is-difference-between-buildscript-plugin-implementation-in-gradle)
    + [What is difference between `testImplementation` and `implementation` in gradle?](#what-is-difference-between-implementation-testimplementation-and-testruntimeonly-in-gradle)



+ ## Bazel
    + [What is Bazel?](#what-is-postgresql)
    + [What is difference between WORKSPACE file and BUILD in bazel?](#what-is-difference-between-workspace-file-and-build-in-bazel)



---

### What is a Build Tool?
- Build tools are programs that are used to automate the creation of executable applications from source code. 
- The building process involves compiling, linking, and packaging the code into a useful or executable form. Developers often implement the build process manually for small projects. 
- But this cannot be done for large projects where it is complicated to keep track of what is needed for construction, in what order, and what dependencies are in the building process. Using the automation tools makes the build process more consistent.

[Table of Contents](#gradle)


## Gradle
### What is Gradle?
- Gradle is an open source build automation tool that is based on the concept of Apache Maven and Apache Ant. It is capable of building almost any type of software.
- It is designed for the multi-project build, which can be quite large. It introduces a Java and Groovy-based DSL(Domain Specific Language)

[Table of Contents](#gradle)


### What is difference between `settings.grandle.kts` and file `build.gradle`?
-  `settings.grandle.kts` is used to configure the project's structure and settings. It defines the organization of the project, specifies which subprojects are part of the build, and manages settings that are common to all subprojects.

```gradle
// settings.gradle.kts
rootProject.name = "my-project"

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
    }
    includeBuild("../my-build-logic")
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
    includeBuild("../my-other-project")
}

include("app")
include("business-logic")
include("data-model")

```


- `build.gradle.kts` file (or build.gradle in Groovy DSL) is used to configure the build process of a specific subproject within the larger project. Each subproject typically has its own build.gradle.kts file, which defines its dependencies, tasks, and other build-related configurations.


```gradle
plugins {
    kotlin("jvm") version "1.5.21"
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}

```

[Table of Contents](#gradle)


### What is difference between `buildscript`, `plugin`, `implementation` in gradle?
- `buildscript` is used to configure the build script itself. It defines dependencies and repositories needed to execute the build script. Inside 

```gradle
buildscript {
    apply from: 'gradle/artifactroty.gradle'
}
```
- A **`plugin`** is a class that implements the Plugin interface, which defines the basic functionality of a Gradle build. Plugins can extend or modify the behavior of the core plugins that are provided by Gradle, such as JavaPlugin, KotlinPlugin, or AndroidPlugin. Plugins can also be created by third-party developers to add new features or integrations to Gradle.

```gradle
plugins {
    id 'java-gradle-plugin'
}
```

- An **`implementation`** is a configuration that declares dependencies on artifacts that are used by your project. Dependencies are references to external libraries or modules that provide some functionality or data for your project. For example, if you want to use the Jackson library to parse JSON data in your Java application, you need to add it as a dependency in your build.gradle file.

```gradle
dependencies {
    implementation 'org.springframework.security:spring-security-core:5.6.1'
    implementation 'com.fasterxml.jackson.core:jackson-databind:2.13.0'
}
```

- The main difference between `plugin` and `implementation` is that plugin is used to configure the core behavior of your project, while implementation is used to declare dependencies on external artifacts. Plugins can affect how your project builds, tests, runs, or publishes its results. Dependencies can affect how your project accesses or uses other libraries or modules.





[Table of Contents](#gradle)


### What is difference between `implementation`, `testImplementation`,  and `testRuntimeOnly` in gradle?
-  **`implementation`** applies dependencies to all source sets, including the test source set

-  **`testImplementation`** is a configuration that applies dependencies only to the test source set, 
- **`testRuntimeOnly`**: This configuration is used to declare dependencies that are required for the execution of your test code only. Dependencies declared in this configuration will not be visible to other modules that depend on your module.



```
For example, if you have a dependency on junit in your app module, you can use either of these configurations:

implementation 'junit:junit:4.12'

testImplementation 'junit:junit:4.12'

// The first one will include the junit dependency in your app module and its dependencies, while the second one will only include it in your app module and not in its dependencies.

```

[Table of Contents](#gradle)


### What is difference between `gradlew `and `gradlew.bat` in gradle?
- `gradlew` and `gradlew.bat` are scripts used in Gradle-based projects. Gradle is a build automation tool primarily used for Java projects but capable of handling builds in various programming languages.

- When you execute commands like ./gradlew build (on Unix-based systems) or gradlew.bat build (on Windows), these scripts handle fetching the correct Gradle version if needed and then execute the specified Gradle tasks for the project.



[Table of Contents](#gradle)

# Bazel

### What is Bazel?
- **Bazel** is an open-source build and test tool developed by Google for multi-language, multi-platform projects of any size. It is a powerful tool that can help you to build and test your software quickly and reliably.

![Alt text](images/What%20is%20Bazel.png)

 [Table of Contents](#bazel)



### What is difference between WORKSPACE file and BUILD in bazel?
- The main difference between a WORKSPACE file and a BUILD file in Bazel is that a WORKSPACE file is used to define external dependencies, while a BUILD file is used to define targets within a workspace.
- A WORKSPACE file can be used to define the following:
    + External repositories
    + Workspaces
    + Build rules
- A BUILD file can be used to define the following:
    + Targets
    + Build rules

Example: 
- The WORKSPACE file defines external repositories for the TensorFlow library and the Go standard library:

```json
http_archive(
    name = "org_tensorflow",
    url = "https://github.com/tensorflow/tensorflow/archive/refs/heads/master.zip",
    strip_prefix = "tensorflow-master",
)

local_repository(
    name = "go",
    path = "/usr/local/go",
)
```
- The BUILD.bazel file defines a target that builds a simple executable that uses the TensorFlow library and the Go standard library:

```json
go_binary(
    name = "my_program",
    srcs = ["go/src/main.go"],
    deps = [
        "@org_tensorflow//tensorflow/c/go/libtensorflow_c.so",
        "@go//src/runtime",
    ],
)
```

- Bazel would first read the WORKSPACE file to find the TensorFlow library and the Go standard library. It would then download and build the TensorFlow library as needed. Once the TensorFlow library and the Go standard library are built, Bazel would build the my_program executable.



**Note**: 
- **Targets**: A target is a unit of work that can be built by Bazel. Targets can be libraries, executables, tests, or other types of artifacts.

 [Table of Contents](#bazel)
