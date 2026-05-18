# Day 10

## 구현 기능
- 로그인 기반 JWT 자동 인증 구현
- test.html 로그인 기능 추가
- WebSocket 자동 연결 처리
- 이전 채팅 로딩과 로그인 흐름 연동

## 학습 내용
- fatch API 기반 로그인 처리
- JWT 자동 발급 및 저장 방식
- REST API 로그인과 WebSocket 연결 흐름
- 로그인 이후 자동 인증 구조

## 구현 흐름

### 1. 로그인 기능 추가
- username / password 입력
- '/users/login' API 호출
- JWT 자동 발급 처리

### 2. WebSocket 자동 연결
- 로그인 성공 후 WebSocket 연결 수행
- JWT Authorization header 자동 전달

### 3. 이전 메시지 로딩 연동
- 로그인 및 room 입장 이후 이전 채팅 조회
- 이전 메시지 출력 후 실시간 연결 진행

## 사용기술
- fatch API
- JWT
- WebSocket
- STOMP

## 느낀 점
- JWT 직접 입력 방식에서 로그인 기반 자동 인증 구조로 개선하면서 실제 서비스 흐름에 가까워졌다.
- REST API 인증과 WebSocket 인증을 연결하는 과정을 경험할 수 있었다.