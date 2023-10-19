var { graphql, buildSchema } = require('graphql');

// A schema is constructed using GraphQL schema language  
var schema = buildSchema(`
    type Query {
        hello: String
    }
`);

// The root provides a resolver function for  each API endpoint  
var root = {
    hello: () => {
        return "Hello world! This is the first GrapghQL query"
    },
};

// Run the GraphQL query '{ hello }' and print out the response
graphql({
    schema,
    source: "{ hello }",
    rootValue: root,
}).then(response => {
    console.log(response)
})