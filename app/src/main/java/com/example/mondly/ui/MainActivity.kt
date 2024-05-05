package com.example.mondly.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.example.mondly.data.network.ItemService
import com.example.mondly.data.repository.ItemRepositoryImpl
import com.example.mondly.ui.composable.ItemsContent
import com.example.mondly.ui.theme.AppTheme
import com.example.mondly.ui.viewmodels.ItemsViewModel
import com.example.mondly.ui.viewmodels.ItemsViewModelFactory
import kotlinx.coroutines.Dispatchers

class MainActivity : ComponentActivity() {

    private lateinit var itemsViewModel: ItemsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val api = ItemService()

        requestViewModels(api)

        setContent {
            AppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    ItemsContent(itemsViewModel = itemsViewModel)
                }
            }
        }
    }

    private fun requestViewModels(api: ItemService) {
        val itemsViewModelFactory = ItemsViewModelFactory(
            ItemRepositoryImpl(api, Dispatchers.IO)
        )
        itemsViewModel = ViewModelProvider(this, itemsViewModelFactory)[ItemsViewModel::class.java]
    }
}
