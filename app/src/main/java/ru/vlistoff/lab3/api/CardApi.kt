package ru.vlistoff.lab3.api

import retrofit2.Call
import retrofit2.http.GET
import ru.vlistoff.lab3.model.APIResponse
import ru.vlistoff.lab3.model.Card

interface CardApi {
    @GET("cards")
    fun getCards() : Call<APIResponse>
}