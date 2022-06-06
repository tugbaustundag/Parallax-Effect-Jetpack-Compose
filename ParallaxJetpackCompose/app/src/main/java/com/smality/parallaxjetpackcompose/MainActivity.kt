package com.smality.parallaxjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import com.jetpack.parallaxeffect.ui.theme.ParallaxEffectTheme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //ParallaxEffect fonk kullanmak için scroll yapma durumunu tanımlıyoruz.
            val scrollState = rememberScrollState()
            ParallaxEffectTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Scaffold() {
                        ParallaxEffect(scrollState)
                    }
                }
            }
        }
    }
}

