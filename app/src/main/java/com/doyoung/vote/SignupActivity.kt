package com.doyoung.vote

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val usernameInput : EditText = findViewById(R.id.id_input)
        val passwordInput : EditText = findViewById(R.id.password_input)
        val passwordReInput : EditText = findViewById(R.id.password_re_input)
        val SignupButton : Button = findViewById(R.id.signup_button)
        val goLoginButton : Button = findViewById(R.id.go_login)
        SignupButton.setOnClickListener(){
            val username = usernameInput.text.toString()
            val password = passwordInput.text.toString()
            val passwordRe = passwordReInput.text.toString()
            GlobalScope.launch {
                val result = Join(username, password, passwordRe)
                Log.d("result", result.toString())
                if (result == "ok"){
                    val intent = Intent(this@SignupActivity, LoginActivity::class.java)
                    startActivity(intent)
                }
            }
            goLoginButton.setOnClickListener(){
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
        }
    }
}