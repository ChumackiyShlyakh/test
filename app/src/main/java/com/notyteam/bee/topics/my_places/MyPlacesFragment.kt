package com.notyteam.bee.topics.my_places

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.notyteam.bee.R
import com.notyteam.bee.core.ui.MainActivity
import com.notyteam.bee.topics.my_places.adapter.DefaultStateViewPagerAdapter
import com.notyteam.bee.topics.my_places.controls.MyPlacesControlsBeehousesFragment
import com.notyteam.bee.topics.my_places.controls.MyPlacesControlsEventsFragment
import com.notyteam.bee.topics.my_places.controls.MyPlacesControlsObjectFragment
import com.notyteam.bee.topics.my_places.viewpager_fragments.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MyPlacesFragment : Fragment(), View.OnClickListener {

    private lateinit var viewpager: ViewPager
    private lateinit var tabs: TabLayout
    var imgbtn_fragment_myplaces: ImageButton? = null
    var adapter: DefaultStateViewPagerAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_myplaces, container, false)

        tabs = view.findViewById(R.id.tabs_fragment_myplaces)
        viewpager = view.findViewById(R.id.viewpager)

        setupViewPager()

        MainActivity.imgbtn_controls_my_places_beehouses?.setOnClickListener({

            when (viewpager.currentItem) {
                0 -> {
                    fragmentManager?.beginTransaction()?.replace(
                        R.id.fragment_container_main_activity,
                        MyPlacesControlsBeehousesFragment()
                    )?.commit()
                    (activity as AppCompatActivity).toolbar_main_drawer?.visibility = View.GONE
                }
                1 -> {
                    fragmentManager?.beginTransaction()?.replace(
                        R.id.fragment_container_main_activity,
                        MyPlacesControlsBeehousesFragment()
                    )?.commit()
                    (activity as AppCompatActivity).toolbar_main_drawer?.visibility = View.GONE
                }
                2 -> {
                    fragmentManager?.beginTransaction()?.replace(
                        R.id.fragment_container_main_activity,
                        MyPlacesControlsObjectFragment()
                    )?.commit()
                    (activity as AppCompatActivity).toolbar_main_drawer?.visibility = View.GONE
                }
                3 -> {
                    fragmentManager?.beginTransaction()?.replace(
                        R.id.fragment_container_main_activity,
                        MyPlacesControlsEventsFragment()
                    )?.commit()
                    (activity as AppCompatActivity).toolbar_main_drawer?.visibility = View.GONE
                }

            }

        })

        viewpager?.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                if (position == 4) {
                    (activity as AppCompatActivity).imgbtn_controls_my_places?.visibility =
                        View.GONE
                } else {
                    (activity as AppCompatActivity).imgbtn_controls_my_places?.visibility =
                        View.VISIBLE
                }
            }

            override fun onPageSelected(position: Int) {
                if (position == 4) {
                    (activity as AppCompatActivity).imgbtn_controls_my_places?.visibility =
                        View.GONE
                } else {
                    (activity as AppCompatActivity).imgbtn_controls_my_places?.visibility =
                        View.VISIBLE
                }
            }

        })

        return view
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity).imgbtn_controls_my_places?.visibility = View.GONE
    }

    override fun onClick(view: View?) {}

    private fun setupViewPager() {

        adapter = DefaultStateViewPagerAdapter(childFragmentManager)
        adapter?.addFragment(VPBeehousesFragment(), "Beehouse")
        adapter?.addFragment(VPApiaryFragment(), "Apiary")
        adapter?.addFragment(VPObjectsFragment(), "Objects")
        adapter?.addFragment(VPEventsFragment(), "Events")
        adapter?.addFragment(VPArchiveFragment(), "Archive")

        viewpager.adapter = adapter
        viewpager.offscreenPageLimit = 5
        tabs.setupWithViewPager(viewpager)
    }
}