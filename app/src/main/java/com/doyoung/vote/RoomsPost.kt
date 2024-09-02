package com.doyoung.vote

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun RoomsPost(title: String, content: String): RoomsResponse? {
    return withContext(Dispatchers.IO) {
        try {
            val authService = RetrofitClient.authService
            val roomsRequest = RoomsRequest(title, content)
            val authToken = "dummy"
            val response = authService.rooms(authToken, roomsRequest)  // RoomsResponse 반환
            response
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}
