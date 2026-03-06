package com.brijesh.instacontentreelsposts.dynamicisland.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.brijesh.instacontentreelsposts.dynamicisland.logic.IslandState

@Composable
fun DynamicIsland(state: IslandState, onClick: () -> Unit) {
    val cornerRadius = 32.dp

    Box(
            modifier =
                    Modifier.padding(horizontal = 16.dp)
                            .clip(RoundedCornerShape(cornerRadius))
                            .background(Color.Black)
                            .clickable(
                                    interactionSource = remember { MutableInteractionSource() },
                                    indication = null,
                                    onClick = onClick
                            )
                            .animateContentSize(
                                    animationSpec =
                                            spring(
                                                    dampingRatio = 0.6f,
                                                    stiffness = Spring.StiffnessMediumLow
                                            )
                            )
    ) {
        AnimatedContent(
                targetState = state,
                transitionSpec = {
                    (fadeIn(animationSpec = tween(220, delayMillis = 90)) +
                                    scaleIn(
                                            initialScale = 0.92f,
                                            animationSpec = tween(220, delayMillis = 90)
                                    ))
                            .togetherWith(fadeOut(animationSpec = tween(90)))
                            .using(SizeTransform(clip = false))
                },
                label = "islandState"
        ) { targetState ->
            when (targetState) {
                IslandState.DEFAULT -> DefaultIslandView()
                IslandState.MUSIC -> MusicIslandView()
                IslandState.CALL -> CallIslandView()
                IslandState.TIMER -> TimerIslandView()
                IslandState.NAVIGATION -> NavigationIslandView()
            }
        }
    }
}
