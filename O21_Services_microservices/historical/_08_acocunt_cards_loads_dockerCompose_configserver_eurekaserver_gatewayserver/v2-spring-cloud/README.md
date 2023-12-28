

```yaml
export MS_version=s9

# build docker
# configserver
./configserver/gradlew -p ./configserver  clean build
docker build ./configserver/ -t npdangkhoa/configserver:$MS_version

#eurekaserver
./eurekaserver/gradlew -p ./eurekaserver  clean build
docker build ./eurekaserver/ -t npdangkhoa/eurekaserver:$MS_version

#accounts
./accounts/gradlew -p ./accounts  clean build
docker build ./accounts/ -t npdangkhoa/accounts:$MS_version

#cards
./cards/gradlew -p ./cards  clean build
docker build ./cards/ -t npdangkhoa/cards:$MS_version

#loans
./loans/gradlew -p ./loans  clean build
docker build ./loans/ -t npdangkhoa/loans:$MS_version


#gatewayserver
./gatewayserver/gradlew -p ./gatewayserver  clean build
docker build ./gatewayserver/ -t npdangkhoa/gatewayserver:$MS_version
```