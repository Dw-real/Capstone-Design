package com.example.gonggu

import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.gonggu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        current = this
        setContentView(binding.root)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
        val navController = navHostFragment.navController
        // CAUTION: findNavController(R.id.fragment) in onCreate will fail.

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNav)
        bottomNavigationView?.setupWithNavController(navController)

    }
//    fun refresh(){
//        this.onResume()
//    }
    fun replaceFragment(fragment : Fragment) {
        Log.d("MainActivity","${fragment}")
        supportFragmentManager
            .beginTransaction()
            .apply {
                replace(R.id.fragment,fragment)
                    .addToBackStack(null)
                commit()
            }
    }
    companion object{
        lateinit var current : MainActivity
    }
}