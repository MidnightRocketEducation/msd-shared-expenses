package com.github.midnightrocketeducation.se5.msd_shared_expenses

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddExpenseScreen(navController: NavController, groupName: String) {
    var amount by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    val members = remember { listOf("User1", "User2", "User3", "User4", "User5") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Add Expense to $groupName") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Default.ArrowBack, "Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            OutlinedTextField(
                value = amount,
                onValueChange = { amount = it },
                label = { Text("Amount") },
                modifier = Modifier.fillMaxWidth(),
                prefix = { Text("$") }
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = description,
                onValueChange = { description = it },
                label = { Text("Description") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text("Split between:")

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(vertical = 16.dp)
            ) {
                items(members) { member ->
                    MemberChip(member)
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    // TODO: Save expense
                    navController.navigateUp()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Add expense")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MemberChip(name: String) {
    var selected by remember { mutableStateOf(true) }

    FilterChip(
        selected = selected,
        onClick = { selected = !selected },
        label = { Text(name) }
    )
}