package com.doyoung.vote

data class JoinRequest(
    val username: String,
    val password: String,
    val confirmPassword: String
)