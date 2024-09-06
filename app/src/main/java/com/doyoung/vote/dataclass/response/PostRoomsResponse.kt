package com.doyoung.vote.dataclass.response

data class PostRoomsResponse (
    val id : String,
    val title : String,
    val content : String,
    val vote : List<String>
)