package com.doyoung.vote

import RoomAdapter
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import androidx.fragment.app.FragmentManager


class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_main, container, false)

        rootView.apply {
            GlobalScope.launch {
                withContext(Dispatchers.Main){
                val recyclerView: RecyclerView = findViewById(R.id.vote_list)
                val context = requireContext()
                val result = getRooms(context)
                if (result!=null){
                    val fragmentManager = childFragmentManager
                    val adapter = RoomAdapter(result,fragmentManager)
                    recyclerView.adapter = adapter
                    recyclerView.layoutManager= LinearLayoutManager(context)
                }
                }
            }

        }
        return rootView
    }


}