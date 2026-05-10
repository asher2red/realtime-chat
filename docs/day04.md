# Day 4

## 구현 기능
- Spring Security 설정 추가
- JWT Filter 구현
- Authorization Header 기반 JWT 인증 검증
- SecurityFilterChain 구성 및 Filter Chain 연결

## 학습 내용
- Spring Security의 Filter 기반 구조 이해
- 요청이 Controller에 도달하기 전 Filter가 먼저 실행
- JWT 인증 방식 (Stateless Authentication)
- OncePerRequestFilter의 역할과 사용 방식
- SecurityFilterChain을 통한 Spring Security 설정 방식

## 구현 흐름
1. 클라이언트가 요청을 보냄 (Authorization Header 포함 가능)
2. JwtFilter가 요청을 먼저 가로챔
3. Header에서 JWT 추출
4. JWT 유효성 검증
5. username 파싱
6. 인증 정보 로그 출력
7. Controller로 요청 전달

## 사용 기술
- Spring Security
- JWT
- Filter (OncePerRequestFilter)

## 느낀 점
- Spring Security가 단순 인증 기능이 아니라 요청 흐름 전체를 제어하는 구조라는 것을 이해했다.
- JWT 인증이 Controller가 아니라 Filter 단계에서 처리된다는 점이 핵심이었다.
- 백엔드에서 "누가 요청했는지"를 처리하는 구조가 어떻게 만들어지는지 체감했다.
- 실무 인증 구조의 기본 뼈대를 경험했다.