package com.khater.weather
import android.app.Application
 import com.khater.weather.di.modules.dataSourceModule
import com.khater.weather.di.modules.networkModule
import com.khater.weather.di.modules.repositoryModule
import com.khater.weather.di.modules.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
class WeatherApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@WeatherApplication)
            modules(dataSourceModule,networkModule, repositoryModule,viewModelModule) // Load your modules here
        }
    }
}