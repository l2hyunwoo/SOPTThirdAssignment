package com.example.soptthirdseminar.network

data class RequestRegister (
    val id : String,
    val password : String,
    val name : String,
    val email : String,
    val phone : String
)