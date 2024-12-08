package com.arnodemarchi.alarmdeezer.ui.alarm

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AlarmComponent(
    alarmName: String = "Morning Alarm",
    alarmTime: String = "07:00 AM",
    playlistTitle: String = "Deezer Playlist",
    playlistDetails: String = "5 songs - 20 mins",
    isAlarmEnabled: Boolean = true,
    onToggle: (Boolean) -> Unit = {}
) {
    // State for toggle switch
    val alarmState = remember { mutableStateOf(isAlarmEnabled) }

    // Alarm container
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.White, shape = RoundedCornerShape(16.dp))
            .border(1.dp, Color.Gray.copy(alpha = 0.3f), RoundedCornerShape(16.dp))
            .padding(16.dp)
    ) {
        Column {
            // Alarm Name
            Text(
                text = alarmName,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Alarm Time
            Text(
                text = alarmTime,
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Days of the Week
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            ) {
                val days = listOf("S", "M", "T", "W", "T", "F", "S")
                days.forEach { day ->
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(32.dp)
                            .background(Color.LightGray, shape = CircleShape)
                            .clickable { /* Handle day selection */ }
                    ) {
                        Text(
                            text = day,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    }
                }
            }

            // Playlist and Toggle Row
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                // Playlist Image and Text
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Playlist Image (Dummy)
                    Box(
                        modifier = Modifier
                            .size(64.dp)
                            .background(Color.Gray, shape = RoundedCornerShape(8.dp))
                    )

                    // Playlist Text
                    Column(modifier = Modifier.padding(start = 8.dp)) {
                        Text(
                            text = playlistTitle,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        Text(
                            text = playlistDetails,
                            fontSize = 14.sp,
                            color = Color.Gray
                        )
                    }
                }

                // Toggle Switch
                Switch(
                    checked = alarmState.value,
                    onCheckedChange = {
                        alarmState.value = it
                        onToggle(it)
                    },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color.Green,
                        uncheckedThumbColor = Color.Red
                    )
                )
            }
        }
    }
}
