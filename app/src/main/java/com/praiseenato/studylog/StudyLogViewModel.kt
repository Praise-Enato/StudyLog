package com.praiseenato.studylog

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

// Holds the study entries so they are not lost when the phone is rotated.
class StudyLogViewModel : ViewModel() {
    // A list that Compose watches. When an entry is added, the list screen redraws.
    val entries = mutableStateListOf<StudyEntry>()

    // Adds a new entry to the end of the list.
    fun addEntry(entry: StudyEntry) {
        entries.add(entry)
    }
}
