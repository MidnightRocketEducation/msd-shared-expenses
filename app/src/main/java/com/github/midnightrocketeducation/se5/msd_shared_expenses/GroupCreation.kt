package com.github.midnightrocketeducation.se5.msd_shared_expenses

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun GroupCreation(navController: NavController) {
    val groupName = remember { mutableStateOf("") }
    val description = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Group Creation",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        OutlinedTextField(
            value = groupName.value,
            onValueChange = { groupName.value = it },
            label = { Text("Group Name") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = description.value,
            onValueChange = { description.value = it },
            label = { Text("Description") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            repeat(5) {
                Canvas(modifier = Modifier.size(40.dp)) {
                    drawCircle(
                        color = Color.Magenta,
                        radius = size.minDimension / 2,
                        style = Fill
                    )
                }
            }
        }

        Button(
            onClick = {
                navController.navigate("groups") {
                    popUpTo("groups")
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Create Group")
        }
    }
}