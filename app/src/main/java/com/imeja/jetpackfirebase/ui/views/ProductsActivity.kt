package com.imeja.jetpackfirebase.ui.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.imeja.jetpackfirebase.errors.DataOrException
import com.imeja.jetpackfirebase.model.Product
import com.imeja.jetpackfirebase.widgets.Cards
import com.imeja.jetpackfirebase.widgets.Progress
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

class ProductsActivity : ComponentActivity() {

    private val viewModel: ProductsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val dataOrException = viewModel.data.value
            ProductsActivity(dataOrException)
        }
    }

    @Composable
    fun ProductsActivity(dataOrException: DataOrException<List<Product>, Exception>) {
        val products = dataOrException.data
        products?.let {
            LazyColumn {
                items(
                    items = products
                ) { product ->
                    Cards(product = product)
                }
            }
        }

        val e = dataOrException.e
        e?.let {
            Text(
                text = e.message!!,
                modifier = Modifier.padding(16.dp)
            )
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Progress(
                isDisplayed = viewModel.loading.value
            )
        }
    }
}
