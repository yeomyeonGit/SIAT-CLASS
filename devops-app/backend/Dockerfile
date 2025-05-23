# 베이스 이미지 pull. vm을 가져 오기
FROM eclipse-temurin:17-jdk-alpine

# jar 위치 지정
ARG JAR_FILE=build/libs/*.jar

# 이름을 모르니까 카피 
COPY ${JAR_FILE} /backend.jar

# 카피한 파일을 컨테이너 실행환경에서 앱 실행
ENTRYPOINT ["java", "-jar" , "/backend.jar"]


# 이미지를 만드려면 베이스이미지가 필요하다