package com.example.mondly.data.network.models

import kotlinx.serialization.Serializable

@Serializable
data class Attributes(
    val description: String,
    val imageInfo: ImageInfo,
    val name: String
)