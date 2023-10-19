- Note that we used glob to select all java files in the current folder. We can now build and run our binary:

```bash
bazel build //example-package:example_package && bazel run //example-package:example_package

```pwd