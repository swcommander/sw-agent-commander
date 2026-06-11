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
                                            SWAgentTheme {
                                                                Surface(
                                                                                        modifier = Modifier.fillMaxSize(),
                                                                                                            color = MaterialTheme.colorScheme.background
                                                                ) {
                                                                                        MainScreen()
                                                                }
                                            }
                            }
        }
}

@Composable
fun MainScreen() {
        var selectedTab by remember { mutableIntStateOf(0) }
            
                val tabs = listOf("Agents", "Search", "Monitor", "Settings")
                    
                        Scaffold(
                                    bottomBar = {
                                                    NavigationBar {
                                                                        tabs.forEachIndexed { index, title ->
                                                                                            NavigationBarItem(
                                                                                                                        icon = { Text("✦") },
                                                                                                                                                label = { Text(title) },
                                                                                                                                                                        selected = selectedTab == index,
                                                                                                                                                                                                onClick = { selectedTab = index }
                                                                                            )
                                                                        }
                                                    }
                                    }
                        ) { padding ->
                                Column(
                                                modifier = Modifier
                                                                .fillMaxSize()
                                                                                .padding(padding)
                                                                                                .padding(16.dp)
                                ) {
                                                when (selectedTab) {
                                                                    0 -> AgentsTab()
                                                                                    1 -> SearchTab()
                                                                                                    2 -> MonitorTab()
                                                                                                                    3 -> SettingsTab()
                                                }
                                }
                        }
}

@Composable
fun AgentsTab() {
        Text(
                    text = "🤖 Active Agents",
                            fontSize = 24.sp,
                                    fontWeight = FontWeight.Bold
        )
            Spacer(modifier = Modifier.height(16.dp))
                Card(modifier = Modifier.fillMaxWidth()) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                            Text("✅ sales-agent", fontSize = 16.sp)
                                                        Text("✅ support-agent", fontSize = 16.sp)
                                                                    Text("⏸️ weather-agent", fontSize = 16.sp)
                            }
                }
}

@Composable
fun SearchTab() {
        Text(
                    text = "🔍 Search Console",
                            fontSize = 24.sp,
                                    fontWeight = FontWeight.Bold
        )
            Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                            value = "",
                                    onValueChange = {},
                                            label = { Text("Search documents...") },
                                                    modifier = Modifier.fillMaxWidth()
                )
}

@Composable
fun MonitorTab() {
        Text(
                    text = "📡 Live Monitor",
                            fontSize = 24.sp,
                                    fontWeight = FontWeight.Bold
        )
            Spacer(modifier = Modifier.height(16.dp))
                Card(modifier = Modifier.fillMaxWidth()) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                            Text("CPU: 42%")
                                                        LinearProgressIndicator(progress = { 0.42f })
                                                                    Spacer(modifier = Modifier.height(8.dp))
                                                                                Text("RAM: 68%")
                                                                                            LinearProgressIndicator(progress = { 0.68f })
                            }
                }
}

@Composable
fun SettingsTab() {
        Text(
                    text = "⚙️ Settings",
                            fontSize = 24.sp,
                                    fontWeight = FontWeight.Bold
        )
            Spacer(modifier = Modifier.height(16.dp))
                Card(modifier = Modifier.fillMaxWidth()) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                            Text("MCP Gateway: ✅ Running")
                                                        Text("Search Index: 1,243 chunks")
                                                                    Text("SSL: ✅ Enabled")
                            }
                }
}
                            }
                }
        )
}
                            }
                }
        )
}
                )
        )
}
                            }
                }
        )
}
                                                }
                                }
                                )}
                                                                                            )}
                                                    }
                                    }
                        )
}
                                                                }
                                                                )
                                            }
                            }
        }
}