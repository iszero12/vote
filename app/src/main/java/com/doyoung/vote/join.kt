package com.doyoung.vote

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun Join(username: String, password: String, confirmPassword: String): String? {
    return withContext(Dispatchers.IO) {
        try {
            val authService = RetrofitClient.authService
            val joinRequest = JoinRequest(username, password, confirmPassword)
            val response = authService.join(joinRequest)
            response
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}