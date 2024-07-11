package br.com.fabriciocurvello.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fabriciocurvello.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HappyBirthdayTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GreetingImage(
                        message = stringResource(R.string.parabens_text),
                        from = "De Roberto"
                    )
                }
            }
        }
    }

}

@Composable
fun GreetingText(message: String, from:String, modifier: Modifier = Modifier) {
    Column ( verticalArrangement = Arrangement.Center, modifier = modifier ){
        Text(text = message, fontSize = 80.sp, lineHeight = 116.sp, textAlign = TextAlign.Center)
        Text(text = from, fontSize = 36.sp, modifier = Modifier
            .padding(16.dp)
            .align(alignment = Alignment.End))
    }
}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.androidparty)
    Box(modifier) {
        Image(painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop, // crop faz a imagem preencher toda a area
            alpha = 0.4F) // opacidade (de 0 a 1, em Float)
        GreetingText(message = message, from = from, modifier = Modifier
            .fillMaxSize()
            .padding(8.dp))
    }
}

@Preview(showBackground = true,
    showSystemUi = true,
    name = "Meu Preview")
@Composable
fun GreetingPreview() {
    HappyBirthdayTheme {
        GreetingImage(message = stringResource(R.string.feliciades_camila), from = stringResource(R.string.de_jenivaldo))
    }
}