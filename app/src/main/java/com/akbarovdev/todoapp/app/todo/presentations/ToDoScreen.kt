package com.akbarovdev.todoapp.app.todo.presentations

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.akbarovdev.todoapp.app.todo.domain.models.ToDo
import com.akbarovdev.todoapp.app.todo.presentations.components.ToDoItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToDoScreen(configuration: Configuration) {
    val todos = mutableListOf<ToDo>(
        ToDo(title = "Clean home", isDone = false),
        ToDo(title = "Doing homeworks", isDone = true),
        ToDo(title = "Reading books", isDone = false)
    )
    Scaffold(topBar = {
        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Red),

            title = {
                Text(
                    "My ToDo List",
                    style = TextStyle(
                        color = Color.White,
                        fontWeight = FontWeight.W700,
                        fontSize = (configuration.screenHeightDp.dp.value / 35).sp
                    )
                )
            }
        )
    }, floatingActionButton = {
        FloatingActionButton(onClick = {}) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Add Icon")
        }
    }) { innerPadding ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            LazyColumn(Modifier.fillMaxWidth()) {
                items(todos.size) { index ->
                    val todo: ToDo = todos[index]
                    ToDoItem(configuration, todo)
                }
            }
        }
    }
}