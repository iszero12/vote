package com.doyoung.vote
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("login")
    suspend fun login(@Body loginRequest: LoginRequest): String
    @POST("join")
    suspend fun join(@Body loginRequest: JoinRequest): String
}
