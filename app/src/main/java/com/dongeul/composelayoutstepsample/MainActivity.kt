package com.dongeul.composelayoutstepsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.dongeul.composelayoutstepsample.airplane.ui.CraneHome
import com.dongeul.composelayoutstepsample.shoppingmall.ShoppingMallApp
import com.dongeul.composelayoutstepsample.ui.theme.ComposeLayoutStepSampleTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            var state by remember {
                mutableStateOf(true)
            }

            ComposeLayoutStepSampleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CraneHome(onExploreItemClicked = {})
                }

            }
        }
    }

}




