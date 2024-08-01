FROM amazoncorretto:17-alpine

ENV context ""
ENV port 8189
RUN addgroup -S lazsa -g 1000 && adduser -S lazsa -u 1000 -G lazsa -s /bin/sh && mkdir /src && mkdir /temp && chown -R lazsa:lazsa /src
USER lazsa

ADD /src/main/resources/application.properties //

ADD /target/demo-1.0-SNAPSHOT.jar //
ENTRYPOINT ["java","-jar", "/demo-1.0-SNAPSHOT.jar", "--server.servlet.context-path=${context}","--server.port=${port}"]
