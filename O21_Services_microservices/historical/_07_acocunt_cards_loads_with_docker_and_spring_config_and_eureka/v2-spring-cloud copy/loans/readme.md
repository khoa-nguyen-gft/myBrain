
# Customer Account Microservices
### Swagger

http://localhost:8090/swagger-ui/index.html

### UP
```cmd
curl --location 'http://localhost:9090/api'
```

### Build Docker image by gradlew

```cmd
./gradlew bootBuildImage --imageName=npdangkhoa/loans:s4

docker run -p 8090:8090 npdangkhoa/loans:s4


```