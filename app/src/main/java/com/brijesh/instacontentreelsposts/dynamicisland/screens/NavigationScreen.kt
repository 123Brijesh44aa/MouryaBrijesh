package com.brijesh.instacontentreelsposts.dynamicisland.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NavigationScreenContent() {
    Box(modifier = Modifier.fillMaxSize().background(Color(0xFFE0E0E0))) {
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceEvenly) {
            repeat(10) { Divider(color = Color.White, thickness = 2.dp) }
        }
        Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceEvenly) {
            repeat(10) {
                Divider(color = Color.White, modifier = Modifier.fillMaxHeight().width(2.dp))
            }
        }

        Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
            Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF1E88E5))
            ) {
                Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                            Icons.Default.ArrowForward,
                            contentDescription = null,
                            modifier = Modifier.size(48.dp),
                            tint = Color.White
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Column {
                        Text(
                                "Turn right on Main St",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                        )
                        Text("200 ft", fontSize = 18.sp, color = Color.White)
                    }
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Row(
                        modifier = Modifier.padding(16.dp).fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                                "12 min",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF2E7D32)
                        )
                        Text("4.2 mi • 3:45 PM", color = Color.Gray)
                    }
                    Box(
                            modifier =
                                    Modifier.clip(RoundedCornerShape(24.dp))
                                            .background(Color.Red.copy(alpha = 0.1f))
                                            .padding(horizontal = 16.dp, vertical = 8.dp)
                    ) { Text("Exit", color = Color.Red, fontWeight = FontWeight.Bold) }
                }
            }
        }
    }
}
