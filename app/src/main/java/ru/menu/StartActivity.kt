package ru.menu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import ru.menu.navigation.WikiNavHost
import ru.menu.ui.theme.*

class StartActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MenuTheme {
                Scaffold() {
                    WikiNavHost()
            }

    }
}
    }
}



