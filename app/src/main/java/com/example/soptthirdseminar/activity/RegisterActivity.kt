package com.example.soptthirdseminar.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.soptthirdseminar.R
import com.example.soptthirdseminar.network.RegisterToServer
import com.example.soptthirdseminar.network.RequestRegister
import com.example.soptthirdseminar.network.ResponseRegister
import kotlinx.android.synthetic.main.activity_register.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btn_register.setOnClickListener {
            if(et_id.text.isNullOrBlank() || et_password.text.isNullOrBlank() || et_passwordCheck.text.isNullOrBlank() || et_name.text.isNullOrBlank() || et_mail.text.isNullOrBlank() || et_phone.text.isNullOrBlank()){
                Toast.makeText(this, "모든 정보를 입력했는 지 확인해주세요", Toast.LENGTH_SHORT).show()
            }
            else if(et_password.text.toString() != et_passwordCheck.text.toString()){
                Toast.makeText(this, "패스워드창과 패스워드 확인창의 내용이 일치하지 않습니다", Toast.LENGTH_SHORT).show()
            }else{

                RegisterToServer.service.requestRegister(
                    RequestRegister(
                        id = et_id.text.toString(),
                        password = et_password.text.toString(),
                        name = et_name.text.toString(),
                        email = et_mail.text.toString(),
                        phone = et_phone.text.toString()
                    )//로그인 정보를 전달
                ).enqueue(object : Callback<ResponseRegister>{
                    override fun onFailure(call: Call<ResponseRegister>, t: Throwable) {
                        TODO("Not yet implemented")
                    }

                    override fun onResponse(
                        call: Call<ResponseRegister>,
                        response: Response<ResponseRegister>
                    ) {
                        if(response.isSuccessful){ //statusCode가 200~300 사이일 떄
                            if(response.body()!!.success){
                                Toast.makeText(this@RegisterActivity, "회원가입 성공", Toast.LENGTH_SHORT).show()
                                finish()
                            }else{
                                Toast.makeText(this@RegisterActivity, response.body()!!.message, Toast.LENGTH_SHORT).show()
                            }
                        }
                    }

                })
            }
        }
    }
}
