package com.example.diplom.Navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarMenu(navController: NavHostController) {

    CenterAlignedTopAppBar(
        title = {
            Text(
                "",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        actions = {
            IconButton(onClick = { navController.navigate("profile_users") }) {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = "Profile Icon"
                )
            }
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(
                    imageVector = Icons.Filled.ExitToApp,
                    contentDescription = "Logout Icon"
                )
            }
        }
    )
}