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

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val usernameInput : EditText = findViewById(R.id.id_input)
        val passwordInput : EditText = findViewById(R.id.password_input)
        val loginButton : Button = findViewById(R.id.enter_button)
        val goSignupButton : Button = findViewById(R.id.go_signup)
        loginButton.setOnClickListener(){
            val username = usernameInput.text.toString()
            val password = passwordInput.text.toString()
            GlobalScope.launch {
                val result = login(username, password)
                Log.d("result", result.toString())
                if (result != null){
                    val intent = Intent(this@LoginActivity, MainActivity::class.java)
                    startActivity(intent)
                }
            }
        }

        goSignupButton.setOnClickListener(){
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }


    }
}