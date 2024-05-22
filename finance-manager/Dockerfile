FROM openjdk:17-jdk-alpine
EXPOSE 8083
ADD target/finance-manager.jar finance-manager.jar
ENTRYPOINT ["java","-jar","/finance-manager.jar"]