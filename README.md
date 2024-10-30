 # fitpin_backend
핏핀 백엔드
## API 목록

### API 사용법

**요청 메인 URL: `http://fitpitback.kro.kr:8080`**

> 요청 URL 예시 `items = http://dmumars.kro.kr:8080/api/items`

<details> <!-- APP API details start-->
 <summary> <h2> APP API </h2> </summary>

<details> <!-- 로그인 & 회원가입 details 시작 -->
 <summary> <h4>  로그인 & 회원가입 </h4> </summary>

# 로그인 및 회원가입

로그인, 회원가입 과정에서 필요한 API 목록입니다. 회원가입, 로그인, 기본정보 등록, 선호스타일과 체형분석 등록이 가능합니다

---
<details> <!-- 회원가입 API 시작 -->

<summary> POST: 회원가입 </summary> 

## POST: 회원가입

#### URL: `/api/members/register`

회원가입을 요청하는 API입니다. 이메일, 비밀번호, 이름 등을 받아 회원가입 처리를 수행합니다.

- **요청 URL 예시**: `http://fitpitback.kro.kr:8080/api/members/register`

### **Request Body Parameters**
| 파라미터           | 타입    | 필수 여부 | 설명                         |
|-------------------|---------|-----------|------------------------------|
| `userEmail`       | string  | required  | 유저의 이메일 주소            |
| `userPwd`         | string  | required  | 유저의 비밀번호               |
| `userName`        | string  | required  | 유저의 이름                   |
| `userPwdConfirm`  | string  | required  | 유저의 비밀번호 재확인        |

### **Response**

- **Status 200 OK**
  ```json
  {
    "message": "회원가입 성공"
  }
  ```

- **Status 400 Bad Request** (비밀번호와 비밀번호 확인 불일치)
  ```json
  {
    "message": "비밀번호가 일치하지 않습니다."
  }
  ```

</details> <!-- 회원가입 API 끝 -->

<details> <!-- 로그인 API 시작 -->

<summary> POST: 로그인 </summary> 

## POST: 로그인

#### URL: `/api/login` 

로그인 요청입니다. 이메일과 비밀번호를  이용해 로그인을 시도합니다, 로그인 성공 시 유저 정보를 반환합니다.

- **요청 URL 예시**: `http://fitpitback.kro.kr:8080/api/login`

### **Request Body Parameters**
| 파라미터           | 타입    | 필수 여부 | 설명                         |
|-------------------|---------|-----------|------------------------------|
| `userEmail`       | string  | required  | 유저의 이메일 주소            |
| `userPwd`         | string  | required  | 유저의 비밀번호               |


### **Response**

- **Status 200 OK**
  ```json
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

- **Status 400 Bad Request** (이메일 혹은 비밀번호 불일치)
  ```json
  {
    "message": "이메일을 찾을 수 없습니다."
  }
  ```

  ```json
  {
    "message": "비밀번호가 틀립니다."
  }
  ```

- **Status 500 Internal Server Error** (서버 에러 발생 시)
  ```json
  {
    "message": "예상치 못한 오류가 발생했습니다."
  }
  ```

</details> <!-- 로그인 API 끝 -->

<details> <!-- 회원탈퇴 API 시작 -->

<summary> POST: 회원탈퇴 </summary> 

## POST: 회원탈퇴

#### URL: `/api/members/delete_id`

회원탈퇴 요청입니다. 이메일을 이용해 회원탈퇴를 시도합니다. 탈퇴 성공 시 성공 메시지를 반환합니다.

- **요청 URL 예시**: `http://fitpitback.kro.kr:8080/api/members/delete_id`

### **Request Body Parameters**
| 파라미터           | 타입    | 필수 여부 | 설명                         |
|-------------------|---------|-----------|------------------------------|
| `userEmail`       | string  | required  | 탈퇴를 요청하는 유저의 이메일 주소  |

### **Response**

- **Status 200 OK**
  ```json
  {
    "message": "회원탈퇴가 완료되었습니다."
  }
  ```

- **Status 400 Bad Request** (유효하지 않은 이메일)
  ```json
  {
    "message": "이메일을 찾을 수 없습니다."
  }
  ```

