package com.example.soptthirdseminar.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RegisterToServer {
    var retrofit = Retrofit.Builder()
        .baseUrl("http://13.209.144.115:3333")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var service: RegisterInterface = retrofit.create(
        RegisterInterface::class.java)
}