package com.example.soptthirdseminar.network

data class ResponseLogin (
    val status : Int,
    val success: Boolean,
    val message: String,
    val data : AddData?
)

data class AddData(
    val jwt: String
)