- **Status 500 Internal Server Error** (서버 에러 발생 시)
  ```json
  {
    "message": "회원탈퇴 중 오류가 발생했습니다."
  }
  ```

</details> <!-- 회원탈퇴 API 끝 -->

 <details> <!-- 유저 기본정보 업데이트 API 시작 -->
  
  <summary> POST : 유저 기본 정보 업데이트 </summary>

  ## POST: 유저 기본정보 업데이트
  
  #### URL: `api/members/basicInfo/{userEmail}`
  
  경로 변수인 {userEmail} 부분에는 member 테이블의 userEmail 칼럼의 실제 값이 들어가야 합니다.
  회원 가입 과정에 필요한 API입니다.

- **요청 URL 예시**: `http://fitpitback.kro.kr:8080/api/members/basicInfo/testEmail`

### **Request Body Parameters**
| 파라미터          | 타입    | 필수 여부 | 설명                         |
|-------------------|---------|-----------|------------------------------|
| `userGender`      | string  | required  | 유저의 성별 ("남" 또는 "여")   |
| `userHeight`      | number  | required  | 유저의 키 (cm)                |
| `userWeight`      | number  | required  | 유저의 몸무게 (kg)            |
| `userFit`         | string  | required  |유저가 선호하는 핏 ("오버핏" 등)|
| `style`           | array   | required  | 선호 스타일 리스트             |

### **Style Array Object**
| 파라미터          | 타입    | 필수 여부 | 설명                               |
|-------------------|---------|-----------|------------------------------------|
| `userEmail`      | string  | required  |  선호 스타일을 업데이트할 유저의 이메일|
| `preferStyle`      | string  | required  | 유저 선호 스타일                   |

### **Request Body 예시**

```js
{
    "userGender": "남",
    "userHeight": 174,
    "userWeight": 80,
    "userFit": "오버핏",
    "style": [
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
}
```

### **Response**
- **Status 200 OK**

```js
{
    "message": "선호 스타일 등록 완료!"
}
```


- **Status 400 Bad Request** (중복된 선호 스타일)

```js
{
    "message": "중복된 선호 스타일: 스트릿"
}
```
  
 </details> <!-- 유저 기본정보 API 끝 -->

<details> <!-- 선호스타일 API 시작 -->
<summary> POST: 선호 스타일 등록 </summary>

## POST: 선호 스타일 등록

#### URL : `/api/userPreferStyle`

선호스타일을 DB에 저장하는 API입니다.

한 유저가 같은 스타일을 선호스타일로 저장시 에러가 발생합니다.

- **요청 URL 예시**: `http://fitpitback.kro.kr:8080/api/userPreferStyle`

### **Request Body Parameters**

| 파라미터           | 타입    | 필수 여부 | 설명                       |
|-------------------|---------|-----------|------------------------------|
| `userEmail`       | string  | required  | 유저의 이메일 주소           |
| `preferStyle`     | string  | required  | 선호 스타일                  |

### **Request Body 예시**

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

### **Response**

- **Status 200 OK**
  ```json
  {
    "message": "선호 스타일 등록 완료: 스트릿, 빈티지, 캐주얼, 테일러"
  }
  ```

 **Status 400 Bad Request** (선호 스타일이 중복시)
  ```json
  {
    "message": "중복된 선호 스타일 : 스트릿"
  }
  ```

</details> <!-- 선호스타일 끝 -->

<details> <!-- 체형분석 시작 -->
<summary> POST : 체형분석 API 리턴값 저장.</summary>

## POST : 체형분석 API 리턴값 저장

#### URL: /api/userForm 

 AR백엔드의 체형분석 API에서 반환된 Json구문을 저장하는 POST API입니다.
 이미 등록되어 있는 userEmail 값으로 요청하면 데이터를 업데이트 합니다.


- **요청 URL 예시**: `http://fitpitback.kro.kr:8080/api/userForm`

