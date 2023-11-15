package com.example.jetnote.data

import com.example.jetnote.model.Note

class NotesDataSource {
    fun loadNote(): List<Note>{
        return listOf(
            Note(title = "A good day", description = "We went on a vacation"),
            Note(title = "Learning Kotlin", description = "Explored advanced Kotlin features"),
            Note(title = "Swift Workshop", description = "Attended a workshop on Swift programming"),
            Note(title = "Flutter Project", description = "Started a new project with Flutter and Dart"),
            Note(title = "Debugging Challenge", description = "Resolved a complex bug in Android code"),
            Note(title = "iOS App Design", description = "Worked on UI/UX for an iOS application"),
            Note(title = "Kotlin Coroutines", description = "Implemented coroutines for asynchronous tasks"),
            Note(title = "Flutter Widgets", description = "Explored various widgets in Flutter development"),
            Note(title = "Swift Playgrounds", description = "Experimented with Swift Playgrounds"),
            Note(title = "Android Architecture Components", description = "Integrated architecture components"),
            Note(title = "Dart Language Features", description = "Reviewed Dart language features for Flutter"),
            Note(title = "Code Review", description = "Participated in a team code review session"),
            Note(title = "iOS App Testing", description = "Conducted thorough testing on an iOS app"),
            Note(title = "Database Integration", description = "Integrated SQLite in Android project"),
            Note(title = "Flutter Animation", description = "Implemented animations in Flutter app"),
            Note(title = "API Integration", description = "Integrated REST API in mobile application"),
            Note(title = "SwiftUI Exploration", description = "Explored SwiftUI framework for iOS development"),
            Note(title = "Kotlin Serialization", description = "Implemented data serialization in Kotlin"),
            Note(title = "Flutter State Management", description = "Explored state management in Flutter"),
            Note(title = "Continuous Learning", description = "Stayed updated with the latest mobile development trends")
        )
    }
}