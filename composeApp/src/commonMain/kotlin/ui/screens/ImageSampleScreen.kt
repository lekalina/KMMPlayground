package ui.screens

import Greeting
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import ui.common.animations.PreviewSnowfallAnimation


@OptIn(ExperimentalResourceApi::class)
@Composable
fun ImageScreen() {
    var greetingText by remember { mutableStateOf("Hello World!") }
    var showImage by remember { mutableStateOf(false) }
    LazyColumn(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        item {
            Button(onClick = {
                greetingText = "Compose: ${Greeting().greet()}"
                showImage = !showImage
            }) {
                Text(greetingText)
            }
        }
        item { AnimatedVisibility(showImage) {
            Image(
                painterResource("compose-multiplatform.xml"),
                null
            )
        } }
        item { ImageLoadedFromUrl() }
        item { ImageLoadedFromVectorAsset() }
        item {
            PreviewSnowfallAnimation()
        }
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun ImageLoadedFromVectorAsset() {
    Box(modifier = Modifier.size(height = 150.dp, width = 200.dp)) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource("andy.xml"),
            contentDescription = "Andy the Android",
        )
    }
}

@Composable
fun ImageLoadedFromUrl() {
    Box(modifier = Modifier.size(height = 200.dp, width = 400.dp)) {
        KamelImage(
            resource = asyncPainterResource("https://i.pinimg.com/originals/6b/84/0a/6b840a6f2b2a69938b34f2483cebd3c1.jpg"),
            contentDescription = "Image of a maltese puppy"
        )
    }
}

