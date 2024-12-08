package com.arnodemarchi.alarmdeezer

import android.app.TimePickerDialog
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.arnodemarchi.alarmdeezer.ui.alarm.AlarmComponent
import com.arnodemarchi.alarmdeezer.ui.buttons.AddAlarmButton
import com.arnodemarchi.alarmdeezer.ui.dialogs.TimePickerDial
import com.arnodemarchi.alarmdeezer.ui.theme.AlarmDeezerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AlarmDeezerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AlarmDeezerApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun AlarmDeezerApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    var timePickerState: TimePickerState? = null
    var openDialog by remember { mutableStateOf(false) }

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            if (openDialog) {
                TimePickerDial(
                    onConfirm = {
                        openDialog = false
                        timePickerState = it
                    },
                    onDismiss = { openDialog = false })
            }
            Box(modifier = modifier.fillMaxSize()) {
                if (timePickerState != null) {
                    AlarmComponent(alarmTime = "${timePickerState.hour}:${timePickerState.minute}")
                }
                AddAlarmButton(
                    onOpenAddAlarmDial = { openDialog = true },
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 16.dp)
                )
            }
        }
        composable("addAlarm") {
            DetailsScreen(onNavigateBack = { navController.popBackStack() })
        }
    }
}

@Composable
fun DetailsScreen(onNavigateBack: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = { onNavigateBack() }) {
            Text("Back to Home")
        }
    }
}