### **Request Body Parameters**
| 파라미터           | 타입    | 필수 여부 | 설명                       |
|-------------------|---------|-----------|------------------------------|
| `userEmail`       | string  | required  | 유저의 이메일 주소           |
| `fileName`        | string  | required  | AR 백엔드 이미지 이름        |
| `result`          | array  | required  | AR 측정 결과                  |

### **result Array Object**
| 파라미터          | 타입    | 필수 여부 | 설명                        |
|-------------------|---------|-----------|------------------------------|
| `armSize`         | number  | required  | 측정 팔 길이                 |
| `shoulderSize`    | number  | required  | 측정 어깨 길이               |
| `bodySize`        | number  | required  | 측정 몸 길이                 |
| `legSize`         | number  | required  | 측정 다리 길이               |

### **Request Body 예시**

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

### **Response**
- **Status 200 OK**

```js
{
    "message": "체형 정보 저장 완료"
}
```

</details> <!-- 체형분석 끝 -->
</details> <! -- 로그인 & 회원가입 관련 API details end>

<details> <!-- 체형분석 API details 시작 -->
<summary> <h4>체형분석 API</h4> </summary>

<details> <!-- 체형분석 이미지 GET 시작 -->
<summary> GET: 체형분석 이미지 조회 </summary>

## GET: 체형분석

#### URL : `/api/userForm/{userEmail}`

 AR서버에서 넘겨준 체형 분석 정보를 저장하는 테이블인 userForm 테이블에서 사진파일의 이름을 userEmail을 키값으로 하여 검색하는 API입니다.


` **요청 URL 예시**: http://fitpitback.kro.kr:8080/api/userForm/test1

### **Response**

- **Status 200 OK**
```js
{
    "fileName": "2c49f715-67b8-40ec-86a2-b9d3e2875923.jpg"
}

```

- **Status 500 Internal Server Error** (서버 오류류)
```js
{
    "message": "예상치 못한 오류가 발생했습니다."
}

```
 
</details> <!-- 체형분석 이미지 GET 끝 -->

<details> <!-- 체형분석 결과 GET -->
<summary>GET: 체형분석 결과 조회 </summary>

## GET: 체형분석 결과 조회

#### URL : `/api/userbodyinfo/{userEmail}`

userEmail값을 경로변수로 요청시 체형분석 결과를 반환하는 GET 메서드입니다.

- **요청 URL 예시**: `http://fitpitback.kro.kr:8080/api/userbodyinfo/test1`

### **Response**

- **Status 200 OK**

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
예외처리 추가하기
 
</details> <!-- 체형분석 결과 GET 끝 -->
 
</details> <!-- 체형분석 API details 끝 -->

<details> <!-- 메인페이지 API details 시작 -->
 
<summary> <h4> 메인페이지 </h4> </summary>

<details> <!-- 메인페이지 상품 목록 조회 API 시작 -->
 <summary>GET: 메인페이지 상품 목록 조회 </summary>

## GET : 메인페이지 상품 목록 조회

#### URL:  `api/items/list/{itemType}`

GET /api/items/list/{itemType} : 상품목록을 조회하는 api입니다.
item 테이블의 itemType(상품 종류)행을 경로변수로 받아서 경로변수와 일치하는 상품을 JSON Array 형태로 조회합니다.
 
반환되는 값은 
```
itemKey (상품 고유번호)
itemName (상품 이름)
itemBrand (상품 브랜드)
itemPrice (상품 가격)
itemImgNames : (상품 이미지 URL)
averageBmi : (구매자 평균 BMI)
```
을 반환합니다.

>요청 URL 예시: http://fitpitback.kro.kr:8080/api/items/list/상의

결과:
```js
[
    {
        "itemKey": 1,
        "itemName": "testItem1",
        "itemBrand": "TEST",
        "itemStyle": "캐주얼",
        "itemPrice": 10000,
        "itemImgNames": [
            "optimize.png"
        ],
        "averageBmi": null
    },
    {
        "itemKey": 2,
        "itemName": "testItem2",
        "itemBrand": "TEST",
        "itemStyle": "캐주얼",
        "itemPrice": 100000,
        "itemImgNames": [
            "hood.jpg"
        ],
        "averageBmi": null
    }
]
```
</details> <!-- 메인페이지 상품 목록 API 끝 -->

