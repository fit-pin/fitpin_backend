# fitpin_backend
핏핀 백엔드
## API 목록

### API 사용법

**요청 메인 URL: `http://fitpitback.kro.kr:8080`**

> 요청 URL 예시 `items = http://dmumars.kro.kr:8080/api/items`

<details>
 <summary><h2>APP API</h2></summary>

  <details> 

   <summary>회원가입을 위한 api입니다.</summary>

   ### POST/api/members/register 
  
> 요청 URL 예시 : `http://fitpitback.kro.kr:8080/api/members/register`

요청 Body
```js
{
    "userEmail": "tlsdnwls@test.com",
    "userPwd": "1234",
    "userName": "신우진",
    "userPwdConfirm": "12334"

}
```

비밀번호와 재확인 부분이 다를시(status : 400)
```js
{
    "message": "비밀번호가 일치하지 않습니다."
}
```
  
  </details>


<details>

 <summary>POST/api/login : 로그인을 위한 api입니다.</summary>

  
> 요청 URL 예시 : `http://fitpitback.kro.kr:8080/api/login`
```js
{
    "userEmail": "tlsdnwls@test.com",
    "userPwd": "1234"
}
```
- 정상응답
```js
{
    "userEmail": "test1",
    "userPwd": null,
    "userName": "테스트용1",
    "userNumber": null,
    "userNickname": null,
    "userAddr": null,
    "userGender": "남자",
    "userHeight": 180,
    "userWeight": 75,
    "userFit": null,
    "userCash": null
}
``` 

비밀번호나 이메일이 다를시(status : 400)
```js
{
    "message": "이메일을 찾을 수 없습니다."
}
```
```js
{
    "message": "비밀번호가 틀립니다."
}
```

 
</details>

 <details>
  <summary>POST/api/members/basicInfo/{userEmail} : userEmail 칼럼의 데이터를 변수로 받아 유저 기본 정보를 업데이트 하는 API입니다.</summary>

  {userEmail} 부분에는 member 테이블의 userEmail 칼럼의 실제 값이 들어가야 합니다.

> 요청 URL 예시 : `http://fitpitback.kro.kr:8080/api/members/basicInfo/test1`
```js
{
    "userGender": "남",
    "userHeight": 174,
    "userWeight": 80,
    "userFit": "오버핏",
    "style": [
        {
            "userEmail": "test1",
            "pr환합니다

정상 응답
```js
{
    "message": "선호 스타일 등록 완료!"
}
```

중복된 스타일을 등록하려 하면 "중복된 선호 스타일 : {스타일}" 라는 메세지를 json 방식으로 반환합니

예외처리(status:400)
```js
{
    "message": "중복된 선호 스타일: 스트릿"
}
```
  
 </details>

<details>
<summary>POST/api/userPreferStyle : 선호 스타일을 json배열 방식으로 받아 DB에 등록 하는 API입니다 </summary>

userEmail과 preferStyle 행의 조합이 pk로 설정되어 있어 한 유저가 같은 스타일을 선호스타일로 등록하려 하면 에러가 발생하니 참고 부탁드립니다.


> 요청 URL 예시: `http://fitpitback.kro.kr:8080/api/userPreferStyle`

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
</details>

<details>
<summary>POST/api/userForm : AR백엔드의 체형분석 API에서 반환된 Json구문을 저장하는 POST API입니다.</summary>
  
 이미 등록되어 있는 userEmail 값으로 요청하면 데이터를 업데이트 합니다.


> 요청 URL 예시: http://fitpitback.kro.kr:8080/api/userForm

```js
{
    "userEmail": "test@naver.com"
    "fileName": "2c49f715-67b8-40ec-86a2-b9d3e2875923.jpg", 
    "result": {
        "armSize": 58.37, 
        "shoulderSize": 32.64, 
        "bodySize": 52.63, 
        "legSize": 63.82 
    }
}
```
정상 응답시 "체형 정보 저장 완료" 메세지를 json 형태로 반환합니다
```js
{
    "message": "체형 정보 저장 완료"
}
```
</details>

