# Overview

As a software engineer, I want to be able to build apps for the phones people use every day. This project was my first step into Android development. I used it to learn the Kotlin language and Jetpack Compose, Android's modern way to build screens. I focused on how a Compose screen redraws itself when its state changes, how to read and check what the user types, and how to move between screens.

Study Log is a small Android app for keeping track of study time. On the main screen you see the total hours you have studied, how many sessions you have logged, and a list of every entry. Tapping **Add Entry** opens a second screen where you type what you studied and how many hours it took. Tapping **Save** adds the entry to the list and takes you back, and the total updates straight away. If the task is empty, or the hours are not a number between 0 and 24, a short message appears under the box and nothing is saved.

I wrote this software because I want to get better at estimating how long my work takes. A simple log of what I worked on and how long it took is the tool I need for that, and building it myself was a good way to learn the basics of Android development.

[Software Demo Video](http://youtube.link.goes.here)

# Development Environment

I built the app in Android Studio on a MacBook Air and tested it on the Android Emulator. Gradle builds the project, and I used Git and GitHub for version control.

The app is written in Kotlin. The user interface uses Jetpack Compose with Material 3 components (text fields, buttons and cards), and Navigation Compose moves between the list screen and the Add Entry screen. A ViewModel holds the list of entries so they are not lost when the phone is rotated.

# Useful Websites

* [Kotlin Tour](https://kotlinlang.org/docs/kotlin-tour-welcome.html)
* [Android Basics with Compose](https://developer.android.com/courses/android-basics-compose/course)
* [State and Jetpack Compose](https://developer.android.com/develop/ui/compose/state)
* [Configure Text Fields in Compose](https://developer.android.com/develop/ui/compose/text/user-input)
* [Lists and Grids in Compose](https://developer.android.com/develop/ui/compose/lists)
* [Navigation with Compose](https://developer.android.com/develop/ui/compose/navigation)
* [ViewModel Overview](https://developer.android.com/topic/libraries/architecture/viewmodel)
