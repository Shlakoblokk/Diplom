package com.example.diplom.Users

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun DropdownUsers(selectedOptions: MutableState<Map<String, List<String>>>) {
    val dropdownData = listOf(
        "подразделение" to listOf("подразделение", "подразделение", "подразделение"),
        "парава доступа" to listOf("пользователь", "администратор"),

    )
    val isOpen = remember { mutableStateMapOf<String, Boolean>() }

    fun toggleDropdown(category: String) {
        isOpen[category] = !(isOpen[category] ?: false)
    }

    fun handleOptionClick(category: String, optionValue: String) {
        val newSelectedOptions = selectedOptions.value.toMutableMap()
        val selectedCategoryOptions = newSelectedOptions[category] ?: emptyList()

        newSelectedOptions[category] = if (selectedCategoryOptions.contains(optionValue)) {
            selectedCategoryOptions - optionValue
        } else {
            selectedCategoryOptions + optionValue
        }
        selectedOptions.value = newSelectedOptions
    }

    Column(modifier = Modifier.padding(16.dp)) {
        dropdownData.forEach { (category, options) ->
            Card(
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.background(Color.White) // Установка белого фона для Card
                ) {
                    Button(
                        onClick = { toggleDropdown(category) },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(
                            contentColor = Color.Black,
                            containerColor = Color.White
                        )
                    ) {
                        Text(
                            text = category,
                            fontSize = 20.sp
                        )
                    }
                    if (isOpen[category] == true) {
                        options.forEach { item ->
                            val isChecked = selectedOptions.value[category]?.contains(item) ?: false
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 10.dp)
                                    .background(Color.White), // Установка белого фона для каждого элемента

                            ) {
                                Checkbox(
                                    checked = isChecked,
                                    onCheckedChange = { handleOptionClick(category, item) },
                                    modifier = Modifier.padding(end = 8.dp)
                                )
                                Text(
                                    text = item,
                                    modifier = Modifier
                                        .weight(1f)
                                        .align(Alignment.CenterVertically), // выравнивание по центру вертикали
                                    fontSize = 20.sp,
                                    textAlign = TextAlign.Start,
                                    color = Color.Black // Установка цвета текста
                                )
                            }
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DropdownUsersPreview() {
    val selectedOptions = remember { mutableStateOf<Map<String, List<String>>>(emptyMap()) }
    DropdownUsers(selectedOptions)
}
