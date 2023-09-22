package com.example.liberty

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.liberty.ui.account.AccountFragment
import com.example.liberty.ui.allcourses.AllCoursesFragment
import com.example.liberty.ui.home.HomeFragment
import com.example.liberty.ui.mycourses.MyCoursesFragment
import com.example.liberty.ui.quiz.QuizFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    companion object {
        const val SHARED_PREFS = "shared_prefs"

    }

    private lateinit var sharedpreferences: SharedPreferences
    private var number: String? = null
    private var passwoed: String? = null


    lateinit var drawerLayout: DrawerLayout
    lateinit var navigationView: NavigationView
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    lateinit var img_drawer: ImageView
    lateinit var tv_badges: TextView

    lateinit var bottomNavigationView: BottomNavigationView
    var homeFragment: Fragment = HomeFragment()
    var allCoursesFragment: Fragment = AllCoursesFragment()
    var myCoursesFragment: Fragment = MyCoursesFragment()
    var quizFragment: Fragment = QuizFragment()
    var accountFragment: Fragment = AccountFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedpreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)


        initView()
        setClickListeners()


        tv_badges.visibility = View.VISIBLE
        val badgeCount = 5
        tv_badges.text = badgeCount.toString()

        actionBarDrawerToggle =
            ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close)
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)


        bottomNavigationView.setOnNavigationItemSelectedListener(this)
        bottomNavigationView.selectedItemId = R.id.home
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

        img_drawer.setOnClickListener {
            drawerLayout.openDrawer(navigationView)
        }

    }

    private fun initView() {
        drawerLayout = findViewById(R.id.drawer_ll)
        navigationView = findViewById(R.id.navigation_drawer)
        bottomNavigationView = findViewById(R.id.navigationViewButton)
        img_drawer = findViewById(R.id.img_drawer)
        tv_badges = findViewById(R.id.tv_badge)

    }
}
