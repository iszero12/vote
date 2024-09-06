package com.doyoung.vote.server.get

import android.content.Context
import android.util.Log
import com.doyoung.vote.server.another.RetrofitClient
import com.doyoung.vote.dataclass.response.GetResultsResponse
import getToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun getResults(context: Context,roomId: Int): GetResultsResponse? {
    return withContext(Dispatchers.IO) {
        try {
            val authService = RetrofitClient.authService
            val authToken = getToken(context).toString()
            Log.d("token", authToken)
            val response = authService.getResults(authToken,roomId)
            response
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}