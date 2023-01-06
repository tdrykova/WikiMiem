package ru.menu.screens

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ru.menu.ui.theme.MenuTheme

@Composable
fun DigestsMIEMScreen(navController: NavController) {
    Scaffold() {
        Text(text = "DigestsMIEM Screen")
    }
}

@Preview(showBackground = true)
@Composable
fun prevDigestsMIEMScreen() {
    MenuTheme {
        DigestsMIEMScreen(navController = rememberNavController())
    }
}