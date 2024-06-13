# fitpin_backend
핏핀 백엔드
## API 목록

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
    "userId": "test1",
    "userPwd": "1234",
    "userName": "테스트용1",
    "userNumber": "010-1234-5678",
    "userNickname": "testman1",
    "userAddr": "서울특별시 구로구",
    "userEmail": "test1@dongyang.com",
    "userGender": "남자",
    "userHeight": 180,
    "userWeight": 75,
    "userForm": 1,
    "userCash": 1000
}
```

#### /api/login : 로그인 과정을 처리하는 api입니다, 로그인 성공시 Login successful 메세지와 함깨 HTTP 200 OK 응답을 같이 반환합니다.

#### /api/pit/top : 상의 수선 내용을 저장합니다 (현재 DB상에 상품 정보 테이블이 상하의가 나뉘어져 있으나, 하나로 통합 예정입니다. 따라서 api도 변경 예정입니다.)
#### /api/pit/bottom



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
