# Day 6

## 구현 기능
- Global Exception Hander 적용
- ApiResponse 공통 응답 구조 생성
- Generic 기반 API 응답 구조 적용
- Custom Exception 추가
- 예외별 상태 코드 분리

## 학습 내용
- @RestContollerAdvice 동작 방식 이해
- @ExceptionHandler 기반 예외 처리
- Generic DTO 구조 이해
- API 응답 구조 통일 방식 학습
- HTTP 상태 코드 의미 이해
- RuntimeException과 Custom Exception 차이 이해

## 구현 흐름
1. Service 계층에서 Custom Exception 발생
2. GlobalExceptionHandler에서 예외 처리
3. ApiResponse 구조로 응답 생성
4. 상황에 맞는 HTTP 상태 코드 변환
5. 클라이언트가 일관된 JSON 응답 수신

## 사용 기술
- Spring Boot
- Spring Web
- ResponseEntity
- @RestControllerAdvice
- @ExceptionHandler
- Generic DTO
- Custom Exception

## 느낀 점
- API는 단순히 기능만 구현하는 것이 아니라 응답 구조와 에러 처리도 중요하다는 점을 느꼈다.
- Generic Response 구조를 적용하면서 API 응답을 일관되게 관리할 수 있다는 점을 이해했다.
- Custom Exception을 통해 예외 상황을 의미있게 표현할 수 있다는 점이 인상적이었다.
- HTTP 상태 코드가 단순 숫자가 아니라 상황을 표현하는 규칙이라는 점을 체감했다.