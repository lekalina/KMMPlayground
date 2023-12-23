
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import ui.navigation.BottomNavigation
import ui.navigation.NavRoute
import ui.navigation.NavigationVM
import ui.screens.CharacterScreen
import ui.screens.HomeScreen
import ui.screens.ImageScreen

@Composable
fun App() {
    val navigationVM = getViewModel(Unit, viewModelFactory { NavigationVM() })
    MaterialTheme {
        BaseContent(navigationVM)
    }
}

@Composable
fun BaseContent(
    navVM: NavigationVM
) {
    val currentScreen by navVM.currentScreen.collectAsState()
    Box(modifier = Modifier.fillMaxSize()) {
        when(currentScreen) {
            NavRoute.Characters -> CharacterScreen()
            NavRoute.SampleImages -> ImageScreen()
            NavRoute.Home -> HomeScreen()
        }
        Box(modifier = Modifier.align(Alignment.BottomCenter)) {
            BottomNavigation(navVM)
        }
    }
}
