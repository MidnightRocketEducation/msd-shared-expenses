package com.github.midnightrocketeducation.se5.msd_shared_expenses

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

data class GroupMember(
    val id: String,
    val name: String,
    val email: String,
    var isSelected: Boolean = true
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddExpenseScreen(navController: NavController, groupName: String) {
    var amount by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    val members = remember {
        mutableStateListOf(
            GroupMember("1", "User 1", "user1@email.com"),
            GroupMember("2", "User 2", "user2@email.com"),
            GroupMember("3", "User 3", "user3@email.com"),
            GroupMember("4", "User 4", "user4@email.com"),
            GroupMember("5", "User 5", "user5@email.com")
        )
    }

    var showConfirmDialog by remember { mutableStateOf(false) }

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
                onValueChange = {
                    if (it.isEmpty() || it.matches(Regex("^\\d*\\.?\\d*$"))) {
                        amount = it
                    }
                },
                label = { Text("Amount") },
                modifier = Modifier.fillMaxWidth(),
                prefix = { Text("$") },
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = description,
                onValueChange = { description = it },
                label = { Text("Description") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                "Split between:",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(vertical = 16.dp)
            ) {
                items(members) { member ->
                    MemberChip(
                        member = member,
                        onSelectionChanged = { isSelected ->
                            val index = members.indexOf(member)
                            members[index] = member.copy(isSelected = isSelected)
                        }
                    )
                }
            }

            Button(
                onClick = { /* TODO: Image picker */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.LightGray
                )
            ) {
                Icon(
                    Icons.Default.List,
                    contentDescription = "Add Receipt",
                    modifier = Modifier.padding(end = 8.dp)
                )
                Text("Add Receipt (Optional)")
            }

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = { showConfirmDialog = true },
                modifier = Modifier.fillMaxWidth(),
                enabled = amount.isNotEmpty() && description.isNotEmpty() &&
                        members.any { it.isSelected }
            ) {
                Text("Add expense")
            }
        }

        if (showConfirmDialog) {
            AlertDialog(
                onDismissRequest = { showConfirmDialog = false },
                title = { Text("Confirm Expense") },
                text = {
                    Column {
                        Text("Amount: $$amount")
                        Text("Description: $description")
                        Text("Split between: ${members.count { it.isSelected }} members")
                    }
                },
                confirmButton = {
                    Button(
                        onClick = {
                            // TODO: Save expense
                            showConfirmDialog = false
                            navController.navigateUp()
                        }
                    ) {
                        Text("Confirm")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showConfirmDialog = false }) {
                        Text("Cancel")
                    }
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MemberChip(
    member: GroupMember,
    onSelectionChanged: (Boolean) -> Unit
) {
    FilterChip(
        selected = member.isSelected,
        onClick = { onSelectionChanged(!member.isSelected) },
        label = { Text(member.name) }
    )
}