# realtime-chat

실시간 매칭 + 채팅 서버 포트폴리오 프로젝트

## 기술 스택
- Java 17
- Spring Boot
- MySQL
- JPA

## 보안
- BCrypt 기반 비밀번호 암호화 적용
- JWT 기반 WebSocket 인증 처리
- STOMP CONNECT 헤더 JWT 검증

## 인증(Authentication)/인가(Authorization)
- JWT 기반 로그인 토큰 발급
- JWT Filter를 통한 요청 인증 검증
- SecurityContext 기반 사용자 인증 처리
- ROLE_USER / ROLE_ADMIN 기반 접근 제어
- 관리자 전용 API 보호
- 인증/인가 실패 상태 코드 처리

## 구현 기능
- 회원가입 API
- 로그인 API
- 유저 조회 API
- Global Exception Handler 적용
- Custom Exception 기반 예외 처리
- Generic API Response 구조 적용
- API 응답 형식 통일
- 실시간 채팅 기능
- WebSocket + STOMP 기반 메시지 브로드캐스트
- 로그인 사용자 기반 채팅 메시지 처리

## API

### 인증
- POST /users/register : 회원가입
- POST /users/login : 로그인 및 JWT 발급

### 사용자
- GET /users/me : 현재 로그인 사용자 조회 (인증 필요)

### 관리자
- GET /admin : 관리자 전용 API (ADMIN 권한 필요)

## API 구조
- Generic API Response 구조 적용
- Global Exception Handler 적용
- Custom Exception 기반 예외 처리
- HTTP 상태 코드 분리

## API / Socket Endpoint

### WebSocket
- '/chat' : WebSocket 연결 endpoint

### STOMP
- '/app/message' : 메시지 전송
- '/topic/message' : 메시지 구독