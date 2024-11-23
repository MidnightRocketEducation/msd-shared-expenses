package com.github.midnightrocketeducation.se5.msd_shared_expenses

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

//username
@Composable
fun ProfileScreen(navController: NavController) {
    androidx.compose.material.Surface(modifier = Modifier.fillMaxSize()) {
        androidx.compose.material.Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Header
            androidx.compose.material.Text(
                text = "Settings",
                style = androidx.compose.material.MaterialTheme.typography.h4,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Profile Image
            androidx.compose.foundation.Image(
                painter = painterResource(id = R.drawable.ic_person), // Replace with actual drawable
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .background(Color.LightGray)
                    .align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Username
            androidx.compose.material.Text(
                text = "username",
                style = androidx.compose.material.MaterialTheme.typography.h6,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Settings List
            androidx.compose.foundation.lazy.LazyColumn {
                items(listOf("Setting 1", "Setting 2", "Setting 3", "Setting 4")) { setting ->
                    androidx.compose.material.Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                            .clickable { /* Handle click */ },
                        color = Color.Gray,
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        androidx.compose.material.Text(
                            text = setting,
                            modifier = Modifier.padding(16.dp),
                            style = androidx.compose.material.MaterialTheme.typography.body1
                        )
                    }
                }
            }
        }
    }
}
