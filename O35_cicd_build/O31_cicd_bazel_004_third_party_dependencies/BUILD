java_binary(
    name = 'example',
    srcs = ['Example.java'],
    main_class = 'example.Example',
    deps = [
        '@maven//:org_junit_jupiter_junit_jupiter_api'
    ],
)
# Note that we use @maven to specify a dependency on a Maven artifact. 
# The name of the dependency is the name of the artifact replacing dots, 
#colons and dashes (., :, -) with underscores (_): org_junit_jupiter_junit_jupiter_api.