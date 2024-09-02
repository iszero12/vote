package com.doyoung.vote

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class AddFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_info, container, false)
        rootView.apply {
            val titleInput: EditText = findViewById(R.id.title_input)
            val contentInput: EditText = findViewById(R.id.content_input)
            val addButton: Button = findViewById(R.id.add_button)
            addButton.setOnClickListener{
                val title = titleInput.text.toString()
                val content = contentInput.text.toString()
                GlobalScope.launch {
                    val result = RoomsPost(title, content)
                }
            }
        }
        return rootView
    }
}