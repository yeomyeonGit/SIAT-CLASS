# 베이스 이미지 pull. vm을 가져 오기
FROM node:20

# jar 위치 지정
WORKDIR /front

# 이름을 모르니까 카피 
COPY package*.json ./
RUN npm install

COPY . .
RUN npm run build

EXPOSE 3000

# 카피한 파일을 컨테이너 실행환경에서 앱 실행
# CMD ["npm", "start"]   # 클라우드 환경에 보낼 거라면 이 명령어가 필요 없다


# 이미지를 만드려면 베이스이미지가 필요하다