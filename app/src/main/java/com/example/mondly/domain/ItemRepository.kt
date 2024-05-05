package com.example.mondly.domain

import com.example.mondly.data.network.models.Item

interface ItemRepository {
    suspend fun fetchItems(): List<Item>
}
