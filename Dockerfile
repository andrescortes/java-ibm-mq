FROM gradle:8.12-jdk17-alpine AS builder

ENV APP_HOME=/usr/app
WORKDIR $APP_HOME

COPY build.gradle main.gradle settings.gradle gradle.properties lombok.config ./

RUN gradle dependencies --no-daemon

COPY applications ./applications
COPY domain ./domain
COPY infrastructure ./infrastructure

RUN gradle bootJar --no-daemon -x test --info --stacktrace

FROM eclipse-temurin:17-jre-alpine

ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=70"
ENV APP_HOME=/usr/app
ENV JAR_FILE=JavaIBMMq.jar

WORKDIR $APP_HOME

RUN addgroup -S appgroup && adduser -S appuser -G appgroup

COPY --from=builder $APP_HOME/applications/app-service/build/libs/$JAR_FILE .

EXPOSE 8080

USER appuser

ENTRYPOINT exec java $JAVA_OPTS -jar $JAR_FILE
