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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Person
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
fun CallScreenContent() {
    Column(
            modifier = Modifier.fillMaxSize().background(Color(0xFF202124)).padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(64.dp))
        Box(
                modifier = Modifier.size(120.dp).clip(CircleShape).background(Color.Gray),
                contentAlignment = Alignment.Center
        ) {
            Icon(
                    Icons.Default.Person,
                    contentDescription = null,
                    modifier = Modifier.size(60.dp),
                    tint = Color.White
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Text("Mom", fontSize = 36.sp, fontWeight = FontWeight.Bold, color = Color.White)
        Text("Mobile - 00:15", fontSize = 18.sp, color = Color.LightGray)

        Spacer(modifier = Modifier.weight(1f))

        Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 32.dp),
                horizontalArrangement = Arrangement.SpaceAround
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Box(
                        modifier =
                                Modifier.size(64.dp).clip(CircleShape).background(Color.DarkGray),
                        contentAlignment = Alignment.Center
                ) { Icon(Icons.Default.Face, contentDescription = null, tint = Color.White) }
                Spacer(modifier = Modifier.height(8.dp))
                Text("Mute", color = Color.White)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Box(
                        modifier =
                                Modifier.size(64.dp).clip(CircleShape).background(Color.DarkGray),
                        contentAlignment = Alignment.Center
                ) { Icon(Icons.Default.Call, contentDescription = null, tint = Color.White) }
                Spacer(modifier = Modifier.height(8.dp))
                Text("Keypad", color = Color.White)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Box(
                        modifier =
                                Modifier.size(64.dp)
                                        .clip(CircleShape)
                                        .background(Color(0xFFD32F2F)),
                        contentAlignment = Alignment.Center
                ) { Icon(Icons.Default.Close, contentDescription = null, tint = Color.White) }
                Spacer(modifier = Modifier.height(8.dp))
                Text("End", color = Color.White)
            }
        }
    }
}
