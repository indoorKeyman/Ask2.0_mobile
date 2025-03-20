FROM openjdk:21-jdk

# 애플리케이션 JAR 파일 복사
COPY ./Jobs-0.0.1-SNAPSHOT.jar /Jobs.jar

# JAR 파일 실행
ENTRYPOINT ["java", "-jar", "/Jobs.jar"]
