package com.doyoung.vote

import android.content.Context
import androidx.core.content.ContentProviderCompat.requireContext
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