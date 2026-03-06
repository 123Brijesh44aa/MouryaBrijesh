package com.brijesh.instacontentreelsposts.dynamicisland.screens

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.brijesh.instacontentreelsposts.dynamicisland.components.DynamicIsland
import com.brijesh.instacontentreelsposts.dynamicisland.components.StateSelectorChip
import com.brijesh.instacontentreelsposts.dynamicisland.logic.IslandState

@Composable
fun DynamicIslandScreen() {
    var islandState by remember { mutableStateOf(IslandState.DEFAULT) }

    Column(
            modifier =
                    Modifier.fillMaxSize()
                            .background(Color(0xFFF0F0F5))
                            .systemBarsPadding()
                            .padding(top = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DynamicIsland(
                state = islandState,
                onClick = {
                    val nextOrdinal = (islandState.ordinal + 1) % IslandState.entries.size
                    islandState = IslandState.entries.toTypedArray()[nextOrdinal]
                }
        )

        Spacer(modifier = Modifier.height(32.dp))

        // State selectors
        LazyRow(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(IslandState.entries.toTypedArray()) { state ->
                StateSelectorChip(
                        state = state,
                        isSelected = state == islandState,
                        onClick = { islandState = state }
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Main Screen Content below
        Box(
                modifier =
                        Modifier.fillMaxWidth()
                                .weight(1f)
                                .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                                .background(Color.White)
        ) {
            AnimatedContent(
                    targetState = islandState,
                    transitionSpec = {
                        fadeIn(animationSpec = tween(300)) togetherWith
                                fadeOut(animationSpec = tween(300))
                    },
                    label = "ScreenContent"
            ) { targetState ->
                when (targetState) {
                    IslandState.DEFAULT -> DefaultScreenContent()
                    IslandState.MUSIC -> MusicScreenContent()
                    IslandState.CALL -> CallScreenContent()
                    IslandState.TIMER -> TimerScreenContent()
                    IslandState.NAVIGATION -> NavigationScreenContent()
                }
            }
        }
    }
}
