package com.example.mondly.domain

class FetchItemsUseCase(private val repository: ItemRepository) {

    suspend operator fun invoke(): Result<List<DomainItem>> {
        return runCatching {
            repository.fetchItems().map { it.toDomainItem() }
        }
    }
}