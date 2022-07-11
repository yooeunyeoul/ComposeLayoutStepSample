package com.dongeul.composelayoutstepsample.shoppingmall.ui.home.cart

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

@Composable
fun Cart() {
    Surface(
        color = Color.Yellow,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Alfred Sisely", fontWeight = FontWeight.Bold)
    }
}