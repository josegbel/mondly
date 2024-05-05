package com.example.mondly.ui.composable

import ItemComposable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mondly.R.string
import com.example.mondly.domain.ItemsError
import com.example.mondly.ui.viewmodels.ItemsViewModel

@Composable
fun ItemsContent(itemsViewModel: ItemsViewModel) {
    val uiState by itemsViewModel.uiState.collectAsState()

    if (uiState.isLoading) {
        LinearProgressIndicator()
    } else if (uiState.error != null) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            val errorMessage = when (uiState.error) {
                ItemsError.NETWORK_ERROR -> stringResource(string.network_error_occurred)
                else -> stringResource(string.something_went_wrong)
            }
            Text(text = errorMessage)
            Spacer(modifier = Modifier.size(8.dp))
            Button(onClick = { itemsViewModel.fetchItems() }) {
                Text(text = stringResource(string.retry))
            }
        }
    } else {
        LazyColumn {
            uiState.items.forEach {
                item {
                    ItemComposable(item = it)
                }
            }
        }
    }
}