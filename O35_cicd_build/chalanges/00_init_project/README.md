


### List all tasks
```cmd
VNPC021952:00_init_project kany$ gradle tasks --all

> Configure project :
Gradle Rock

> Task :tasks

------------------------------------------------------------
Tasks runnable from root project 'basic'
------------------------------------------------------------

Build Setup tasks
-----------------
init - Initializes a new Gradle build.
wrapper - Generates Gradle wrapper files.

Help tasks
----------
buildEnvironment - Displays all buildscript dependencies declared in root project 'basic'.
dependencies - Displays all dependencies declared in root project 'basic'.
dependencyInsight - Displays the insight into a specific dependency in root project 'basic'.
help - Displays a help message.
javaToolchains - Displays the detected java toolchains.
kotlinDslAccessorsReport - Prints the Kotlin code for accessing the currently available project extensions and conventions.
outgoingVariants - Displays the outgoing variants of root project 'basic'.
projects - Displays the sub-projects of root project 'basic'.
properties - Displays the properties of root project 'basic'.
resolvableConfigurations - Displays the configurations that can be resolved in root project 'basic'.
tasks - Displays the tasks runnable from root project 'basic'.

Other tasks
-----------
components - Displays the components produced by root project 'basic'. [deprecated]
dependentComponents - Displays the dependent components of components in root project 'basic'. [deprecated]
firstTask
model - Displays the configuration model of root project 'basic'. [deprecated]
prepareKotlinBuildScriptModel

```

### Call and Execute Tasks


```cmd
VNPC021952:00_init_project kany$ gradle firstTask

> Configure project :
Gradle Rock

BUILD SUCCESSFUL in 395ms
VNPC021952:00_init_project kany$ 
```
