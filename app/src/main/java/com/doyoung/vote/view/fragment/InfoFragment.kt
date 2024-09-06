package com.doyoung.vote.view.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.doyoung.vote.view.activity.LoginActivity
import com.doyoung.vote.R
import saveToken


class InfoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.fragment_info, container, false)
        rootView.apply {
            val goLoginButton: Button = findViewById(R.id.go_login)
            goLoginButton.setOnClickListener {
                val intent = Intent(activity, LoginActivity::class.java)
                startActivity(intent)
            }
            val rogOutButton: Button = findViewById(R.id.rog_out)
            rogOutButton.setOnClickListener {
                val context = requireContext()
                saveToken(context,"")
                val rogOutText: TextView = findViewById(R.id.rog_out_text)
                rogOutText.text = "로그아웃 되었습니다."

            }

            return rootView
        }
    }
}