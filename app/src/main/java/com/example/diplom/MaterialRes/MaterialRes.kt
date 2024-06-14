package com.example.diplom.MaterialRes

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.QrCode
import androidx.compose.material.icons.filled.ViewModule
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.example.diplom.R
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

data class Item(val text: String, val imageRes: Int)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MaterialRes(navController: NavHostController) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val isListView = remember { mutableStateOf(false) }
    val items = listOf(
        Item("Бумага офисная А4", R.drawable.image1),
        Item("Картридж 013R00621/ Xerox WC PE220", R.drawable.image2),
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
                                trailingIcon = {
                                    Icon(
                                        imageVector = Icons.Default.QrCode,
                                        contentDescription = "QR Code"
                                    )
                                }
                            )

                            Spacer(modifier = Modifier.height(20.dp))

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Button(
                                    modifier = Modifier.align(Alignment.CenterVertically),
                                    onClick = { navController.navigate("create_material_res")},
                                    shape = RoundedCornerShape(8.dp),
                                    colors = ButtonDefaults.buttonColors(
                                        contentColor = Color.White,
                                        containerColor = Color(0xFF7986CB)
                                    )
                                ) {
                                    Text(
                                        text = "новая запись",
                                        fontSize = 20.sp,
                                    )
                                }


                                Spacer(modifier = Modifier.weight(1f))

                                TextButton(
                                    onClick = { navController.navigate("filter_material_res")  },
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

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.End
                            ) {
                                IconButton(onClick = { isListView.value = !isListView.value }) {
                                    Icon(
                                        imageVector = if (isListView.value) Icons.Filled.ViewModule else Icons.Filled.List,
                                        contentDescription = if (isListView.value) "List View" else "Card View",
                                        modifier = Modifier.widthIn(max = 200.dp)
                                    )
                                }
                            }



                            if (isListView.value) {
                                items.forEach { item ->
                                    Card(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(vertical = 5.dp)
                                            .clickable { navController.navigate("card_material_res") },
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
                                                    text = item.text,
                                                    style = MaterialTheme.typography.bodyLarge,
                                                    modifier = Modifier.alignByBaseline()
                                                )

                                            }
                                        }

                                    }
                                }
                            } else {

                                items.chunked(2).forEach { rowItems ->
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        rowItems.forEachIndexed { index, item ->
                                            if (index > 0) {
                                                Spacer(modifier = Modifier.width(10.dp))
                                            }
                                            Card(
                                                modifier = Modifier
                                                    .padding(vertical = 5.dp)
                                                    .height(230.dp)
                                                    .weight(1f)
                                                    .clickable { navController.navigate("card_material_res") }, // Используйте clickable здесь
                                                shape = RoundedCornerShape(8.dp),
                                                border = BorderStroke(1.dp, Color.LightGray)
                                            ) {
                                                Box(
                                                    modifier = Modifier
                                                        .fillMaxSize()
                                                        .background(Color.White)
                                                ) {
                                                    Column(
                                                        horizontalAlignment = Alignment.CenterHorizontally,
                                                        modifier = Modifier.padding(12.dp)
                                                    ) {
                                                        Image(
                                                            painter = painterResource(id = item.imageRes),
                                                            contentDescription = "Localized description",
                                                            modifier = Modifier.size(130.dp)
                                                        )
                                                        Text(
                                                            text = item.text,
                                                            style = TextStyle(fontSize = 20.sp),
                                                            textAlign = TextAlign.Center
                                                        )
                                                    }
                                                }
                                            }
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
fun MaterialResPreview() {
    val navController = rememberNavController()
    DiplomTheme {
        MaterialRes(navController)
    }
}
