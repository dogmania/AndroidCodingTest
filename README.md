## 프로젝트 설명
안드로이드 인턴 코딩 테스트 과제입니다.

## 요구사항
- Compose를 사용하여 UI 구축
- WorkManager를 사용하여 백그라운드 작업 관리
- 작업이 완료되면 알림 보내기
- ProtoBuffer DataStore를 사용하여 데이터 저장
- Coroutine을 사용하여 비동기 처리
- Hilt를 사용하여 의존성 주입

## 구현 결과
### 작업 생성, 작업 상태 변화, 알림
https://github.com/user-attachments/assets/b16d956a-70e7-41e2-a818-b114bdec31f9

### 작업 상세 조회, 작업 상태 변화
https://github.com/user-attachments/assets/4557fe75-2799-4dc4-bd75-e05a90675569

## 주의사항
- 앱의 알림 권한이 없으면 알림이 가지 않습니다. 알림이 오지 않는 다면 알림 권한 부여 부탁드립니다.
- 작업의 상태가 변하는 시간을 5초로 설정해두었습니다.
- BaseViewModel의 공유 코드를 활용하기 위해 Event, PageState 인터페이스를 정의하였습니다.
- ProtoBuffer 설정 과정에서 에러가 발생하여 Kotlin, Compose 버전을 최신 버전보다 낮게 설정하였습니다.
