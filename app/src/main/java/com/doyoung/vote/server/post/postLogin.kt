package com.doyoung.vote.server.post

import com.doyoung.vote.dataclass.request.PostLoginRequest
import com.doyoung.vote.server.another.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun postLogin(username: String, password: String): String? {
    return withContext(Dispatchers.IO) {
        try {
            val authService = RetrofitClient.authService
            val loginRequest = PostLoginRequest(username, password)
            val response = authService.postLogin(loginRequest)
            response
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}