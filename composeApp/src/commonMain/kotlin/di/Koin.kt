package di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoinAndroid(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(appModule())
}

fun initKoiniOS() = startKoin {
    modules(appModule())
}