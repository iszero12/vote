package com.doyoung.vote

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.Settings.Global
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class AddFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_add, container, false)
        rootView.apply {
            val titleInput: EditText = findViewById(R.id.title_input)
            val contentInput: EditText = findViewById(R.id.content_input)
            val addButton: Button = findViewById(R.id.add_button)
                addButton.setOnClickListener {
                    GlobalScope.launch {
                        val title = titleInput.text.toString()
                        val content = contentInput.text.toString()
                        val context: Context = this@AddFragment.requireContext()
                        val result = postRoom(context, title, content)
                    }
                }
            }
        return rootView
    }
}