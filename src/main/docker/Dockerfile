FROM openjdk:8-jre-alpine
MAINTAINER ameizi <sxyx2008@163.com>
VOLUME /tmp
ADD *.jar app.jar
RUN sh -c 'touch /app.jar' \
    && mkdir -p /opt/settings \
    && echo "env=DEV" > /opt/settings/server.properties
ENV JAVA_OPTS=""
EXPOSE 9090
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]