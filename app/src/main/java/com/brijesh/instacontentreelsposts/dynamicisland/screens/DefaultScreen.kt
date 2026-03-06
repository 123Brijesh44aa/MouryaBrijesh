package com.brijesh.instacontentreelsposts.dynamicisland.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DefaultScreenContent() {
    Column(modifier = Modifier.fillMaxSize().background(Color(0xFFFAFAFA)).padding(24.dp)) {
        // Header
        Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text("Good Morning,", fontSize = 16.sp, color = Color.Gray)
                Text(
                        "Brijesh \uD83D\uDC4B",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.Black
                )
            }
            Box(
                    modifier =
                            Modifier.size(50.dp)
                                    .clip(RoundedCornerShape(16.dp))
                                    .background(
                                            brush =
                                                    Brush.linearGradient(
                                                            colors =
                                                                    listOf(
                                                                            Color(0xFF6A11CB),
                                                                            Color(0xFF2575FC)
                                                                    )
                                                    )
                                    ),
                    contentAlignment = Alignment.Center
            ) { Icon(Icons.Default.Person, contentDescription = null, tint = Color.White) }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Hero Card (e.g., wallet balance or summary)
        Box(
                modifier =
                        Modifier.fillMaxWidth()
                                .height(180.dp)
                                .clip(RoundedCornerShape(24.dp))
                                .background(
                                        brush =
                                                Brush.linearGradient(
                                                        colors =
                                                                listOf(
                                                                        Color(0xFF11998E),
                                                                        Color(0xFF38EF7D)
                                                                )
                                                )
                                )
                                .padding(24.dp)
        ) {
            Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Total Balance", color = Color.White.copy(alpha = 0.8f), fontSize = 16.sp)
                Text(
                        "$12,450.00",
                        color = Color.White,
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Bold
                )
                Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("**** **** **** 4812", color = Color.White.copy(alpha = 0.8f))
                    Text("05/28", color = Color.White.copy(alpha = 0.8f))
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text("Quick Actions", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Black)
        Spacer(modifier = Modifier.height(16.dp))

        // Grid for actions
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            ActionCard("Send", Icons.Default.ArrowForward, Color(0xFFE3F2FD), Color(0xFF1976D2))
            ActionCard("Receive", Icons.Default.ArrowBack, Color(0xFFE8F5E9), Color(0xFF388E3C))
            ActionCard("Rewards", Icons.Default.Star, Color(0xFFFFF3E0), Color(0xFFF57C00))
            ActionCard("Settings", Icons.Default.Settings, Color(0xFFF3E5F5), Color(0xFF7B1FA2))
        }
    }
}

@Composable
fun ActionCard(
        title: String,
        icon: androidx.compose.ui.graphics.vector.ImageVector,
        bgColor: Color,
        iconColor: Color
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
                modifier = Modifier.size(64.dp).clip(RoundedCornerShape(20.dp)).background(bgColor),
                contentAlignment = Alignment.Center
        ) {
            Icon(icon, contentDescription = null, tint = iconColor, modifier = Modifier.size(28.dp))
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(title, fontSize = 12.sp, fontWeight = FontWeight.Medium, color = Color.DarkGray)
    }
}
