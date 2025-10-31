# java-lotto-precourse

## 구현할 기능
### Application.java
- [ ] `main()` 메서드 작성
- [ ] `LottoController.run()` 호출

### controller/LottoController.java
- [ ] 전체 프로그램 흐름 제어
- [ ] 구입 금액 입력 → 로또 발행 → 출력
- [ ] 당첨 번호, 보너스 번호 입력
- [ ] 결과 계산 및 출력å
- [ ] 예외 발생 시 메시지 출력 후 재입력 처리


### domain/Lotto.java
- [X] 6개 번호 저장
- [X] 번호 개수 검증
- [X] 중복 번호 검증
- [X] 범위(1~45) 검증
- [X] 번호 정렬
- [X] 번호 리스트 반환 메서드 구현


### domain/LottoNumber.java
- [X] 단일 번호 저장
- [X] 1~45 범위 검증
- [X] equals(), hashCode() 오버라이드

### domain/LottoTicket.java
- [ ] 여러 장의 Lotto 관리
- [ ] 로또 목록 저장 및 반환
- [ ] 로또 개수 반환

### domain/WinningLotto.java
- [ ] 당첨 번호 6개 저장
- [ ] 보너스 번호 저장
- [ ] 당첨 번호 및 보너스 번호 유효성 검증
- [ ] 구매 로또와 일치 개수 비교
- [ ] Rank 계산 메서드 구현


### domain/Rank.java
- [X] Enum 정의 (1~5등, NONE)
- [X] 일치 개수, 보너스 여부, 상금 필드 정의
- [X] `Rank.of(matchCount, matchBonus)` 메서드 구현
- [X] 상금 반환 메서드 구현

### domain/LottoResult.java
- [ ] Rank별 당첨 개수 집계
- [ ] 총 상금 합계 계산
- [ ] 수익률 계산
- [ ] 결과 출력용 데이터 반환

### service/LottoService.java
- [ ] 금액 입력에 따른 로또 자동 발행
- [ ] 로또 리스트 생성
- [ ] 당첨 번호 비교 및 결과 집계
- [ ] 수익률 계산 로직 구현


### view/InputView.java
- [ ] 구입 금액 입력받기
- [ ] 당첨 번호 입력받기
- [ ] 보너스 번호 입력받기
- [ ] 입력값 문자열 반환


### view/OutputView.java
- [ ] 구매한 로또 개수 및 번호 출력
- [ ] 당첨 통계 출력
- [ ] 수익률 출력


### view/ErrorHandler.java
- [ ] `[ERROR]` 포맷으로 예외 메시지 출력
- [ ] IllegalArgumentException 처리

### util/Validator.java
- [ ] 금액이 1,000원 단위인지 검증
- [ ] 번호가 6개인지 검증
- [ ] 번호 중복 검증
- [ ] 범위(1~45) 검증
- [ ] 보너스 번호 중복 검증


### util/Converter.java
- [ ] 입력 문자열(`"1,2,3,4,5,6"`)을 `List<Integer>`로 변환
- [ ] 공백 제거 처리
- [ ] 숫자 변환 시 예외 처리

### test/LottoTest.java
- [ ] Lotto 객체 생성 검증
- [ ] 번호 개수 및 범위 검증 테스트

### test/domain/LottoNumberTest.java

### test/domain/WinningLottoTest.java


### test/RankTest.java
- [X] Rank 판정 로직 테스트
- [X] 보너스 번호 포함 여부 테스트

### test/LottoResultTest.java
- [ ] 당첨 결과 집계 테스트
- [ ] 수익률 계산 테스트


### test/LottoServiceTest.java
- [ ] 로또 발행 수량 테스트
- [ ] 결과 계산 로직 테스트

### test/ValidatorTest.java
- [ ] 각 유효성 검증 로직 테스트
- [ ] 예외 발생 시 메시지 확인

```
src/
├── main/
│ └── java/
│ └── lotto/
│ ├── Application.java
│ ├── controller/
│ │ └── LottoController.java
│ ├── domain/
│ │ ├── Lotto.java
│ │ ├── LottoNumber.java
│ │ ├── LottoTicket.java
│ │ ├── WinningLotto.java
│ │ ├── Rank.java
│ │ └── LottoResult.java
│ ├── service/
│ │ └── LottoService.java
│ ├── view/
│ │ ├── InputView.java
│ │ ├── OutputView.java
│ │ └── ErrorHandler.java
│ └── util/
│ ├── Validator.java
│ └── Converter.java
│
└── test/
└── java/
└── lotto/
├── LottoTest.java
├── RankTest.java
├── LottoResultTest.java
├── LottoServiceTest.java
└── ValidatorTest.java
```