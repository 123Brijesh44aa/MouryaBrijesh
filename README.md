<div align="center">
  
# 🚀 InstaContent Reels UI

A dynamic collection of stunning, bite-sized **Jetpack Compose UI components** built explicitly for Instagram Reels!

![GitHub stars](https://img.shields.io/github/stars/brijesh/insta_content?style=social)
![Kotlin](https://img.shields.io/badge/Kotlin-Native-purple?style=flat-square&logo=kotlin)
![Jetpack Compose](https://img.shields.io/badge/Jetpack_Compose-Magic-blue?style=flat-square&logo=android)

---

### 🌟 Welcome, New Explorers! Don't Get Lost! 🌟

If you've landed here from an Instagram Reel, you are in the right place! 
This repository isn't a single, complicated app. Instead, it's a **UI Playground**. 

Here is your map to navigate this repo without getting lost:

### 🗺️ The Map

Every unique UI concept shown in the reels lives in its **own isolated subfolder** inside the `com.brijesh.instacontentreelsposts` package. 

```text
app/src/main/java/com/brijesh/instacontentreelsposts/
│
├── 🕒 datetime/          <-- (1st Reel) A modern, animated analog/digital clock
├── 🪐 [next_app]/        <-- (2nd Reel) Coming soon...
├── 🎵 [another_app]/     <-- (3rd Reel) Coming soon...
│
└── 🎬 MainActivity.kt    <-- The Stage!
```

### 🎮 How to play with the code?
1. **Find the Reel**: Look for the subfolder matching the reel you liked (e.g., `datetime`).
2. **Mount it to the Stage**: Open `MainActivity.kt` and change the root Composable to the screen you want to run.
   ```kotlin
   setContent {
       InstaContentReelsPostsTheme {
           DateTimeScreen() // <-- Change this to test different UIs!
       }
   }
   ```
3. **Run & Wow**: Hit run on Android Studio and be amazed!

---

> *"Code like art, build like magic." ✨*

</div>
