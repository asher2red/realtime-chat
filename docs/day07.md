# Day 7

## 구현 기능
- WebSocket 기반 실시간 채팅 기능 구현
- STOMP 프로토콜 적용
- SockJS 연결 설정
- 채팅 메시지 브로드캐스트 구현
- JWT 기반 WebSocket 인증 처리
- 로그인 사용자 이름 기반 메시지 전송 구현

## 학습 내용
- WebSocket과 HTTP의 차이
- STOMP publish / subscript 구조
- SockJS 동작 방식
- Spring WebSocket 메시지 흐름
- ChannelInterceptor 동작 원리
- WebSocket CONNECT frame 인증 처리
- SessionAttributes 기반 사용자 정보 유지 방식
- REST 인증과 WebSocket 인증 구조 차이

## 구현 흐름

### 1. WebhSocket 연결
- '/chat' endpoint 생성
- SockJS 기반 연결 설정
- STOMP client 연결 처리

### 2. 메시지 송수신
- '/app/message' 로 메시지 전송
- '/topic/message' 구독 처리
- 브로드캐스트 방식 실시간 메시지 출력 구현

### 3. JWT 인증 연동
- CONNECT 요청에서 Authorization 헤더 추출
- JWT 검증 후 username 추출
- SessionAttributes 에 username 저장
- 메시지 전송 시 로그인 사용자 이름 사용

### 사용 기술
- Spring WebSocket
- STOMP
- SockJS
- Spring Security
- JWT
- ChannelInterceptor

## 트러블 슈팅

### 1. SockJS 403 에러
- '/chat/**' 경로 permitAll 처리 필요
- JwtFilter 에서 websocket 경로 제외 처리

### 2. Principal null 문제
- WebSocket session 에 user 정보가 자동 유지되지 않음
- SessionAttributes 를 이용하여 username 저장 후 해결

## 느낀 점
- WebSocket은 기존 HTTP 요청/응답 방식과 흐름이 크게 달랐다.
- 실시간 연결 환경에서는 인증 처리 방식도 별도로 필요하다는 점을 이해했다.
- STOMP와 ChannelInterceptor 구조를 직접 구현하면서 메시지 흐름을 더 깊게 이해할 수 있었다.