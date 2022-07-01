package com.dongeul.composelayoutstepsample.navigating

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.dongeul.composelayoutstepsample.navigating.accounts.AccountsBody
import com.dongeul.composelayoutstepsample.navigating.accounts.SingleAccountBody
import com.dongeul.composelayoutstepsample.navigating.bills.BillsBody
import com.dongeul.composelayoutstepsample.navigating.components.RallyTabRow
import com.dongeul.composelayoutstepsample.navigating.data.UserData
import com.dongeul.composelayoutstepsample.navigating.overview.OverviewBody

@Composable
fun RallyApp() {
    MaterialTheme() {
        val allScreens = RallyScreen.values().toList()
        val navController = rememberNavController()
        val backstackEntry = navController.currentBackStackEntryAsState()
        val currentScreen: RallyScreen =
            RallyScreen.fromRoute(backstackEntry.value?.destination?.route)

        Scaffold(
            topBar = {
                RallyTabRow(
                    allScreens = allScreens,
                    onTabSelected = { screen ->
                        navController.navigate(screen.name)
                    },
                    currentScreen = currentScreen
                )
            }
        ) { innerPadding ->

            NavHost(
                navController = navController,
                startDestination = RallyScreen.Overview.name,
                modifier = Modifier.padding(innerPadding)
            ) {

                composable(RallyScreen.Overview.name) {
                    OverviewBody(
                        onClickSeeAllAccounts = {
                            navController.navigate(RallyScreen.Accounts.name)
                        },
                        onClickSeeAllBills = {
                            navController.navigate(RallyScreen.Bills.name)
                        }, onAccountClick = { name ->
                            navigateToSingleAccount(navController, name)
                        })

                }
                composable(
                    RallyScreen.Accounts.name
                ) {
                    AccountsBody(
                        accounts = UserData.accounts,
                        onAccountClick = { name ->
                            navigateToSingleAccount(navController, name)
                        })
                }
                composable(RallyScreen.Bills.name) {
                    BillsBody(
                        bills = UserData.bills,
                        onClickBill = {

                        })
                }
                val accountsName = RallyScreen.Accounts.name
                composable(
                    route = "$accountsName/{name}",
                    arguments = listOf(
                        navArgument("name") {
                            type = NavType.StringType
                        }
                    ),
                    deepLinks = listOf(
                        navDeepLink {
                            uriPattern = "rally://$accountsName/{name}"
                        }
                    ),
                ) { entry ->
                    val accountName = entry.arguments?.getString("name")
                    val account = UserData.getAccount(accountName)
                    SingleAccountBody(account = account)
                }
            }

        }
    }
}

fun navigateToSingleAccount(
    navController: NavHostController,
    accountName: String
) {
    navController.navigate("${RallyScreen.Accounts.name}/$accountName")
}
