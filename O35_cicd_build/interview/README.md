## [Main title](/README.md)

![Alt text](images/Build%20Tool.png)


# Build Tool

+ [What is a Build Tool?](#what-is-a-build-tool)

+ ## Gradle
    + [What is Gradle?](#what-is-gradle)

    + [What is difference between `settings.grandle.kts` and file `build.gradle`?](#what-is-difference-between-settingsgrandlekts-and-file-buildgradle)
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
