package com.example.liberty.ui.dashboard

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.liberty.R
import com.example.liberty.databinding.ActivityMainBinding
import com.example.liberty.ui.dashboard.account.AccountFragment
import com.example.liberty.ui.dashboard.allcourses.AllCoursesFragment
import com.example.liberty.ui.dashboard.home.HomeFragment
import com.example.liberty.ui.dashboard.mycourses.MyCoursesFragment
import com.example.liberty.ui.dashboard.quiz.QuizFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    companion object {
        const val SHARED_PREFS = "shared_prefs"
    }

    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedpreferences: SharedPreferences
    private var number: String? = null
    private var passwoed: String? = null

    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle

    private var homeFragment: Fragment = HomeFragment()
    private var allCoursesFragment: Fragment = AllCoursesFragment()
    private var myCoursesFragment: Fragment = MyCoursesFragment()
    private var quizFragment: Fragment = QuizFragment()
    private var accountFragment: Fragment = AccountFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        sharedpreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)


        setClickListeners()


        binding.tvBadge.visibility = View.VISIBLE
        val badgeCount = 5
        binding.tvBadge.text = badgeCount.toString()

        actionBarDrawerToggle =
            ActionBarDrawerToggle(this, binding.drawerLl, R.string.nav_open, R.string.nav_close)
        binding.drawerLl.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)


        binding.navigationViewButton.setOnNavigationItemSelectedListener(this)
        binding.navigationViewButton.selectedItemId = R.id.home
    }

    /* override fun onBackPressed() {
         super.onBackPressed()
         val editor = sharedpreferences.edit()
         editor.clear()
         editor.apply()
         val i = Intent(this, LoginActivity::class.java)
         startActivity(i)
         finish()
     }*/
    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.home -> {
                supportFragmentManager.beginTransaction().replace(R.id.frame_ll, homeFragment)
                    .commit()
                return true
            }

            R.id.allCourses -> {
                supportFragmentManager.beginTransaction().replace(R.id.frame_ll, allCoursesFragment)
                    .commit()
                return true
            }

            R.id.myCourses -> {

                supportFragmentManager.beginTransaction().replace(R.id.frame_ll, myCoursesFragment)
                    .commit()
                return true
            }

            R.id.quiz -> {

                supportFragmentManager.beginTransaction().replace(R.id.frame_ll, quizFragment)
                    .commit()
                return true
            }

            else -> {
                supportFragmentManager.beginTransaction().replace(R.id.frame_ll, accountFragment)
                    .commit()
                return true
            }
        }

    }

    private fun setClickListeners() {

        binding.imgDrawer.setOnClickListener {
            binding.drawerLl.openDrawer(binding.navigationDrawer)
        }

    }

}
