# Day 2

## 구현 기능
- 로그인 API 구현
- user 단건 조회 API 추가
- Response DTO 생성
- 비밀번호 BCryptPasswordEncoder 암호화 적용

## 배운 점
- JPA findByUsername 사용
- Optional 처리
- @GetMapping / @PostMapping 차이 이해
- @PathVariable 사용
- RuntimeException 발생 시 Spring의 기본 500 응답 확인
- Entity와 API 응답 역할 분리
- 평문 비밀번호 저장 위험성 이해
- Spring Bean 등록 방식 이해
- BCryptPasswordEncoder 사용법 학습

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

### 4. 기존 유저 로그인 실패
- 기존 데이터는 평문 저장 상태
- BCrypt 적용 이후 새 회원가입 테이터부터 정상 로그인 가능