package com.example.cams

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    lateinit var toggle:ActionBarDrawerToggle
    lateinit var drawer:DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        drawer=findViewById(R.id.drawer)
        toggle = ActionBarDrawerToggle(this, drawer, R.string.open, R.string.close)
        drawer.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val nav: NavigationView =findViewById(R.id.nav)
        nav.setNavigationItemSelectedListener {
            it.isChecked=true
            when (it.itemId) {
                R.id.home->{
                    replaceFragment(HomeFragment())
                }
                R.id.pos -> {
                    replaceFragment(ProblemToSolveFragment())
                }
                R.id.wic -> {
                    replaceFragment(WhatIsCamsFragment())
                }
                R.id.vth -> {
                    replaceFragment(VolunteerToHelpFragment())
                }
                R.id.bad -> {
                    replaceFragment(BookADemoFragment())
                }
            }
            true
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frag, fragment)
        fragmentTransaction.commit()
        drawer.closeDrawers()

    }
}