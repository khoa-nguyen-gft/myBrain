
# Cards Microservices
### Swagger

http://localhost:9000/swagger-ui/index.html

### UP
```
curl --location 'http://localhost:9000/api'
```


### Build Docker image by gradlew

```cmd
./gradlew bootBuildImage

docker run -p 9000:9000 npdangkhoa/cards:s4

```