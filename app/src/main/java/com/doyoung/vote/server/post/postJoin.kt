package com.doyoung.vote.server.post

import com.doyoung.vote.server.another.RetrofitClient
import com.doyoung.vote.dataclass.request.PostJoinRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun postJoin(username: String, password: String, confirmPassword: String): String? {
    return withContext(Dispatchers.IO) {
        try {
            val authService = RetrofitClient.authService
            val joinRequest = PostJoinRequest(username, password, confirmPassword)
            val response = authService.postJoin(joinRequest)
            response
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}