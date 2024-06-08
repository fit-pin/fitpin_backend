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
#### /api/search/(query): DB상의 itemName, itemType, itemBrand 컬럼에서 주어진 검색어(query)와 일치하는 항목들을 검색하여 결과를 반환합니다.
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
