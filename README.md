# fitpin_backend
핏핀 백엔드
## API 목록

### API 사용법

**요청 메인 URL: `http://fitpitback.kro.kr:8080`**

> 요청 URL 예시 /items = http://dmumars.kro.kr:8080/api/items


### POST 요청

#### POST
#### /api/members/register : 회원가입을 위한 api입니다.


-  요청
  
> 요청 URL 예시 : http://fitpitback.kro.kr:8080/api/members/register
```js
{
    "userEmail": "tlsdnwls@test.com",
    "userPwd": "1234",
    "userName": "신우진",
    "userPwdConfirm": "1234"
}
```
요청 성공시 DB에 이메일,비밀번호,이름 칼럼이 저장됩니다.

-  정상응답 (code:200)
  
```js
{
    이메일, 비밀번호, 이름 POST 요청 완료
}
```

비밀번호가 다르면 bad Request:400 코드를 반환합니다.

- 비밀번호가 다를시 (code:400)
```js
비밀번호가 일치하지 않습니다.
```

#### POST
#### /api/login : 로그인 과정을 처리하는 api입니다
#### 로그인 성공시 로그인 유저의 member 테이블을 json 형식으로 반환합니다.

- 요청

> 요청 URL 예시 : http://fitpitback.kro.kr:8080/api/login

```js
{
    "userEmail": "tlsdnwls@test.com",
    "userPwd": "1234",
    "userName": "신우진"
}
```


정상응답
```js
 {
    "userEmail": "test1",
    "userPwd": "1234",
    "userName": "테스트용1",
    "userNumber": null,
    "userNickname": null,
    "userAddr": null,
    "userGender": null,
    "userHeight": null,
    "userWeight": null,
    "userForm": null,
    "userCash": null
}
```

비밀번호나 이메일이 다르면 에러 로그를 반환합니다.

```비밀번호 틀릴시
{
    "timestamp": "2024-06-15T23:20:03.047+00:00",
    "status": 500,
    "error": "Internal Server Error",
    "message": "비밀번호가 틀립니다.",
    "path": "/api/login"
}
```
#### POST
#### /api/members/basicInfo/{userEmail} : userEmail 칼럼의 데이터를 변수로 받아 유저 기본 정보를 업데이트 하는 API입니다.
#### {userEmail} 부분에는 member 테이블의 userEmail 칼럼의 실제 값이 들어가야 합니다.

> 요청 URL 예시 : http://fitpitback.kro.kr:8080/api/members/basicInfo/test1
```js
{
    "userGender": "남자",
    "userHeight": 180,
    "userWeight": 75
}
```
정상 응답시 "기본 정보 업데이트 완료: 성별, 키, 몸무게" 라는 문자열을 반환합니다.

정상 응답
```js
기본 정보 업데이트 완료: 성별, 키, 몸무게
```

#### POST
#### /api/userPreferStyle : 선호 스타일을 json배열 방식으로 받아 DB에 등록 하는 API입니다 
userEmail과 preferStyle 행의 조합이 pk로 설정되어 있어 한 유저가 같은 스타일을 선호스타일로 등록하려 하면 에러가 발생하니 참고 부탁드립니다.

- 요청
> 요청 URL 예시: http://fitpitback.kro.kr:8080/api/userPreferStyle

```js
[
    {
        "userEmail": "test1",
        "preferStyle": "스트릿"
    },
   {
        "userEmail": "test1",
        "preferStyle": "빈티지"
    },
    {
        "userEmail": "test1",
        "preferStyle": "캐주얼"
    },
    {
        "userEmail": "test1",
        "preferStyle": "테일러"
    }
]

```


### GET 요청

#### GET
#### /api/GetUserPreferStyle/{userEmail}: userEmail 칼럼의 데이터를 변수로 받아 유저의 선호 스타일을 Json 배열 방식으로 반환받는 API입니다

-요청
> 요청 URL 예시: http://fitpitback.kro.kr:8080/api/GetUserPreferStyle/test1

정상응답
```js
[
    {
        "userEmail": "test1",
        "preferStyle": "빈티지"
    },
    {
        "userEmail": "test1",
        "preferStyle": "스트릿"
    },
    {
        "userEmail": "test1",
        "preferStyle": "캐주얼"
    },
    {
        "userEmail": "test1",
        "preferStyle": "테일러"
    }
]
```
