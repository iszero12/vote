package com.doyoung.vote

data class RoomsResponse (
    val id : String,
    val title : String,
    val content : String,
    val vote : List<String>
)