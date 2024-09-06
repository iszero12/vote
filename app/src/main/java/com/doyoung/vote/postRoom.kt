package com.doyoung.vote

import android.content.Context
import getToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun postRoom(context: Context, title: String, content: String): RoomsResponse? {
    return withContext(Dispatchers.IO) {
        try {
            val authService = RetrofitClient.authService
            val roomsRequest = RoomsRequest(title, content)
            val authToken = getToken(context).toString()
            val response = authService.postRooms(authToken, roomsRequest)  // RoomsResponse 반환
            response
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}
