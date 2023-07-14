package com.dcl.jetpackcomposetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dcl.jetpackcomposetest.ui.theme.JetpackComposeTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier) {
    JetpackComposeTutorial(modifier = modifier)
//    TaskManagerTutorial(modifier = modifier)
//    ComposeQuadrantTutorial(modifier = modifier)
}

@Composable
fun ComposeQuadrantTutorial(modifier: Modifier = Modifier) {
    val firstQColor = Color(0xFFEADDFF)
    val secondQColor = Color(0xFFD0BCFF)
    val thirdDColor = Color(0xFFB69DF8)
    val forthQColor = Color(0xFFF6EDFF)

    Row(modifier = modifier
    ) {
        Quadrant(
            title = "Text composable",
            body = "Displays text and follows the recommended Material Design guidelines",
            color = firstQColor
        )
        Quadrant(
            title = "Image composable",
            body = "Creates a composable that lays out and draws a given Painter class object.",
            color = secondQColor
        )
    }

}

@Composable
fun Quadrant(title: String, body: String, color: Color, modifier: Modifier = Modifier) {
    Card(modifier = modifier.background(color = color),
        ) {
        Column(
            modifier = modifier.weight(2f, true),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = modifier.padding(bottom = 16.dp),
                text = title,
                fontWeight = FontWeight.Bold
            )
            Text(text = body)
        }
    }
}


@Composable
fun TaskManagerTutorial(modifier: Modifier = Modifier) {
    Column(modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        TaskSuccessImage(modifier = modifier)
        Text(
            modifier = modifier.padding(top = 24.dp, bottom = 8.dp),
            text = "All tasks completed",
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Text(text = "Nice work!", fontSize = 16.sp, textAlign = TextAlign.Justify)
    }
}

@Composable
fun TaskSuccessImage(modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.ic_task_completed)
    
    Image(
        modifier = modifier.size(120.dp),
        painter = image, 
        contentDescription = "task completed",
    )
}

@Composable
fun JetpackComposeTutorial(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        AppBarImage()
        TitlePart()
        ParagraphPart()
        BodyPart()
    }
}

@Composable
fun AppBarImage(modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.bg_compose_background)

    Image(
        modifier = modifier.fillMaxWidth(),
        painter = image,
        contentDescription = "compose background"
    )
}

@Composable
fun TitlePart(modifier: Modifier = Modifier) {
    Text(
        text = "Jetpack Compose tutorial",
        modifier = modifier.padding(16.dp),
        fontSize = 24.sp
    )
}

@Composable
fun ParagraphPart(modifier: Modifier = Modifier) {
    Text(
        text = "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.",
        modifier = modifier.padding(start = 16.dp, end = 16.dp),
        textAlign = TextAlign.Justify
    )
}

@Composable
fun BodyPart(modifier: Modifier = Modifier) {
    Text(
        text = "In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app\'s UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI\'s construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name.",
        modifier = modifier.padding(
            start = 16.dp,
            end = 16.dp,
            top = 16.dp
        ),
        textAlign = TextAlign.Justify
    )
}