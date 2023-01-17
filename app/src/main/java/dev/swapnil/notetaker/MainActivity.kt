package dev.swapnil.notetaker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.TransitionManager


class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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