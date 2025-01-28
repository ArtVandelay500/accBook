# 베이스 이미지 설정
FROM openjdk:17-jdk-slim

# JAR 파일 복사
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar

# Expose the application port
EXPOSE 8080
# 실행 명령어 설정
ENTRYPOINT ["java", "-jar", "/app.jar"]
