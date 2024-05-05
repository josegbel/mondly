package com.example.mondly.data.network.models

import kotlinx.serialization.Serializable

@Serializable
data class Item(
    val attributes: Attributes,
    val id: String
)