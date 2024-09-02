package com.doyoung.vote

import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface AuthService {
    @POST("login")
    suspend fun login(@Body loginRequest: LoginRequest): String
    @POST("join")
    suspend fun join(@Body loginRequest: JoinRequest): String
    @POST("rooms")
    suspend fun rooms(
        @Header("Authorization") token: String,
        @Body roomRequest: RoomsRequest):RoomsResponse
}
