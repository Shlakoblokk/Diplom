package com.example.diplom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.diplom.Navigation.NavGraph

import com.example.diplom.ui.theme.DiplomTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DiplomTheme {
                NavGraph()


            }
        }
    }

}






