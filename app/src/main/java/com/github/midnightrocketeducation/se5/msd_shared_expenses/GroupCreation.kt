package com.github.midnightrocketeducation.se5.msd_shared_expenses

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun GroupCreation(navComposable: NavController){
    val groupname = remember { mutableStateOf("") }
    val description = remember { mutableStateOf("")}

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            fontSize = 24.sp,
            text = "Group Creation"
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = groupname.value,
            onValueChange = { groupname.value = it },
            label = { Text("Group Name") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = description.value,
            onValueChange = { description.value = it },
            label = { Text("Description") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.Start,
        ) {
            repeat(5) {
                Canvas(modifier = Modifier.size(50.dp)){
                    drawCircle(
                        color = Color.Magenta,
                        radius = size.minDimension / 2,
                        style = Fill
                    )
                }
            }
        }
    }
}

