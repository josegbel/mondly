package com.example.mondly.data.network

import com.example.mondly.data.network.models.DataCollection
import com.example.mondly.data.network.models.FetchItemsResponse
import retrofit2.Call
import retrofit2.http.GET

interface ItemApi {

    @GET("mondly_android_code_task_json")
    fun fetchItems(
    ): Call<FetchItemsResponse>
}
