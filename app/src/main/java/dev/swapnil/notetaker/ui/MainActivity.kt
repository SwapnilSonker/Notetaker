package dev.swapnil.notetaker.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import dev.swapnil.notetaker.R


class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //val splashScreen = installSplashScreen()


        setContentView(R.layout.activity_main)





        var navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
          navController = navHostFragment.navController

        //setting up action bar with navcontroller.
        setupActionBarWithNavController(navController)
    }

    override fun onNavigateUp(): Boolean {

        return navController.navigateUp() || super.onNavigateUp()
    }

}