package com.example.soptthirdseminar

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.soptthirdseminar.fragment.BookFragment
import com.example.soptthirdseminar.fragment.HomeFragment
import com.example.soptthirdseminar.fragment.MyPageFragment

class MainPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {
    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> HomeFragment()
            1 -> BookFragment()
            else -> MyPageFragment()
        }
    }

    override fun getCount() = 3
}