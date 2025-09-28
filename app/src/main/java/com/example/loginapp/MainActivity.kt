package com.example.loginapp

import androidx.compose.ui.tooling.preview.Preview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginapp.ui.theme.Purple40
import com.example.loginapp.ui.theme.Purple80

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AuthScreen()
        }
    }
}

@Composable
fun AuthScreen() {
    var isLogin by remember { mutableStateOf(true) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Purple80, Purple40)
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.9f)),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = if (isLogin) "Login" else "Register",
                    fontSize = 28.sp,
                    color = Purple40
                )

                Spacer(modifier = Modifier.height(24.dp))

                if (isLogin) {
                    LoginForm()
                } else {
                    RegisterForm()
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = if (isLogin) "Don't have an account? Register" else "Already have an account? Login",
                    fontSize = 14.sp,
                    color = Purple40,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .clickable { isLogin = !isLogin }
                        .padding(top = 8.dp)
                )
            }
        }
    }
}

@Composable
fun LoginForm() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    OutlinedTextField(
        value = email,
        onValueChange = { email = it },
        label = { Text("Email") },
        singleLine = true,
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Purple40,
            unfocusedIndicatorColor = Color.Gray,
            focusedLabelColor = Purple40,
            cursorColor = Purple40
        ),
        modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.height(16.dp))

    OutlinedTextField(
        value = password,
        onValueChange = { password = it },
        label = { Text("Password") },
        singleLine = true,
        visualTransformation = PasswordVisualTransformation(),
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Purple40,
            unfocusedIndicatorColor = Color.Gray,
            focusedLabelColor = Purple40,
            cursorColor = Purple40
        ),
        modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.height(24.dp))

    Button(
        onClick = { /* TODO: login logic */ },
        colors = ButtonDefaults.buttonColors(containerColor = Purple40),
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Text(text = "Login", color = Color.White, fontSize = 16.sp)
    }
}

@Composable
fun RegisterForm() {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    OutlinedTextField(
        value = firstName,
        onValueChange = { firstName = it },
        label = { Text("First Name") },
        singleLine = true,
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Purple40,
            unfocusedIndicatorColor = Color.Gray,
            focusedLabelColor = Purple40,
            cursorColor = Purple40
        ),
        modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.height(16.dp))

    OutlinedTextField(
        value = lastName,
        onValueChange = { lastName = it },
        label = { Text("Last Name") },
        singleLine = true,
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Purple40,
            unfocusedIndicatorColor = Color.Gray,
            focusedLabelColor = Purple40,
            cursorColor = Purple40
        ),
        modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.height(16.dp))

    OutlinedTextField(
        value = email,
        onValueChange = { email = it },
        label = { Text("Email") },
        singleLine = true,
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Purple40,
            unfocusedIndicatorColor = Color.Gray,
            focusedLabelColor = Purple40,
            cursorColor = Purple40
        ),
        modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.height(16.dp))

    OutlinedTextField(
        value = password,
        onValueChange = { password = it },
        label = { Text("Password") },
        singleLine = true,
        visualTransformation = PasswordVisualTransformation(),
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Purple40,
            unfocusedIndicatorColor = Color.Gray,
            focusedLabelColor = Purple40,
            cursorColor = Purple40
        ),
        modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.height(16.dp))

    OutlinedTextField(
        value = confirmPassword,
        onValueChange = { confirmPassword = it },
        label = { Text("Confirm Password") },
        singleLine = true,
        visualTransformation = PasswordVisualTransformation(),
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Purple40,
            unfocusedIndicatorColor = Color.Gray,
            focusedLabelColor = Purple40,
            cursorColor = Purple40
        ),
        modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.height(24.dp))

    Button(
        onClick = { /* TODO: register logic */ },
        colors = ButtonDefaults.buttonColors(containerColor = Purple40),
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Text(text = "Register", color = Color.White, fontSize = 16.sp)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AuthPreview() {
    AuthScreen()
}