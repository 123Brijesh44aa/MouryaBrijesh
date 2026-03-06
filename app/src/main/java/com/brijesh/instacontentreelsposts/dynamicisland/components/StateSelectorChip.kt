package com.brijesh.instacontentreelsposts.dynamicisland.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.brijesh.instacontentreelsposts.dynamicisland.logic.IslandState

@Composable
fun StateSelectorChip(state: IslandState, isSelected: Boolean, onClick: () -> Unit) {
    val bgColor by animateColorAsState(if (isSelected) Color.Black else Color.LightGray)
    val contentColor by animateColorAsState(if (isSelected) Color.White else Color.DarkGray)

    Row(
            modifier =
                    Modifier.clip(RoundedCornerShape(20.dp))
                            .background(bgColor)
                            .clickable { onClick() }
                            .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
                imageVector = state.icon,
                contentDescription = state.title,
                tint = contentColor,
                modifier = Modifier.size(16.dp)
        )
        Spacer(modifier = Modifier.width(6.dp))
        Text(
                text = state.title,
                color = contentColor,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
        )
    }
}
