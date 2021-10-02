package com.imeja.jetpackfirebase.widgets

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import kotlinx.coroutines.ExperimentalCoroutinesApi


@ExperimentalCoroutinesApi
@Composable
fun Progress(
    isDisplayed: Boolean
) {
    if (isDisplayed) {
        CircularProgressIndicator()
    }
}