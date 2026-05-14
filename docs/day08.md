# Day 8

## 구현 기능
- 채팅방(Room) 기반 실시간 채팅 구현
- roomId 기반 STOMP publish / subscribe 처리
- 채팅 메시지 DB 저장 기능 구현
- 채팅 내역 조회 API 구현
- createdAt 기준 채팅 정렬 처리

## 학습 내용
- STOMP topic 동적 분기 처리
- SimpMessagingTemplate 사용법
- room 기반 메시지 브로드캐스트 구조
- WebSocket과 DB 저장 연동 방식
- JAP Query Method 활용
- 실시간 메시지와 영속화 동시 처리 방식

## 구현 흐름

### 1. 채팅방(Room) 분리
- '/topic/room/{roomId}' 구조 적용
- roomId 기반 메시지 구독 처리
- room 별 메시지 분리

### 2. 실시간 메시지 처리
- '/app/chat/{roomId}' 로 메시지 전송
- SimpMessagingTemplete 를 이용한 동적 topic 전송 처리

### 3. 채팅 저장
- Chat Entity 생성
- 메시지 저장 시 roomId / sender / message / createAt 저장
- WebSocket 메시지 처리와 DB 저장 연결

### 4. 채팅 조회 API
- 'GET /chat/room/{roomId}'
- roomId 기준 채팅 내역 조회
- createdAt 오름차순 정렬 처리

## 사용 기술
- Spring WebSocket
- STOMP
- SockJS
- Spring Data JPA
- MySQL
- SimpMessagingTemplate

## API

### 채팅 조회
- 'GET /chat/room/{roomId}'

### WebSocket
- '/chat'

### STOMP
- '/app/chat/{roomId}'
- '/topic/room/{roomId}'

## 느낀 점
- 단순 브로드캐스트가 아닌 room 기반 구조를 적용하면서 실제 채팅 서비스 구조에 가까워졌다.
- 실시간 메시지 처리와 DB 저장을 함께 연결하면서 백엔드 흐름을 더 입체적으로 이해할 수 있었다.
- SimpMessagingTemplate 를 사용하여 동적으로 topic 을 분기하는 방식을 학습할 수 있었다.
