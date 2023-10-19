
- Execute GraphQL query with a command-line tool

```bash
npm init  
npm install express express-graphql graphql --save

```

- Now, run this using the following command:

```
node server.js  
```

-  If you navigate in a web browser to http://localhost:4000/graphql, you should see an interface that lets you enter queries. It should look like:

```json
{
  hello
}
```

```bash
curl -X POST \
-H "Content-Type: application/json" \
-d '{"query": "{ hello }"}' \
http://localhost:4000/graphql
```