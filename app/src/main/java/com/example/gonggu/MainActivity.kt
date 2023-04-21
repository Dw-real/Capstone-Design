package com.example.gonggu

import android.Manifest.permission.ACCESS_FINE_LOCATION

import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Base64
import android.util.Log
import androidx.annotation.RequiresApi
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.gonggu.databinding.ActivityMainBinding
import java.security.MessageDigest

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}

    @RequiresApi(Build.VERSION_CODES.P)
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

        // 해시키 구하기
        try {
            val information =
                packageManager.getPackageInfo(packageName, PackageManager.GET_SIGNING_CERTIFICATES)
            val signatures = information.signingInfo.apkContentsSigners
            val md = MessageDigest.getInstance("SHA")
            for (signature in signatures) {
                val md: MessageDigest
                md = MessageDigest.getInstance("SHA")
                md.update(signature.toByteArray())
                var hashcode = String(Base64.encode(md.digest(), 0))
                Log.d("hashcode", "" + hashcode)
            }
        } catch (e: Exception) {
            Log.d("hashcode", "에러::" + e.toString())

        }
    }

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