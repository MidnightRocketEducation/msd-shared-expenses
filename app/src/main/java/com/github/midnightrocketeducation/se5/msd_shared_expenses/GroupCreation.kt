package com.github.midnightrocketeducation.se5.msd_shared_expenses

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
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
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = description.value,
            onValueChange = { description.value = it },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth()
        )
    }
}