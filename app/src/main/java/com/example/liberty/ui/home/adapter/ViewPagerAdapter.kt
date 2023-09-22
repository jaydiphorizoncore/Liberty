package com.example.liberty.ui.home.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter

import com.example.liberty.ui.home.viewpagerFragment.FirstFragment
import com.example.liberty.ui.home.viewpagerFragment.SecondFragment
import com.example.liberty.ui.home.viewpagerFragment.ThirdFragment

class ViewPagerAdapter(
    fm: androidx.fragment.app.FragmentManager, private val tabCount: Int
) :
    FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return tabCount
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> FirstFragment()
            1 -> SecondFragment()
            else -> ThirdFragment()

        }
    }
}