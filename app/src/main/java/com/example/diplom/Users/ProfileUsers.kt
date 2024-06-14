package com.example.diplom.Users

import androidx.compose.foundation.Image
import androidx.compose.foundation.background

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.diplom.R
import com.example.diplom.Navigation.TopAppBarBack
import com.example.diplom.ui.theme.DiplomTheme


@Composable
fun ProfileUsers(navController: NavHostController) {

    Box(Modifier.fillMaxSize()) {

        Scaffold(topBar = { TopAppBarBack(navController) },

            content = { innerPadding ->

                LazyColumn(
                    modifier = Modifier.fillMaxWidth(),

                    ) {
                    item {

                        Column(
                            modifier = Modifier
                                .padding(innerPadding)
                                .padding(20.dp)
                                .fillMaxWidth()
                        ) {


                            Box(
                                modifier = Modifier
                                    .fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Card(
                                    modifier = Modifier
                                        .size(220.dp)
                                        .clip(CircleShape)
                                        .padding(16.dp)
                                        .shadow(
                                            elevation = 8.dp,
                                            shape = CircleShape
                                        ),
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .background(Color.White)
                                            .padding(16.dp)
                                            .clip(RoundedCornerShape(8.dp)), // Скругление углов внутренней части
                                        contentAlignment = Alignment.Center // Центрирование содержимого
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.user),
                                            contentDescription = "Localized description",
                                            modifier = Modifier
                                                .size(150.dp) // Установка размера изображения
                                        )
                                    }
                                }
                            }

                            Spacer(modifier = Modifier.height(40.dp))





                            Column(
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),

                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = "имя",
                                        fontSize = 20.sp,
                                        modifier = Modifier.alignByBaseline(),
                                        color = Color(0xFF666666)
                                    )
                                    Text(
                                        text = "-",
                                        fontSize = 20.sp,
                                        textAlign = TextAlign.End,
                                        modifier = Modifier.alignByBaseline()
                                    )
                                }
                                Spacer(modifier = Modifier.height(10.dp))
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(1.dp)
                                        .background(Color(0xFFEEEEEE))
                                )
                            }
                            Spacer(modifier = Modifier.height(10.dp))
                            Column(
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),

                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = "фамилия",
                                        fontSize = 20.sp,
                                        modifier = Modifier.alignByBaseline(),
                                        color = Color(0xFF666666)
                                    )
                                    Text(
                                        text = "-",
                                        fontSize = 20.sp,
                                        textAlign = TextAlign.End,
                                        modifier = Modifier.alignByBaseline()
                                    )
                                }
                                Spacer(modifier = Modifier.height(10.dp))
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(1.dp)
                                        .background(Color(0xFFEEEEEE))
                                )
                            }
                            Spacer(modifier = Modifier.height(10.dp))

                            Column(
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),

                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = "отчество",
                                        fontSize = 20.sp,
                                        modifier = Modifier.alignByBaseline(),
                                        color = Color(0xFF666666)
                                    )
                                    Text(
                                        text = "-",
                                        fontSize = 20.sp,
                                        textAlign = TextAlign.End,
                                        modifier = Modifier.alignByBaseline()
                                    )
                                }
                                Spacer(modifier = Modifier.height(10.dp))
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(1.dp)
                                        .background(Color(0xFFEEEEEE))
                                )
                            }
                            Spacer(modifier = Modifier.height(10.dp))
                            Column(
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),

                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = "должность",
                                        fontSize = 20.sp,
                                        modifier = Modifier.alignByBaseline(),
                                        color = Color(0xFF666666)
                                    )
                                    Text(
                                        text = "-",
                                        fontSize = 20.sp,
                                        textAlign = TextAlign.End,
                                        modifier = Modifier.alignByBaseline()
                                    )
                                }
                                Spacer(modifier = Modifier.height(10.dp))
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(1.dp)
                                        .background(Color(0xFFEEEEEE))
                                )
                            }
                            Spacer(modifier = Modifier.height(10.dp))
                            Column(
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),

                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = "рабочий телефон",
                                        fontSize = 20.sp,
                                        modifier = Modifier.alignByBaseline(),
                                        color = Color(0xFF666666)
                                    )
                                    Text(
                                        text = "-",
                                        fontSize = 20.sp,
                                        textAlign = TextAlign.End,
                                        modifier = Modifier.alignByBaseline()
                                    )
                                }
                                Spacer(modifier = Modifier.height(10.dp))
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(1.dp)
                                        .background(Color(0xFFEEEEEE))
                                )
                            }

                            Spacer(modifier = Modifier.height(10.dp))
                            Column(
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),

                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = "мобильный телефон",
                                        fontSize = 20.sp,
                                        modifier = Modifier.alignByBaseline(),
                                        color = Color(0xFF666666)
                                    )
                                    Text(
                                        text = "-",
                                        fontSize = 20.sp,
                                        textAlign = TextAlign.End,
                                        modifier = Modifier.alignByBaseline()
                                    )
                                }
                                Spacer(modifier = Modifier.height(10.dp))
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(1.dp)
                                        .background(Color(0xFFEEEEEE))
                                )
                            }

                            Spacer(modifier = Modifier.height(10.dp))

                            Column(
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),

                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = "почта",
                                        fontSize = 20.sp,
                                        modifier = Modifier.alignByBaseline(),
                                        color = Color(0xFF666666)
                                    )
                                    Text(
                                        text = "-",
                                        fontSize = 20.sp,
                                        textAlign = TextAlign.End,
                                        modifier = Modifier.alignByBaseline()
                                    )
                                }
                                Spacer(modifier = Modifier.height(10.dp))
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(1.dp)
                                        .background(Color(0xFFEEEEEE))
                                )
                            }

                            Spacer(modifier = Modifier.height(10.dp))
                            Column(
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),

                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = "подразделение",
                                        fontSize = 20.sp,
                                        modifier = Modifier.alignByBaseline(),
                                        color = Color(0xFF666666)
                                    )
                                    Text(
                                        text = "-",
                                        fontSize = 20.sp,
                                        textAlign = TextAlign.End,
                                        modifier = Modifier.alignByBaseline()
                                    )
                                }
                                Spacer(modifier = Modifier.height(10.dp))
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(1.dp)
                                        .background(Color(0xFFEEEEEE))
                                )
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
fun ProfileUsers() {
    val navController = rememberNavController()
    DiplomTheme {
        ProfileUsers(navController)
    }
}