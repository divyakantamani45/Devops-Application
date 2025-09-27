FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY target/eks-sample-app-1.0.0.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
