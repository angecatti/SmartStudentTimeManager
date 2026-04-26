# 📚 StudyFlow — Smart Student Time Management App
### Built with Kotlin + Jetpack Compose + Room + Hilt

---

## ✅ Features Implemented

### 🏠 Home Screen
- Daily progress ring (animated arc showing % of goal)
- Study streak counter (consecutive days)
- Urgent deadline cards with day countdown

### ⏱ Focus Screen
- Subject selector & Goal setting
- **Music for Focus**: Choice of Lo-Fi, Rain, Forest, or White Noise to help concentration.
- **Background Audio**: Integrated `MediaPlayer` in a Foreground Service for uninterrupted music.
- **Timer Modes**: Free Timer & Pomodoro (25/5/15).
- **Post-session reflection**: Track mood and productivity.

### 📊 Reports Screen
- Focus Score & Weekly study vs distraction bar charts.
- Real app usage tracking via `UsageStatsManager`.

### 📅 Deadlines Screen
- Task management with priority levels and urgency sorting.

---

## 📱 Required Permissions
- `FOREGROUND_SERVICE_MEDIA_PLAYBACK`: Required for background music (Android 14+).
- `POST_NOTIFICATIONS`: For the persistent timer and music controls.
- `PACKAGE_USAGE_STATS`: For productivity tracking.

---

## 🚀 Setup Audio
To enable the music feature, place `.mp3` files in `app/src/main/res/raw/` named:
`lofi.mp3`, `rain.mp3`, `forest.mp3`, and `white_noise.mp3`.
