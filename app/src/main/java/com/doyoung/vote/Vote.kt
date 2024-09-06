package com.doyoung.vote

import android.content.Context
import getToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun vote(context: Context, choice: Boolean, roomId: Int): String? {
    return withContext(Dispatchers.IO) {
        try {
            val authService = RetrofitClient.authService
            val voteRequest = VoteRequest(choice)
            val authToken = getToken(context).toString()
            val response = authService.vote(authToken, roomId, voteRequest)
            response
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}