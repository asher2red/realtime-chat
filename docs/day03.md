# Day 3

## 구현 기능
- JWT 토큰 발급 기능 구현
- JWT 기반 사용자 인증 테스트
- Authorization Header 처리

## 학습 내용
- JWT 구조 이해
- 토큰 기반 인증 흐름 이해
- Bearer Token 방식 이해
- Header 기반 인증 요청 처리

## 구현 흐름
로그인 성공
-> JWT 발급
-> Autorization Header 포함 요청
-> JWT 파싱
-> 사용자 식별

## 사용 기술
- jjwt
- BCryptPasswordEncoder
- RequestHeader

## 느낀 점
- 세션 없이 사용자 인증이 가능함
- 게임 서버 sessionKey 방식과 유사한 흐름 느낌