package com.github.midnightrocketeducation.se5.msd_shared_expenses

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

data class Expense(
    val description: String,
    val amount: Double,
    val date: String
)

data class Member(
    val username: String,
    val email: String,
    val balance: Double
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GroupDetailScreen(navController: NavController, groupName: String) {
    var expenses by remember { mutableStateOf(listOf(
        Expense("Description", 100.00, "05.05.2024, 00:00"),
        Expense("Description", 100.00, "05.05.2024, 00:00"),
        Expense("Description", 100.00, "05.05.2024, 00:00"),
        Expense("Description", 100.00, "05.05.2024, 00:00"),
        Expense("Description", 100.00, "05.05.2024, 00:00")
    ))}

    var members by remember { mutableStateOf(listOf(
        Member("username", "email", 13.95),
        Member("username", "email", 350.00),
        Member("username", "email", 350.00),
        Member("username", "email", 350.00)
    ))}

    val totalAmount = 7871.00

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(groupName) },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Default.ArrowBack, "Back")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("add_expense/${groupName}")
                }
            ) {
                Icon(Icons.Default.Add, "Add Expense")
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text("Group Total", fontWeight = FontWeight.Bold)
                    Text("$$totalAmount", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("You owe", color = Color.Red)
                    Text("-$236.95", fontSize = 20.sp, color = Color.Red)
                }
            }

            Text(
                "Expenses summary",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            LazyColumn(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(expenses) { expense ->
                    ExpenseItem(expense)
                }
            }

            Divider(modifier = Modifier.padding(vertical = 8.dp))

            Text(
                "You owe",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(members) { member ->
                    MemberBalanceItem(member)
                }
            }

            Button(
                onClick = {
                    navController.navigate("add_expense/${groupName}")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
            ) {
                Text("Add expense")
            }
        }
    }
}

@Composable
fun ExpenseItem(expense: Expense) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(expense.description)
            Text(
                expense.date,
                fontSize = 12.sp,
                color = Color.Gray
            )
        }
        Text(
            "$${String.format("%.2f", expense.amount)}",
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun MemberBalanceItem(member: Member) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.LightGray, CircleShape)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(member.username)
                Text(member.email, fontSize = 12.sp, color = Color.Gray)
            }
        }
        Text(
            "$${String.format("%.2f", member.balance)}",
            color = Color.Red,
            fontWeight = FontWeight.Bold
        )
    }
}