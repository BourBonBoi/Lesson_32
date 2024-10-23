package com.example.constrainlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.constrainlayout.ui.theme.ConstrainLayoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ConstrainLayoutTheme {
                GreetingPreview()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (text, button, image) = createRefs()
        val bottomGuideLine = createGuidelineFromBottom(0.2f)

        Button(onClick = {

        },
            modifier = Modifier.constrainAs(button){
                bottom.linkTo(bottomGuideLine)
                top.linkTo(bottomGuideLine)
                end.linkTo(parent.end)
                start.linkTo(parent.start)
            }
        ) {
            Text(text = "click")
        }
        Text(
            text = "text",
            modifier = Modifier.constrainAs(text){
                bottom.linkTo(button.top, 16.dp)
                start.linkTo(button.start)
                end.linkTo(button.end)
            }
        )
        Image(painter = painterResource(id = R.drawable.img),
            contentDescription = "img",
            modifier = Modifier.constrainAs(image){
                bottom.linkTo(text.top, 16.dp)
                start.linkTo(button.start)
                end.linkTo(button.end)
            }
        )
    }
}