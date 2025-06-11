package com.khater.weather.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import com.khater.weather.ui.screens.homeScreen.HomeScreen
import com.khater.weather.ui.screens.homeScreen.HomeViewModel
import com.khater.weather.ui.screens.homeScreen.composables.VerticalSpacer
import com.khater.weather.ui.theme.WeatherTheme
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        enableEdgeToEdge()
        setContent {

            val homeViewModel: HomeViewModel = koinViewModel()

            WeatherTheme(isDarkTheme = !homeViewModel.homeUiState.isDay) {
                if (homeViewModel.homeUiState.isLoading) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        VerticalSpacer(
                            height = WindowInsets.statusBars.asPaddingValues().calculateTopPadding()
                        )

                        CircularProgressIndicator()
                    }
                } else if (homeViewModel.homeUiState.error != null) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text(text = homeViewModel.homeUiState.error.toString(), color = White)
                    }
                } else {
                    HomeScreen(homeViewModel.homeUiState)
                }


            }


        }
    }
}

