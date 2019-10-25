package com.notyteam.bee.topics.my_places

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.notyteam.bee.R
import com.notyteam.bee.topics.my_places.adapter.MyFragmentPagerAdapter
import com.notyteam.bee.topics.my_places.viewpager_fragments.MyFrament
import com.notyteam.bee.topics.my_places.viewpager_fragments.SecondFragment

class MyPlacesFragment : Fragment() {

    private lateinit var viewpager: ViewPager
    private lateinit var tabs: TabLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_myplaces, container, false)

        tabs = view.findViewById(R.id.tabs)
        viewpager = view.findViewById(R.id.viewpager)

        setupViewPager()

        return view
    }

    private fun setupViewPager() {

        val adapter = MyFragmentPagerAdapter(childFragmentManager)

        var firstFragmet: MyFrament = MyFrament.newInstance("First Fragment")
        var secondFragmet: SecondFragment = SecondFragment()
        var thirdFragmet: MyFrament = MyFrament.newInstance("Third Fragment")
        var foreFragmet: MyFrament = MyFrament.newInstance("4 Fragment")

        adapter.addFragment(firstFragmet, "Beehouses")
        adapter.addFragment(secondFragmet,"Plots")
        adapter.addFragment(thirdFragmet, "Objects")
        adapter.addFragment(foreFragmet, "Events")

        viewpager.adapter = adapter

        tabs.setupWithViewPager(viewpager)

    }
}