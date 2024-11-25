package com.github.midnightrocketeducation.se5.msd_shared_expenses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavType
import androidx.navigation.navArgument

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationMethod()
        }
    }
}

@Composable
fun NavigationMethod() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "signup") {
        composable("signup") {
            SignUpScreen(navController)
        }
        composable("login") {
            LoginScreen(navController)
        }
        composable("groups") {
            GroupScreen(navController)
        }
        composable("groupcreation") {
            GroupCreation(navController)
        }
        composable("settings") {
            SettingsScreen(navController)
        }
        composable(
            "group_detail/{groupName}",
            arguments = listOf(navArgument("groupName") { type = NavType.StringType })
        ) { backStackEntry ->
            GroupDetailScreen(
                navController = navController,
                groupName = backStackEntry.arguments?.getString("groupName") ?: ""
            )
        }
    }
}