package com.dongeul.composelayoutstepsample.shoppingmall

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat

class MainActivityShoppingMall : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            ShoppingMallApp()
        }
    }
}