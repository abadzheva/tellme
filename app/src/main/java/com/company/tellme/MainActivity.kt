package com.company.tellme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

private const val LAST_SELECTED_ITEM  = "LAST_SELECTED_ITEM"
private val PREDICTER_FRAGMENT = PredicterFragment().javaClass.name
private val AFFIRMATION_FRAGMENT = AffirmationFragment().javaClass.name
private val COLOR_FRAGMENT = ColordayFragment().javaClass.name

class MainActivity : AppCompatActivity() {

    private lateinit var bottomMenu: BottomNavigationView

    private var affirmationFragment = AffirmationFragment()
    private var colorFragment = ColordayFragment()
    private var predicterFragment = PredicterFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomMenu = findViewById(R.id.bottom_navigation_menu)

        bottomMenu.setOnItemSelectedListener { item ->
            var fragment: Fragment? = null
            when (item.itemId) {
                R.id.affirmation -> {
                    fragment =
                        savedInstanceState?.let {
                            supportFragmentManager.getFragment(it, AFFIRMATION_FRAGMENT)
                        } ?:affirmationFragment
                }

                R.id.predicter -> {
                    fragment =
                        savedInstanceState?.let {
                            supportFragmentManager.getFragment(it, PREDICTER_FRAGMENT)
                        } ?:predicterFragment
                }

                R.id.colorday -> {
                    fragment =
                        savedInstanceState?.let {
                            supportFragmentManager.getFragment(it, COLOR_FRAGMENT)
                        } ?:colorFragment
                }
            }
            replaceFragment(fragment!!)
            true
        }



        bottomMenu.selectedItemId =
            savedInstanceState?.getInt(LAST_SELECTED_ITEM) ?: R.id.affirmation
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(LAST_SELECTED_ITEM, bottomMenu.selectedItemId)
        val fragment = supportFragmentManager.fragments.last()
        supportFragmentManager.putFragment(outState, fragment.javaClass.name, fragment)
        super.onSaveInstanceState(outState)


    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}