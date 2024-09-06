package com.doyoung.vote.dataclass.request

data class PostJoinRequest(
    val username: String,
    val password: String,
    val confirmPassword: String
)