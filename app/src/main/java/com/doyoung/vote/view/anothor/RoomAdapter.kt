package com.doyoung.vote.view.anothor

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.fragment.app.FragmentManager
import com.doyoung.vote.R
import com.doyoung.vote.dataclass.response.GetRoomsResponse
import com.doyoung.vote.view.fragment.VoteFragment
import com.doyoung.vote.server.get.getRoomsId
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RoomAdapter(
    private val rooms: List<GetRoomsResponse>,
    private val fragmentManager: FragmentManager
) : RecyclerView.Adapter<RoomAdapter.RoomViewHolder>() {

    class RoomViewHolder(itemView: View, private val rooms: List<GetRoomsResponse>, private val fragmentManager: FragmentManager) : RecyclerView.ViewHolder(itemView) {
        val roomName: TextView = itemView.findViewById(R.id.room_name)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val roomId = rooms[position].id
                    val context = itemView.context
                    GlobalScope.launch {
                        CoroutineScope(Dispatchers.IO).launch {
                            val response = getRoomsId(context, roomId)
                            Log.d("response", response.toString())

                            val fragment = VoteFragment().apply {
                                arguments = Bundle().apply {
                                    putInt("roomId", roomId)
                                    putString("content", response?.contents)
                                    putString("title", response?.title)
                                }
                            }

                            (context as? FragmentActivity)?.supportFragmentManager?.beginTransaction()
                                ?.replace(R.id.fragment_container, fragment)
                                ?.addToBackStack(null)
                                ?.commit()
                        }
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.room_item, parent, false)
        return RoomViewHolder(itemView, rooms, fragmentManager)
    }

    override fun onBindViewHolder(holder: RoomViewHolder, position: Int) {
        val room = rooms[position]
        holder.roomName.text = room.title
    }

    override fun getItemCount(): Int {
        return rooms.size
    }
}
