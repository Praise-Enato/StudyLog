package com.praiseenato.studylog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {

    // Runs when the app opens and puts the Study Log on the screen.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                StudyLogApp()
            }
        }
    }
}

// Sets up the two screens and moves between them. Both screens share one ViewModel.
@Composable
fun StudyLogApp(studyLogViewModel: StudyLogViewModel = viewModel()) {
    val navController = rememberNavController()

    Scaffold { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "list",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("list") {
                ListScreen(
                    entries = studyLogViewModel.entries,
                    onAddClick = { navController.navigate("add") }
                )
            }
            composable("add") {
                AddEntryScreen(
                    onSave = { entry ->
                        studyLogViewModel.addEntry(entry)
                        navController.popBackStack()
                    },
                    onCancel = { navController.popBackStack() }
                )
            }
        }
    }
}
