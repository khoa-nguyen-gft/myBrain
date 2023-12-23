
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
docker build . -t npdangkhoa/configserver:s6

# List images
docker images

# Inspect image with image id
docker inspect image 5822dcb7fd78

# Run docker image
docker run -p 9090:9090 npdangkhoa/account:s4

# list of ps of docker
docker ps -a

```

