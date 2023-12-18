## [Main title](/README.md)


## Docker
+ [What is containerize?](#what-is-containerize)
+ [Why do we need containerize?](#why-do-we-need-containerize)
+ [What is difference between Containerization, Container and Docker?](#what-is-difference-between-containerization-container-and-docker)
+ [What is difference between Container and VM?](#what-is-difference-between-container-and-vm)
+ [What is difference between FROM, MAINTAINER, COPY và ENTRYPOINT in Dockerfile?](#what-is-difference-between-from-maintainer-copy-và-entrypoint-in-dockerfile)
+ [What is difference between RUN, ENTRYPOINT and CMD in Dockerfile?](#what-is-difference-between-run-cmd-entrypoint-in-dockerfile)

## Kuberante

## HELM

## ECS
+ [What is difference between ECS, EKS, Fargate and ECR?](#what-is-difference-between-ecs-eks-fargate-and-ecr)


## Other
+ [What is Docker Commands Diagram?](#what-is-docker-commands-diagram)


---
## Docker
### What is containerize?
[Table of Contents](#docker)


### Why do we need containerize?
- Containers offer a self-contained and isolated environment for applications, including all necessary dependencies.
- By containerizing an application, it becomes portable and can run seamlessly in any cloud environment. 
- Containers enable unified management of applications regardless of the language or framework used.

[Table of Contents](#docker)


### What is difference between Containerization, Container and Docker?
- **Container** is a loosely isolated environment that allows us to build and run software packages. These software packages include the code and all dependencies to run applications quickly and reliably on any computing environment. We call these packages as container images.

- **Containerization** is an OS virtualization method that is used to deploy and run containers without using a virtual machine (VM). Containers can run on physical hardware, in the cloud, VMs, and across multiple OS.

- **Docker** is an open source platform that "provides the bility to package and run an application in a loosely isolated"


![Alt text](.//images/Pasted%20Graphic%2026.png)


[Table of Contents](#docker)


### What is difference between Container and VM?
- Main differences between virtual machines and containers. Containers don't need the Guest OS nor the
hypervisor to assign resources; instead, they use the container engine.

![Alt text](./images/Containers%20VS%20VMs.png)

[Table of Contents](#docker)


### What is difference between FROM, MAINTAINER, COPY và ENTRYPOINT in Dockerfile?
- **FROM**: The FROM instruction sets the base image for subsequent instructions in the Dockerfile. 
- **MAINTAINER**: The MAINTAINER instruction, while deprecated since Docker version 1.13.0 in favor of LABEL, used to specify the author or maintainer of the Dockerfile. 
- **ENTRYPOINT**: As mentioned earlier, ENTRYPOINT specifies the primary command that should be run when a container is launched. It sets the initial command that is executed when the container starts.


```yaml
#Start with a base image containing Java runtime
FROM openjdk:17-jdk-slim

#Information around who maintains the image
MAINTAINER eazybytes.com

# Add the application's jor to the image
COPY build/libs/accounts-0.0.1-SNAPSHOT.jar accounts-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "accounts-0.0.1-SNAPSHOT.jar"]

```

[Table of Contents](#docker)

### What is difference between RUN, CMD, ENTRYPOINT in Dockerfile?

- **RUN**: This instruction is used to execute commands during the build process of the Docker image. It's responsible for running commands like installing packages, setting up configurations, downloading files, etc. Each RUN command creates a new layer in the Docker image.

```yaml
RUN apt-get update && apt-get install -y python3
```

-**ENTRYPOINT**: ENTRYPOINT is the primary command that's executed when the **container starts**, and it can also be used to pass arguments dynamically to the containerized application.

```yaml
ENTRYPOINT ["python3", "app.py"]
```

- **CMD**: CMD is used to provide default commands that will be executed when a container is launched from the image. 

```yaml
CMD ["default_argument"]
```



```yaml
# Use a base image
FROM python:3.9

# Set the working directory in the container
WORKDIR /app

# Copy the Python script into the container
COPY app.py /app/app.py

# Install any dependencies needed for the application
RUN pip install requests

# Set the entry point as the Python interpreter with app.py as the default argument
ENTRYPOINT ["python", "app.py"]

# Default argument if none is provided when running the container
CMD ["default_argument"]

# Docker run
# docker run my-python-app [default_argument]
# docker run my-python-app custom_argument


```

[Table of Contents](#docker)



## Kuberante

## Heml

## ECS

### What is difference between ECS, EKS, Fargate and ECR?
![Alt text](.//images/Pasted%20Graphic%2027.png)

[Table of Contents](#aws)


## Other

### What is docker Commands Diagram?

![Alt text](.//images/Docker%20Commands%20Diagram.png)

```yaml
# build docker
docker build . -t npdangkhoa/account:s4

# List images
docker images

# Inspect image with image id
docker inspect image 5822dcb7fd78

# Run docker image
docker run -p 9090:9090 npdangkhoa/account:s4

# list of ps of docker
docker ps -a
```

[Table of Contents](#other)
