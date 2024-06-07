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
#### /api/search/(query): DB상의 itemName, itemType, itemBrand 쿼리에 대한 키워드에 대한 검색 결과를 조회합니다, 
-요청형식 : /api/search?query={searchKeyword}
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
