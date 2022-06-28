package com.dongeul.composelayoutstepsample.navigating

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.MoneyOff
import androidx.compose.material.icons.filled.PieChart
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.dongeul.composelayoutstepsample.navigating.accounts.AccountsBody
import com.dongeul.composelayoutstepsample.navigating.bills.BillsBody
import com.dongeul.composelayoutstepsample.navigating.overview.OverviewBody

enum class RallyScreen(
    val icon: ImageVector,
    val body: @Composable ((String) -> Unit) -> Unit
) {
    Overview(
        icon = Icons.Filled.PieChart,
        body = { OverviewBody() }
    ),
    Accounts(
        icon = Icons.Filled.AttachMoney,
        body = { AccountsBody(com.dongeul.composelayoutstepsample.navigating.data.UserData.accounts) }
    ),
    Bills(
        icon = Icons.Filled.MoneyOff,
        body = { BillsBody(com.dongeul.composelayoutstepsample.navigating.data.UserData.bills) }
    );

    @Composable
    fun content(onScreenChange: (String) -> Unit) {
        body(onScreenChange)
    }

    companion object {
        fun fromRoute(route: String?): RallyScreen =
            when (route?.substringBefore("/")) {
                Accounts.name -> Accounts
                Bills.name -> Bills
                Overview.name -> Overview
                null -> Overview
                else -> throw IllegalArgumentException("Route $route is not recognized.")
            }
    }
}
