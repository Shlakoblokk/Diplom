package com.example.diplom.Elements

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Calendar() {

    var calendartext by remember { mutableStateOf("") }
    val context = LocalContext.current
    val format = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val calendar = Calendar.getInstance()


    OutlinedTextField(
        value = calendartext,
        onValueChange = { calendartext = it },
        label = {
            Text(
                text = "дата ввода в эксплуатацию",
                color = Color(0xFF666666),
                style = TextStyle(fontSize = 20.sp) // Установка размера текста для label
            )
        },
        textStyle = TextStyle(fontSize = 20.sp), // Установка размера текста
        shape = RoundedCornerShape(8.dp),
        trailingIcon = {
            Icon(
                imageVector = Icons.Filled.DateRange,
                contentDescription = "Select Date",
                modifier = Modifier.clickable {
                    val datePickerDialog = DatePickerDialog(
                        context,
                        { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
                            calendar.set(year, month, dayOfMonth)
                            calendartext = format.format(calendar.time)
                        },
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)
                    )
                    datePickerDialog.show()
                }
            )
        },
        modifier = Modifier
            .fillMaxWidth(),
        readOnly = true
    )
}