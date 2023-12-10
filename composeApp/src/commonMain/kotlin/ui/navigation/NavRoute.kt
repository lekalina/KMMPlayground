package ui.navigation

sealed class NavRoute(val route: String, val title: String? = null, val icon: String? = null) {
    data object Characters: NavRoute(route = "characters", title = "Characters", icon = "ic_characters.xml")
    data object SampleImages: NavRoute(route = "sample_images", title = "Images", icon = "ic_image.xml")
    data object Home: NavRoute(route = "home", title = "Home", icon = "andy.xml")
}