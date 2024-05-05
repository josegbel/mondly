package com.example.mondly.domain

import com.example.mondly.data.network.models.Item

data class DomainItem(
    val id: String,
    val name: String,
    val description: String,
    val imageUrl: String
)

internal fun Item.toDomainItem() = DomainItem(
    id = id,
    name = attributes.name,
    description = attributes.description,
    imageUrl = attributes.imageInfo.imageUrl
)