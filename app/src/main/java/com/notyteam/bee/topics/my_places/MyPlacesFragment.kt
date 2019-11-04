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
import com.notyteam.bee.topics.my_places.viewpager_fragments.*

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

        var firstFragmet: VPBeehousesFragment = VPBeehousesFragment()
        var secondFragmet: VPApiaryFragment = VPApiaryFragment()
        var thirdFragmet: VPObjectsFragment = VPObjectsFragment()
        var foreFragmet: VPEventsFragment = VPEventsFragment()
        var fiveFragmet: VPArchiveFragment = VPArchiveFragment()

        adapter.addFragment(firstFragmet, "Beehouse")
        adapter.addFragment(secondFragmet,"Apiary")
        adapter.addFragment(thirdFragmet, "Objects")
        adapter.addFragment(foreFragmet, "Events")
        adapter.addFragment(fiveFragmet, "Archive")

        viewpager.adapter = adapter

        tabs.setupWithViewPager(viewpager)
    }
}