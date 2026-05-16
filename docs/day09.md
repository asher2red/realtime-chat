# Day 9

## 구현기능
- 채팅방 입장 / 퇴장 메시지 기능 구현
- 이전 채팅 내역 자동 로딩 기능 구현

## 학습 내용
- WebSocket Session 이벤트 처리 방식
- SessionAttributes 를 이용한 사용자 정보 유지
- fetch API 를 이용한 이전 데이터 조회
- REST API 와 Websocket 조합 방식

## 구현 흐름

### 1. 입장 / 퇴장 메시지
- SessionConnectEvent 처리
- SessionDisconnectEvent 처리
- roomId 기반 채팅방 메시지 브로드캐스트

### 2. 이전 메시지 로딩
- 채팅방 입장 시 REST API 호출
- roomId 기준 이전 채팅 조회
- 조회한 메시지 출력 후 실시간 연결 진행

## 사용 기술
- Spring WebSocket
- STOMP
- SessionConnectEvent
- SessionDisconnectEvent
- fetch API

## 느낀 점
- 실시간 채팅뿐 아니라 입장/퇴장 흐름까지 추가되면서 실제 채팅 서비스 구조에 가까워졌다.
- WebSocket 과 REST API 를 함께 사용하는 흐름을 이해할 수 있었다.
- 이전 메시지를 먼저 불러온 뒤 실시간 연결하는 구조를 경험할 수 있었다.