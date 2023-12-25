
# Customer Account Microservices
### Swagger

http://localhost:9090/swagger-ui/index.html

### UP
```
curl --location 'http://localhost:9090/api'
```

### Create Customer Account

```
curl --location 'http://localhost:9090/api/create' \
--header 'Content-Type: application/json' \
--data-raw '{
      "name": "John Doe",
      "email": "john@example.com",
      "mobileNumber": "1234567890"
    }'
```

### Get Customer Account

```
curl --location 'http://localhost:9090/api/fetch?phoneNumber=12345678888'
```


### Update Customer Account

```
curl --location --request PUT 'http://localhost:9090/api/update' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "John Doe updated",
    "email": "john@example.com",
    "mobileNumber": "12345678888",
    "accounts": {
        "accountNumber": 11185867631,
        "accountType": "Savings",
        "branchAddress": "123 Main Street, New York"
    }
}'
```

### Delete Customer Account

```
curl --location --request DELETE 'http://localhost:9090/api/delete?phoneNumber=1234567890'
```

### Build JARs

```
./gradlew clean build 
```

###  Start Jar file


```cmd
java -jar  build/libs/accounts-0.0.1-SNAPSHOT.jar
```


### DOCKER IMAGE

```yaml
# build docker
docker build . -t npdangkhoa/accounts:s4

# List images
docker images

# Inspect image with image id
docker inspect image 5822dcb7fd78

# Run docker image
docker run -p 9090:9090 npdangkhoa/account:s4

# list of ps of docker
docker ps -a

```

