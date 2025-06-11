# Weather-Ktor-Client 💦: 

<a href="https://www.linkedin.com/in/khateer/">
    <img src="https://img.shields.io/badge/LinkedIn-blue?style=for-the-badge&logo=linkedin&logoColor=white" alt="LinkedIn Badge"/>
  </a>
  
 **Weather App** That's Built With Kotlin to get accurate, real-time weather information with a beautiful, user-friendly interface that makes checking the weather a delightful experience. This repository contains a Weather App This is an educational App at the chance. Use and run this App to learn more about Apps design and best practices. That's built with Kotlin language with compose, That's implements Coroutines,Ktor-client for HTTP requests,clean architecture,koin,etc. 

 ![](https://i.ibb.co/sp6v0yVg/weather-cover.png)
 
 ## Features
- 🌡️ Current Weather Conditions
- ⏲️ Hourly Weather Forecast per current day
- 📅 Weekly Weather Forecast

 ## App Overview

Authentication Screens
<div align="center">
  <img src="https://i.ibb.co/4wHX2PgC/IMG-20250611-16270490.jpg" width="300" />
  <img src="https://i.ibb.co/fz5BjcV7/Screenshot-2025-06-11-16-26-58-64-866e054aaf05788d90cdc472497efeb2.jpg" width="300" />
</div>

## App Demo Videos

<div align="center">
  <video width="400" controls>
    <source src="https://github.com/khaatteerr/weather-app-assets/blob/main/Record_2025-06-09-19-41-24_866e054aaf05788d90cdc472497efeb2.mp4" type="video/mp4">
  </video>
  <video width="400" controls>
    <source src="https://github.com/khaatteerr/weather-app-assets/blob/main/Record_2025-06-11-17-23-51_866e054aaf05788d90cdc472497efeb2.mp4" type="video/mp4">
  </video>
</div>
## Built With 🛠

*  [Kotlin](https://kotlinlang.org/) 
*  [Jetpack Compose](https://developer.android.com/jetpack/compose) 
*  [Coroutines](https://developer.android.com/kotlin/coroutines)
*  MVVM architecture
*  Clean architecture
*  [Koin](https://insert-koin.io/) 
*  [Ktor-Client](https://ktor.io/docs/getting-started-ktor-client-multiplatform-mobile.html)
*  [Serialization](https://kotlinlang.org/docs/serialization.html/)
*  Single activity concept 
*  Repository pattern

 ## Project Structure
```
weather app

📂 app
└── 📂 weather
├── 📄 WeatherApplication.kt
├── 📂 data
│   ├── 📂 networking
│   │   ├── 📄 ResponseToResult.kt
│   │   └── 📄 SafeCallNetworkConnection.kt
│   ├── 📂 repositories
│   │   ├── 📄 LocationRepositoryImpl.kt
│   │   └── 📄 WeatherRepositoryImpl.kt
│   ├── 📂 source
│   │   └── 📂 remote
│   │       ├── 📂 dataSource
│   │       │   ├── 📂 location
│   │       │   │   ├── 📄 LocationDataSource.kt
│   │       │   │   └── 📄 LocationRemoteDataSource.kt
│   │       │   └── 📂 weather
│   │       │       ├── 📄 WeatherDataSource.kt
│   │       │       └── 📄 WeatherRemoteDataSource.kt
│   │       └── 📂 responseDto
│   │           ├── 📂 locationDto
│   │           │   ├── 📄 IpAddressResponseModel.kt
│   │           │   └── 📄 LocationResponseModel.kt
│   │           └── 📂 weatherDto
│   │               ├── 📄 CurrentUnitsWeatherResponseModel.kt
│   │               ├── 📄 CurrentWeatherResponseModel.kt
│   │               ├── 📄 DailyUnitsWeatherTemperatureResponseModel.kt
│   │               ├── 📄 DailyWeatherTemperatureResponseModel.kt
│   │               ├── 📄 HourlyUnitsResponseModel.kt
│   │               ├── 📄 HourlyWeatherResponseModel.kt
│   │               └── 📄 WeatherResponseModel.kt
│   └── 📂 utils
│       ├── 📄 Constants.kt
│       ├── 📄 ExceptionMapper.kt
│       └── 📄 NetworkException.kt
├── 📂 di
│   └── 📂 modules
│       ├── 📄 DataSourceModule.kt
│       ├── 📄 NetworkModule.kt
│       ├── 📄 RepositoryModule.kt
│       └── 📄 ViewModelModule.kt
├── 📂 domain
│   ├── 📂 entities
│   │   ├── 📂 locationEntity
│   │   │   ├── 📄 IpAddress.kt
│   │   │   └── 📄 Location.kt
│   │   └── 📂 weatherEntity
│   │       ├── 📄 CurrentUnitsWeather.kt
│   │       ├── 📄 CurrentWeather.kt
│   │       ├── 📄 DailyUnitsWeather.kt
│   │       ├── 📄 DailyWeather.kt
│   │       ├── 📄 HourlyUnits.kt
│   │       ├── 📄 HourlyWeather.kt
│   │       └── 📄 Weather.kt
│   ├── 📂 repositories
│   │   ├── 📄 LocationRepository.kt
│   │   └── 📄 WeatherRepository.kt
│   ├── 📂 usecases
│   │   └── 📄 GetWeatherUseCase.kt
│   └── 📂 utils
│       └── 📂 exceptions
│           ├── 📄 LocationException.kt
│           ├── 📄 WeatherException.kt
│           └── 📄 WeatherExceptions.kt
└── 📂 ui
├── 📄 MainActivity.kt
├── 📂 screens
│   └── 📂 homeScreen
│       ├── 📄 HomeScreen.kt
│       ├── 📄 HomeUiStateMapper.kt
│       ├── 📄 HomeViewModel.kt
│       ├── 📂 composables
│       │   ├── 📄 CurrentWeatherSection.kt
│       │   ├── 📄 ExtraWeatherInfoItem.kt
│       │   ├── 📄 ExtraWeatherSection.kt
│       │   ├── 📄 LocationSection.kt
│       │   ├── 📄 MinMaxTemperature.kt
│       │   ├── 📄 SectionLabel.kt
│       │   ├── 📄 Spacer.kt
│       │   ├── 📄 TodaySection.kt
│       │   ├── 📄 TodayWeatherItem.kt
│       │   ├── 📄 WeatherForecastCard.kt
│       │   └── 📄 WeatherForecastItem.kt
│       └── 📂 uiStates
│           ├── 📄 CurrentWeatherUiState.kt
│           ├── 📄 DailyForecast.kt
│           ├── 📄 ExtraWeatherInfoUiState.kt
│           ├── 📄 HomeUiState.kt
│           ├── 📄 HourlyWeatherUiState.kt
│           ├── 📄 TodayWeatherUiState.kt
│           └── 📄 WeeklyWeatherUiState.kt
```

## LICENSE
```MIT License

Copyright (c) 2025 khaatteerr

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
