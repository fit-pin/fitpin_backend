# fitpin_backend
핏핀 백엔드
## API 목록

### API 사용법

**요청 메인 URL: `http://http://fitpitback.kro.kr:8080`**

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

-  정상응답 (code:200)
  
```js
{
    `Status Code`200 OK
}
```
      
- 에러 (code:500)

```js


```

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
#### /api/pit/top 
#### /api/pit/bottom
#### 상하의 수선 내용을 저장합니다 
#### (현재 DB상에 상품 정보 테이블이 상하의가 나뉘어져 있으나, 하나로 통합 예정입니다. 따라서 api도 변경 예정입니다.)


### GET 요청
#### /itemdetails/{itemKey}: 제품의 상세 정보를 조회합니다

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
#### /api/search?query={Keywords}: DB상의 itemName, itemType, itemBrand 컬럼에서 주어진 검색어(query)와 일치하는 항목들을 검색하여 결과를 반환합니다. api/search/{Keywords}의 형태로 수정 예정입니다.
##### 요청 파라미터: `query` (String, 필수): 검색할 키워드
-요쳥예시 : /api/search?query=shirt

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
#### /api/itemdetails/{itemKey} : 특정 상품의 상세 정보를 조회하는 GET 메서드 입니다.

#### /api/itembottomsize/{itemKey} : 하의 상품의 크기를 조회합니다 (마찬가지로 DB상에 상품 정보 테이블이 상하의가 나뉘어져 있으나, 하나로 통합 예정입니다. 따라서 api도 변경 예정입니다.)

#### /api/itemtopsize/{itemKey} : 상의 상품의 크기를 조회합니다.
