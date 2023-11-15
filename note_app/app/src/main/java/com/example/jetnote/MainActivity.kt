package com.example.jetnote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetnote.screen.NoteScreen
import com.example.jetnote.ui.theme.JetNoteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                NoteScreen(
                    notes = emptyList(),
                    onAddNote = {},
                    onRemoveNote = {}
                )
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    JetNoteTheme {
        content()
    }
}