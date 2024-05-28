# fitpin_backend
핏핀 백엔드
## API 목록

### POST 요청
#### /items: 제품을 등록합니다

-  요청

```js
{
    "itemKey": 1,
    "itemNum": 100,
    "itemName": "Test Item",
    "itemImg1": "img1.png",
    "itemImg2": "img2.png",
    "itemImg3": "img3.png",
    "itemContent": "테스트 아이템입니다",
    "itemPrice": 99.99,
    "itemSale": 89.99,
    "itemCnt": 10,
    "itemDate": "2023-01-01"
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
#### /orders: 주문을 신청합니다.

-  요청

```js
{
  "itemKey": 1,
  "userName": "홍길동",
  "userAddr": "서울특별시 강남구",
  "userNumber": "010-1234-5678",
  "itemName": "테스트 상품",
  "itemImg1": "image_url_here",
  "itemSize": 42,
  "itemPrice": 150000,
  "itemBuycnt": 2,
  "itemTotal": 300000,
  "pitPrice": 5000
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

### GET 요청
#### /iteminfo/{itemKey}: 해당key값을 가진 제품에 대한 정보 반환


-정상응답 (code:200)
```js

{
    "itemKey": 1,
    "itemSize": 42.0,
    "itemHeight": 180.0,
    "itemShoulder": 50.0,
    "itemArm": 60.0,
    "itemChest": 100.0,
    "itemWaists": 80.0,
    "itemThighs": 50.0,
    "itemRise": 20.0,
    "itemHem": 18.0
}

```



