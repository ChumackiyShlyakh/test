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
import com.notyteam.bee.topics.my_places.controls.MyPlacesControlsBeehousesFragment
import com.notyteam.bee.topics.my_places.adapter.FragmentWithViewPager
import com.notyteam.bee.topics.my_places.adapter.MyFragmentPagerAdapter
import com.notyteam.bee.topics.my_places.controls.MyPlacesControlsBeehousesFragment
import com.notyteam.bee.topics.my_places.controls.MyPlacesControlsEventsFragment
import com.notyteam.bee.topics.my_places.controls.MyPlacesControlsObjectFragment
import com.notyteam.bee.topics.my_places.viewpager_fragments.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MyPlacesFragment : Fragment(), View.OnClickListener {

    private lateinit var viewpager: ViewPager
    private lateinit var tabs: TabLayout

    var imgbtn_fragment_myplaces: ImageButton? = null
    var adapter: MyFragmentPagerAdapter? = null

    private lateinit var pagerAdapter: PagerAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_myplaces, container, false)


        tabs = view.findViewById(R.id.tabs_fragment_myplaces)
        viewpager = view.findViewById(R.id.viewpager)
        adapter = MyFragmentPagerAdapter(childFragmentManager)
//        imgbtn_fragment_myplaces = view.findViewById(R.id.imgbtn_fragment_myplaces)
//        imgbtn_fragment_myplaces?.setOnClickListener({
//                    Log.d("imgbtn_fragment", "imgbtn_fragment_myplaces 1: ")
//        })

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
                    Log.d("imgbtn_fragment", "imgbtn_fragment_myplaces 2: ")
//                    (activity as AppCompatActivity).toolbar_main_drawer?.visibility = View.GONE
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
                4 -> {
                    MainActivity.imgbtn_controls_my_places_beehouses?.visibility = View.GONE
                }
            }


//            if (adapter?.getItemId(1) == 1L){
//                Log.d("imgbtn_fragment", "imgbtn_fragment_myplaces 1: ")
//            }
//            else{
//                Log.d("imgbtn_fragment", "imgbtn_fragment_myplaces 3: ")
//            }
            Log.d(
                "imgbtn_fragment",
                "imgbtn_fragment_myplaces 5: " + adapter?.getItem(1) + " ItemId " + adapter?.getItemId(
                    id
                )
            )
        })
        val fragments = arrayOf(
            instantiate(context!!, VPBeehousesFragment::class.java.getName()),
            instantiate(context!!, VPApiaryFragment::class.java.getName()),
            instantiate(context!!, VPObjectsFragment::class.java.getName()),
            instantiate(context!!, VPEventsFragment::class.java.getName()),
            instantiate(context!!, VPArchiveFragment::class.java.getName())
        )


        pagerAdapter = PagerAdapter(childFragmentManager, fragments)

        setupViewPager()

        return view
    }

    override fun onClick(view: View?) {
//        when (adapter?.count) {
        Log.d("imgbtn_fragment", "imgbtn_fragment_myplaces 2: ")
//            1 -> {
//                Log.d("imgbtn_fragment", "imgbtn_fragment_myplaces 2: ")
//                childFragmentManager.beginTransaction().replace(
//                    R.id.fragment_container_main_activity,
//                    MyPlacesControlsBeehousesFragment()
//                ).commit()

//            }
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

        adapter?.addFragment(firstFragmet, "Beehouse")
        adapter?.addFragment(secondFragmet, "Apiary")
        adapter?.addFragment(thirdFragmet, "Objects")
        adapter?.addFragment(foreFragmet, "Events")
        adapter?.addFragment(fiveFragmet, "Archive")


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