<details> <!-- 상품 이미지 서빙 시작 -->
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

</details> <!-- 상품 이미지 서빙 끝 -->
 
</details> <!-- 메인페이지 API details 끝 -->

<details>
<summary> <h4>핏 보관함</h4> </summary> <!-- 핏보관함 api details 시작 -->

# 핏 보관함 API

핏 보관함과 관련된 API 목록입니다. 이미지를 업로드, 조회, 삭제할 수 있습니다.

---
<details> <!-- 핏보관함 이미지 서빙 시작-->
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

</details> <!--- 핏보관함 이미지 서빙 끝--->

<details>
 <summary> 이미지 업로드</summary> <!-- 핏 보관함 이미지 업로드 시작 -->

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
    "message": "이미지 업로드 성공: image.png"
  }
  ```
- **Status 500 Internal Server Error**
  ```json
  {
    "message": "이미지 업로드 실패: 에러 메시지"
  }
  ```

</details> <!-- 핏보관함 이미지 업로드 끝 -->


<details>
 <summary>사진 삭제</summary> <!-- 핏 보관함 사진 삭제 시작-->
  
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
</details> <!-- 핏보관함 사진 삭제 끝-->

<details>
 <summary> 핏 보관함 조회 </summary> <!-- 핏 보관함 조회 시작 -->
 
## GET: 핏 보관함 조회

#### URL: `/api/fitStorageImages/user/{userEmail}`

유저 이메일을 경로 변수로 받아 핏 보관함의 내용을 리스트를 조회하는 API입니다.

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
      "fitStorageImg": "testImg.png",
      "fitComment": null,
      "itemType": null,
      "itemBrand": null,
      "itemSize": null,
      "option": null
    },
    {
      "userEmail": "test1",
      "fitStorageImg": "testImg2.png"
      "fitComment": null,
      "itemType": null,
      "itemBrand": null,
      "itemSize": null,
      "option": null
    }
  ]
  ```
 </details><!-- 핏 보관함 조회 끝 -->

<details>
<summary> GET: 모든 코멘트 조회 </summary>

## GET: 모든 코멘트 조회

모든 코멘트를 조회하는 API입니다. `fitStorage` 테이블에 저장된 모든 코멘트를 조회하여 리스트로 반환합니다.

- **요청 URL 예시**: `http://fitpitback.kro.kr:8080/api/fit_comment/get_fitcomment`

### **Response**

- **Status 200 OK**
  ```json
  [
    {
      "fitStorageKey": 1,
      "userEmail": "user1@example.com",
      "fitStorageImg": "image1.jpg",
      "fitComment": "This is a comment",
      "itemName": "Sample Item",
      "itemType": "Clothing",
      "itemBrand": "BrandX",
      "itemSize": "M",
      "option": "Fits well"
    },
    {
      "fitStorageKey": 2,
      "userEmail": "user2@example.com",
      "fitStorageImg": "image2.jpg",
      "fitComment": "Another comment",
      "itemName": "Another Item",
      "itemType": "Accessory",
      "itemBrand": "BrandY",
      "itemSize": "L",
      "option": "Fits tight"
    }
  ]
  ```

</details> <!-- 모든 코멘트 조회 API 끝 -->


<details>
<summary> GET: 특정 코멘트 조회 </summary>

## GET: 특정 코멘트 조회

특정 코멘트를 조회하는 API입니다. `fitStorageKey`로 지정된 코멘트를 조회하여 반환합니다.

- **요청 URL 예시**: `http://fitpitback.kro.kr:8080/api/fit_comment/get_fitcomment/{fitStorageKey}`
  - `{fitStorageKey}`는 조회할 코멘트의 고유 키 값입니다.

### **Path Parameters**
| 파라미터         | 타입    | 필수 여부 | 설명                  |
|------------------|---------|-----------|-----------------------|
| `fitStorageKey`  | int     | required  | 조회할 코멘트의 키 값  |

### **Response**

