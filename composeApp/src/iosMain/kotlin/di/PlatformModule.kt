package di

import domain.repos.ImageRepo
import org.koin.dsl.module
import ui.ImageVM

actual fun platformModule() = module {
    single { dataStore() }
    single { ImageRepo(get()) }
    viewModelDefinition { ImageVM(get()) }
}