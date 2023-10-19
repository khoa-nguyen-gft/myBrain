var express = require("express");
const { graphqlHTTP } = require('express-graphql');
var { buildSchema } = require('graphql');


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
var app = express()
app.use(
    "/graphql",
    graphqlHTTP({
        schema: schema,
        rootValue: root,
        graphiql: true,
    })
)

app.listen(4000)
console.log("Running a GraphQL API server at http://localhost:4000/graphql")
