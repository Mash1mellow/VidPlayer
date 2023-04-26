package com.alexander.vidplayer

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.alexander.vidplayer.ui.theme.VidPlayerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VidPlayerTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    val context = LocalContext.current
    val mper = MediaPlayer()
    var jpg = arrayListOf(
        R.drawable.jkt,
        R.drawable.pantai,
        R.drawable.cermin,
        R.drawable.pura,
        R.drawable.borobudur,
    )

    var teext = arrayListOf(
        "Jakarta ", "Pantai Seminyak", "Pantai Cermin", "Candi Pura", "Candi Borobudur"
    )

    Column {
        Text(text = "Indonesia")
        Button(onClick = {
            mper.reset()
            context.startActivity(Intent(context, VideoActivity::class.java))
        }) {
            Text(text = "Sejarah Indonesia")
        }

        LazyColumn {
            items(5) { index ->
                Text(text = teext [index % 5])
                Image(
                    painterResource(id = jpg[index % 5]),
                    contentDescription = "123"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    VidPlayerTheme {
        Greeting("Android")
    }
}