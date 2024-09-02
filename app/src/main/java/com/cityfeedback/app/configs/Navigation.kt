import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cityfeedback.app.ui.pages.CreateRateScreen
import com.cityfeedback.app.ui.pages.HomeScreen
import com.cityfeedback.app.ui.pages.MainScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "main") {
        composable("main") {
            MainScreen(navController)
        }
        composable("create_review") {
            CreateRateScreen()
        }
    }
}