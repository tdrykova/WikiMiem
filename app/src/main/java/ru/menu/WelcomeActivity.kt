package ru.menu


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity

val darkYellow = Color(0xFFFFC107)
val orange = Color(0xFFE98030)

class WelcomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WelcomeScreen()
        }
        fun NextScreen() {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}

@Composable @Preview (showBackground = true)
fun WelcomeScreen() {
    val context = LocalContext.current
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
                painter = painterResource(id = R.drawable.miem_gray),
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
        OutlinedButton(onClick = {
            context.startActivity(Intent(context, MainActivity::class.java))
        },
            modifier= Modifier
                .height(30.dp)
                .width(150.dp),
            border= BorderStroke(1.dp, Color.Gray),
            contentPadding = PaddingValues(0.dp),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Black)
        ) {
            // Adding an Icon "Add" inside the Button
            Text(text="Войти")
            Spacer(modifier = Modifier.width(15.dp))
            Icon(
                Icons.Default.ArrowForward,
                contentDescription = "content description",
                tint = darkYellow,
                modifier = Modifier
                    .size(15.dp)
            )
        }
    }
}

//@Composable
//fun NextScreen() {
//    val context = LocalContext.current
//    context.startActivity(Intent(context, MainActivity::class.java))
//}


