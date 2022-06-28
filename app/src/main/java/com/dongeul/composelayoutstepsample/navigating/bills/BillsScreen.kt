package com.dongeul.composelayoutstepsample.navigating.bills

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import com.dongeul.composelayoutstepsample.R
import com.dongeul.composelayoutstepsample.navigating.components.BillRow
import com.dongeul.composelayoutstepsample.navigating.components.StatementBody
import com.dongeul.composelayoutstepsample.navigating.data.Bill

@Composable
fun BillsBody(bills: List<Bill>) {
    StatementBody(
        modifier = Modifier.clearAndSetSemantics { contentDescription = "Bills" },
        items = bills,
        amounts = { bill -> bill.amount },
        colors = { bill -> bill.color },
        amountsTotal = bills.map { bill -> bill.amount }.sum(),
        circleLabel = stringResource(R.string.due),
        rows = { bill ->
            BillRow(bill.name, bill.due, bill.amount, bill.color)
        }
    )
}
