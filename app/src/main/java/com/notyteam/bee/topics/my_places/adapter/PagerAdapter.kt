package com.notyteam.bee.topics.my_places.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PagerAdapter(fragmentManager: FragmentManager, private val fragments: Array<Fragment>) :
    FragmentPagerAdapter(fragmentManager) {

    override fun getCount(): Int {
        return fragments.size
    }

   override fun getPageTitle(position: Int): CharSequence {
        return fragments[position].javaClass.getSimpleName()
    }

   override fun getItem(position: Int): Fragment {
        return fragments[position]
    }
}