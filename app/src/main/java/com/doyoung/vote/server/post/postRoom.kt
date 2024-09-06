package com.doyoung.vote.server.post

import android.content.Context
import com.doyoung.vote.server.another.RetrofitClient
import com.doyoung.vote.dataclass.request.PostRoomsRequest
import com.doyoung.vote.dataclass.response.PostRoomsResponse
import getToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun postRoom(context: Context, title: String, content: String): PostRoomsResponse? {
    return withContext(Dispatchers.IO) {
        try {
            val authService = RetrofitClient.authService
            val roomsRequest = PostRoomsRequest(title, content)
            val authToken = getToken(context).toString()
            val response = authService.postRooms(authToken, roomsRequest)
            response
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}
