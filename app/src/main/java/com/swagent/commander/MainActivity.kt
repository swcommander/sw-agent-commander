package com.swagent.commander

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme(colorScheme = darkColorScheme()) {
                Surface(modifier = Modifier.fillMaxSize()) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    var selectedTab by remember { mutableIntStateOf(0) }
    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(icon = { Text("🤖") }, label = { Text("Agents") }, selected = selectedTab == 0, onClick = { selectedTab = 0 })
                NavigationBarItem(icon = { Text("🔍") }, label = { Text("Search") }, selected = selectedTab == 1, onClick = { selectedTab = 1 })
                NavigationBarItem(icon = { Text("📡") }, label = { Text("Monitor") }, selected = selectedTab == 2, onClick = { selectedTab = 2 })
                NavigationBarItem(icon = { Text("⚙️") }, label = { Text("Settings") }, selected = selectedTab == 3, onClick = { selectedTab = 3 })
            }
        }
    ) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(16.dp)) {
            Text("SW Agent Commander", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(16.dp))
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("✅ sales-agent", fontSize = 16.sp)
                    Text("✅ support-agent", fontSize = 16.sp)
                    Text("⏸️ weather-agent", fontSize = 16.sp)
                }
            }
        }
    }
}
