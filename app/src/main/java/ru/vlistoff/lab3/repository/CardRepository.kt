package ru.vlistoff.lab3.repository

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.vlistoff.lab3.api.CardApi
import ru.vlistoff.lab3.model.APIResponse
import ru.vlistoff.lab3.model.Card

class CardRepository(private val api : CardApi) {
    fun getCards(callback: (List<Card>?) -> Unit) {
        api.getCards().enqueue(object : Callback<APIResponse> {
            override fun onResponse(call: Call<APIResponse>, response: Response<APIResponse>) {
                if (response.isSuccessful) {
                    val apiResponse = response.body()
                    if (apiResponse != null) {
                        callback(apiResponse.cards)
                    }
                    else{
                        callback(null)
                    }
                } else {
                    callback(null)
                }
            }
            override fun onFailure(call: Call<APIResponse>, t: Throwable) {
                callback(null)
            }
        })
    }
}