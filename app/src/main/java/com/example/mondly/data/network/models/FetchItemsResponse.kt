package com.example.mondly.data.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FetchItemsResponse(
    @SerialName("dataCollection")
    val data: List<DataCollection>
)