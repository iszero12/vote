package com.doyoung.vote.server.post

import android.content.Context
import com.doyoung.vote.dataclass.request.VoteRequest
import com.doyoung.vote.server.another.RetrofitClient
import getToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun postVote(context: Context, choice: Boolean, roomId: Int): String? {
    return withContext(Dispatchers.IO) {
        try {
            val authService = RetrofitClient.authService
            val voteRequest = VoteRequest(choice)
            val authToken = getToken(context).toString()
            val response = authService.postVote(authToken, roomId, voteRequest)
            response
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}