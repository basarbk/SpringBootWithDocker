FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
COPY /target/helloserver.jar .
EXPOSE 8080
RUN sh -c 'touch /helloserver.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/helloserver.jar"]