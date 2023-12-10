package di

import data.helpers.NetworkCreator
import domain.repos.StarWarsRepo
import org.koin.dsl.module
import ui.StarWarsVM

fun appModule() = module {
    single { NetworkCreator() }
    single { StarWarsRepo(get()) }
    viewModelDefinition { StarWarsVM(get()) }
}