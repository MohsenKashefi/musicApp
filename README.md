# Music App UI

A beautiful, modern Android music application built with Kotlin and Jetpack Compose, featuring a stunning Material Design 3 UI with gradients, cards, and smooth animations. This app showcases modern Android development practices with a clean, intuitive user interface.

## Table of Contents

- [About](#about)  
- [Features](#features)  
- [Screenshots](#screenshots)
- [Prerequisites](#prerequisites)  
- [Getting Started](#getting-started)  
- [Project Structure](#project-structure)  
- [Technology Stack](#technology-stack)
- [Build & Run](#build--run)  
- [Contributing](#contributing)  
- [License](#license)  
- [Contact](#contact)

---

## About

`Music App UI` is a modern Android application built with Kotlin and Jetpack Compose, demonstrating beautiful Material Design 3 components and clean architecture. The app features a fully functional music interface with navigation, user profiles, and subscription management.

### Key Highlights

- 🎨 **Material Design 3** - Latest design system with beautiful gradients and animations
- 📱 **Jetpack Compose** - Modern declarative UI framework
- 🧭 **Navigation** - Bottom navigation and drawer navigation
- 🎵 **Music Interface** - Home, Library, Browse, Account, and Subscription screens
- 💫 **Modern UI** - Cards, gradients, and smooth transitions

## Features

### 🏠 **Home Screen**
- Welcome message with personalized greeting
- Featured playlists with beautiful gradient cards
- Music categories (Hits, Happy, Workout, Running, TGIF, Yoga)
- Recently played music with album art

### 🎵 **Library Screen**
- Quick stats (Playlists, Following, Followers)
- Library sections: My Music, Liked Songs, Downloaded, Recently Played
- Account settings and help sections
- Beautiful gradient profile header

### 🔍 **Browse Screen**
- Grid layout of music categories
- Beautiful gradient category cards
- 8 different music genres and moods
- Responsive 2x4 grid design

### 👤 **Account Screen**
- Gradient profile header with user info
- Quick stats cards
- Library menu items with icons
- Settings and help sections

### 💳 **Subscription Screen**
- Current plan display with gradient background
- Plan comparison (Premium, Family)
- Feature lists with checkmarks
- Modern pricing cards

### 🎨 **UI/UX Features**
- Material Design 3 theming
- Beautiful gradient backgrounds
- Smooth animations and transitions
- Responsive design for all screen sizes
- Modern card-based layouts

## Screenshots

*Add screenshots of your app here to showcase the beautiful UI*

## Prerequisites

- **Android Studio** - Arctic Fox or later
- **Java JDK** - Version 11 or higher
- **Android SDK** - API Level 24+ (Android 7.0)
- **Gradle** - Version 8.2+ (included in project)

## Getting Started

1. **Clone the repository**
   ```bash
   git clone https://github.com/MohsenKashefi/musicApp.git
   cd musicApp
   ```

2. **Open in Android Studio**
   - Launch Android Studio
   - Select "Open an existing project"
   - Navigate to the cloned directory and select it

3. **Sync the project**
   - Android Studio will automatically sync the project
   - Wait for the sync to complete

4. **Run the app**
   - Connect an Android device or start an emulator
   - Click the "Run" button (▶️) or press `Shift + F10`

## Project Structure

```
app/
├── src/main/java/eu/tutorials/musicappui/
│   ├── MainActivity.kt              # Main activity entry point
│   ├── MainViewModel.kt             # ViewModel for state management
│   ├── Screen.kt                    # Navigation screen definitions
│   ├── Dummy.kt                     # Sample data models
│   └── ui/theme/
│       ├── MainView.kt              # Main navigation container
│       ├── HomeView.kt              # Home screen with featured content
│       ├── Library.kt               # Music library screen
│       ├── BrowseView.kt            # Browse categories screen
│       ├── AccountView.kt           # User profile and settings
│       ├── AccountDialog.kt         # Login/registration dialog
│       ├── Subscription.kt          # Subscription management
│       ├── Theme.kt                 # Material Design 3 theme
│       ├── Color.kt                 # App color definitions
│       └── Type.kt                  # Typography definitions
├── src/main/res/
│   ├── drawable/                    # App icons and drawable resources
│   ├── values/
│   │   ├── colors.xml               # Color resources
│   │   ├── strings.xml              # String resources
│   │   └── themes.xml               # Theme definitions
│   └── mipmap/                      # App launcher icons
└── build.gradle.kts                 # App-level build configuration
```

## Technology Stack

### **Core Technologies**
- **Kotlin** - Primary programming language
- **Jetpack Compose** - Modern UI toolkit
- **Material Design 3** - Latest design system

### **Android Architecture**
- **MVVM Pattern** - Model-View-ViewModel architecture
- **Navigation Compose** - Type-safe navigation
- **ViewModel** - UI-related data holder
- **State Management** - Reactive state handling

### **UI Components**
- **Material3 Components** - Cards, Buttons, TextFields, etc.
- **LazyColumn/LazyRow** - Efficient list rendering
- **LazyVerticalGrid** - Grid layout for categories
- **Gradients** - Beautiful color transitions
- **Animations** - Smooth transitions and effects

### **Dependencies**
```kotlin
// Core Android
androidx.core:core-ktx:1.12.0
androidx.lifecycle:lifecycle-runtime-ktx:2.6.2
androidx.activity:activity-compose:1.8.0

// Jetpack Compose
androidx.compose:compose-bom:2023.10.01
androidx.compose.ui:ui
androidx.compose.material3:material3
androidx.compose.material:material

// Navigation
androidx.navigation:navigation-compose:2.7.5
```

## Build & Run

### **Debug Build**
```bash
# Clean the project
./gradlew clean

# Build debug APK
./gradlew assembleDebug

# Install on connected device
./gradlew installDebug
```

### **Release Build**
```bash
# Build release APK
./gradlew assembleRelease
```

### **Run Tests**
```bash
# Run unit tests
./gradlew test

# Run instrumented tests
./gradlew connectedAndroidTest
```

## Contributing

We welcome contributions! Please follow these steps:

1. **Fork the repository**
2. **Create a feature branch**
   ```bash
   git checkout -b feature/amazing-feature
   ```
3. **Make your changes**
   - Follow the existing code style
   - Add comments for complex logic
   - Test your changes thoroughly

4. **Commit your changes**
   ```bash
   git commit -m 'Add amazing feature'
   ```
5. **Push to your branch**
   ```bash
   git push origin feature/amazing-feature
   ```
6. **Open a Pull Request**

### **Code Style Guidelines**
- Use Kotlin coding conventions
- Follow Material Design principles
- Keep components small and focused
- Add proper documentation

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

```
MIT License

Copyright (c) 2024 Music App UI

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

## Contact

**Mohsen Kashefi**
- GitHub: [@MohsenKashefi](https://github.com/MohsenKashefi)
- Email: mohsen@example.com
- Project Link: [https://github.com/MohsenKashefi/musicApp](https://github.com/MohsenKashefi/musicApp)

---

⭐ **Star this repository if you found it helpful!**