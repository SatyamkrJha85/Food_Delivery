package com.theapplication.fooddelivery.ui

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.theapplication.fooddelivery.ui.Screens.AuthScreen
import com.theapplication.fooddelivery.ui.Screens.FoodScreen
import com.theapplication.fooddelivery.ui.Screens.HomeScreen
import com.theapplication.fooddelivery.ui.Screens.OnboardingScreen

@Composable
fun Navigation() {

    val navController= rememberNavController()

    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("main",Context.MODE_PRIVATE)
    val userLoggedIn = sharedPreferences.getBoolean("loggedin",false)
    NavHost(navController =navController , startDestination ="onbording" ) {
        composable("auth"){
            AuthScreen(navController)
        }
        composable("home"){
            HomeScreen(navController)
        }

        composable("food"){
            FoodScreen(navController)
        }
        composable("onbording"){
            OnboardingScreen(navController)
        }
    }
}