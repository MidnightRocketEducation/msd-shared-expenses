package com.github.midnightrocketeducation.se5.msd_shared_expenses

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

data class Group(
    val name: String,
    val balance: Double,
    val isPositive: Boolean = true
)

@Composable
fun GroupScreen(navController: NavController) {
    var groups by remember { mutableStateOf(
        listOf(
            Group("Vacation Trip", 321.00),
            Group("Dinner Group", 0.00),
            Group("Apartment", 9.69, false),
            Group("Movie Night", 0.00),
            Group("Birthday Party", 95.00, false),
            Group("House Expenses", 51230.35, false)
        )
    )}

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Text(
                text = "Groups",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            LazyColumn(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(groups) { group ->
                    GroupItem(group) {
                        navController.navigate("group_detail/${group.name}")
                    }
                }
            }
        }
    }
}

@Composable
fun GroupItem(group: Group, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Group icon placeholder
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .background(Color.LightGray, CircleShape)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = group.name,
                    fontSize = 16.sp
                )
            }

            Text(
                text = "${if (group.isPositive) "" else "-"}$${String.format("%.2f", group.balance)}",
                color = if (group.balance == 0.0) Color.Black
                else if (group.isPositive) Color.Green
                else Color.Red,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    NavigationBar {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
            selected = true,
            onClick = { navController.navigate("groups") }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Add, contentDescription = "Add") },
            selected = false,
            onClick = { navController.navigate("groupcreation") }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
            selected = false,
            onClick = { navController.navigate("settings") }
        )
    }
}