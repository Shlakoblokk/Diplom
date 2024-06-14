package com.example.diplom.Navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Computer
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.diplom.ui.theme.DiplomTheme
import androidx.compose.material3.*
import androidx.compose.runtime.*


@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val items = listOf("мат. запасы", "осн. средства", "пользователи")
    val routes = listOf("material_res", "fixed_assets", "users")


    NavigationBar(
        containerColor = colorScheme.primary
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    when (index) {
                        0 -> Icon(
                            Icons.Filled.Book,
                            contentDescription = item,
                            tint = Color(0xFF191C2E)
                        )

                        1 -> Icon(
                            Icons.Filled.Computer,
                            contentDescription = item,
                            tint = colorScheme.primary
                        )

                        2 -> Icon(
                            Icons.Filled.Person,
                            contentDescription = item,
                            tint = Color(0xFF191C2E)
                        )

                        else -> Icon(
                            Icons.Filled.Favorite,
                            contentDescription = item,
                            tint = Color(0xFF191C2E)
                        )
                    }
                },
                label = { Text(item, color = Color(0xFF191C2E)) },
                selected = currentRoute == routes[index],
                onClick = {
                    if (currentRoute != routes[index]) {
                        navController.navigate(routes[index]) {
                            popUpTo(navController.graph.startDestinationId) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = colorScheme.onPrimary,
                    unselectedIconColor = colorScheme.onPrimary,
                    selectedTextColor = colorScheme.onPrimary,
                    unselectedTextColor = colorScheme.onPrimary
                )
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val navController = rememberNavController()
    DiplomTheme {
        BottomNavigationBar(navController)
    }
}