package com.alexander.vidplayer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.alexander.vidplayer.ui.theme.VidPlayerTheme

class VideoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VidPlayerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting2("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String) {
    val context = LocalContext.current
    val link = "https://rr4---sn-o097znz7.googlevideo.com/videoplayback?expire=1682513753&ei=-cpIZKbLHeKG_9EP3ouG0AM&ip=198.199.101.47&id=o-AAqN64Yqvy8tqBeqVgtJQp25GiKGqDK_R86J8aVXUy1V&itag=22&source=youtube&requiressl=yes&mh=Tv&mm=31,26&mn=sn-o097znz7,sn-q4flrnsd&ms=au,onr&mv=m&mvi=4&pl=24&initcwndbps=147500&spc=qEK7BwzgSN7qZ8dVaZ5o14dfhIZlCd532ecnE5O_YQ&vprv=1&mime=video/mp4&ns=gjDQplyKJ7Ja03kW7sbVVnQN&cnr=14&ratebypass=yes&dur=1165.455&lmt=1648905877581839&mt=1682491986&fvip=4&fexp=24007246&c=WEB_EMBEDDED_PLAYER&txp=5532434&n=q5mBNJ3nsQwWvGmLF&sparams=expire,ei,ip,id,itag,source,requiressl,spc,vprv,mime,ns,cnr,ratebypass,dur,lmt&sig=AOq0QJ8wRQIhANOF5C3m9sucA5_jT-A8qtZSzlm4cCGAkuIcHl_Ys7-UAiAYpMlstm9SXAutbIzkq48JPj_Zb-REZquA0xp93H7KCw==&lsparams=mh,mm,mn,ms,mv,mvi,pl,initcwndbps&lsig=AG3C_xAwRgIhAJ3T0qaY-4pKPF9htQyyJ5YRmC91prORZYTYRGe9D1LVAiEA_Z9hJTQlE0yPNWgUtEpdOgwjAEc6t5BC0b4W-0VVmtk=&title=Sejarah%20Pulau-Pulau%20Indonesia"
    val exoPlayer = ExoPlayer.Builder(context).build()
    val mediaItem = MediaItem.fromUri(android.net.Uri.parse(link))
    exoPlayer.setMediaItem(mediaItem)
    val playerView = PlayerView(context)
    playerView.player = exoPlayer

    DisposableEffect(AndroidView(factory = {playerView})){
        exoPlayer.prepare()
        exoPlayer.playWhenReady = true
        onDispose{
            exoPlayer.release()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    VidPlayerTheme {
        Greeting2("Android")
    }
}