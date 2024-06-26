package com.example.calculator.Functionality

import androidx.annotation.Nullable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Calculator() {

    Spacer(modifier = Modifier.height(16.dp))
    var text1 = remember {
        mutableStateOf("")
    }
    var text2 = remember {
        mutableStateOf("")
    }

    var result = remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
    Spacer(modifier = Modifier.height(50.dp))
        Text(text = "Calculator",
            color = Color.Red,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Gray)
                .padding(10.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "Result is :",
            color = Color.Black,
            fontSize = 20.sp)
        
        Text(text = result.value)
        
        Spacer(modifier = Modifier.height(50.dp))

        TextField(
            value = text1.value,
            onValueChange = { text1.value = it },
            maxLines = 1,

            placeholder = {
                Text(text = "Enter Number 1")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(value = text2.value, onValueChange = { text2.value = it },
            placeholder = {
                Text(text = "Enter Number 2")
            },
            maxLines = 1,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                    text1.value = ""
                    text2.value = ""
                    result.value = ""
                },
                modifier = Modifier
                    .size(71.dp) // Ensure the button is circular by setting a fixed size
                    .clip(CircleShape), // Apply the CircleShape
                shape = CircleShape
            ) {
                Text(text = "AC")
            }

            Button(onClick = {
                if (text1.value.isNotEmpty() && text2.value.isNotEmpty()) {
                    val rs = text1.value.toDouble() + text2.value.toDouble()
                    result.value = rs.toString()
                }
               else if (text1.value.isNotEmpty()){
                    result.value = text1.value
                }
                else if (text2.value.isNotEmpty()){
                    result.value = text2.value
                }
                else {
                    result.value = "Please enter numbers"
                }
            },
                    modifier = Modifier
                        .size(71.dp) // Ensure the button is circular by setting a fixed size
                        .clip(CircleShape), // Apply the CircleShape
                shape = CircleShape
            ) {
                Text("+")
            }

            Button(onClick = {
                if (text1.value.isNotEmpty() && text2.value.isNotEmpty()) {
                    val rs = text1.value.toDouble() - text2.value.toDouble()
                    result.value = rs.toString()
                }
                else if (text1.value.isNotEmpty()){
                    result.value = text1.value
                }
                else if (text2.value.isNotEmpty()){
                    result.value = text2.value
                }
                else {
                    result.value = "Please enter numbers"
                }
            },
                modifier = Modifier
                    .size(71.dp) // Ensure the button is circular by setting a fixed size
                    .clip(CircleShape), // Apply the CircleShape
                shape = CircleShape
                ) {
                Text("-")
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = {
                if (text1.value.isNotEmpty() && text2.value.isNotEmpty()) {
                    val rs = text1.value.toDouble() * text2.value.toDouble()
                    result.value = rs.toString()
                }  else if (text1.value.isNotEmpty()){
                    result.value = text1.value
                }
                else if (text2.value.isNotEmpty()){
                    result.value = text2.value
                }else {
                    result.value = "Please enter numbers"
                }
            },
                modifier = Modifier
                    .size(71.dp) // Ensure the button is circular by setting a fixed size
                    .clip(CircleShape), // Apply the CircleShape
                shape = CircleShape
                ) {
                Text("*")
            }

            Button(onClick = {
                if (text1.value.isNotEmpty() && text2.value.isNotEmpty()) {
                    val rs = text1.value.toDouble() / text2.value.toDouble()
                    result.value = rs.toString()
                } else if (text1.value.isNotEmpty()){
                    result.value = text1.value
                }
                else if (text2.value.isNotEmpty()){
                    result.value = text2.value
                } else {
                    result.value = "Please enter numbers"
                }
            },
                modifier = Modifier
                    .size(71.dp) // Ensure the button is circular by setting a fixed size
                    .clip(CircleShape), // Apply the CircleShape
                shape = CircleShape
                ) {
                Text("/")
            }

            Button(onClick = {
                if (text1.value.isNotEmpty() && text2.value.isNotEmpty()) {
                    val rs = text1.value.toDouble() % text2.value.toDouble()
                    result.value = rs.toString()
                } else if (text1.value.isNotEmpty()){
                    result.value = text1.value
                }
                else if (text2.value.isNotEmpty()){
                    result.value = text2.value
                } else {
                    result.value = "Please enter numbers"
                }
            },
                modifier = Modifier
                    .size(71.dp) // Ensure the button is circular by setting a fixed size
                    .clip(CircleShape), // Apply the CircleShape
                shape = CircleShape
                ) {
                Text("%")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}
