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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
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
fun TimerScreenContent() {
    Column(
            modifier = Modifier.fillMaxSize().background(Color(0xFF121212)).padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
    ) {
        Box(modifier = Modifier.size(300.dp), contentAlignment = Alignment.Center) {
            CircularProgressIndicator(
                    progress = { 0.8f },
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFFF9800),
                    strokeWidth = 12.dp,
                    trackColor = Color.DarkGray
            )
            Text("04:59", fontSize = 64.sp, fontWeight = FontWeight.Light, color = Color.White)
        }
        Spacer(modifier = Modifier.height(64.dp))
        Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 48.dp),
                horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                    modifier = Modifier.size(80.dp).clip(CircleShape).background(Color.DarkGray),
                    contentAlignment = Alignment.Center
            ) { Text("Cancel", color = Color.LightGray, fontSize = 18.sp) }
            Box(
                    modifier =
                            Modifier.size(80.dp)
                                    .clip(CircleShape)
                                    .background(Color(0xFFFF9800).copy(alpha = 0.3f)),
                    contentAlignment = Alignment.Center
            ) { Text("Pause", color = Color(0xFFFF9800), fontSize = 18.sp) }
        }
    }
}
