package com.chaos.asratly.ui.navigation;

sealed class Screen (val route:String){

   object Onboarding : Screen("onboarding_screen")
   object Home : Screen("home_screen")
   object Debts : Screen("debts_screen")
   object Asrat : Screen("asrat_screen")
   object Settings : Screen("settings_screen") 
   
}