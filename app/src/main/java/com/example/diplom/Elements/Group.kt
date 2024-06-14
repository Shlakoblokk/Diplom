package com.example.diplom.Elements

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Group() {

    val options = listOf(
        "компьютерная техника",
        "принтеры и мфу",
        "картриджи",
    )
    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf("") }


    Box {
        OutlinedTextField(
            value = selectedOptionText,
            onValueChange = { selectedOptionText = it },
            label = {
                Text(
                    text = "группа",
                    color = Color(0xFF666666),
                    style = TextStyle(fontSize = 20.sp) // Установка размера текста для label
                )
            },
            textStyle = TextStyle(fontSize = 20.sp), // Установка размера текста
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = true },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "Dropdown Icon",
                    modifier = Modifier.clickable { expanded = true }
                )
            },
            readOnly = true
        )

        DropdownMenu(

            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .background(Color.White)

        ) {
            options.forEach { selectionOption ->
                DropdownMenuItem(
                    {
                        Text(
                            text = selectionOption,
                            style = TextStyle(fontSize = 20.sp) // Установка размера текста для каждого элемента
                        )
                    },

                    onClick = {
                        selectedOptionText = selectionOption
                        expanded = false
                    }
                )
            }
        }
    }
}