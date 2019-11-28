FROM adoptopenjdk/openjdk11-openj9:jdk-11.0.1.13-alpine-slim
WORKDIR /opt/apps
ADD . /opt/apps
RUN ./gradlew shadowJar
EXPOSE 8080
CMD java ${JAVA_OPTS} \
    -jar build/libs/java-slack-bot-example-al.jar