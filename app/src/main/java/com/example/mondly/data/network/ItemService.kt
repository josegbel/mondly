package com.example.mondly.data.network

import com.example.mondly.data.network.models.Item
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

@ExperimentalSerializationApi
class ItemService {

    private val jsonConfig = Json {
        ignoreUnknownKeys = true // Configure Json parsing settings
    }
    private val retrofit =
        Retrofit.Builder().baseUrl("https://europe-west1-mondly-workflows.cloudfunctions.net/")
            .addConverterFactory(jsonConfig.asConverterFactory("application/json".toMediaType()))
            .build()

    private val itemApi = retrofit.create(ItemApi::class.java)

    fun fetchItems(): Result<List<Item>> {
        return itemApi.fetchItems().let {
            val response = it.execute()
            if (response.isSuccessful) {
                response.body()?.let { fetchItemsResponse ->
                    Result.success(fetchItemsResponse.data.map { it.item })
                } ?: Result.success(emptyList())
            } else {
                Result.failure(Exception("Failed to fetch items"))
            }
        }
    }
}