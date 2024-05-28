# fitpin_backend
핏핀 백엔드
## API 목록

### POST 요청
#### '/items': 제품을 등록합니다

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
