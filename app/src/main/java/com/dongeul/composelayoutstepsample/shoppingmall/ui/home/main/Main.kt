package com.dongeul.composelayoutstepsample.shoppingmall.ui.home.main

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dongeul.composelayoutstepsample.shoppingmall.ui.components.CommonButton

@Composable
fun Main(onDetailSelected: () -> Unit) {
    Surface(
        color = Color.Blue,
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn {
            item {

                Spacer(modifier = Modifier.height(50.dp))

                CommonButton(modifier = Modifier.padding(5.dp),
                    onClick = { onDetailSelected() }) {
                    Text(text = "디테일 화면으로 이동 ")
                }

            }
        }


    }
}

fun drawButton(button: @Composable () -> Unit) {

}


