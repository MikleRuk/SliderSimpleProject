package com.example.slidersimpleproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderPositions
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.slidersimpleproject.ui.theme.SliderSimpleProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SliderSimpleProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DemoScreen()
                }
            }
        }
    }
}

@Composable
fun DemoText(message: String, fontSize: Float) {
    Text(
        text = message,
        fontSize = fontSize.sp,
        fontWeight = FontWeight.Bold
    )
}


@Preview(showSystemUi = true, device = "spec:width=1080px,height=2340px,dpi=480")
@Composable
fun DemoTextPreview() {
    SliderSimpleProjectTheme {
       DemoScreen()
    }
}


@Composable
fun DemoSlider(sliderPositions: Float, onPositionChange: (Float) -> Unit) {

    Slider(
        modifier = Modifier.padding(10.dp),
        valueRange = 20f..38f,
        value = sliderPositions,
        onValueChange = onPositionChange
    )

}


@Composable
fun DemoScreen() {

    var sliderPosition by remember { mutableStateOf(20f) }
    val handlePositionChange = { position: Float -> sliderPosition = position }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {

        DemoText(message ="Welcome to the club Buddy" , fontSize = sliderPosition )
        Spacer(modifier = Modifier.height(150.dp))


        DemoSlider(sliderPositions = sliderPosition, onPositionChange = handlePositionChange)


        Text(
            style = MaterialTheme.typography.headlineMedium,
            text = sliderPosition.toInt().toString()+"sp")

        
    }


}