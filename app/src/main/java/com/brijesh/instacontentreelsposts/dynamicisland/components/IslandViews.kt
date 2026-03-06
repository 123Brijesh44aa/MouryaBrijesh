package com.brijesh.instacontentreelsposts.dynamicisland.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.PlayArrow
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
fun DefaultIslandView() {
    Box(modifier = Modifier.height(32.dp).width(120.dp), contentAlignment = Alignment.Center) {
        Box(modifier = Modifier.size(10.dp).clip(CircleShape).background(Color.DarkGray))
    }
}

@Composable
fun MusicIslandView() {
    Row(
            modifier = Modifier.padding(16.dp).fillMaxWidth(0.9f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                    modifier =
                            Modifier.size(48.dp)
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(Color.DarkGray),
                    contentAlignment = Alignment.Center
            ) {
                Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "Album Art",
                        tint = Color.White
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text("Blinding Lights", color = Color.White, fontWeight = FontWeight.Bold)
                Text("The Weeknd", color = Color.LightGray, fontSize = 12.sp)
            }
        }
        Icon(
                imageVector = Icons.Default.PlayArrow,
                contentDescription = "Play/Pause",
                tint = Color.White,
                modifier = Modifier.size(32.dp)
        )
    }
}

@Composable
fun CallIslandView() {
    Row(
            modifier = Modifier.padding(16.dp).fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                    modifier = Modifier.size(48.dp).clip(CircleShape).background(Color.DarkGray),
                    contentAlignment = Alignment.Center
            ) {
                Icon(
                        imageVector = Icons.Default.Call,
                        contentDescription = "Caller",
                        tint = Color.White
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text("Mom", color = Color.White, fontWeight = FontWeight.Bold)
                Text("Incoming Call...", color = Color.LightGray, fontSize = 12.sp)
            }
        }
        Row {
            Box(
                    modifier = Modifier.size(48.dp).clip(CircleShape).background(Color.Red),
                    contentAlignment = Alignment.Center
            ) {
                Icon(
                        imageVector = Icons.Default.Call,
                        contentDescription = "Decline",
                        tint = Color.White
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box(
                    modifier = Modifier.size(48.dp).clip(CircleShape).background(Color.Green),
                    contentAlignment = Alignment.Center
            ) {
                Icon(
                        imageVector = Icons.Default.Call,
                        contentDescription = "Accept",
                        tint = Color.White
                )
            }
        }
    }
}

@Composable
fun TimerIslandView() {
    Row(
            modifier = Modifier.padding(horizontal = 24.dp, vertical = 12.dp).fillMaxWidth(0.85f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "Timer",
                    tint = Color(0xFFFF9800),
                    modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text("Timer", color = Color.LightGray, fontSize = 16.sp, fontWeight = FontWeight.Medium)
        }
        Text("04:59", color = Color(0xFFFF9800), fontSize = 24.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun NavigationIslandView() {
    Row(
            modifier = Modifier.padding(16.dp).fillMaxWidth(0.9f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                    modifier = Modifier.size(40.dp).clip(CircleShape).background(Color(0xFF2196F3)),
                    contentAlignment = Alignment.Center
            ) {
                Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = "Turn Right",
                        tint = Color.White
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text("In 200 ft", color = Color.White, fontWeight = FontWeight.Bold)
                Text("Turn right on Main St", color = Color.LightGray, fontSize = 12.sp)
            }
        }
        Icon(
                imageVector = Icons.Default.Close,
                contentDescription = "End Route",
                tint = Color.Gray,
                modifier =
                        Modifier.size(24.dp)
                                .clip(CircleShape)
                                .background(Color.DarkGray)
                                .padding(4.dp)
        )
    }
}
