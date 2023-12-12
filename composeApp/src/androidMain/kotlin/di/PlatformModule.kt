package di

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

actual fun platformModule() = module {
    single {
        dataStore(androidContext())
    }
}