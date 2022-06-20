package com.dongeul.composelayoutstepsample.airplane.base

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.dongeul.composelayoutstepsample.R

@Composable
fun CraneUserInput(
    modifier: Modifier = Modifier,

    ) {

    Surface(
        modifier = modifier.fillMaxWidth(),
        color = MaterialTheme.colors.error
    ) {
        Row(Modifier.padding(all = 24.dp)) {
            Icon(
                painter = painterResource(id = R.drawable.ic_crane_logo),
                contentDescription = null
            )

            Spacer(modifier = Modifier.width(10.dp))

            Text(
                text = "이게 도대체 뭔데 그래",
                color = MaterialTheme.colors.secondary
            )

            Row(modifier = Modifier.align(CenterVertically)) {
                Text(text = "text", style = MaterialTheme.typography.body1)
            }

        }
    }

}