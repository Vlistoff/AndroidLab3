package ru.vlistoff.lab3.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ClientOkHttp {
    private const val BASE_URL = "https://api.magicthegathering.io/v1/"

    val api: CardApi = getRetrofit(BASE_URL).create(CardApi::class.java)

    private fun getRetrofit(baseUrl: String): Retrofit {
        val okHttpClient = OkHttpClient
            .Builder()
            .build()

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
