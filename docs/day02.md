# Day 2

## 구현 기능
- 로그인 API 구현
- user 단건 조회 API 추가

## 배운 점
- JPA findByUsername 사용
- Optional 처리
- @GetMapping / @PostMapping 차이 이해
- @PathVariable 사용
- RuntimeException 발생 시 Spring의 기본 500 응답 확인

## 트러블 슈팅

### 1. findByUserName 오타
- Entity 필드명(username)과 Repository 메서드명이 달라 에러 발생
- findByUsername 으로 수정

### 2. 405 Method Not Allowed
- GET 요청인데 @PostMapping 사용
- @GetMapping 으로 수정

### 3. RuntimeException 발생 시 500 응답
- Spring 기본 예외 처리 방식 확인
- 이후 GlobalExceptionHandler 학습 예정