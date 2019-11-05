package com.notyteam.bee.topics.my_places

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat.invalidateOptionsMenu
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.notyteam.bee.R
import com.notyteam.bee.topics.my_places.adapter.FragmentWithViewPager
import com.notyteam.bee.topics.my_places.adapter.MyFragmentPagerAdapter
import com.notyteam.bee.topics.my_places.adapter.PagerAdapter
import com.notyteam.bee.topics.my_places.viewpager_fragments.*

class MyPlacesFragment : Fragment() {

    private lateinit var viewpager: ViewPager
    private lateinit var tabs: TabLayout
    private lateinit var pagerAdapter: PagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_myplaces, container, false)

        val fragments = arrayOf(
            instantiate(context!!, VPBeehousesFragment::class.java.getName()),
            instantiate(context!!, VPApiaryFragment::class.java.getName()),
            instantiate(context!!, VPObjectsFragment::class.java.getName()),
            instantiate(context!!, VPEventsFragment::class.java.getName()),
            instantiate(context!!, VPArchiveFragment::class.java.getName())
        )

        tabs = view.findViewById(R.id.tabs)
        viewpager = view.findViewById(R.id.viewpager)
        pagerAdapter = PagerAdapter(childFragmentManager, fragments)

        setupViewPager()

        return view
    }

    private fun setupViewPager() {

//        val adapter = MyFragmentPagerAdapter(childFragmentManager)
//
//        var firstFragmet: VPBeehousesFragment = VPBeehousesFragment()
//        var secondFragmet: VPApiaryFragment = VPApiaryFragment()
//        var thirdFragmet: VPObjectsFragment = VPObjectsFragment()
//        var foreFragmet: VPEventsFragment = VPEventsFragment()
//        var fiveFragmet: VPArchiveFragment = VPArchiveFragment()
//
//        adapter.addFragment(firstFragmet, "Beehouse")
//        adapter.addFragment(secondFragmet,"Apiary")
//        adapter.addFragment(thirdFragmet, "Objects")
//        adapter.addFragment(foreFragmet, "Events")
//        adapter.addFragment(fiveFragmet, "Archive")

        viewpager.adapter = pagerAdapter

//        viewpager.offscreenPageLimit
        viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

            override fun onPageSelected(position: Int) {
                invalidateOptionsMenu(position)
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
        invalidateOptionsMenu(0)

        tabs.setupWithViewPager(viewpager)
    }

    private fun invalidateOptionsMenu(position: Int) {
        for (i in 0 until pagerAdapter.getCount()) {
            val fragment = pagerAdapter.getItem(i)
            fragment.setHasOptionsMenu(i == position)

            if (fragment is FragmentWithViewPager) {
                val fragmentWithViewPager = fragment as FragmentWithViewPager
                if (fragmentWithViewPager.pagerAdapter != null) {
                    for (j in 0 until fragmentWithViewPager.pagerAdapter!!.getCount()) {
                        fragmentWithViewPager.pagerAdapter!!.getItem(j)
                            .setHasOptionsMenu(i == position)
                    }
                }
            }
        }

//        invalidateOptionsMenu()
    }
}