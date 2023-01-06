package ru.menu.screens

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ru.menu.ui.theme.MenuTheme

@Composable
fun OtherScreen(navController: NavController) {
    Scaffold() {
        Text(text = "Other Screen")
    }
}

@Preview(showBackground = true)
@Composable
fun prevOtherScreen() {
    MenuTheme {
        OtherScreen(navController = rememberNavController())
    }
}