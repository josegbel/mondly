package com.example.mondly.data.repository

import com.example.mondly.data.network.ItemService
import com.example.mondly.data.network.models.Item
import com.example.mondly.domain.ItemRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class ItemRepositoryImpl(
    private val service: ItemService, private val dispatcher: CoroutineDispatcher
) : ItemRepository {

    override suspend fun fetchItems(): List<Item> {
        return withContext(dispatcher) {
            service.fetchItems().let {
                it.getOrNull() ?: emptyList()
            }
        }
    }
}
