package com.example.jetnote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import com.example.jetnote.data.model.Note
import com.example.jetnote.presentation.screen.NoteScreen
import com.example.jetnote.presentation.ui.theme.JetNoteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                val notes = remember {
                    mutableStateListOf<Note>()
                }

                NoteScreen(
                    notes = notes,
                    onAddNote = {
                        notes.add(it)
                    },
                    onRemoveNote = {
                        notes.remove(it)
                    }
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