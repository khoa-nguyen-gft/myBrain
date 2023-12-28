### Health

```url
  http://localhost:80/actuator/health
```



### DOCKER IMAGE

```yaml
# build docker
docker build . -t npdangkhoa/eurekaserver:s6

# List images
docker images

# Inspect image with image id
docker inspect image 5822dcb7fd78

# Run docker image
docker run -p 9090:9090 npdangkhoa/eurekaserver:s6

# list of ps of docker
docker ps -a

```