<details>
<summary> GET/api/GetUserPreferStyle/{userEmail}: userEmail 칼럼의 데이터를 변수로 받아 유저의 선호 스타일을 Json 배열 방식으로 반환받는 API입니다</summary>

> 요청 URL 예시: `http://fitpitback.kro.kr:8080/api/GetUserPreferStyle/test1`

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
</details>

<details>
<summary> GET/api/userForm/{userEmail}: userForm 테이블(AR서버에서 넘겨준 체형 분석 정보를 저장하는 테이블)에서 사진파일의 이름을 userEmail을 키값으로 하여 검색하는 API입니다.</summary>
 

>요청 URL 예시: http://fitpitback.kro.kr:8080/api/userForm/test1

정상 응답시 이미지 URL을 반환합니다.
```js
{
    "fileName": "2c49f715-67b8-40ec-86a2-b9d3e2875923.jpg"
}

```
 
</details>

<details>
<summary>GET/api/userbodyinfo/{userEmail} : userEmail값을 키값으로 요청시 반환하는 GET 메서드입니다.</summary>

>요청 URL 예시: http://fitpitback.kro.kr:8080/api/userbodyinfo/test1

정상 응답시 위의 요소를 반환합니다.

```js
{
    "userEmail": "test1",
    "userHeight": 174,
    "userWeight": 80,
    "armSize": 58.37,
    "shoulderSize": 32.64,
    "bodySize": 52.63,
    "legSize": 63.82
}
```
 
</details>


<details>
 <summary>GET /api/items/list/{itemType} : 상품목록을 조회하는 api입니다.</summary>
item 테이블의 itemType(상품 종류)행을 경로변수로 받아서 경로변수와 일치하는 상품을 JSON Array 형태로 조회합니다.
 
반환되는 값은 
```
itemKey (상품 고유번호)
itemName (상품 이름)
itemBrand (상품 브랜드)
itemPrice (상품 가격)
itemImgUrls : (상품 이미지 URL)
```
을 반환합니다.

>요청 URL 예시: http://fitpitback.kro.kr:8080/api/items/list/상의

결과:
```js
[
    {
        "itemKey": 1,
        "itemName": "테스트용 상품1",
        "itemBrand": "TEST",
        "itemStyle": "캐주얼",
        "itemPrice": 10000,
        "itemImgUrls": [
            "C:/ItemImg/testImg.png"
        ]
    },
    {
        "itemKey": 2,
        "itemName": "테스트상품",
        "itemBrand": "TEST",
        "itemStyle": "캐주얼",
        "itemPrice": 100000,
        "itemImgUrls": []
    },
    {
        "itemKey": 4,
        "itemName": "테스트상품",
        "itemBrand": "TEST",
        "itemStyle": "테일러",
        "itemPrice": 100000,
        "itemImgUrls": []
    }
]
```
</details> 

<details>
<summary>GET/api/item-info/1{itemKey} : itemKey를 경로인자로 받아 상품의 상세 정보를 반환합니다. </summary>

>요청 URL 예시: http://fitpitback.kro.kr:8080/api/item-info/1

정상 응답시 위의 요소를 반환합니다.

```js
{
    "itemKey": 1,
    "itemName": "테스트용 상품1(상의)",
    "itemBrand": "TEST",
    "itemType": "상의",
    "itemStyle": "캐주얼",
    "itemPrice": 10000,
    "itemContent": "테스트용 상의 상품",
    "itemImgUrls": [
        "/home/ubuntu/home/fitpin_backend/home/itemImg/optimize.png"
    ],
    "itemTopInfo": {
        "itemSize": "M",
        "itemHeight": 40.0,
        "itemShoulder": 15.5,
        "itemArm": 10.0,
        "itemChest": 12.0,
        "itemSleeve": 14.5
    },
    "itemBottomInfo": null
}
```

</details>

