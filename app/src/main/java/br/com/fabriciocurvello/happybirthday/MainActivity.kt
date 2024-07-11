package br.com.fabriciocurvello.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import br.com.fabriciocurvello.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HappyBirthdayTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GreetingText(
                        message = "Parabéns, Juliana!",
                        modifier = Modifier.padding(innerPadding),
                        from = "De Roberto"
                    )
                }
            }
        }
    }

}

@Composable
fun GreetingText(message: String, from:String, modifier: Modifier = Modifier) {
    Column {
        Text(text = message, fontSize = 92.sp, lineHeight = 116.sp)
        Text(text = from, fontSize = 36.sp)
    }

}

@Preview(showBackground = true,
    showSystemUi = true,
    name = "Meu Preview")
@Composable
fun GreetingPreview() {
    HappyBirthdayTheme {
        GreetingText(message = "Feliciades, Camila", from = "De Jenivaldo")
    }
}