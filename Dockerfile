FROM eclipse-temurin:17-jdk-focal as builder

RUN mkdir /source
WORKDIR /source

COPY . /source/
RUN ./gradlew --no-daemon test bootJar

FROM eclipse-temurin:17-jre-focal as releaser

RUN adduser --disabled-password --gecos "solarisbank default user" solarisbank
USER solarisbank

COPY --from=builder "/source/build/libs/*.jar" /app.jar

CMD ["java", "-jar", "/app.jar"]

EXPOSE 8080 9090
