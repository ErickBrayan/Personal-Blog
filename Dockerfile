FROM openjdk:17-slim

COPY target/Personal-Blog-0.0.1-SNAPSHOT.jar Personal-Blog.jar

EXPOSE 8080

CMD ["java", "-jar", "/Personal-Blog.jar"]