package com.example.diplom.Users

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.example.diplom.ui.theme.DiplomTheme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.diplom.Navigation.BottomNavigationBar
import com.example.diplom.Navigation.TopAppBarMenu

data class Item(val name: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Users(navController: NavHostController) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val isListView = remember { mutableStateOf(false) }
    val items = listOf(
        Item("фамилия имя отчество"),
        Item("фамилия имя отчество"),
        Item("фамилия имя отчество"),
        Item("фамилия имя отчество")
    )

    Box(Modifier.fillMaxSize()) {
        Scaffold(
            topBar = { TopAppBarMenu(navController) },
            content = { innerPadding ->
                var text by rememberSaveable { mutableStateOf("") }

                Column(
                    modifier = Modifier
                        .padding(innerPadding)
                        .padding(16.dp)
                        .fillMaxWidth()
                ) {
                    LazyColumn(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        item {
                            OutlinedTextField(value = text,
                                onValueChange = { text = it },
                                label = {
                                    Text(
                                        text = "поиск...",
                                        color = Color(0xFF666666),
                                        style = TextStyle(fontSize = 20.sp) // Установка размера текста для label
                                    )
                                },
                                textStyle = TextStyle(fontSize = 20.sp), // Установка размера текста
                                shape = RoundedCornerShape(8.dp),
                                modifier = Modifier.fillMaxWidth(),

                            )

                            Spacer(modifier = Modifier.height(20.dp))

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Button(
                                    modifier = Modifier.align(Alignment.CenterVertically),
                                    onClick = { navController.navigate("create_users") },
                                    shape = RoundedCornerShape(8.dp),
                                    colors = ButtonDefaults.buttonColors(
                                        contentColor = Color.White,
                                        containerColor = Color(0xFF7986CB)
                                    )
                                ) {
                                    Text(
                                        text = "новый пользователь",
                                        fontSize = 20.sp,
                                    )
                                }


                                Spacer(modifier = Modifier.weight(1f))

                                TextButton(
                                    onClick = {  navController.navigate("filter_users") },
                                    modifier = Modifier.align(Alignment.CenterVertically)
                                ) {
                                    Text(
                                        text = "фильтры",
                                        style = TextStyle(
                                            fontSize = 20.sp,
                                            color = Color.Black
                                        )
                                    )
                                }
                            }


                            Spacer(modifier = Modifier.height(10.dp))



                                items.forEach { item ->
                                    Card(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(vertical = 5.dp)
                                            .clickable { navController.navigate("card_users") },
                                        shape = RoundedCornerShape(8.dp),
                                        border = BorderStroke(1.dp, Color.LightGray)
                                    )

                                    {
                                        Box(
                                            modifier = Modifier
                                                .fillMaxSize()
                                                .background(Color.White)

                                        ) {
                                            Row(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .padding(16.dp),
                                                horizontalArrangement = Arrangement.SpaceBetween
                                            ) {
                                                Text(
                                                    text = item.name,
                                                    style = MaterialTheme.typography.bodyLarge,
                                                    modifier = Modifier.alignByBaseline()
                                                )

                                            }
                                        }

                                    }






                            }
                        }
                    }
                }
            },
            bottomBar = {
                BottomNavigationBar(navController)
            }
        )

    }
}


@Preview(showBackground = true)
@Composable
fun UsersPreview() {
    val navController = rememberNavController()
    DiplomTheme {
        Users(navController)
    }
}
