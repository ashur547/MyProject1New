package com.example.examen4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

private const val LAST_SELECTID_ITEM = "item"
private val BALL_FLY_FRAGMENT = BallFlyFragment().javaClass.name
private val ABOUT_FRAGMENT = AboutFragment().javaClass.name

class MainActivity : AppCompatActivity() {

    lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottom_navigation)

        bottomNavigationView.setOnItemSelectedListener { item->
            var fragment: Fragment? = null
            when (item.itemId){
                R.id.fly_ball -> {
                        fragment = if (savedInstanceState != null)supportFragmentManager.getFragment(
                            savedInstanceState,
                            BALL_FLY_FRAGMENT
                        ) else BallFlyFragment()
                }
                R.id.about -> {
                        fragment = if (savedInstanceState != null)supportFragmentManager.getFragment(
                            savedInstanceState,
                            ABOUT_FRAGMENT
                        ) else AboutFragment()
                }
            }
            replaceFragment(fragment!!)
            true
        }

        bottomNavigationView.selectedItemId =
            savedInstanceState?.getInt(LAST_SELECTID_ITEM) ?: R.id.fly_ball

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(LAST_SELECTID_ITEM, bottomNavigationView.selectedItemId)

        val currentFragment = supportFragmentManager.fragments.last()
        supportFragmentManager.putFragment(
            outState,
            currentFragment.javaClass.name,
            currentFragment
        )
    }

        private fun replaceFragment(fragment: Fragment) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_contaner, fragment)
                .commit()

        }
    }