package com.example.mondly.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.mondly.domain.DomainItem
import com.example.mondly.domain.FetchItemsUseCase
import com.example.mondly.domain.ItemRepository
import com.example.mondly.domain.ItemsError
import com.example.mondly.domain.ItemsError.GENERIC_ERROR
import com.example.mondly.domain.ItemsError.NETWORK_ERROR
import com.example.mondly.utils.AndroidLogger
import com.example.mondly.utils.Logger
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.net.UnknownHostException

class ItemsViewModel(private val fetchItemsUseCase: FetchItemsUseCase, private val logger: Logger) :
    ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    init {
        fetchItems()
    }

    fun fetchItems() {
        viewModelScope.launch {
            _uiState.update { currentState ->
                currentState.copy(
                    isLoading = true,
                    error = null,
                )
            }

            fetchItemsUseCase().onSuccess { result ->
                logger.d(TAG, "${result.size} items fetched successfully")
                _uiState.update { currentState ->
                    currentState.copy(
                        isLoading = false,
                        items = result,
                    )
                }
            }.onFailure {
                logger.e(TAG, "Network error occurred")
                _uiState.update { currentState ->
                    if(it is UnknownHostException){
                        currentState.copy(
                            error = NETWORK_ERROR, isLoading = false
                        )
                    } else {
                        currentState.copy(
                            error = GENERIC_ERROR, isLoading = false
                        )
                    }
                }
            }
        }
    }

    data class UiState(
        val error: ItemsError? = null,
        val isLoading: Boolean = false,
        val items: List<DomainItem> = emptyList(),
    )

    companion object {
        private const val TAG = "ItemsViewModel"
    }
}

class ItemsViewModelFactory(private val repository: ItemRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ItemsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST") return ItemsViewModel(
                FetchItemsUseCase(repository), AndroidLogger()
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}