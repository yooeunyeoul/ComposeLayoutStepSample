package com.dongeul.composelayoutstepsample.shoppingmall

import android.content.res.Resources
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.dongeul.composelayoutstepsample.R
import com.dongeul.composelayoutstepsample.shoppingmall.MainDestinations.HOME_ROUTE
import com.dongeul.composelayoutstepsample.shoppingmall.ui.home.HomeSections
import com.dongeul.composelayoutstepsample.shoppingmall.ui.home.cart.Cart
import com.dongeul.composelayoutstepsample.shoppingmall.ui.home.main.Main
import com.dongeul.composelayoutstepsample.shoppingmall.ui.home.profile.Profile
import com.dongeul.composelayoutstepsample.shoppingmall.ui.home.search.Search
import com.dongeul.composelayoutstepsample.shoppingmall.ui.theme.ShoppingTheme
import kotlinx.coroutines.CoroutineScope

object MainDestinations {
    const val HOME_ROUTE = "home"
    const val DETAIL_ROUTE = "detail"
    const val DETAIL_ID_KEY = "detailId"
}

typealias onNavigationClicked = () -> Unit

@Composable
fun ShoppingMallApp() {
    ShoppingTheme {
        val scaffoldState: ScaffoldState = rememberScaffoldState()
        val navController: NavHostController = rememberNavController()
        val resources: Resources = LocalContext.current.resources
        val coroutineScope: CoroutineScope = rememberCoroutineScope()


        val bottomBarTabs = HomeSections.values()

        val bottomBarRoutes = bottomBarTabs.map { it.route }
        val shouldShowBottomBar: Boolean =
            navController.currentBackStackEntryAsState().value?.destination?.route in bottomBarRoutes

        Scaffold(
            bottomBar = {
                MallBottomBar(
                    tabs = HomeSections.values(),
                    onSelected = { route ->
                        navController.navigate(route) {
                            launchSingleTop = true
                            restoreState = true
                            popUpTo(findStartDestination(navController.graph).id) {
                                saveState = true
                            }
                        }

                    }

                )
            },
            scaffoldState = scaffoldState
        ) { innerPaddingModifier ->
            NavHost(
                navController = navController,
                startDestination = HOME_ROUTE,
                modifier = Modifier.padding(innerPaddingModifier)
            ) {
                navigation(
                    route = HOME_ROUTE,
                    startDestination = HomeSections.MAIN.route
                ) {
                    addHomeGraph(
                        onItemSelected = { id, entry ->
                            navigateDetail(navController, id, entry)
                        })
                }

                composable(
                    route = "${MainDestinations.DETAIL_ROUTE}/{${MainDestinations.DETAIL_ID_KEY}}",
                    arguments = listOf(
                        element = navArgument(MainDestinations.DETAIL_ID_KEY,
                            builder = {
                                type = NavType.LongType
                            })
                    )
                ) { backStackEntry ->
                    val arguments = requireNotNull(backStackEntry.arguments)
                    val detailId = arguments.getLong(MainDestinations.DETAIL_ID_KEY)
                    ShoppingMallDetail(detailId)
                }
            }

        }


    }
}

@Composable
fun ShoppingMallDetail(
    detailId: Long
) {
    Column(Modifier.fillMaxSize()) {
        Text(
            text = "이곳은 디테일 입니다",
            color = Color.Green,
            style = MaterialTheme.typography.h6
        )
    }

}

fun navigateDetail(controller: NavHostController, id: Long, entry: NavBackStackEntry) {
    if (entry.lifecycle.currentState == Lifecycle.State.RESUMED) {
        controller.navigate("${MainDestinations.DETAIL_ROUTE}/$id")
    }
}

fun findStartDestination(graph: NavDestination): NavDestination {
    return if (graph is NavGraph) findStartDestination(graph.startDestination!!) else graph

}

private val NavGraph.startDestination: NavDestination?
    get() = findNode(startDestinationId)

private val BottomNavHeight = 56.dp
private val TextIconSpacing = 2.dp


@Preview
@Composable
private fun PreviewBottomNav() {
    ShoppingTheme {
        MallBottomBar(tabs = HomeSections.values(), onSelected = {})
    }
}

@Composable
fun MallBottomBar(
    onSelected: (String) -> Unit,
    selected: Boolean = false,
    tabs: Array<HomeSections>,
    currentRoute: String = HomeSections.MAIN.route
) {
    val routes: List<String> = remember {
        HomeSections.values().map { it.route }
    }
    val currentSection: String = routes.first { it == currentRoute }

    Surface(
        color = Color.White,
        contentColor = MaterialTheme.colors.onSecondary,
        modifier = Modifier.fillMaxWidth()
    ) {

        Row(
            Modifier.height(BottomNavHeight),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = CenterVertically
        ) {
            tabs.forEach { sections ->
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = CenterVertically,
                    modifier = Modifier
                        .weight(1f)
                        .background(color = Color.Yellow)
                        .fillMaxHeight()
                        .selectable(
                            selected = selected,
                            onClick = { onSelected(sections.route) }
                        )
                ) {
                    Box(
                        modifier = Modifier
                            .layoutId("icon")
                            .padding(horizontal = TextIconSpacing),
                        content = {
                            Icon(
                                painterResource(id = R.drawable.ic_crane_logo),
                                contentDescription = null
                            )
                        }

                    )
                    Box(
                        modifier = Modifier
                            .layoutId("text")
                            .padding(horizontal = TextIconSpacing),
                        content = {
                            Text(
                                text = "Text",
                                color = Color.Green,
                                style = MaterialTheme.typography.button,
                                maxLines = 1
                            )
                        }
                    )


                }
            }

        }


    }
}

fun NavGraphBuilder.addHomeGraph(
    onItemSelected: (Long, NavBackStackEntry) -> Unit,
    modifier: Modifier = Modifier
) {
    composable(HomeSections.MAIN.route) { from ->
        Main(onDetailSelected = {
            onItemSelected(1, from)
        })
    }
    composable(HomeSections.SEARCH.route) { from ->
        Search()
    }
    composable(HomeSections.CART.route) { from ->
        Cart()
    }
    composable(HomeSections.PROFILE.route) { from ->
        Profile()
    }
}

