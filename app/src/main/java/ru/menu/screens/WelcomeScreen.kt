package ru.menu.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ru.menu.R

import ru.menu.navigation.NavRoute
import ru.menu.ui.theme.MenuTheme

val orange = Color(0xFFEC8D01)
val yellow = Color(0xFFE4EC01)

@Composable
fun WelcomeScreen(navController: NavController) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color.Yellow,
                        Color.White,
                        orange
                    )
                )
            ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Row(modifier = Modifier
                .height(55.dp)
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Top
            ) {
                Image(
                    painter = painterResource(R.drawable.miem_gray),
                    contentDescription = "logo",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(50.dp)
                        .width(200.dp)
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text =  "Wiki",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }
            Text(
                text =  "Сервис хранения документации",
                fontSize = 15.sp,
                color = Color.LightGray,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(15.dp))
            OutlinedButton(
                onClick = {
                navController.navigate(NavRoute.Main.route)
            },
                modifier= Modifier
                    .height(30.dp)
                    .width(150.dp),
                border= BorderStroke(1.dp, Color.Gray),
                contentPadding = PaddingValues(0.dp),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Black)
            ) {
                Text(text="Войти")
                Spacer(modifier = Modifier.width(15.dp))
                Icon(
                    Icons.Default.ArrowForward,
                    contentDescription = "content description",
                    tint = yellow,
                    modifier = Modifier
                        .size(15.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun prevWelcomeScreen() {
    MenuTheme {
        WelcomeScreen(navController = rememberNavController())
    }
}