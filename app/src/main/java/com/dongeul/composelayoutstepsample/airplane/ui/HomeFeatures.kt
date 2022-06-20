package com.dongeul.composelayoutstepsample.airplane.ui

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dongeul.composelayoutstepsample.airplane.base.*

@Composable
fun FlySearchContent(
    onPeopleChanged: (Int) -> Unit,
    titleSuffix: String
) {

    PeopleUserInput(
        titleSuffix = titleSuffix,
        onPeopleChanged = onPeopleChanged,
    )

}

@Composable
fun PeopleUserInput(
    titleSuffix: String,
    onPeopleChanged: (Int) -> Unit
) {
    Column() {

        CraneUserInput()
        Spacer(modifier =Modifier.height(8.dp) )
        FromDestination()
        Spacer(modifier =Modifier.height(8.dp) )
        ToDestinationUserInput()
        Spacer(modifier =Modifier.height(8.dp) )
        DatesUserInput()
    }
}

@Composable
fun SleepSearchContent() {
    CraneUserInput()
    Spacer(modifier = Modifier.height(8.dp))
    DataUserInput()

}










