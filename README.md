# realtime-chat

실시간 매칭 + 채팅 서버 포트폴리오 프로젝트

## 기술 스택
- Java 17
- Spring Boot
- MySQL
- JPA

## 보안
- BCrypt 기반 비밀번호 암호화 적용

## 구현 기능
- 회원가입 API
- 로그인 API
- 유저 조회 API

## API

### 회원가입
POST /users/register

### 로그인
POST /users/login

### 유저 조회
GET /users/{id}
