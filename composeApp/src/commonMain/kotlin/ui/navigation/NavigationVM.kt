package ui.navigation

import dev.icerock.moko.mvvm.livedata.MutableLiveData
import dev.icerock.moko.mvvm.livedata.postValue
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class NavigationVM: ViewModel() {

    private val _currentScreen = MutableStateFlow<NavRoute>(NavRoute.Home)
    val currentScreen = _currentScreen
    private val routeBackStack = mutableListOf<NavRoute>(NavRoute.Home)
    val bottomNavItems = listOf(NavRoute.Home, NavRoute.Characters, NavRoute.SampleImages)

    fun navigate(route: NavRoute) {
        if (currentScreen.value != route) {
            currentScreen.update { route }
            updateBackStack(route)
        }
    }

    fun back() {
        routeBackStack.remove(currentScreen.value)
        currentScreen.update { routeBackStack.last() }
    }

    private fun updateBackStack(route: NavRoute) {
        routeBackStack.remove(route)
        routeBackStack.add(route)
    }
}