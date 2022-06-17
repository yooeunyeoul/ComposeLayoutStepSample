package com.dongeul.composelayoutstepsample.airplane.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.dongeul.composelayoutstepsample.airplane.model.ExploreModel
import com.dongeul.composelayoutstepsample.airplane.viewmodel.MainViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

typealias OnExploreItemClicked = (ExploreModel) -> Unit

enum class CraneScreen {
    FLY, SLEEP, EAT
}


@Composable
fun CraneHome(
    onExploreItemClicked: OnExploreItemClicked,
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        modifier = Modifier.statusBarsPadding(),
        drawerContent = {

        })
    { padding ->
        CraneHomeContent(
            modifier = Modifier.padding(padding),
            onExploreItemClicked = onExploreItemClicked,
            openDrawer = {
                // TODO Codelab: rememberCoroutineScope step - open the navigation drawer
                // scaffoldState.drawerState.open()
            },
            viewModel = viewModel
        )
    }

}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CraneHomeContent(
    onExploreItemClicked: OnExploreItemClicked,
    openDrawer: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = viewModel()
) {
//    val suggestedDestinations by viewModel.suggestedDestinations.collectAsState()

    var tabSelected by remember {
        mutableStateOf(CraneScreen.FLY)
    }

    BackdropScaffold(
        scaffoldState = rememberBackdropScaffoldState(initialValue = BackdropValue.Revealed),
        appBar = { /*TODO*/
        },

        frontLayerScrimColor = Color.Unspecified,
        frontLayerContent = {
            when (tabSelected) {
                CraneScreen.FLY -> {

                }
                CraneScreen.EAT -> {

                }
                CraneScreen.SLEEP -> {

                }
            }
        },
        backLayerContent = { /*TODO*/
        }

    )
    {

    }
}