//package com.github.midnightrocketeducation.se5.msd_shared_expenses
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.BottomAppBar
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//
//@Composable
//fun GroupItem(name: String, amount: String, amountColor: Color, i: Int, i1: Int, i2: Int) {
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(8.dp)
//            .background(Color.Blue, shape = RoundedCornerShape(8.dp))
//            .padding(16.dp),
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        Image(
//            painter = painterResource(id = com.github.midnightrocketeducation.se5.msd_shared_expenses.ressources),
//            contentDescription = "Gruppe ikonen",
//            modifier = Modifier.size(40.dp)
//        )
//        Spacer(modifier = Modifier.width(16.dp))
//
//        Text(
//            text = name,
//            fontSize = 16.sp,
//            modifier = Modifier.weight(1f)
//        )
//        Text(
//            text = amount,
//            fontSize = 16.sp,
//            color = amountColor,
//            fontWeight = FontWeight.Bold
//        )
//
//        Spacer(modifier = Modifier.width(8.dp))
//
//        Image(
//            painter = painterResource(id = com.github.midnightrocketeducation.se5.msd_shared_expenses.ressources),
//            contentDescription = "Arrow Icon",
//            modifier = Modifier.size(24.dp)
//        )
//    }
//}
//
//@Composable
//fun Group(navComposable: Composable){
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(16.dp)
//    ) {
//        Text(
//            fontSize = 24.sp,
//            text = "Groups",
//            fontWeight = FontWeight.Bold
//        )
//        Spacer(modifier = Modifier.height(8.dp))
//        GroupItem(name = "Group 1", amount="1000 KR,-", amountColor = Color.Blue)
//        GroupItem(name = "Group 2", amount="2000 KR,-", amountColor = Color.Blue)
//        GroupItem(name = "Group 3", amount="3000 KR,-", amountColor = Color.Blue)
//        GroupItem(name = "Group 4", amount="4000 KR,-", amountColor = Color.Blue)
//        Spacer(modifier = Modifier.height(8.dp))
//
//        BottomNavigationBar()
//    }
//}
//
//@Composable
//fun BottomNavigationBar() {
//    BottomAppBar(
//        backgroundColor = Color.White,
//        contentColor = Color.Black,
//        modifier = Modifier.fillMaxWidth()
//    ) {
//        IconButton(onClick = { }) {
//            Icon(
//                painter = painterResource(id = com.github.midnightrocketeducation.se5.msd_shared_expenses.ressources),
//                contentDescription = "Home"
//            )
//        }
//
//
//        IconButton(onClick = { }) {
//            Icon(
//                painter = painterResource(id = com.github.midnightrocketeducation.se5.msd_shared_expenses.ressources),
//                contentDescription = "Add"
//            )
//        }
//
//
//        IconButton(onClick = {}) {
//            Icon(
//                painter = painterResource(id = com.github.midnightrocketeducation.se5.msd_shared_expenses.ressources),
//                contentDescription = "Profile"
//            )
//        }
//    }
//}