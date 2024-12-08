@file:OptIn(ExperimentalMaterial3Api::class)

package com.arnodemarchi.alarmdeezer.ui.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AddAlarmButton(onOpenAddAlarmDial: () -> Unit = {}, modifier: Modifier = Modifier) {
     Box(
         contentAlignment = Alignment.Center,
         modifier = modifier
             .size(70.dp)
             .background(color = Color.Red, shape = CircleShape)
     ) {
         IconButton(onClick = { onOpenAddAlarmDial() }) {
             Icon(
                 imageVector = Icons.Default.Add,
                 contentDescription = "Add",
                 tint = Color.White,
                 modifier = Modifier.size(42.dp)
             )
         }
     }
}




@Preview
@Composable
fun Preview() {
    AddAlarmButton()
}
