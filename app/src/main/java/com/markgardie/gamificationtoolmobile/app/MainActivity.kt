package com.markgardie.gamificationtoolmobile.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.markgardie.gamificationtoolmobile.core.theme.GamificationToolMobileTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GamificationToolMobileTheme {
                GamificationNavHost()
            }
        }
    }
}

