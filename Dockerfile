FROM maven:3.9-eclipse-temurin-17 AS build

WORKDIR /app

COPY . .

RUN mkdir -p /root/.m2 && \
echo "<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0">
<servers>
<server>
<id>github</id>
<username>johan969</username>
<password>'"$MY_GITHUB_TOKEN"'</password>
</server>
</servers>
</settings>" > /root/.m2/settings.xml


RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]