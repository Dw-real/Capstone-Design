package com.example.gonggu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gonggu.databinding.ActivityLoginBinding
import com.example.gonggu.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    val binding by lazy { ActivitySignUpBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 회원 가입 완료 버튼
        val submitBtn = binding.submitButton

        submitBtn.setOnClickListener {
            println("hi")
            val loginIntent = Intent(this, LoginActivity::class.java)
            startActivity(loginIntent)
        }
    }

    companion object{
        lateinit var binding: SignUpActivity
    }
}