package com.example.diplom.Users

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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

import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.diplom.Navigation.TopAppBarFilters

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FiltersUsers(navController: NavHostController) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val selectedOptions = remember { mutableStateOf<Map<String, List<String>>>(emptyMap()) }
    val checkedState = remember { mutableStateOf(true) }

    Box(Modifier.fillMaxSize()) {
        Scaffold(
            topBar = { TopAppBarFilters(navController) },
            content = { innerPadding ->
                var text by rememberSaveable { mutableStateOf("") }

                LazyColumn(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    item {
                        Column(
                            modifier = Modifier
                                .padding(innerPadding)
                                .padding(16.dp)
                                .padding(bottom = 40.dp)
                                .fillMaxWidth()
                        ) {
                            DropdownUsers(selectedOptions = selectedOptions)
                        }
                    }
                }
            }
        )


        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .align(Alignment.BottomCenter),
            color = Color.White
        ) {

            Button(

                onClick = { /* Do something! */ },
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = Color(0xFF7986CB)),


                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
                    .padding(bottom = 8.dp)
            ) {
                Text(
                    text = "применить",
                    fontSize = 20.sp,)
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun FilterUsers() {
    val navController = rememberNavController()
    DiplomTheme {
        FiltersUsers(navController)
    }
}