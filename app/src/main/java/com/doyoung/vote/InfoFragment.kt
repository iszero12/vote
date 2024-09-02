package com.doyoung.vote

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.app.ActivityOptionsCompat


class InfoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView =  inflater.inflate(R.layout.fragment_info, container, false)
        rootView.apply{
            val goLoginButton : Button = findViewById(R.id.go_login)
            goLoginButton.setOnClickListener{
                val intent = Intent(activity, LoginActivity::class.java)
                startActivity(intent)
            }
        }
        return rootView
    }
}