<details>
 <summary> POST : 장바구니 저장 </summary>
 
 장바구니 목록을 저장하는 API입니다.
 
>요청 URL 예시: http://fitpitback.kro.kr:8080/api/cart/store

```js
{
    "itemKey": 1,
    "userEmail": "test1",
    "itemName": "테스트용 상품1(상의)",
    "itemSize": "M",
    "itemType": "상의",
    "itemPrice": 10000,
    "pit": 1

}
```
</details> 

<details>
 <summary> GET : 장바구니 목록 조회 </summary>
 
#### GET/api/cart/get-store/{userEmail}

{userEmail}을 경로변수로 받아 장바구니 목록을 조회하는 API입니다. 
 
>요청 URL 예시: http://fitpitback.kro.kr:8080/api/cart/get-store/test1

결과:
```js
{
    "itemKey": 1,
    "userEmail": "test1",
    "itemName": "테스트용 상품1(상의)",
    "itemSize": "M",
    "itemType": "상의",
    "itemPrice": 10000,
    "pit": 1

}
```
</details> 

<details>
 <summary> GET : 수선내역 조회 </summary>
 
#### GET/api/pit/get/{cartKey}

장바구니 테이블의 {cartKey}을 경로변수로 받아 장바구니 목록을 조회하는 API입니다. 
 
>요청 URL 예시: http://fitpitback.kro.kr:8080/api/pit/get/2

결과:
```js
{
    "itemKey": 1,
    "cartKey": 2,
    "itemSize": "M",
    "itemHeight": 35.0,
    "itemShoulder": 15.0,
    "itemArm": 9.0,
    "itemChest": 10.0,
    "itemSleeve": 14.0
}
```
</details> 

<details>
 <summary>GET : 상품 이미지 서빙 (itemImg 디렉토리)</summary>
 
#### GET /api/img/imgserve/itemimg/{imageName}

이미지 이름을 경로 변수로 받아 `itemImg` 디렉토리 내의 이미지를 서빙하는 API입니다.

> 요청 URL 예시: `http://fitpitback.kro.kr:8080/api/img/imgserve/itemimg/optimize.png`

**Path Variables:**
- `imageName`: 이미지 파일명 (예: `optimize.png`)

**Response:**
- **Status 200 OK:**
  - 성공적으로 이미지를 반환합니다.
  - 이미지의 MIME 타입에 따라 콘텐츠가 반환됩니다.
- **Status 404 Not Found:**
  - 파일이 존재하지 않거나 읽을 수 없는 경우
  ```json
  {
      "message": "파일을 찾을 수 없습니다."
  }
  ```
- **Status 403 Forbidden:**
  - 경로가 허용된 범위 밖에 있는 경우
  ```json
  {
      "message": "접근이 허용되지 않는 경로입니다."
  }
  ```
- **Status 500 Internal Server Error:**
  - 서버 내부에서 파일을 읽는 중 오류가 발생한 경우
  ```json
  {
      "message": "파일을 읽는 중 오류가 발생했습니다."
  }
  ```

</details> <!--- 상품 이미지 서빙   --->

<details>
 <summary>GET : 핏보관함 이미지 서빙 (fitStorageImg 디렉토리)</summary>
 
#### GET /api/img/imgserve/fitstorageimg/{imageName}

이미지 이름을 경로 변수로 받아 `fitStorageImg` 디렉토리 내의 이미지를 서빙하는 API입니다.

> 요청 URL 예시: `http://fitpitback.kro.kr:8080/api/img/imgserve/fitstorageimg/anotherImage.png`

**Path Variables:**
- `imageName`: 이미지 파일명 (예: `anotherImage.png`)

**Response:**
- **Status 200 OK:**
  - 성공적으로 이미지를 반환합니다.
  - 이미지의 MIME 타입에 따라 콘텐츠가 반환됩니다.
- **Status 404 Not Found:**
  - 파일이 존재하지 않거나 읽을 수 없는 경우
  ```json
  {
      "message": "파일을 찾을 수 없습니다."
  }
  ```
