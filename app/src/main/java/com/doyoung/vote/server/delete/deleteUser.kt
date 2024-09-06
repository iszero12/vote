package com.doyoung.vote.server.delete

import android.content.Context
import com.doyoung.vote.server.another.RetrofitClient
import getToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun deleteUser(context: Context): String? {
    return withContext(Dispatchers.IO) {
        try {
            val authService = RetrofitClient.authService
            val authToken = getToken(context).toString()
            val response = authService.deleteUser(authToken)
            response
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}