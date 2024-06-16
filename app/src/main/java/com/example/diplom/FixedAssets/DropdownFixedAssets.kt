package com.example.diplom.FixedAssets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.diplom.Elements.Calendar

@Composable
fun DropdownFixedAssets(selectedOptions: MutableState<Map<String, List<String>>>) {

    var isExpanded by remember { mutableStateOf(false) }

    val dropdownData = listOf(
        "Группа" to listOf("Компьютерная техника", "Принтеры и МФУ", "Картриджи"),
        "Аудитория" to listOf("4324", "3927", "2452"),
        "Статус" to listOf("Статус 1", "Статус 2", "Статус 3" , "Статус 3", "Статус 3", "Статус 3", "Статус 3")
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
                    modifier = Modifier.background(Color.White)
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
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = category,
                                fontSize = 20.sp
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
                    }


                    if (isOpen[category] == true) {
                        options.forEach { item ->
                            val isChecked = selectedOptions.value[category]?.contains(item) ?: false
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 10.dp)
                                    .background(Color.White),

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
        Calendar()
    }
}

@Preview(showBackground = true)
@Composable
fun DropdownFixedAssetsPreview() {
    val selectedOptions = remember { mutableStateOf<Map<String, List<String>>>(emptyMap()) }
    DropdownFixedAssets(selectedOptions)
}
