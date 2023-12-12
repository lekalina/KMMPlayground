package di

import data.helpers.NetworkCreator
import domain.repos.ImageRepo
import domain.repos.StarWarsRepo
import domain.source.LocalSource
import org.koin.dsl.module
import ui.ImageVM
import ui.StarWarsVM

fun sharedModule() = module {
    single { NetworkCreator() }
    single { LocalSource(get()) }
    single { StarWarsRepo(get()) }
    single { ImageRepo(get()) }
    viewModelDefinition { StarWarsVM(get()) }
    viewModelDefinition { ImageVM(get()) }
}