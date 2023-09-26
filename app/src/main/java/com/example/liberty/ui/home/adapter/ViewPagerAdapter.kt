package com.example.liberty.ui.home.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(
    fm: androidx.fragment.app.FragmentManager
) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val fragmentList: MutableList<Fragment> = mutableListOf()
    override fun getCount(): Int {
        return fragmentList.size
    }

    override fun getItem(position: Int): Fragment {
        /*return when (position) {
            0 -> FirstFragment()
            1 -> SecondFragment()
            else -> ThirdFragment()

        }*/
        return fragmentList[position]
    }
    fun addFragment(fragment: Fragment) {
        fragmentList.add(fragment)
    }
}