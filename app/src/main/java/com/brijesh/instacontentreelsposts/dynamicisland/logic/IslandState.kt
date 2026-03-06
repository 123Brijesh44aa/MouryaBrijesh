package com.brijesh.instacontentreelsposts.dynamicisland.logic

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.ui.graphics.vector.ImageVector

enum class IslandState(val title: String, val icon: ImageVector) {
    DEFAULT("Home", Icons.Default.Home),
    MUSIC("Music", Icons.Default.Favorite),
    CALL("Phone", Icons.Default.Call),
    TIMER("Timer", Icons.Default.Notifications),
    NAVIGATION("Maps", Icons.Default.LocationOn)
}