- **Status 200 OK**
  ```json
  {
    "fitStorageKey": 1,
    "userEmail": "user1@example.com",
    "fitStorageImg": "image1.jpg",
    "fitComment": "This is a comment",
    "itemName": "Sample Item",
    "itemType": "Clothing",
    "itemBrand": "BrandX",
    "itemSize": "M",
    "option": "Fits well"
  }
  ```

- **Status 404 Not Found** (코멘트를 찾을 수 없는 경우)
  ```json
  {
    "message": "해당 키에 대한 데이터를 찾을 수 없습니다."
  }
  ```

</details> <!-- 특정 코멘트 조회 API 끝 -->


<details>
 <summary> 코멘트 저장</summary> <!-- 핏 보관함 코멘트 저장 시작 -->

## POST: 핏 보관함 코멘트 저장

#### URL: `/api/fit_comment/save_comment`

유저의 이메일과 이미지 이름을 기반으로 코멘트를 작성하는 API입니다. 유저가 특정 이미지에 대해 코멘트를 저장할 수 있습니다.

- **요청 URL 예시**: `http://fitpitback.kro.kr:8080/api/fit_comment/save_comment`

### **Request Body Parameters**
| 파라미터        | 타입    | 필수 여부 | 설명                    |
|-----------------|---------|-----------|-------------------------|
| `userEmail`     | string  | required  | 유저의 이메일 주소        |
| `fitStorageImg` | string  | required  | 이미지 이름              |
| `fitComment`    | string  | required  | 작성할 코멘트            |
| `itemType`      | string  | required  | 상품 종류ex)바지, 상의...|
| `itemBrand`     | string  | required  | 상품 브랜드              |
| `itemSize`      | string  | required  | 상품 사이즈              |
| `option`        | string  | required  | 선택 옵션ex)크다, 작다.. |

### **Response**

- **Status 200 OK**
  ```json
  {
    "message": "코멘트 저장 성공"
  }
  ```
- **Status 404 Not Found**
  ```json
  {
    "message": "이미지를 찾을 수 없습니다"
  }
  ```

</details> <!-- 핏 보관함 코멘트 저장 끝 -->



<details>
 <summary> 코멘트 수정</summary> <!-- 핏 보관함 코멘트 수정 시작 -->

## POST: 핏 보관함 코멘트 수정

#### URL: `/api/fit_comment/update_comment`

유저의 이메일과 이미지 이름을 기반으로 코멘트를 수정하는 API입니다. 이미 저장된 코멘트를 수정할 수 있습니다.

- **요청 URL 예시**: `http://fitpitback.kro.kr:8080/api/fit_comment/update_comment`

### **Request Body Parameters**
| 파라미터        | 타입    | 필수 여부 | 설명                    |
|-----------------|---------|-----------|-------------------------|
| `userEmail`     | string  | required  | 유저의 이메일 주소        |
| `fitStorageImg` | string  | required  | 이미지 이름              |
| `fitComment`    | string  | required  | 작성할 코멘트            |
| `itemType`      | string  | required  | 상품 종류ex)바지, 상의...|
| `itemBrand`     | string  | required  | 상품 브랜드              |
| `itemSize`      | string  | required  | 상품 사이즈              |
| `option`        | string  | required  | 선택 옵션ex)크다, 작다.. |

### **Response**

- **Status 200 OK**
  ```json
  {
    "message": "코멘트 수정 성공"
  }
  ```
- **Status 404 Not Found**
  ```json
  {
    "message": "이미지를 찾을 수 없습니다"
  }
  ```

- **Status 500 Internal Server Error**
 ```json
{
  "message": "서버 에러가 발생했습니다."
}
 ```

</details> <!-- 핏 보관함 코멘트 수정 끝 -->



<details>
 <summary> 코멘트 삭제</summary> <!-- 핏 보관함 코멘트 삭제 시작 -->

## DELETE: 핏 보관함 코멘트 삭제

#### URL: `/api/fit_comment/delete_comment`

유저의 이메일과 이미지 이름을 기반으로 코멘트를 삭제하는 API입니다. 이미 저장된 코멘트를 삭제할 수 있습니다.

- **요청 URL 예시**: `http://fitpitback.kro.kr:8080/api/fit_comment/delete_comment`

