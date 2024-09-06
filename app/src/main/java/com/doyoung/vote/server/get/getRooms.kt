package com.doyoung.vote.server.get

import android.content.Context
import android.util.Log
import com.doyoung.vote.server.another.RetrofitClient
import com.doyoung.vote.dataclass.response.GetRoomsResponse
import getToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun getRooms(context: Context): List<GetRoomsResponse>? {
    return withContext(Dispatchers.IO) {
        try {
            val authService = RetrofitClient.authService
            val authToken = getToken(context).toString()
            Log.d("token", authToken)
            val response = authService.getRooms(authToken)
            response
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}