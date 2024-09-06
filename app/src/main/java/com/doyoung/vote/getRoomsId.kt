package com.doyoung.vote

import android.content.Context
import android.util.Log
import getToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun getRoomsId(context: Context,id:Int): detailRoom? {
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