FROM openjdk:8u191-jre-alpine3.8

RUN apk add curl jq
#workspace
WORKDIR /usr/share/udemy

# Add .jar under target from host

ADD target/selenium-docker.jar          selenium-docker.jar
ADD target/selenium-docker-tests.jar    selenium-docker-tests.jar
ADD target/libs                         libs

# Add ll dependency files like .json / .csv/ 

#ADD suite files in the 

ADD search-module.xml                   search-module.xml

#add health check
ADD healthcheck.sh                      healthcheck.sh

# Entry point, pass all envrionment variables, browser, host and test suite(MODULE)--in entry to try to parameterize as much as possible

#ENTRYPOINT java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* -DBROWSER=$BROWSER -DHUB_HOST=$HUB_HOST org.testng.TestNG $MODULE
ENTRYPOINT sh healthcheck.sh


