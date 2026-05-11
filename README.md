# realtime-chat

실시간 매칭 + 채팅 서버 포트폴리오 프로젝트

## 기술 스택
- Java 17
- Spring Boot
- MySQL
- JPA

## 보안
- BCrypt 기반 비밀번호 암호화 적용

## 인증(Authentication)
- JWT 기반 로그인 토큰 발급
- JWT Filter를 통한 요청 인증 검증
- SecurityContext 기반 사용자 인증 처리

## 인가(Authorization)
- ROLE_USER / ROLE_ADMIN 기반 접근 제어
- 관리자 전용 API 보호

## 구현 기능
- 회원가입 API
- 로그인 API
- 유저 조회 API

## API

### 인증
- POST /users/register : 회원가입
- POST /users/login : 로그인 및 JWT 발급

### 사용자
- GET /users/me : 현재 로그인 사용자 조회 (인증 필요)

### 관리자
- GET /admin : 관리자 전용 API (ADMIN 권한 필요)