### **Form Data Parameters**
| 파라미터        | 타입    | 필수 여부 | 설명                    |
|-----------------|---------|-----------|-------------------------|
| `userEmail`     | string  | required  | 유저의 이메일 주소        |
| `fitStorageImg` | string  | required  | 이미지 이름              |

### **Response**

- **Status 200 OK**
  ```json
  {
    "message": "코멘트 삭제 성공"
  }
  ```
- **Status 404 Not Found**
  ```json
  {
    "message": "이미지를 찾을 수 없습니다"
  }
  ```

- **Status 500 Internal Server Error**
 ```json
{
  "message": "서버 에러가 발생했습니다."
}
 ```
  

</details> <!-- 핏 보관함 코멘트 삭제 끝 -->

 
</details> <!-- 핏보관함 details API 끝 -->


<details> <!- 제품 상세 API details 시작 -->

<summary> <h4> 제품 상세 페이지 </h4> </summary>

<details> <!-- 상품 상세 정보 APi 시작-->
<summary>GET/api/item-info/{itemKey} : itemKey를 경로인자로 받아 상품의 상세 정보를 반환합니다. </summary>

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
    "itemImgNames": [
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

</details> <!-- 상품 상세 정보 API 끝--> 


<details> <!-- 장바구니 저장 API 시작 -->

<summary> POST: 장바구니 저장 </summary> 

## POST: 장바구니 저장

#### URL: `/api/cart/store`

상품을 장바구니에 저장하는 API입니다. 상품 정보와 수량을 받아 장바구니에 저장합니다.

- **요청 URL 예시**: `http://fitpitback.kro.kr:8080/api/cart/store`

### **Request Body Parameters**
| 파라미터     | 타입    | 필수 여부 | 설명                    |
|-------------|---------|-----------|---------------------------|
| `itemKey`   | int     | required  | 상품 고유번호             |
| `userEmail` | string  | required  | 유저 이메일 주소          |
| `itemImgName`| string  | required  | 상품 이미지 파일명       |
| `itemName`  | string  | required  | 상품 이름                 |
| `itemSize`  | string  | required  | 상품 사이즈               |
| `itemType`  | string  | required  | 상품 유형                 |
| `itemPrice` | int     | required  | 상품 가격                 |
| `pit`       | int     | optional  | 수선 가격                 |
| `qty`       | int     | required  | 상품 수량                 |

### **Response**

- **Status 200 OK**
  ```json
  {
    "message": "장바구니에 상품이 성공적으로 추가되었습니다."
  }
  ```

- **Status 500 Internal Server Error**
  ```json
  {
    "message": "장바구니에 상품 추가 중 오류가 발생했습니다."
  }
  ```

</details> <!-- 장바구니 저장 API 끝 -->
 
</details> <!-- 제품 상세 API detils 끝 -->

<details> <!-- 장바구니 페이지 API details 시작 -->

<summary> <h4> 장바구니 페이지 </h4> </summary>

<details> <!-- 장바구니 목록 조회 시작 -->
 <summary> GET : 장바구니 목록 조회 </summary>
 
#### GET/api/cart/get-store/{userEmail}

{userEmail}을 경로변수로 받아 장바구니 목록을 조회하는 API입니다. 
 
>요청 URL 예시: http://fitpitback.kro.kr:8080/api/cart/get-store/test1

결과:
```js
[
    {
        "cartKey": 2,
        "itemKey": 1,
        "userEmail": "test1",
        "itemImgName": "testImg",
        "itemName": "테스트용 상품1(상의)",
        "itemSize": "M",
        "itemType": "상의",
        "itemPrice": 10000,
        "pit": 1,
        "qty": 0
    },
    {
        "cartKey": 18,
        "itemKey": 3,
        "userEmail": "test1",
        "itemImgName": "testImg",
        "itemName": "테스트용 상품2",
        "itemSize": "M",
        "itemType": "하의",
        "itemPrice": 10000,
        "pit": 1,
        "qty": 0
    }
]
```
</details> <!-- 장바구니 목록 조회 끝-->

<details> <!-- 수선내역 조회 시작 -->
 <summary> GET : 수선내역 조회 </summary>
 
#### GET/api/pit/get/{cartKey}

장바구니 테이블의 {cartKey}을 경로변수로 받아 장바구니 목록을 조회하는 API입니다. 
 
>요청 URL 예시: http://fitpitback.kro.kr:8080/api/pit/get/2

결과:
```js
{
    "cartKey": 2,
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
</details> <!-- 수선내역 조회 끝 -->

</details> <!-- 장바구니 페이지 API details 끝 -->

<details> <!-- 검색 페이지 API details 시작 -->
<summary> <h4> 검색 페이지 </h4></summary> <!-- 상품 검색 시작 -->

<details> 
<summary>GET : 상품 검색</summary> <!-- 상품 검색 시작 -->

## GET: 상품 검색


#### URL: `/api/item-search/search/{searchWord}`

특정 검색어를 기준으로 `item` 테이블에서 `itemName`, `itemType`, `itemBrand`, `itemContent` 필드에 해당하는 상품을 검색하는 API입니다. 검색어는 URL 경로 변수로 전달되며, 결과로는 해당 조건에 맞는 상품 리스트가 반환됩니다.

 예외가 발생하거나 검색 결과가 없는 경우 `searchResult`는 빈 배열로 반환됩니다.

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
            "itemImgName": "optimize.png"
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
  
</details> <!-- 상품검색 끝-->

<details>  
<summary>GET : 추천 검색어</summary> <!-- 추천 검색어 시작-->

## GET: 추천 검색어

#### URL: `/api/item-search/recommend`

검색 횟수가 높은 상위 10개의 검색어 중 3개를 랜덤으로 추천해주는 API입니다. 서버는 `searchTable`에서 검색 횟수(`SearchCount`)가 높은 검색어를 기준으로 추천 검색어를 제공합니다.

- **요청 URL 예시**: `http://fitpitback.kro.kr:8080/api/item-search/recommend`

### **Response**

- **Status 200 OK**
  ```json
  {
    "recommendations": [
        "상의",
        "바지",
        "신발"
    ]
  }
  ```

- **Status 500 Internal Server Error**
  ```json
  {
    "message": "추천 검색어 조회 중 오류가 발생했습니다."
  }
  ```

### **설명**
- 이 API는 검색 횟수가 많은 상위 10개의 검색어 중 3개를 랜덤으로 반환합니다.
- 결과는 `recommendations` 필드에 배열 형태로 반환되며, 이 배열에는 3개의 추천 검색어가 포함됩니다.
- 예외가 발생할 경우 `message` 필드에 오류 메시지가 포함됩니다.

</details> <!-- 추천 검색어 끝-->

</details> <!-- 검색 페이지 API details 끝 -->

<details> <!-- 주문/결제 페이지 details start-->
<summary><h4>주문/결제 페이지</h4></summary>


<details> <!-- 주문내역 등록 API 시작 -->

<summary> POST: 주문내역 등록 </summary> 

## POST: 주문 등록

#### URL: `/api/order/post_order`

주문을 등록하는 API입니다. 주문 정보를 받아 처리합니다.

- **요청 URL 예시**: `http://fitpitback.kro.kr:8080/api/order/post_order`

### **Request Body Parameters**
| 파라미터      | 타입    | 필수 여부 | 설명                                                    |
|---------------|---------|-----------|---------------------------------------------------------|
| `itemKey`     | int     | required  | 상품 고유번호                                           |
| `userEmail`   | string  | required  | 회원 이메일                                             |
| `userName`    | string  | required  | 회원 이름                                               |
| `userAddr`    | string  | required  | 회원 주소                                               |
| `userNumber`  | string  | required  | 회원 전화번호                                           |
| `optional`    | string  | optional  | 상품 이름                                               |
| `itemImg`     | string  | optional  | 상품 이미지 URL                                         |
| `itemSize`    | string  | required  | 상품 사이즈                                                       |
| `itemPrice`   | int     | required  | 상품 가격                                                         |
| `itemTotal`   | int     | required  | 총 가격                                                           |
| `pit`         | int     | required  | 수선 여부 (0: 수선 없음, 1: 수선 있음)                             |
| `pitPrice`    | int     | optional  | 수선 가격 (수선이 없는 경우 null 가능)                             |
| `qty`         | int     | optional  | 수량                                                               |
| `orderStatus` | int     | optional  | 주문 상태 (0: 결제 완료, 1: 배송 중, 2: 배송 완료, 기본값은 0입니다.)|

### **Response**

- **Status 200 OK**
  ```json
  {
    "message": "주문 등록 완료."
  }
  ```

- **Status 500 Internal Server Error**
  ```json
  {
    "message": "알 수 없는 오류가 발생했습니다."
  }
  ```

</details> <!-- 주문내역 등록 API 끝 -->


<details> <!-- 주문 조회 API 시작 -->

<summary> GET: 주문 조회 </summary> 

## GET: 주문 조회

#### URL: `/api/order/get_order/{userEmail}`

특정 사용자의 주문 목록을 조회하는 API입니다.

- **요청 URL 예시**: `http://fitpitback.kro.kr:8080/api/order/get_order/{userEmail}`

### **Path Variables**
| 파라미터   | 타입    | 필수 여부 | 설명               |
|------------|---------|-----------|--------------------|
| `userEmail`  | string  | required  | 조회할 회원 이메일 |

### **Response**

- **Status 200 OK**
  ```json
  [
    {
      "itemKey": 1,
      "userEmail": "test@example.com",
      "userName": "테스트",
      "userAddr": "서울시 강남구",
      "userNumber": "010-1234-5678",
      "optional": "상품1",
      "itemImg": "image_url.jpg",
      "itemSize": "L",
      "itemPrice": 30000,
      "itemTotal": 60000,
      "qty": 2,
      "pitStatus": "수선 있음",          // 수선 여부, 0: 수선 없음, 1: 수선 있음
      "displayPitPrice": "5000",        // 수선 비용, null일 경우 "경매중"
      "displayOrderStatus": "결제 완료"  // 주문 상태, 0: 결제 완료, 1: 배송중, 2: 배송완료
    }
  ]
  ```
  
DB에 저장된 값에 따라 ``pitStatus`` , ``displayPitPrice`` , ``displayOrderStatus`` 값이 다르게 나옵니다.


- **Status 404 Not Found**
  ```json
  {
    "message": "주문 리스트가 없습니다."
  }
  ```

- **Status 500 Internal Server Error**
  ```json
  {
    "message": "주문 조회 중 오류가 발생했습니다."
  }
  ```

</details> <!-- 주문 조회 API 끝 -->


<details> <!-- 결제 내역 저장 API 시작 -->

<summary> POST: 결제 내역 저장 </summary> 

## POST: 결제 완료

#### URL: `/api/payment/complete`

결제 완료 및 주문 내역을 저장하는 API입니다. 결제 정보를 받아 처리합니다.

- **요청 URL 예시**: `http://fitpitback.kro.kr:8080/api/payment/complete`

### **Request Body Parameters**
| 파라미터     | 타입    | 필수 여부 | 설명                      |
|-------------|---------|-----------|---------------------------|
| `paymentKey`| int     | required  | 결제 고유번호             |
| `orderKey`  | int     | required  | 주문 고유번호             |
| `userKey`   | int     | required  | 회원 고유번호             |
| `totalPrice`| int     | required  | 결제 총액                 |
| `paymentDate`| string | required  | 결제 날짜                 |

### **Response**

- **Status 200 OK**
  ```json
  {
    "message": "결제 및 주문 내역 저장 완료."
  }
  ```

- **Status 500 Internal Server Error**
  ```json
  {
    "message": "결제 내역 저장 중 오류가 발생했습니다."
  }
  ```

</details> <!-- 결제 내역 저장 API 끝 -->

 
</details> <!-- 주문/결제 페이지 details end-->
 
</details> <!-- APP API details end-->


<details><!-- WEB API details start-->
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
 <summary>POST/api/itemBottomInfo/register : 하의 상품의 상세 정보를 등록를 등록하는 API입니다.</summary>
 
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
 
</details> <!-- WEB API details end-->



