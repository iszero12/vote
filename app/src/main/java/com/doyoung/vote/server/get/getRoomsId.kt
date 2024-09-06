package com.doyoung.vote.server.get

import android.content.Context
import android.util.Log
import com.doyoung.vote.dataclass.response.GetRoomsIdResponse
import com.doyoung.vote.server.another.RetrofitClient
import getToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun getRoomsId(context: Context,id:Int): GetRoomsIdResponse? {
    return withContext(Dispatchers.IO) {
        try {
            val authService = RetrofitClient.authService
            val authToken = getToken(context).toString()
            Log.d("token", authToken)
            val response = authService.getRoomId(authToken,id)
            response
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}