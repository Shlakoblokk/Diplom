package com.example.diplom.Users

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.diplom.ui.theme.DiplomTheme


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.diplom.Navigation.TopAppBarEditUsers

import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditUsers(navController: NavHostController) {

    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    var checked by remember { mutableStateOf(false) }

    var text by rememberSaveable { mutableStateOf("") }

    var log by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var name by rememberSaveable { mutableStateOf("") }
    var fam by rememberSaveable { mutableStateOf("") }
    var oth by rememberSaveable { mutableStateOf("") }
    var dolzn by rememberSaveable { mutableStateOf("") }
    var rabtel by rememberSaveable { mutableStateOf("") }
    var mobtel by rememberSaveable { mutableStateOf("") }
    var pochta by rememberSaveable { mutableStateOf("") }
    var podr by rememberSaveable { mutableStateOf("") }



    Box(Modifier.fillMaxSize()) {

        Scaffold(
            topBar = { TopAppBarEditUsers(navController) },

            content = { innerPadding ->

                LazyColumn(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    item {

                        Column(
                            modifier = Modifier
                                .padding(innerPadding)
                                .padding(16.dp)

                        ) {

                            OutlinedTextField(
                                value = log,
                                onValueChange = { log = it },
                                label = {
                                    Text(
                                        text = "логин",
                                        color = Color(0xFF666666),
                                        style = TextStyle(fontSize = 20.sp) // Установка размера текста для label
                                    )
                                },
                                textStyle = TextStyle(fontSize = 20.sp), // Установка размера текста
                                shape = RoundedCornerShape(8.dp), // Скругленные углы
                                modifier = Modifier.fillMaxWidth(),

                                )
                            OutlinedTextField(
                                value = password,
                                onValueChange = { password = it },
                                label = {
                                    Text(
                                        text = "пароль",
                                        color = Color(0xFF666666),
                                        style = TextStyle(fontSize = 20.sp) // Установка размера текста для label
                                    )
                                },
                                textStyle = TextStyle(fontSize = 20.sp), // Установка размера текста
                                shape = RoundedCornerShape(8.dp),
                                modifier = Modifier.fillMaxWidth()
                            )

                            OutlinedTextField(
                                value = name,
                                onValueChange = { name = it },
                                label = {
                                    Text(
                                        text = "имя",
                                        color = Color(0xFF666666),
                                        style = TextStyle(fontSize = 20.sp) // Установка размера текста для label
                                    )
                                },
                                textStyle = TextStyle(fontSize = 20.sp), // Установка размера текста
                                shape = RoundedCornerShape(8.dp),
                                modifier = Modifier.fillMaxWidth()
                            )



                            OutlinedTextField(
                                value = fam,
                                onValueChange = { fam = it },
                                label = {
                                    Text(
                                        text = "фамилия",
                                        color = Color(0xFF666666),
                                        style = TextStyle(fontSize = 20.sp) // Установка размера текста для label
                                    )
                                },
                                textStyle = TextStyle(fontSize = 20.sp), // Установка размера текста
                                shape = RoundedCornerShape(8.dp),
                                modifier = Modifier.fillMaxWidth()
                            )

                            OutlinedTextField(
                                value = oth,
                                onValueChange = { oth = it },
                                label = {
                                    Text(
                                        text = "отчество",
                                        color = Color(0xFF666666),
                                        style = TextStyle(fontSize = 20.sp) // Установка размера текста для label
                                    )
                                },
                                textStyle = TextStyle(fontSize = 20.sp), // Установка размера текста
                                shape = RoundedCornerShape(8.dp),
                                modifier = Modifier.fillMaxWidth()
                            )

                            OutlinedTextField(
                                value = dolzn,
                                onValueChange = { dolzn = it },
                                label = {
                                    Text(
                                        text = "должность",
                                        color = Color(0xFF666666),
                                        style = TextStyle(fontSize = 20.sp) // Установка размера текста для label
                                    )
                                },
                                textStyle = TextStyle(fontSize = 20.sp), // Установка размера текста
                                shape = RoundedCornerShape(8.dp),
                                modifier = Modifier.fillMaxWidth()
                            )



                            OutlinedTextField(
                                value = rabtel,
                                onValueChange = { rabtel = it },
                                label = {
                                    Text(
                                        text = "рабочий телефон",
                                        color = Color(0xFF666666),
                                        style = TextStyle(fontSize = 20.sp) // Установка размера текста для label
                                    )
                                },
                                textStyle = TextStyle(fontSize = 20.sp), // Установка размера текста
                                shape = RoundedCornerShape(8.dp),
                                modifier = Modifier.fillMaxWidth()
                            )

                            OutlinedTextField(
                                value = mobtel,
                                onValueChange = { mobtel = it },
                                label = {
                                    Text(
                                        text = "мобильный телефон",
                                        color = Color(0xFF666666),
                                        style = TextStyle(fontSize = 20.sp) // Установка размера текста для label
                                    )
                                },
                                textStyle = TextStyle(fontSize = 20.sp), // Установка размера текста
                                shape = RoundedCornerShape(8.dp),
                                modifier = Modifier.fillMaxWidth()
                            )

                            OutlinedTextField(
                                value = pochta,
                                onValueChange = { pochta = it },
                                label = {
                                    Text(
                                        text = "почта",
                                        color = Color(0xFF666666),
                                        style = TextStyle(fontSize = 20.sp) // Установка размера текста для label
                                    )
                                },
                                textStyle = TextStyle(fontSize = 20.sp), // Установка размера текста
                                shape = RoundedCornerShape(8.dp),
                                modifier = Modifier.fillMaxWidth()
                            )

                            OutlinedTextField(
                                value = podr,
                                onValueChange = { podr = it },
                                label = {
                                    Text(
                                        text = "подразделение",
                                        color = Color(0xFF666666),
                                        style = TextStyle(fontSize = 20.sp) // Установка размера текста для label
                                    )
                                },
                                textStyle = TextStyle(fontSize = 20.sp), // Установка размера текста
                                shape = RoundedCornerShape(8.dp),
                                modifier = Modifier.fillMaxWidth()
                            )



                            Spacer(modifier = Modifier.height(10.dp))


                            Row(
                                verticalAlignment = Alignment.CenterVertically,

                                ) {
                                Checkbox(
                                    checked = checked,
                                    onCheckedChange = { checked = it }
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = "администратор",
                                    style = TextStyle(fontSize = 20.sp) // Установка размера текста
                                )
                            }



                            Spacer(modifier = Modifier.height(20.dp))



                            BoxWithConstraints {
                                val screenWidth = maxWidth

                                if (screenWidth < 600.dp) {
                                    Column(
                                        modifier = Modifier.fillMaxWidth(),

                                        ) {
                                        Button(
                                            modifier = Modifier.fillMaxWidth(),
                                            onClick = { /* Do something! */ },
                                            shape = RoundedCornerShape(8.dp),
                                            colors = ButtonDefaults.buttonColors(
                                                contentColor = Color.White,
                                                containerColor = Color(0xFF7986CB)
                                            )
                                        ) {
                                            Text(
                                                text = "добавить фотографию",
                                                fontSize = 20.sp,)
                                        }

                                        Button(
                                            modifier = Modifier.fillMaxWidth(),
                                            onClick = { /* Do something! */ },
                                            shape = RoundedCornerShape(8.dp),
                                            colors = ButtonDefaults.buttonColors(
                                                contentColor = Color.White,
                                                containerColor = Color(0xFF7986CB)
                                            )
                                        ) {
                                            Text(
                                                text = "сохранить",
                                                fontSize = 20.sp,)
                                        }
                                    }
                                } else {
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.spacedBy(80.dp)
                                    ) {
                                        Button(

                                            onClick = { /* Do something! */ },
                                            shape = RoundedCornerShape(8.dp),
                                            colors = ButtonDefaults.buttonColors(
                                                contentColor = Color.White,
                                                containerColor = Color(0xFF7986CB)
                                            )
                                        ) {
                                            Text(
                                                text = "добавить фотографию",
                                                fontSize = 20.sp,)
                                        }

                                        Spacer(modifier = Modifier.weight(1f))

                                        Button(

                                            onClick = { /* Do something! */ },
                                            shape = RoundedCornerShape(8.dp),
                                            colors = ButtonDefaults.buttonColors(
                                                contentColor = Color.White,
                                                containerColor = Color(0xFF7986CB)
                                            )
                                        ) {
                                            Text(
                                                text = "сохранить",
                                                fontSize = 20.sp,)
                                        }
                                    }
                                }
                            }
                        }
                    }


                }


            }


        )
    }

}


@Preview(showBackground = true)
@Composable
fun EditUsersPreview() {
    val navController = rememberNavController()
    DiplomTheme {
        EditUsers(navController)
    }
}