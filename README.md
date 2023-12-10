# KMM Playground App
This is a Kotlin Multi-platform app that explores migrating an existing app written in kotlin jetpack compose into a KMM compose app capable of running on both Android and iOS. 
This app is specifically for the purpose of trying out new dependencies that run on both Android and iOS that replace existing Android only dependencies.
- Hilt -> Koin
- Retrofit -> Ktor
- AndroidX ViewModel -> MOKO MVVM
- Coil -> Kamel
- Gson -> Kotlinx-Serialization


### Architecture
The architecture pattern is base on the **Model-View-ViewModel (MVVM)** Pattern where there are 3 layers within the application:
- Data Layer: the data sources and repos related to data persistence, REST calls, etc.
- Domain Layer: high-level abstractions and use cases which contain the applications business logic & domain rules
- Presentation (UI) Layer: all functionality related to the user interface (activities, views, viewModels, etc)

This Kotlin Multiplatform project targets Android and iOS.

* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - `commonMain` is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    `iosMain` would be the right folder for such calls.

* `/iosApp` contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform, 
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.


Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…