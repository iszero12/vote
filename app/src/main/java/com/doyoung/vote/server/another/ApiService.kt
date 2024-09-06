package com.doyoung.vote.server.another

import com.doyoung.vote.dataclass.request.PostJoinRequest
import com.doyoung.vote.dataclass.request.PostLoginRequest
import com.doyoung.vote.dataclass.response.GetRoomsResponse
import com.doyoung.vote.dataclass.request.PostRoomsRequest
import com.doyoung.vote.dataclass.request.PostVotesRequest
import com.doyoung.vote.dataclass.response.PostRoomsResponse
import com.doyoung.vote.dataclass.response.GetResultsResponse
import com.doyoung.vote.dataclass.response.GetRoomsIdResponse
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface AuthService {
    @POST("login")
    suspend fun postLogin(@Body loginRequest: PostLoginRequest): String
    @POST("join")
    suspend fun postJoin(@Body joinRequest: PostJoinRequest): String
    @POST("rooms")
    suspend fun postRooms(
        @Header("Authorization") token: String,
        @Body roomRequest: PostRoomsRequest
    ): PostRoomsResponse
    @GET("rooms")
    suspend fun getRooms(
        @Header("Authorization") token: String
    ): List<GetRoomsResponse>
    @GET("rooms/{id}")
    suspend fun getRoomId(
        @Header("Authorization") token: String,
        @Path("id") id: Int
    ): GetRoomsIdResponse
    @POST("votes/{roomId}")
    suspend fun postVote(
        @Header("Authorization") token: String,
        @Path("roomId") roomId: Int,
        @Body choice: PostVotesRequest
    ): String
    @GET("votes/{roomId}/results")
    suspend fun getResults(
        @Header("Authorization") token: String,
        @Path("roomId") roomId: Int
    ): GetResultsResponse
    @DELETE("users/delete")
    suspend fun deleteUser(
        @Header("Authorization") token: String
    ): String

}