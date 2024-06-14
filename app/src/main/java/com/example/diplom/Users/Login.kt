package com.example.diplom.Users

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun Login(navController: NavHostController) {
    var username by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,

        ) {
            Text(
                text = "Вход",
                style = TextStyle(fontSize = 20.sp),
                modifier = Modifier.padding(bottom = 16.dp)
            )


            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = {
                    Text(
                        text = "Логин",
                        color = Color(0xFF666666),
                        style = TextStyle(fontSize = 20.sp) // Установка размера текста для label
                    )
                },
                textStyle = TextStyle(fontSize = 20.sp), // Установка размера текста
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.fillMaxWidth()
            )


            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = {
                    Text(
                        text = "Пароль",
                        color = Color(0xFF666666),
                        style = TextStyle(fontSize = 20.sp) // Установка размера текста для label
                    )
                },
                visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val image = if (showPassword)
                        Icons.Filled.Visibility
                    else Icons.Filled.VisibilityOff

                    IconButton(onClick = { showPassword = !showPassword }) {
                        Icon(imageVector = image, contentDescription = null)
                    }
                },
                textStyle = TextStyle(fontSize = 20.sp), // Установка размера текста
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(20.dp))


            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    if (validateLogin(username, password)) {
                        navController.navigate("material_res")
                    }
                          },
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = Color(0xFF7986CB))
            ) {
                Text(
                    text = "войти",
                    fontSize = 20.sp,)
            }


        }
    }
}

fun validateLogin(username: String, password: String): Boolean {
    return username == "1" && password == "1"
}

@Composable
@Preview(showBackground = true)
fun LoginPreview() {
    val navController = rememberNavController()
    Login (navController)
}