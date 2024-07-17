FROM amazoncorretto:17-alpine
ENV context ""
ENV port 8188
RUN addgroup -S lazsa -g 1000 && adduser -S lazsa -u 1000 -G lazsa -s /bin/sh && mkdir /src && chown -R lazsa:lazsa /src
USER lazsa

ADD /src/main/resources/application.properties //

COPY /build/libs/*-0.0.1-SNAPSHOT.jar demo.jar
ENTRYPOINT ["java", "-jar", "/demo.jar", "--server.servlet.context-path=${context}","--server.port=${port}"]