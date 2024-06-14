package com.example.diplom.FixedAssets

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
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
fun CardFixedAssets(navController: NavHostController) {

    var isExpanded by remember { mutableStateOf(false) }
    var showDialog by remember { mutableStateOf(false) }


    Scaffold(


        topBar = { TopAppBarBack(navController) },

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


                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(8.dp))

                                .padding(16.dp)
                                .shadow(
                                    elevation = 8.dp,
                                    shape = RoundedCornerShape(8.dp)
                                )
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(Color.White)
                                    .padding(16.dp)
                                    .clip(RoundedCornerShape(8.dp))
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.image3),
                                    contentDescription = "Localized description",
                                    modifier = Modifier
                                        .width(300.dp)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(40.dp))

                        Text(
                            text = "Анкерная линия",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF333333),
                            modifier = Modifier.padding(bottom = 20.dp)
                        )




                        Column(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),

                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "статус",
                                    fontSize = 20.sp,
                                    color = Color(0xFF666666),
                                    modifier = Modifier.alignByBaseline()
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
                                modifier = Modifier
                                    .fillMaxWidth(),

                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "дата изменения статуса",
                                    fontSize = 20.sp,
                                    modifier = Modifier.alignByBaseline(),
                                    color = Color(0xFF666666)
                                )
                                Text(
                                    text = "23.05.2023",
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
                            modifier = Modifier
                                .fillMaxWidth(),

                            verticalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            // Row to contain the text and the icon button
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    text = "примечание о изменении статуса",
                                    fontSize = 20.sp,
                                    color = Color(0xFF666666),
                                    modifier = Modifier.weight(1f) // Fill remaining space
                                )
                                IconButton(
                                    onClick = { isExpanded = !isExpanded }
                                ) {
                                    Icon(
                                        imageVector = if (isExpanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                                        contentDescription = if (isExpanded) "Collapse" else "Expand"
                                    )
                                }
                            }

                            // Text to display the last changes if expanded
                            if (isExpanded) {
                                Column {
                                    Text(
                                        text = "изменено потому что так надо вот да хе хе изменено потому что так надо изменено потому что так надо",
                                        fontSize = 20.sp,
                                        textAlign = TextAlign.Start,

                                    )
                                    Box(
                                        modifier = Modifier.fillMaxWidth(),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        TextButton(
                                            onClick = { showDialog = true }
                                        ) {
                                            Text(
                                                text = "показать все",
                                                color = Color(0xFF7986CB),
                                                fontSize = 20.sp,
                                            )
                                        }
                                    }
                                }
                            }


                            if (showDialog) {
                                AlertDialog(
                                    onDismissRequest = { showDialog = false },
                                    title = { Text("Изменение статуса") },
                                    text = {
                                        Column(
                                            modifier = Modifier
                                                .height(400.dp)

                                                .verticalScroll(rememberScrollState())
                                        ) {
                                            Text(
                                                text = "изменено в связи с такой то причиной изменено в связи с такой то причиной изменено в связи с такой то причиной изменено в связи с такой то причиной изменено в связи с такой то причиной изменено в связи с такой то причиной",
                                                fontSize = 20.sp,
                                                textAlign = TextAlign.Start
                                            )
                                        }
                                    },
                                    confirmButton = {
                                        Button(
                                            modifier = Modifier.fillMaxWidth(),
                                            onClick = { showDialog = false },
                                            shape = RoundedCornerShape(8.dp),
                                            colors = ButtonDefaults.buttonColors(
                                                contentColor = Color.White,
                                                containerColor  = Color(0xFF7986CB)
                                            )
                                        ) {
                                            Text(
                                                text = "Закрыть",
                                                fontSize = 20.sp,
                                            )
                                        }
                                    },

                                )
                            }
                        }



                        Spacer(modifier = Modifier.height(20.dp))


                        BoxWithConstraints {
                            val screenWidth = maxWidth

                            if (screenWidth < 600.dp) {
                                Column(
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Button(
                                        modifier = Modifier.fillMaxWidth(),
                                        onClick = { navController.navigate("edit_status_fixed_assets") },
                                        shape = RoundedCornerShape(8.dp),
                                        colors = ButtonDefaults.buttonColors(
                                            contentColor = Color.White,
                                            containerColor = Color(0xFF7986CB)
                                        )
                                    ) {
                                        Text(
                                            text = "редактировать статус",
                                            fontSize = 20.sp,
                                        )
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
                                        onClick = { navController.navigate("edit_status_fixed_assets") },
                                        shape = RoundedCornerShape(8.dp),
                                        colors = ButtonDefaults.buttonColors(
                                            contentColor = Color.White,
                                            containerColor = Color(0xFF7986CB)
                                        )

                                    ) {
                                        Text(
                                            text = "редактировать статус",
                                            fontSize = 20.sp,
                                        )
                                    }
                                }
                            }
                        }


                        Spacer(modifier = Modifier.height(20.dp))


                        Column(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),

                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "№п/п",
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
                                modifier = Modifier
                                    .fillMaxWidth(),

                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "категория",
                                    fontSize = 20.sp,
                                    modifier = Modifier.alignByBaseline(),
                                    color = Color(0xFF666666)
                                )
                                Text(
                                    text = "основные средства",
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
                                modifier = Modifier
                                    .fillMaxWidth(),

                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "модель",
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
                                modifier = Modifier
                                    .fillMaxWidth(),

                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "инвентарный номер",
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
                                modifier = Modifier
                                    .fillMaxWidth(),

                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "заводской номер",
                                    fontSize = 20.sp,
                                    modifier = Modifier.alignByBaseline(),
                                    color = Color(0xFF666666)
                                )
                                Text(
                                    text = "23.05.2023",
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
                                modifier = Modifier
                                    .fillMaxWidth(),

                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "дата ввода в эксплуатацию",
                                    fontSize = 20.sp,
                                    modifier = Modifier.alignByBaseline(),
                                    color = Color(0xFF666666)
                                )
                                Text(
                                    text = "23.05.2023",
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
                                modifier = Modifier
                                    .fillMaxWidth(),

                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "стоимость",
                                    fontSize = 20.sp,
                                    modifier = Modifier.alignByBaseline(),
                                    color = Color(0xFF666666)
                                )
                                Text(
                                    text = "24354655",
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
                                modifier = Modifier
                                    .fillMaxWidth(),

                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "номер аудитории",
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
                                modifier = Modifier
                                    .fillMaxWidth(),

                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "группа",
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
                                modifier = Modifier
                                    .fillMaxWidth(),

                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "единица измерения",
                                    fontSize = 20.sp,
                                    modifier = Modifier.alignByBaseline(),
                                    color = Color(0xFF666666)
                                )
                                Text(
                                    text = "пачка",
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
                            modifier = Modifier
                                .fillMaxWidth(),

                            verticalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            // Row to contain the text and the icon button
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    text = "примечание",
                                    fontSize = 20.sp,
                                    color = Color(0xFF666666),
                                    modifier = Modifier.weight(1f) // Fill remaining space
                                )
                                IconButton(
                                    onClick = { isExpanded = !isExpanded }
                                ) {
                                    Icon(
                                        imageVector = if (isExpanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                                        contentDescription = if (isExpanded) "Collapse" else "Expand"
                                    )
                                }
                            }

                            // Text to display the last changes if expanded
                            if (isExpanded) {
                                Column {
                                    Text(
                                        text = "Имеет втяжной трос, сто позволяет удобно и быстро производить ее установку и демонтаж. Кроме того, система универсальна: благодаря встроеной лебедке можно установить данную анкерную линию на любую длину рубочей площадки (до 18м). Система EZ-LINE имеет встроеные индикаторы напряжения, падения и рассчитана на 2-х пользователей. В данном основном средстве (оборудовании) могут находится драгоценные металлы, содержание которых будет определено после списания, разборки (демонтаже) и утилизации.",
                                        fontSize = 20.sp,
                                        textAlign = TextAlign.Start,

                                    )

                                }
                            }


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
                                        onClick = { navController.navigate("edit_fixed_assets") },
                                        shape = RoundedCornerShape(8.dp),
                                        colors = ButtonDefaults.buttonColors(
                                            contentColor = Color.White,
                                            containerColor = Color(0xFF7986CB)
                                        )
                                    ) {
                                        Text(
                                            text = "редактировать запись",
                                            fontSize = 20.sp,
                                        )
                                    }

                                    Button(
                                        modifier = Modifier.fillMaxWidth(),
                                        onClick = { navController.navigate("edit_fixed_assets") },
                                        shape = RoundedCornerShape(8.dp),
                                        colors = ButtonDefaults.buttonColors(
                                            contentColor = Color.White,
                                            containerColor = Color(0xFF7986CB)
                                        )
                                    ) {
                                        Text(
                                            text = "удалить",
                                            fontSize = 20.sp,
                                        )
                                    }
                                }
                            } else {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.spacedBy(200.dp)
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
                                            text = "редактировать запись",
                                            fontSize = 20.sp,
                                        )
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
                                            text = "удалить",
                                            fontSize = 20.sp,
                                        )
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


@Preview(showBackground = true)
@Composable
fun CardFixedAssetsPreview() {
    val navController = rememberNavController()
    DiplomTheme {
        CardFixedAssets(navController)
    }
}