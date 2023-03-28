package com.example.gonggu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.gonggu.R
import com.example.gonggu.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    val binding by lazy { ActivityLoginBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 로그인 버튼
        val loginBtn = binding.signInBtn

        loginBtn.setOnClickListener {
            val id = binding.id.text.toString() // id
            val pwd = binding.password.text.toString() // password

            // 로그인 성공 시 메인 화면으로 이동
            if (id == "hansung" && pwd == "1234"){
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(this, "아이디 또는 비밀번호를 확인하세요!", Toast.LENGTH_LONG).show()
            }
        }

        // 회원가입 버튼
        val signUpBtn = binding.signUpBtn

        signUpBtn.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }


    companion object{
        lateinit var binding: LoginActivity
    }
}