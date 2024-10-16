package com.doyoung.vote.view.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.doyoung.vote.R
import com.doyoung.vote.server.post.postLogin
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import saveToken


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
                val result = postLogin(username, password)
                Log.d("resultdddd", result.toString())
                if (result != null){
                    val context: Context = this@LoginActivity
                    saveToken(context,result)
                    val intent = Intent(this@LoginActivity, MainActivity::class.java)
                    startActivity(intent)
                }
                else{
                    withContext(Dispatchers.Main) {
                        val errorView: TextView = findViewById(R.id.error_view)
                        errorView.text = "로그인 실패"
                    }
                }
            }
        }

        goSignupButton.setOnClickListener{
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }


    }
}