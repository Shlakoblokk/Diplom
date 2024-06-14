package com.example.diplom.MaterialRes

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

import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.diplom.Elements.Calendar
import com.example.diplom.Elements.Group
import com.example.diplom.Navigation.TopAppBarEdit
import com.example.diplom.Elements.Unit

import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditMaterialRes(navController: NavHostController) {

    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    var text by rememberSaveable { mutableStateOf("") }

    var name by rememberSaveable { mutableStateOf("") }
    var number by rememberSaveable { mutableStateOf("") }
    var category by rememberSaveable { mutableStateOf("") }
    var quantity by rememberSaveable { mutableStateOf("") }
    var model by rememberSaveable { mutableStateOf("") }
    var inv by rememberSaveable { mutableStateOf("") }
    var zav by rememberSaveable { mutableStateOf("") }
    var costed by rememberSaveable { mutableStateOf("") }
    var cost by rememberSaveable { mutableStateOf("") }
    var aud by rememberSaveable { mutableStateOf("") }
    var prim by rememberSaveable { mutableStateOf("") }


    Box(Modifier.fillMaxSize()) {

        Scaffold(
            topBar = { TopAppBarEdit(navController) },

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
                                value = name,
                                onValueChange = { name = it },
                                label = {
                                    Text(
                                        text = "наименование",
                                        color = Color(0xFF666666),
                                        style = TextStyle(fontSize = 20.sp) // Установка размера текста для label
                                    )
                                },
                                textStyle = TextStyle(fontSize = 20.sp), // Установка размера текста
                                shape = RoundedCornerShape(8.dp), // Скругленные углы
                                modifier = Modifier.fillMaxWidth(),

                                )
                            OutlinedTextField(
                                value = number,
                                onValueChange = { number = it },
                                label = {
                                    Text(
                                        text = "№п/п",
                                        color = Color(0xFF666666),
                                        style = TextStyle(fontSize = 20.sp) // Установка размера текста для label
                                    )
                                },
                                textStyle = TextStyle(fontSize = 20.sp), // Установка размера текста
                                shape = RoundedCornerShape(8.dp),
                                modifier = Modifier.fillMaxWidth()
                            )

                            OutlinedTextField(
                                value = category,
                                onValueChange = { category = it },
                                label = {
                                    Text(
                                        text = "категория",
                                        color = Color(0xFF666666),
                                        style = TextStyle(fontSize = 20.sp) // Установка размера текста для label
                                    )
                                },
                                textStyle = TextStyle(fontSize = 20.sp), // Установка размера текста
                                shape = RoundedCornerShape(8.dp),
                                modifier = Modifier.fillMaxWidth()
                            )

                            OutlinedTextField(
                                value = quantity,
                                onValueChange = { quantity = it },
                                label = {
                                    Text(
                                        text = "количество",
                                        color = Color(0xFF666666),
                                        style = TextStyle(fontSize = 20.sp) // Установка размера текста для label
                                    )
                                },
                                textStyle = TextStyle(fontSize = 20.sp), // Установка размера текста
                                shape = RoundedCornerShape(8.dp),
                                modifier = Modifier.fillMaxWidth()
                            )

                            OutlinedTextField(
                                value = model,
                                onValueChange = { model = it },
                                label = {
                                    Text(
                                        text = "модель",
                                        color = Color(0xFF666666),
                                        style = TextStyle(fontSize = 20.sp) // Установка размера текста для label
                                    )
                                },
                                textStyle = TextStyle(fontSize = 20.sp), // Установка размера текста
                                shape = RoundedCornerShape(8.dp),
                                modifier = Modifier.fillMaxWidth()
                            )

                            OutlinedTextField(
                                value = inv,
                                onValueChange = { inv = it },
                                label = {
                                    Text(
                                        text = "инвентарный номер",
                                        color = Color(0xFF666666),
                                        style = TextStyle(fontSize = 20.sp) // Установка размера текста для label
                                    )
                                },
                                textStyle = TextStyle(fontSize = 20.sp), // Установка размера текста
                                shape = RoundedCornerShape(8.dp),
                                modifier = Modifier.fillMaxWidth()
                            )

                            OutlinedTextField(
                                value = zav,
                                onValueChange = { zav = it },
                                label = {
                                    Text(
                                        text = "заводской номер",
                                        color = Color(0xFF666666),
                                        style = TextStyle(fontSize = 20.sp) // Установка размера текста для label
                                    )
                                },
                                textStyle = TextStyle(fontSize = 20.sp), // Установка размера текста
                                shape = RoundedCornerShape(8.dp),
                                modifier = Modifier.fillMaxWidth()
                            )

                            Calendar()

                            OutlinedTextField(
                                value = costed,
                                onValueChange = { costed = it },
                                label = {
                                    Text(
                                        text = "стоимость (ед.)",
                                        color = Color(0xFF666666),
                                        style = TextStyle(fontSize = 20.sp) // Установка размера текста для label
                                    )
                                },
                                textStyle = TextStyle(fontSize = 20.sp), // Установка размера текста
                                shape = RoundedCornerShape(8.dp),
                                modifier = Modifier.fillMaxWidth(),
                            )

                            OutlinedTextField(
                                value = cost,
                                onValueChange = { cost = it },
                                label = {
                                    Text(
                                        text = "стоимость",
                                        color = Color(0xFF666666),
                                        style = TextStyle(fontSize = 20.sp) // Установка размера текста для label
                                    )
                                },
                                textStyle = TextStyle(fontSize = 20.sp), // Установка размера текста
                                shape = RoundedCornerShape(8.dp),
                                modifier = Modifier.fillMaxWidth()
                            )

                            OutlinedTextField(
                                value = aud,
                                onValueChange = { aud = it },
                                label = {
                                    Text(
                                        text = "номер аудитории",
                                        color = Color(0xFF666666),
                                        style = TextStyle(fontSize = 20.sp) // Установка размера текста для label
                                    )
                                },
                                textStyle = TextStyle(fontSize = 20.sp), // Установка размера текста
                                shape = RoundedCornerShape(8.dp),
                                modifier = Modifier.fillMaxWidth()
                            )

                            Group()
                            Unit()



                            OutlinedTextField(
                                value = prim,
                                onValueChange = { prim = it },
                                label = {
                                    Text(
                                        text = "примечание",
                                        color = Color(0xFF666666),
                                        style = TextStyle(fontSize = 20.sp)
                                    )
                                },
                                textStyle = TextStyle(fontSize = 20.sp),
                                shape = RoundedCornerShape(8.dp),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(200.dp),

                                singleLine = false
                            )

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
fun EditMaterialResPreview() {
    val navController = rememberNavController()
    DiplomTheme {
        EditMaterialRes(navController)
    }
}