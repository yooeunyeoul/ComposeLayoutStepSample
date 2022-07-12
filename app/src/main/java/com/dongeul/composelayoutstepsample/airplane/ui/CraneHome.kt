package com.dongeul.composelayoutstepsample.airplane.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dongeul.composelayoutstepsample.R
import com.dongeul.composelayoutstepsample.airplane.model.ExploreModel
import com.dongeul.composelayoutstepsample.airplane.viewmodel.MainViewModel

typealias OnExploreItemClicked = (ExploreModel) -> Unit

enum class CraneScreen {
    FLY, SLEEP, EAT
}


@Composable
fun CraneHome(
    onExploreItemClicked: OnExploreItemClicked,
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = viewModel()
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
    val suggestedDestinations by viewModel.suggestedDestinations.collectAsState()
//    val suggestedDestination = viewModel.suggestedDestinations.collectAsState().value

    var tabSelected by remember {
        mutableStateOf(CraneScreen.FLY)
    }

    BackdropScaffold(
        scaffoldState = rememberBackdropScaffoldState(initialValue = BackdropValue.Revealed),
        appBar = {
            HomeTabBar(
                openDrawer = openDrawer,
                tabSelected = tabSelected,
                onTabSelected = { tabSelected = it })
        },

        frontLayerScrimColor = Color.Unspecified,
        frontLayerContent = {
            when (tabSelected) {
                CraneScreen.FLY -> {
                    ExploreSection(
                        title = "메인 홈 비행",
                        exploreList = suggestedDestinations,
                        onItemClicked = {

                        }
                    )
                }
                CraneScreen.EAT -> {
                    ExploreSection(
                        title = "메인 홈 음식",
                        exploreList = viewModel.restaurants,
                        onItemClicked = {

                        }
                    )

                }
                CraneScreen.SLEEP -> {
                    ExploreSection(title = "메인 홈 잠",
                        exploreList = viewModel.hotels,
                        onItemClicked = {

                        })
                }
            }
        },
        backLayerContent = {
            SearchContent(
                tabSelected = tabSelected,
                viewModel = viewModel,
                onPeopleChanged = {})
        }

    )
    {

    }
}

@Composable
fun SearchContent(
    tabSelected: CraneScreen,
    viewModel: MainViewModel,
    onPeopleChanged: (Int) -> Unit
) {
    when (tabSelected) {
        CraneScreen.FLY ->{
            FlySearchContent(
                onPeopleChanged = onPeopleChanged,
                titleSuffix =", Economy"
            )
        }
        CraneScreen.SLEEP->{
            SleepSearchContent()
        }
        CraneScreen.EAT->{
            FlySearchContent(
                onPeopleChanged = onPeopleChanged,
                titleSuffix =", Economy"
            )
        }
    }
}


@Composable
fun HomeTabBar(
    openDrawer: () -> Unit,
    tabSelected: CraneScreen,
    onTabSelected: (CraneScreen) -> Unit,
    modifier: Modifier = Modifier
) {
    CraneTabBar(
        modifier = modifier,
        onMenuClicked = openDrawer
    )
    { tabModifier ->
        CraneTabs(modifier = tabModifier,
            tabSelected = tabSelected,
            titles = CraneScreen.values().map { it.name },
            onTabSelected = { newTab -> onTabSelected(CraneScreen.values()[newTab.ordinal]) })
    }

}

@Composable
fun CraneTabs(
    modifier: Modifier,
    titles: List<String>,
    tabSelected: CraneScreen,
    onTabSelected: (CraneScreen) -> Unit
) {
    TabRow(selectedTabIndex = tabSelected.ordinal,
        modifier = modifier,
        contentColor = MaterialTheme.colors.onSurface,
        indicator = {},
        divider = {})
    {
        titles.forEachIndexed { index, title ->
            val selected = index == tabSelected.ordinal

            Tab(selected = selected,
                onClick = {
                    onTabSelected.invoke(CraneScreen.values()[index])
                })
            {
                Text(
                    text = title.uppercase(),
                    color = Color.Magenta
                )
            }

        }
    }

}

@Composable
fun CraneTabBar(
    modifier: Modifier,
    onMenuClicked: () -> Unit,
    children: @Composable (Modifier) -> Unit
) {
    Row(modifier = modifier) {
        Row {
            Image(
                painter = painterResource(id = R.drawable.ic_menu),
                contentDescription = null,
                modifier = Modifier
                    .padding(24.dp)
                    .clickable(onClick = onMenuClicked)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Image(
                modifier = Modifier.padding(10.dp),
                painter = painterResource(id = R.drawable.ic_crane_logo),
                contentDescription = null
            )
        }
        children.invoke(Modifier.align(CenterVertically))
    }
}
