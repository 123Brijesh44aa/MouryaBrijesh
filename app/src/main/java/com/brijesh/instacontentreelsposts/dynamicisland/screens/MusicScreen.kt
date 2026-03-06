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
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
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
fun MusicScreenContent() {
    Column(
            modifier = Modifier.fillMaxSize().background(Color(0xFF8F1E24)).padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(48.dp))
        Box(
                modifier =
                        Modifier.size(250.dp)
                                .clip(RoundedCornerShape(32.dp))
                                .background(Color.DarkGray),
                contentAlignment = Alignment.Center
        ) {
            Icon(
                    Icons.Default.Favorite,
                    contentDescription = null,
                    modifier = Modifier.size(100.dp),
                    tint = Color.LightGray
            )
        }
        Spacer(modifier = Modifier.height(48.dp))
        Text("Blinding Lights", fontSize = 32.sp, fontWeight = FontWeight.Bold, color = Color.White)
        Text("The Weeknd", fontSize = 20.sp, color = Color.LightGray)
        Spacer(modifier = Modifier.height(32.dp))
        Slider(
                value = 0.3f,
                onValueChange = {},
                colors =
                        SliderDefaults.colors(
                                thumbColor = Color.White,
                                activeTrackColor = Color.White,
                                inactiveTrackColor = Color.White.copy(alpha = 0.3f)
                        )
        )
        Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 32.dp),
                horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                    Icons.Default.ArrowBack,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(40.dp)
            )
            Icon(
                    Icons.Default.PlayArrow,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(64.dp)
            )
            Icon(
                    Icons.Default.ArrowForward,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(40.dp)
            )
        }
    }
}
