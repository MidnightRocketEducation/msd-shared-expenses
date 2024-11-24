package com.github.midnightrocketeducation.se5.msd_shared_expenses

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun SettingsScreen(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            fontSize = 24.sp,
            text = "Settings"
        )
        Spacer(modifier = Modifier.height(16.dp))
        Canvas(modifier = Modifier.size(50.dp)){
            drawCircle(
                color = Color.Magenta,
                radius = size.minDimension / 2,
                style = Fill
            )
        }
        Text(
            fontSize = 15.sp,
            text = "Username"
        )
        Spacer(modifier = Modifier.height(16.dp))
        //Sektion 1
        Button(
            onClick = {
                navController.navigate("groupcreation")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Setting")
        }
        Spacer(modifier = Modifier.height(16.dp))
        //Sektion 2
        Button(
            onClick = {
                navController.navigate("groupcreation")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Setting")
        }
        Button(
            onClick = {
                navController.navigate("groupcreation")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Setting")
        }
        Button(
            onClick = {
                navController.navigate("groupcreation")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Setting")
        }
        Button(
            onClick = {
                navController.navigate("groupcreation")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Setting")
        }
        Button(
            onClick = {
                navController.navigate("groupcreation")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Setting")
        }
        Spacer(modifier = Modifier.height(16.dp))
        //Sektion 3
        Button(
            onClick = {
                navController.navigate("groupcreation")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Setting")
        }
        Button(
            onClick = {
                navController.navigate("groupcreation")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Setting")
        }
    }
}