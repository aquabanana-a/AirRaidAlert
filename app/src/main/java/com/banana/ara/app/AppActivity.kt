package com.banana.ara.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.banana.ara.R
import com.google.android.material.navigation.NavigationView

class AppActivity : AppCompatActivity() {

    private lateinit var navigationView: NavigationView
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationController: NavController
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupNavigation()
    }

    private fun setupNavigation() {
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        drawerLayout = findViewById(R.id.rootLayout)
        navigationView = findViewById(R.id.navigationView)
        navigationController = Navigation.findNavController(this, R.id.navigationHost)
        NavigationUI.setupActionBarWithNavController(this, navigationController, drawerLayout)
        NavigationUI.setupWithNavController(navigationView, navigationController)

        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> navigationController.navigate(R.id.homeFragment)
                R.id.nav_map -> navigationController.navigate(R.id.mapFragment)
                R.id.nav_history -> navigationController.navigate(R.id.historyFragment)
                R.id.nav_about -> navigationController.navigate(R.id.aboutFragment)
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }
}