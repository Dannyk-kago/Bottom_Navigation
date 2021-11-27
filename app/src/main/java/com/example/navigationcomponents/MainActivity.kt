package com.example.navigationcomponents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.navigationcomponents.fragments.DashboardFragment
import com.example.navigationcomponents.fragments.InfoFragment
import com.example.navigationcomponents.fragments.SettingsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val dashboardFragment = DashboardFragment()
    private val settingsFragment = SettingsFragment()
    private val infoFragment = InfoFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceFragment(dashboardFragment)

        bottom_navigation.setOnNavigationItemSelectedListener{
            when(it.itemId){
               R.id.ic_dashboard -> replaceFragment(dashboardFragment)
               R.id.ic_settings -> replaceFragment(settingsFragment)
               R.id.ic_info -> replaceFragment(infoFragment)
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        if (fragment != null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container,fragment)
            transaction.commit()
        }
    }
}