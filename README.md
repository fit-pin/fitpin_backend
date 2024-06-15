# fitpin_backend
핏핀 백엔드
## API 목록

### API 사용법

**요청 메인 URL: `http://fitpitback.kro.kr:8080`**

> 예시 /items = http://dmumars.kro.kr:8080/api/items


### POST 요청
#### /items: 제품을 등록합니다

-  요청

```js
{
    "itemKey": 1,
    "itemNum": 1,
    "itemName": "테스트용 요청 옷",
    "itemType": "상의",
    "ItemBrand": "테스트용 브랜드",
    "itemImg1": "img1.png",
    "itemImg2": "img2.png",
    "itemImg3": "img3.png",
    "itemCnt": "5000",
    "itemContent": "테스트 아이템입니다",
    "itemPrice": 300,
    "itemDate": "2023-06-05"
}
```

-  정상응답 (status:200)
  
```js
{
    `Status Code`200 OK
}
```
      
- 에러 (code:500)

```js


```
#### POST
#### /api/members/register : 회원가입을 위한 api입니다.

-  요청

```js
{
    "userEmail": "tlsdnwls@test.com",
    "userPwd": "1234",
    "userName": "신우진",
    "userPwdConfirm": "1234"
}
```
요청 성공시 DB에 이메일,비밀번호,이름 칼럼이 저장됩니다.

-  정상응답 (status:200)
  
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
    "userEmail": "tlsdnwls@test.com",
    "userPwd": "1234",
    "userName": "신우진",
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
#### POS
#### /api/userPreferStyle : 유저 선호 스타일을 jsonArray 형식으로 전달받습니다.
#### 요청 성공시 선호 스타일 등록 완료 : "스타일명1", "스타일명2", ... 이런식으로 등록된 스타일이 반환됩니다.
#### DB의 preferStyle 테이블에 하나씩 등록됩니다, {userEmail+preferStyle}행의 조합이 중복되어 있으면 에러가 발생합니다.

- 요청 예시
POST/ http://fitpitback.kro.kr:8080/api/userPreferStyle
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
정상응답(status:200)
```js
 {
    선호 스타일 등록 완료: 스트릿, 빈티지, 캐주얼, 테일러
 }
```

#### POST
#### /api/members/basicInfo/{userEmail} :  이메일을 키값으로 받 회원의 기본 정보(성별, 키, 몸무게)를 업데이트합니다.
#### 요청 성공시 "기본 정보 업데이트 완료 : 성별, 키, 몸무게" 라는 메세지를 반환합니다.
#### DB의 member 테이블의 칼럼들을 체웁니다.

- 요청 예시
POST /api/members/basicInfo/test1@test.com
                                  ▲ member 테이블 상의 실제 userEmail 행 값이어야 합니다!!
```js

{
    "userGender": "남자",
    "userHeight": 180,
    "userWeight": 75
}

```
정상응답(status:200)
```js
기본 정보 업데이트 완료: 성별, 키, 몸무게
```

### GET 요청

#### GET 
