- We use the java_binary rule. All rules in Bazel require a name. This name is called a target name in Bazel, and it’s used to create unique way to refer to this specific binary. We chose example_package as a name, but it could have been anything. The srcs argument is used to specify the source files we want to compile. Finally, we need to tell Bazel which package contains the main function.

We can now build our binary:


```bash
#ove-challenge-code/O31_cicd_bazel/O31_cicd_bazel_001_first_example
pwd

bazel build //example-package:example_package
```

And run it:

```bash
bazel run //example-package:example_package
```

**NOTE:**
   + **//example-package:example_package** syntax. This is called a label. A label is used to uniquely identify a target. The **//** at the beginning tells Bazel to go to the root of this workspace (Where the WORKSPACE file is).