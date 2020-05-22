# SOPTThirdAssignment
3주차 필수과제에 해당하는 내용입니다.
3주차 성장과제는 본인의 건강이 5/12일부터 안 좋았던지라 차후에 하는걸로...

## CapturedImages
<img src="https://user-images.githubusercontent.com/54518925/82676157-e16d3900-9c80-11ea-90cb-c3caf175b50b.png" width="30%"></img>
<img src="https://user-images.githubusercontent.com/54518925/82676170-e5995680-9c80-11ea-8977-706e74440b08.png" width="30%"></img>
<img src="https://user-images.githubusercontent.com/54518925/82676175-e8944700-9c80-11ea-8241-a655056c0e9c.png" width="30%"></img>
<img src="https://user-images.githubusercontent.com/54518925/82676182-ea5e0a80-9c80-11ea-8bd7-4a45a1678528.png" width="30%"></img>

## Retrofit2 라이브러리를 활용한 네트워크 통신
### 1. Request/Response 데이터 구조 설계
#### data class RequestLogin
```
data class RequestLogin (
    val id: String,
    val password: String
)
```

#### data class ResponseLogin
```
data class ResponseLogin (
    val status : Int,
    val success: Boolean,
    val message: String,
    val data : AddData?
)

data class AddData(
    val jwt: String
)
```

### 2. 네트워크 Interface 설계
#### interface RequestInterface
```
interface RequestInterface {
    @POST("/user/signin")
    fun requestLogin(@Body body: RequestLogin) : Call<ResponseLogin>
}
```

### 3. Interface 구현
#### object RequestToServer
```
object RequestToServer {
    var retrofit = Retrofit.Builder()
        .baseUrl("http://13.209.144.115:3333")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var service: RequestInterface = retrofit.create(
        RequestInterface::class.java)
}
```

### 4. LoginActivity에서 이를 활용하여 서버와 통신
#### LoginActivity.kt
```
        btn_login.setOnClickListener {
            if(et_id.text.isNullOrBlank() || et_password.text.isNullOrBlank()){
                showToast("아이디와 비밀번호를 입력하세요.")
            }else{
                //로그인 요청
                RequestToServer.service.requestLogin(
                    RequestLogin(
                        id = et_id.text.toString(),
                        password = et_password.text.toString()
                    )//로그인 정보를 전달
                ).enqueue(object : Callback<ResponseLogin>{
                    override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
                        //통신 실패
                        TODO("Not yet implemented")
                    }

                    override fun onResponse(
                        call: Call<ResponseLogin>,
                        response: Response<ResponseLogin>
                    ) {
                        //통신 성공
                        if(response.isSuccessful){ //statusCode가 200~300 사이일 떄
                            if(response.body()!!.success){ //ResponseLogin의 success가 true인 경우
                                showToast("로그인 성공")
                                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                                startActivity(intent)
                                finish()
                            }else{
                                showToast("아이디/비밀번호를 확인하세요")
                            }
                        }
                    }

                })
            }
        }
```

