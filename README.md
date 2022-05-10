# DayPrint_Backend

- java : 1.8
- Spring : 2.5.13


## Swagger-ui를 활용한 api 테스트

1. swagger 접속하기
   - 제공된 ip를 확인한다.
   - 주소창에 "{ip}:8080/swagger-ui" 로 접속한다. ( 예: 127.0.0.1:8080/swagger-ui )
   - swagger 화면이 나온다면 정상 접속.
<br>
2. swagger 사용하기
    - 원하는 메소드를 선택한다.
    - 오른쪽 위에 "Try it out"을 클릭한다.
    - Parameter(예: id, postId) 가 있는 경우는 값을 넣어준다.
      - 저장되지 않은 값을 넣으면 오류가 난다.
    - Request body 에는 Json 형식으로 값을 넣어준다.(예: "key":"value")
      - targetDate의 값은 꼭 yyyy-mm-dd 형식을 지켜줘야 한다.
    - Execute 버튼을 누르면 해당하는 Http Code에 맞게 결과값이 나온다.
<br>
3. 안내
    - 데이터베이스가 rds로 올라가 있고 테스트를 진행한 후이기 때문에
    - id 값은 계속 증가 중이다.