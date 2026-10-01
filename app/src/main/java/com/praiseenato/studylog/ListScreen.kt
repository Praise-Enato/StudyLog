package com.praiseenato.studylog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// The main screen: the total hours at the top and every saved entry below it.
@Composable
fun ListScreen(entries: List<StudyEntry>, onAddClick: () -> Unit) {
    val totalHours = entries.sumOf { it.hours }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Study Log", style = MaterialTheme.typography.headlineMedium)
        Text(
            text = "Total: ${formatHours(totalHours)} hours",
            style = MaterialTheme.typography.titleLarge
        )
        Text(text = "Sessions logged: ${entries.size}")

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onAddClick, modifier = Modifier.fillMaxWidth()) {
            Text("Add Entry")
        }
        Spacer(modifier = Modifier.height(16.dp))

        if (entries.isEmpty()) {
            Text("No entries yet. Tap Add Entry to log your first study session.")
        } else {
            LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                items(entries) { entry ->
                    EntryRow(entry)
                }
            }
        }
    }
}

// Shows one entry as a card, with the task on the left and the hours on the right.
@Composable
fun EntryRow(entry: StudyEntry) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
            Text(text = entry.task, modifier = Modifier.weight(1f))
            Text(text = "${formatHours(entry.hours)} h")
        }
    }
}

// Shows hours with one decimal place, so 1.5 shows as "1.5" and 2 shows as "2.0".
fun formatHours(hours: Double): String {
    return "%.1f".format(hours)
}
