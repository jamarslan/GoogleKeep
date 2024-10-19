package com.example.keepnotes.navigation.graph

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.keepnotes.R
import com.example.keepnotes.data.auth.GoogleUser
import com.example.keepnotes.data.auth.SignInResult
import com.example.keepnotes.data.local.InMemoryCache
import com.example.keepnotes.navigation.screen.Screen
import com.example.keepnotes.presentation.common.ProgressIndicator
import com.example.keepnotes.presentation.screen.loginscreen.LoginScreen
import com.example.keepnotes.presentation.screen.loginscreen.LoginViewModel
import com.example.keepnotes.presentation.screen.loginscreen.SignInViewModel
import com.example.keepnotes.presentation.screen.splash.SplashScreen
import kotlinx.coroutines.launch

@Composable
fun RootNavigationGraph(navHostController: NavHostController) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    NavHost(
        navController = navHostController,
        route = Graph.ROOT,
        startDestination = Screen.Splash.route // Start with Splash screen as usual
    ) {
        composable(route = Screen.Splash.route) {
            SplashScreen(navController = navHostController)
        }

        composable(route = Screen.Login.route) {
            // Skip the login screen and directly navigate to the main screen
            LaunchedEffect(Unit) {
                // Show a toast or perform other actions if needed
                Toast.makeText(
                    context.applicationContext,
                    "Skipping sign-in, navigating to main screen.",
                    Toast.LENGTH_SHORT
                ).show()

                // Directly navigate to the main screen
                navHostController.navigate(Graph.MAIN)
            }
        }

        composable(route = Graph.MAIN) {
            MainNavGraph()
        }
    }
}
