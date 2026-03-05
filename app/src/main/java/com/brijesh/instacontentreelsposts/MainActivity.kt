package com.brijesh.instacontentreelsposts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.brijesh.instacontentreelsposts.datetime.DateTimeScreen
import com.brijesh.instacontentreelsposts.ui.theme.InstaContentReelsPostsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { InstaContentReelsPostsTheme { DateTimeScreen() } }
    }
}
