# Day 5

## 구현 기능
- SecurityContext에 인증 사용자 저장
- Authentication 객체 기반 현재 로그인 사용자 조회
- 인증이 필요한 API 보호
- Role 기반 인가 처리 추가
- 관리자 전용 API 구성

## 학습 내용
- SecurityContextHolder의 역할 이해
- Authentication 객체 생성 및 저장 방식
- 인증(Authentication)과 인가(Authorization)의 차이
- ROLE_USER / ROLE_ADMIN 권한 구조
- Spring Security의 권한 기반 접근 제어 방식

## 구현 흐름
1. 클라이언트 요청 수신
2. JwtFilter에서 JWT 검증
3. username 추출
4. Authentication 객체 생성
5. SecurityContext에 인증 정보 저장
6. Controller에서 Authentication 객체 사용
7. 권한(Role)에 따라 API 접근 여부 결정

## 사용 기술
- Spring Security
- JWT
- SecurityContextHolder
- Authentication
- UsernamePasswordAuthenticationToken
- Role-based Authorization

## 느낀 점
- 인증은 "누구인지 확인"이고, 인가는 "무엇을 할 수 있는지 결정"이라는 차이를 이해했다.
- Spring Security가 단순 로그인 기능이 아니라 인증 정보를 관리하는 구조라는 점이 인상적이었다.
- Filter -> SecurityContext -> Controller 흐름이 연결되는 과정을 체감했다.
- Role 기반 권한 처리 구조를 직접 구현하며 실무 인증 구조에 가까워졌다고 느꼈다.