package com.doyoung.vote

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface AuthService {
    @POST("login")
    suspend fun login(@Body loginRequest: LoginRequest): String
    @POST("join")
    suspend fun join(@Body joinRequest: JoinRequest): String
    @POST("rooms")
    suspend fun postRooms(
        @Header("Authorization") token: String,
        @Body roomRequest: RoomsRequest):RoomsResponse
    @GET("rooms")
    suspend fun getRooms(
        @Header("Authorization") token: String
    ): List<Room>
    @GET("rooms/{id}")
    suspend fun getRoomId(
        @Header("Authorization") token: String,
        @Path("id") id: Int
    ): detailRoom
    @POST("votes/{roomId}")
    suspend fun vote(
        @Header("Authorization") token: String,
        @Path("roomId") roomId: Int,
        @Body choice: VoteRequest
    ): String
    @GET("votes/{roomId}/results")
    suspend fun getResults(
        @Header("Authorization") token: String,
        @Path("roomId") roomId: Int
    ): VoteResponse

}