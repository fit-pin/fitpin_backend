# fitpin_backend
핏핀 백엔드
## API 목록

### API 사용법

**요청 메인 URL: `http://fitpitback.kro.kr:8080`**

> 요청 URL 예시 `items = http://dmumars.kro.kr:8080/api/items`

<details>
 <summary><h2>APP API</h2></summary>

  <details> 

   <summary>POST/api/members/register : 회원가입을 위한 api입니다.</summary>
  
> 요청 URL 예시 : `http://fitpitback.kro.kr:8080/api/members/register`
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
<summary>GET/api/userbodyinfo/{userEmail} : userEmail값을 키값으로 요청시 유저 이메일,키,몸무게,팔길,어깨너비,몸길이,다리길이를 반환하는 GET 메서드입니다.</summary>

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

</details>

<details>
 <summary><h2>WEB API</h2></summary>

<details>
 <summary>POST/api/items/register : 상품 정보를 등록하는 API입니다.</summary>
 
>요청 URL 예시: http://localhost:8080/api/items/register

```js
{
  "itemName": "테스트상품",
  "itemType": "상의",
  "itemBrand": "TEST",
  "itemStyle":"테일러",
  "itemCnt": 100,
  "itemContent": "테스트용 상의 상품",
  "itemPrice": 100000,
  "itemDate": "2024-07-28"
}
```
</details> 

 <details>
 <summary>POST/api/itemImages/upload : 상품의 이미지를 등록하는 api입니다. </summary>
  
>요청 URL 예시: http://localhost:8080/api/itemImages/upload

### 헤더 
- Content-Type: multipart/form-data

##### Form Data
```
- `image` (File): 사용자의 이메일 주소
- `itemKey` (Text): item테이블의 itemKey 열, 제품의 고유번호
```
</details> 

<details>
 <summary>POST/api/itemTopInfo/register : 상의 상품의 상세 정보 등록하는 API입니다.</summary>
 
>요청 URL 예시: http://localhost:8080/api/itemTopInfo/register

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

<details>
 <summary>POST/api/itemTopInfo/register : 상의 상품의 상세 정보 등록하는 API입니다.</summary>
 
>요청 URL 예시: http://localhost:8080/api/itemBottomInfo/register

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

 
</details> 




 