- **Status 403 Forbidden:**
  - 경로가 허용된 범위 밖에 있는 경우
  ```json
  {
      "message": "접근이 허용되지 않는 경로입니다."
  }
  ```
- **Status 500 Internal Server Error:**
  - 서버 내부에서 파일을 읽는 중 오류가 발생한 경우
  ```json
  {
      "message": "파일을 읽는 중 오류가 발생했습니다."
  }
  ```

</details> <!--- 핏보관함 이미지 서빙 --->

<details> 
<summary>GET : 상품 검색</summary>

## GET: 상품 검색

## 반환 리스트에 이미지 URL(이미지 이름)도 같이 반환하도록 변경 예정입니다.

#### URL: `/api/item-search/search/{searchWord}`

특정 검색어를 기준으로 `item` 테이블에서 `itemName`, `itemType`, `itemBrand`, `itemContent` 필드에 해당하는 상품을 검색하는 API입니다. 검색어는 URL 경로 변수로 전달되며, 결과로는 해당 조건에 맞는 상품 리스트가 반환됩니다.

- **요청 URL 예시**: `http://fitpitback.kro.kr:8080/api/item-search/search/상의`

### **Path Parameters**
| 파라미터      | 타입    | 필수 여부 | 설명                        |
|---------------|---------|-----------|-----------------------------|
| `searchWord`  | string  | required  | 검색할 키워드 (예: 상의, 바지 등) |

### **Response**

- **Status 200 OK**
  ```json
  {
    "searchResult": [
        {
            "itemKey": 1,
            "itemName": "테스트용 상품1(상의)",
            "itemType": "상의",
            "itemBrand": "TEST",
            "itemStyle": "캐주얼",
            "itemCnt": 100,
            "itemContent": "테스트용 상의 상품",
            "itemPrice": 10000,
            "itemDate": "2023-07-29"
        },
        {
            "itemKey": 2,
            "itemName": "테스트상품",
            "itemType": "상의",
            "itemBrand": "TEST",
            "itemStyle": "캐주얼",
            "itemCnt": 100,
            "itemContent": "테스트용 상의 상품",
            "itemPrice": 100000,
            "itemDate": "2024-07-28"
        }
    ]
  }
  ```

- **Status 500 Internal Server Error**
  ```json
  {
    "searchResult": []
  }
  ```

### **설명**
- 이 API는 특정 키워드를 기준으로 상품을 검색합니다. 검색 결과는 `searchResult` 필드에 배열 형태로 반환됩니다.
- 예외가 발생하거나 검색 결과가 없는 경우 `searchResult`는 빈 배열로 반환됩니다.
  
</details>

<details>
<summary> 핏 보관함 관련 API </summary> <!--- 핏보관함 api 시작 --->

# 핏 보관함 API

핏 보관함과 관련된 API 목록입니다. 이미지를 업로드, 조회, 삭제할 수 있습니다.

---
<details>
 <summary> 이미지 업로드</summary>

## POST: 핏 보관함 이미지 업로드

#### URL: `/api/fitStorageImages/upload`

유저의 이메일과 함께 이미지를 업로드하는 API입니다. `multi-part form data` 형식으로 이미지를 업로드하며, 서버에 이미지를 저장하고 그 경로를 데이터베이스에 저장합니다.

- **요청 URL 예시**: `http://fitpitback.kro.kr:8080/api/fitStorageImages/upload`

### **Form Data Parameters**
| 파라미터      | 타입    | 필수 여부 | 설명                        |
|---------------|---------|-----------|-----------------------------|
| `image`       | file    | required  | 업로드할 이미지 파일         |
| `userEmail`   | string  | required  | 유저의 이메일 주소           |

### **Response**

- **Status 200 OK**
  ```json
  {
    "message": "이미지 업로드 성공: /path/to/uploaded/image.png"
  }
  ```
- **Status 500 Internal Server Error**
  ```json
  {
    "message": "이미지 업로드 실패: 에러 메시지"
  }
  ```

