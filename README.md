# fitpin_backend
핏핀 백엔드
## API 목록

### API 사용법

**요청 메인 URL: `http://fitpitback.kro.kr:8080`**

> 예시 /items = http://dmumars.kro.kr:8080/api/items


### POST 요청

#### POST
#### /api/members/register : 회원가입을 위한 api입니다.


-  요청
>요청 엔드포인트 예시 : http://fitpitback.kro.kr:8080/api/members/register

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



### GET 요청


#### GET
#### /api/GetUserPreferStyle/{userEmail}: 제품의 상세 정보를 조회합니다
#### 

-정상응답 (code:200)
```js
{
    "itemKey": 1,
    "itemNum": 1,
    "itemName": "테스트용 요청 옷",
    "itemType": "상의",
    "itemBrand": "테스트용 브랜드",
    "itemImg1": "image1_url",
    "itemImg2": "image2_url",
    "itemImg3": "image3_url",
    "itemCnt": 5000,
    "itemSize": 50,
    "itemContent": "테스트용 요청입니다",
    "itemPrice": 300,
    "itemDate": "2024-06-05"
}

```
