package com.brijesh.instacontentreelsposts.datetime

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.*
import kotlinx.coroutines.delay

@Composable
fun DateTimeScreen() {
    var currentTime by remember { mutableStateOf(Calendar.getInstance()) }

    LaunchedEffect(Unit) {
        while (true) {
            currentTime = Calendar.getInstance()
            delay(1000)
        }
    }

    val hour = currentTime.get(Calendar.HOUR_OF_DAY)
    val minute = currentTime.get(Calendar.MINUTE)
    val second = currentTime.get(Calendar.SECOND)
    val amPm = if (hour >= 12) "PM" else "AM"
    val displayHour = if (hour % 12 == 0) 12 else hour % 12

    val date = currentTime.get(Calendar.DAY_OF_MONTH)
    val month =
        currentTime.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault()) ?: ""
    val dayOfWeek =
        currentTime.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault())
            ?: ""

    Box(
        modifier = Modifier.fillMaxSize().background(Color(0xFF0F0F13)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "$dayOfWeek, $month $date",
                color = Color.White,
                fontSize = 40.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.padding(bottom = 48.dp)
            )

            Box(contentAlignment = Alignment.Center, modifier = Modifier.size(320.dp)) {
                // Background Track Rings
                ClockRings(
                    radius = 140.dp,
                    strokeWidth = 16.dp,
                    color = Color.White.copy(alpha = 0.05f),
                    sweepAngle = 360f
                )
                ClockRings(
                    radius = 110.dp,
                    strokeWidth = 16.dp,
                    color = Color.White.copy(alpha = 0.05f),
                    sweepAngle = 360f
                )
                ClockRings(
                    radius = 80.dp,
                    strokeWidth = 16.dp,
                    color = Color.White.copy(alpha = 0.05f),
                    sweepAngle = 360f
                )

                // Foreground Animated Progress
                val animatedSecond by
                animateFloatAsState(
                    targetValue =
                        if (second == 0) 360f else second * 6f,
                    animationSpec =
                        tween(
                            durationMillis = 500,
                            easing = LinearOutSlowInEasing
                        ),
                    label = "second"
                )
                val animatedMinute by
                animateFloatAsState(
                    targetValue =
                        if (minute == 0 && second == 0) 360f
                        else (minute * 6f) + (second * 0.1f),
                    animationSpec = tween(durationMillis = 500),
                    label = "minute"
                )
                val animatedHour by
                animateFloatAsState(
                    targetValue =
                        if (hour % 12 == 0 &&
                            minute == 0 &&
                            second == 0
                        )
                            360f
                        else ((hour % 12) * 30f) + (minute * 0.5f),
                    animationSpec = tween(durationMillis = 500),
                    label = "hour"
                )

                ClockRingAnimated(
                    radius = 140.dp, // Seconds (Outer Ring)
                    strokeWidth = 16.dp,
                    sweepAngle = animatedSecond,
                    colors = listOf(Color(0xFF00F2FE), Color(0xFF4FACFE))
                )
                ClockRingAnimated(
                    radius = 110.dp, // Minutes (Middle Ring)
                    strokeWidth = 16.dp,
                    sweepAngle = animatedMinute,
                    colors = listOf(Color(0xFFFA709A), Color(0xFFFEE140))
                )
                ClockRingAnimated(
                    radius = 80.dp, // Hours (Inner Ring)
                    strokeWidth = 16.dp,
                    sweepAngle = animatedHour,
                    colors = listOf(Color(0xFF43E97B), Color(0xFF38F9D7))
                )

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text =
                            String.format(
                                Locale.getDefault(),
                                "%02d:%02d",
                                displayHour,
                                minute
                            ),
                        color = Color.White,
                        fontSize = 42.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text =
                            String.format(
                                Locale.getDefault(),
                                "%02d %s",
                                second,
                                amPm
                            ),
                        color = Color.White.copy(alpha = 0.7f),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }

            ClockLegend()
        }


        val infiniteTransition = rememberInfiniteTransition(label = "pulse")
        val alpha by
        infiniteTransition.animateFloat(
            initialValue = 0.3f,
            targetValue = 1.0f,
            animationSpec =
                InfiniteRepeatableSpec(
                    animation =
                        tween(1500, easing = LinearOutSlowInEasing),
                    repeatMode = RepeatMode.Reverse
                ),
            label = "alpha"
        )

    }
}

@Composable
fun ClockRings(radius: Dp, strokeWidth: Dp, color: Color, sweepAngle: Float) {
        Canvas(modifier = Modifier.size(radius * 2)) {
                drawArc(
                        color = color,
                        startAngle = -90f,
                        sweepAngle = sweepAngle,
                        useCenter = false,
                        style = Stroke(width = strokeWidth.toPx(), cap = StrokeCap.Round)
                )
        }
}

@Composable
fun ClockRingAnimated(radius: Dp, strokeWidth: Dp, sweepAngle: Float, colors: List<Color>) {
        Canvas(modifier = Modifier.size(radius * 2)) {
                drawArc(
                        brush = Brush.sweepGradient(colors),
                        startAngle = -90f,
                        sweepAngle = sweepAngle,
                        useCenter = false,
                        style = Stroke(width = strokeWidth.toPx(), cap = StrokeCap.Round)
                )
        }
}

@Composable
fun ClockLegend() {
        Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 48.dp)
        ) {
                LegendItem(color = Color(0xFF00F2FE), label = "Seconds")
                Spacer(modifier = Modifier.width(24.dp))
                LegendItem(color = Color(0xFFFA709A), label = "Minutes")
                Spacer(modifier = Modifier.width(24.dp))
                LegendItem(color = Color(0xFF43E97B), label = "Hours")
        }
}

@Composable
fun LegendItem(color: Color, label: String) {
        Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                        modifier =
                                Modifier.size(12.dp)
                                        .background(
                                                color,
                                                shape =
                                                        androidx.compose.foundation.shape
                                                                .CircleShape
                                        )
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                        text = label,
                        color = Color.White.copy(alpha = 0.7f),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium
                )
        }
}