</details> <!-- 핏보관함 이미지 업로드 -->

<details>
 <summary>사진 삭제</summary>
  
## DELETE: 핏 보관함 사진 삭제

#### URL: `/api/fitStorageImages/delete/{imageName}`

이미지의 이름을 받아 핏 보관함에 저장된 이미지를 삭제하는 API입니다. 유저의 이메일은 이미지 삭제 시에는 필요하지 않으며, 이미지 이름으로 이미지를 삭제합니다.

- **요청 URL 예시**: `http://fitpitback.kro.kr:8080/api/fitStorageImages/delete/{imageName}`

### **Path Parameters**
| 파라미터         | 타입    | 필수 여부 | 설명                        |
|------------------|---------|-----------|-----------------------------|
| `imageName`      | string  | required  | 삭제할 이미지의 이름         |

### **Response**

- **Status 200 OK**
  ```json
  {
    "message": "이미지 삭제 성공: /path/to/deleted/image.png"
  }
  ```
- **Status 404 Not Found**
  ```json
  {
    "message": "이미지를 찾을 수 없습니다: /path/to/nonexistent/image.png"
  }
  ```
- **Status 500 Internal Server Error**
  ```json
  {
    "message": "이미지 삭제 실패: 에러 메시지"
  }
  ```

---
</details>

<details>
 <summary> 사진 리스트 조회 </summary>
## GET: 핏 보관함 사진 리스트 조회

#### URL: `/api/fitStorageImages/user/{userEmail}`

유저 이메일을 경로 변수로 받아 핏 보관함에 저장된 이미지 리스트를 조회하는 API입니다.

- **요청 URL 예시**: `http://fitpitback.kro.kr:8080/api/fitStorageImages/user/test1`

### **Path Parameters**
| 파라미터      | 타입    | 필수 여부 | 설명                        |
|---------------|---------|-----------|-----------------------------|
| `userEmail`   | string  | required  | 조회할 유저의 이메일 주소     |

### **Response**

- **Status 200 OK**
  ```json
  [
    {
      "userEmail": "test1",
      "fitStorageImg": "testImg.png"
    },
    {
      "userEmail": "test1",
      "fitStorageImg": "testImg2.png"
    }
  ]
  ```
 </details>
</details> <!-- 핏보관함 관련 API 묶음 -->


<!-- APP API 이 위로 작성하면 됨..-->

</details>

<details>
 <summary><h2>관리자 API</h2></summary>


 <details>
 <summary>POST/api/itemImages/upload : 상품의 이미지를 등록하는 api입니다. </summary>
  
>요청 URL 예시: http://fitpitback.kro.kr:8080/api/itemImages/upload

### 헤더 
- Content-Type: multipart/form-data

##### Form Data
```
- `image` (File): 사용자의 이메일 주소
- `itemKey` (Text): item테이블의 itemKey 열, 제품의 고유번호
```
</details> 

<details>
 <summary>POST/api/itemBottomInfo/register : 하의 상품의 상세 정보 등록하는 API입니다.</summary>
 
>요청 URL 예시: http://fitpitback.kro.kr:8080/api/itemBottomInfo/register

```js
{
  "itemKey": 1,
  "itemSize": 32.5,
  "itemHeight": 40.0,
  "itemWaists": 15.5,
  "itemThighs": 20.0,
  "itemRise": 10.0,
  "itemHem": 8.0
}

```
</details> 

<details>
 <summary>POST/api/itemTopInfo/register : 상의 상품의 상세 정보 등록하는 API입니다.</summary>
 
>요청 URL 예시: http://fitpitback.kro.kr:8080/api/itemTopInfo/register

```js
{
  "itemKey": 1,
  "itemSize": 32.5,
  "itemHeight": 40.0,
  "itemShoulder": 15.5,
  "itemArm": 20.0,
  "itemChest": 10.0,
  "itemSleeve": 8.0
}

```
</details> 

 
</details> 




 



