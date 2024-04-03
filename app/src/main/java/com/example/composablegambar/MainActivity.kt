package com.example.composablegambar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composablegambar.ui.theme.ComposableGambarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposableGambarTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Chosogun(
                        judul = stringResource(id = R.string.gun),
                        namegame = stringResource(id = R.string.name))
                }
            }
        }
    }
}

@Composable
fun namegun(choso : Int):String{
    return when(choso){
        1 -> "Desert Eagle"
        2 -> "Winchester"
        3 -> "AK-47"
        4 -> "P90"
        else -> "M21"
    }
}

@Composable
fun Background(judul:String){

    Image(
        painter = painterResource(id = R.drawable.background_button),
        contentDescription =null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop)
    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.fillMaxSize()

    ) {
        Text(
            text = judul,
            style = TextStyle(
                color = Color.White,
                textAlign = TextAlign.Center,
                fontSize = 56.sp,
                fontFamily = FontFamily(Font(R.font.cs_regular)),
                lineHeight = 48.sp

            )
        )
    }
}
@Composable
fun Chosogun(judul:String,namegame:String){

    var choso by remember {
        mutableIntStateOf(1)
    }

    val weapon = when(choso){
        1 -> R.drawable.deserteagle
        2 -> R.drawable.winchester
        3 -> R.drawable.ak47
        4 -> R.drawable.p90
        else -> R.drawable.m21
    }

    val sizegun = when(choso){
        1 -> Modifier.size(200.dp)
        3 -> Modifier.size(280.dp)
        4 -> Modifier.size(260.dp)
        else -> Modifier.size(300.dp)
    }
    Box(modifier = Modifier.fillMaxSize())
    {
        Background(judul = judul)

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(156.dp))
            Image(
                painter = painterResource(id = weapon),
                contentDescription = namegun(choso),
                modifier = sizegun
            )
            Spacer(modifier = Modifier.height(80.dp))
        }
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(480.dp))
            Button(onClick = {
                if (choso < 5) {
                    choso++
                } else {
                    choso = 1
                }
            },
                modifier = Modifier.size(152.dp,52.dp),
                colors =ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.merah_marun)
                ) ) {
                Text(
                    text = stringResource(R.string.Next),
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.cs_regular)),
                        fontSize = 32.sp,
                        color = colorResource(id = R.color.abu_cerah)
                    )
                )
            }
            Spacer(modifier = Modifier.height(184.dp))
            Text(
                text =namegame,
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    fontSize = 24.sp,
                    fontFamily = FontFamily(Font(R.font.cs_regular))
                )
            )
        }
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(400.dp))
            Text(
                text = namegun(choso),
                style = TextStyle(
                    color = Color.White,
                    fontSize = 24.sp,
                    fontFamily = FontFamily(Font(R.font.cs_regular))
                )
            )
        }


    }
}



@Preview(showBackground = true)
@Composable
fun GrettingPreview(){
    ComposableGambarTheme {
        Chosogun(
            judul = stringResource(id = R.string.gun),
            namegame = stringResource(id = R.string.name) )
    }
}
