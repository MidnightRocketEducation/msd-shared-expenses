package com.github.midnightrocketeducation.se5.msd_shared_expenses

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(navController: NavController) {
    val userEmail = "user@example.com"
    var notificationsEnabled by remember { mutableStateOf(true) }
    var darkModeEnabled by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Settings") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Filled.ArrowBack, "Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(64.dp)
                        .clip(CircleShape)
                        .background(Color.LightGray)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(
                        text = userEmail.substringBefore('@'),
                        fontSize = 20.sp
                    )
                    Text(
                        text = userEmail,
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                }
            }

            Divider()
            Spacer(modifier = Modifier.height(16.dp))

            Text("Account Settings", color = Color.Gray, modifier = Modifier.padding(vertical = 8.dp))
            SettingsItem(
                icon = Icons.Outlined.Person,
                title = "Edit Profile",
                onClick = { /* TODO */ }
            )
            SettingsItem(
                icon = Icons.Outlined.Lock,
                title = "Change Password",
                onClick = { /* TODO */ }
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text("App Settings", color = Color.Gray, modifier = Modifier.padding(vertical = 8.dp))
            SettingsItem(
                icon = Icons.Outlined.Notifications,
                title = "Notifications",
                onClick = { /* TODO */ },
                trailing = {
                    Switch(
                        checked = notificationsEnabled,
                        onCheckedChange = { notificationsEnabled = it }
                    )
                }
            )
            SettingsItem(
                icon = Icons.Outlined.Settings,
                title = "Dark Mode",
                onClick = { /* TODO */ },
                trailing = {
                    Switch(
                        checked = darkModeEnabled,
                        onCheckedChange = { darkModeEnabled = it }
                    )
                }
            )
            SettingsItem(
                icon = Icons.Outlined.Settings,
                title = "Language",
                onClick = { /* TODO */ }
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text("Support & About", color = Color.Gray, modifier = Modifier.padding(vertical = 8.dp))
            SettingsItem(
                icon = Icons.Filled.Face,
                title = "Help & Support",
                onClick = { /* TODO */ }
            )
            SettingsItem(
                icon = Icons.Outlined.Info,
                title = "About",
                onClick = { /* TODO */ }
            )

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    navController.navigate("login") {
                        popUpTo(0)
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
            ) {
                Text("Log Out")
            }
        }
    }
}

@Composable
fun SettingsItem(
    icon: ImageVector,
    title: String,
    onClick: () -> Unit,
    trailing: @Composable (() -> Unit)? = null
) {
    Surface(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(vertical = 12.dp)
                .padding(end = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Text(
                text = title,
                modifier = Modifier.weight(1f)
            )
            trailing?.invoke()
        }
    }
}