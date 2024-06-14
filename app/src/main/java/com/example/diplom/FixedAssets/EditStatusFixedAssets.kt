package com.example.diplom.FixedAssets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.diplom.Elements.CalendarStatus
import com.example.diplom.Navigation.TopAppBarEditStatus

import com.example.diplom.ui.theme.DiplomTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditStatusFixedAssets(navController: NavHostController) {

    var text by rememberSaveable { mutableStateOf("") }

    var status by rememberSaveable { mutableStateOf("") }
    var prim by rememberSaveable { mutableStateOf("") }

    Box(Modifier.fillMaxSize())
    {

        Scaffold(
            topBar = { TopAppBarEditStatus(navController) },

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
                                .fillMaxWidth()

                        ) {


                            OutlinedTextField(
                                value = status,
                                onValueChange = { status = it },
                                label = {
                                    Text(
                                        text = "статус",
                                        color = Color(0xFF666666),
                                        style = TextStyle(fontSize = 20.sp) // Установка размера текста для label
                                    )
                                },
                                textStyle = TextStyle(fontSize = 20.sp), // Установка размера текста
                                shape = RoundedCornerShape(8.dp), // Скругленные углы
                                modifier = Modifier.fillMaxWidth(),

                                )



                            CalendarStatus()

                            OutlinedTextField(
                                value = prim,
                                onValueChange = { prim = it },
                                label = {
                                    Text(
                                        text = "примечание о изменении статуса",
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
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Button(
                                            modifier = Modifier.fillMaxWidth(),
                                            onClick = { /* Do something! */ },
                                            shape = RoundedCornerShape(8.dp),
                                            colors = ButtonDefaults.buttonColors(
                                                contentColor = Color.White,
                                                containerColor = Color(0xFF7986CB))
                                        ) {
                                            Text(
                                                text = "сохранить",
                                                fontSize = 20.sp,)
                                        }
                                    }
                                } else {
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth(),

                                        horizontalArrangement = Arrangement.End
                                    ) {
                                        Button(
                                            modifier = Modifier.widthIn(max = 200.dp),
                                            onClick = { /* Do something! */ },
                                            shape = RoundedCornerShape(8.dp),
                                            colors = ButtonDefaults.buttonColors(
                                                contentColor = Color.White,
                                                containerColor = Color(0xFF7986CB))
                                        ) {
                                            Text(
                                                text = "редактировать статус",
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
fun EditStatusFixedAssetsPreview() {
    val navController = rememberNavController()
    DiplomTheme {
        EditStatusFixedAssets(navController)
    }
}
