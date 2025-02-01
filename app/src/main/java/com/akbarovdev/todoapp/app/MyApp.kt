package com.akbarovdev.todoapp.app

import android.graphics.drawable.Icon
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
import androidx.compose.material.icons.filled.CheckCircle
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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp(modifier: Modifier = Modifier) {
    val configuration = LocalConfiguration.current
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
                items(25) {
                    Row(
                        Modifier
                            .padding(top = 10.dp, start = 15.dp, end = 15.dp)
                            .background(
                                color = Color.Red.copy(alpha = 0.5f), shape = RoundedCornerShape(
                                    15
                                )
                            )
                            .fillMaxWidth()
                            .padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Box(
                                modifier = Modifier
                                    .padding(end = 5.dp)
                                    .width(25.dp)
                                    .height(25.dp)
                                    .border(width = 1.dp, color = Color.Black, shape = CircleShape),
                            ) { }
                            Text(
                                "Clean house", style = TextStyle(
                                    fontWeight = FontWeight.W500,
                                    fontSize = (configuration.screenHeightDp.dp.value / 45).sp
                                )
                            )
                        }
                        Row {
                            IconButton(onClick = {}) {
                                Icon(
                                    imageVector = Icons.Default.Edit,
                                    contentDescription = "Delete Icon"
                                )
                            }
                            IconButton(onClick = {}) {
                                Icon(
                                    imageVector = Icons.Default.Delete,
                                    contentDescription = "Delete Icon"
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun MyAppPreview() {
    MyApp()
}