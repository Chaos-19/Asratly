package com.chaos.asratly.ui.navigation;

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.chaos.asratly.ui.screen.home.HomeScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(navController = navController)
        }
    }
}
/*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.chaos.asratly.ui.screen.home.HomeScreen
//import com.chaos.asratly.ui.onboarding.OnboardingScreen
import com.chaos.asratly.ui.screen.debts.DebtScreen
import com.chaos.asratly.ui.screen.asrat.AsratScreen
import com.chaos.asratly.ui.screen.setting.SettingsScreen
//import com.chaos.asratly.ui.splash.SplashViewModel

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(navController = navController)
        }
    }
}

/
@Composable
fun AppNavGraph(
    navController: NavHostController,
    //splashViewModel: SplashViewModel
) {
    val startDestination = Screen.Home.route

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        /*
        composable(Screen.Onboarding.route) {
            OnboardingScreen(
                navController = navController
            )
        }
        */
        composable(Screen.Home.route) {
            HomeScreen(
                navController = navController
            )
        }
        composable(Screen.Debts.route) {
            DebtScreen(
                navController = navController,
                //viewModel = signUpViewModel
            )
        }
        composable(Screen.Asrat.route) {
            AsratScreen(
                navController = navController
            )
        }
        composable(Screen.Settings.route) {
            SettingsScreen(
                navController = navController
            )
        }
    }
}
*/