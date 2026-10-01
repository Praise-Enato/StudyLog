package com.praiseenato.studylog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

// The second screen: type what you studied and for how long, then save it.
@Composable
fun AddEntryScreen(onSave: (StudyEntry) -> Unit, onCancel: () -> Unit) {
    // Each time one of these changes, Compose redraws this screen with the new value.
    var task by rememberSaveable { mutableStateOf("") }
    var hours by rememberSaveable { mutableStateOf("") }
    var taskError by rememberSaveable { mutableStateOf("") }
    var hoursError by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(text = "Add Entry", style = MaterialTheme.typography.headlineMedium)

        OutlinedTextField(
            value = task,
            onValueChange = { task = it },
            label = { Text("What did you study?") },
            isError = taskError != "",
            supportingText = { Text(taskError) },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = hours,
            onValueChange = { hours = it },
            label = { Text("Hours") },
            isError = hoursError != "",
            supportingText = { Text(hoursError) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                taskError = checkTask(task)
                hoursError = checkHours(hours)

                // Only save when both boxes are filled in correctly.
                if (taskError == "" && hoursError == "") {
                    onSave(StudyEntry(task.trim(), hours.toDouble()))
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Save")
        }

        OutlinedButton(onClick = onCancel, modifier = Modifier.fillMaxWidth()) {
            Text("Cancel")
        }
    }
}

// Returns an error message if the task box is empty, or "" if it is fine.
fun checkTask(task: String): String {
    if (task.isBlank()) {
        return "Please enter what you studied."
    }
    return ""
}

// Returns an error message unless the hours are a number above 0 and up to 24.
fun checkHours(hours: String): String {
    val number = hours.toDoubleOrNull()
    if (number == null) {
        return "Please enter a number, like 1.5."
    }
    if (number <= 0 || number > 24) {
        return "Hours must be more than 0 and no more than 24."
    }
    return ""
}
