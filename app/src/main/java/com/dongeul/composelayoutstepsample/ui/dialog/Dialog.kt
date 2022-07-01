package com.dongeul.composelayoutstepsample.ui.dialog

import android.nfc.Tag
import android.provider.ContactsContract
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

typealias onDialogClick = () -> Unit

@Composable
fun KotlinWorldDialog() {
    val openDialog = remember {
        mutableStateOf(true)
    }
    Dialog(
        onDismissRequest = {
            openDialog.value = false
        },
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true
        )
    ) {
        DialogContent(onDialogClick = {
            Log.e("Button", "Button Click")
            openDialog.value = false
        })
    }
}

@Composable
fun DialogContent(
    onDialogClick: onDialogClick = {}
) {


    Card(
        shape = MaterialTheme.shapes.small
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(20.dp)
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Kotlin World",
                style = MaterialTheme.typography.h6
            )

            Spacer(modifier = Modifier.padding(10.dp))

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    onDialogClick.invoke()
                },


                ) {
                Text(text = "Enter")
            }
        }

    }


}

@Composable
@Preview("PrevDialogContent")
fun PreviewDialogContent() {
    DialogContent()
}

@Composable
@Preview("PrevDialogContent")
fun PreviewCustomDialogContent() {
    EmailVerifyLinkNoticeDialog(visible = true) {

    }
}

@Composable
fun CustomAlertDialog(
    onDismissRequest: () -> Unit,
    properties: DialogProperties = DialogProperties(),
    content: @Composable () -> Unit,
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = properties
    ) {
        content()
    }
}

@Preview
@Composable
fun PreviewAlertDialogSample(){
    AlertDialogSample()
}

@Composable
fun AlertDialogSample() {
    MaterialTheme {
        Column {
            val openDialog = remember { mutableStateOf(false)  }

            Button(onClick = {
                openDialog.value = true
            }) {
                Text("Click me")
            }

            if (openDialog.value) {

                AlertDialog(
                    onDismissRequest = {
                        // Dismiss the dialog when the user clicks outside the dialog or on the back
                        // button. If you want to disable that functionality, simply use an empty
                        // onCloseRequest.
                        openDialog.value = false
                    },
                    title = {
                        Text(text = "Dialog Title")
                    },
                    text = {
                        Text("Here is a text ")
                    },
                    confirmButton = {
                        Button(

                            onClick = {
                                openDialog.value = false
                            }) {
                            Text("This is the Confirm Button")
                        }
                    },
                    dismissButton = {
                        Button(

                            onClick = {
                                openDialog.value = false
                            }) {
                            Text("This is the dismiss Button")
                        }
                    }
                )
            }
        }

    }
}

@Composable
fun EmailVerifyLinkNoticeDialog(
    visible: Boolean,
    onDismissRequest: () -> Unit,
) {
    if (visible) {
        CustomAlertDialog(onDismissRequest = { onDismissRequest() }) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .clip(RoundedCornerShape(12.dp))
                    .background(color = Color.White)
            ) {
                Text(
                    modifier = Modifier
                        .padding(top = 24.dp)
                        .padding(horizontal = 24.dp),
                    text = "nanananananana"

                )
                Text(
                    modifier = Modifier
                        .padding(12.dp)
                        .align(Alignment.End)
                        .clickable {
                            onDismissRequest()
                        }
                        .padding(12.dp),
                    text = "OK"
                )
            }
        }
    }
}