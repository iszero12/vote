package com.doyoung.vote

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_main, container, false)
        rootView.apply {
            val recyclerView: RecyclerView = findViewById(R.id.vote_list)
            val rooms = mutableListOf(
                "aㅁㄴ러아ㅣ",
                "adsf",
                "adsf",
                "asdfasdf",
                "aㅁㄴ러아ㅣ",
                "adsf",
                "adsf",
                "asdfasdf",
                "aㅁㄴ러아ㅣ",
                "adsf",
                "adsf",
                "asdfasdf",
                "aㅁㄴ러아ㅣ",
                "adsf",
                "adsf",
                "asdfasdf",
            )
            val adapter = RoomAdapter(rooms)
            recyclerView.adapter = adapter
            recyclerView.layoutManager= LinearLayoutManager(context)
            adapter.notifyDataSetChanged()
        }
        return rootView
    }


}