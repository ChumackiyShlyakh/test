package com.notyteam.bee.topics.my_places.adapter

import android.os.Parcelable
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter
import com.notyteam.bee.topics.my_places.viewpager_fragments.*

import java.util.ArrayList

class DefaultStateViewPagerAdapter : FragmentStatePagerAdapter {

    private var mFragments: ArrayList<Fragment>? = null
    private var mFragmentTitles: ArrayList<String>? = null

    constructor(fm: FragmentManager) : super(fm) {
        this.mFragments = ArrayList()
        this.mFragmentTitles = ArrayList()
    }


    override fun getItem(position: Int): Fragment {
        return mFragments!![position]
    }

    override fun getItemPosition(`object`: Any): Int {
        var index = mFragments!!.indexOf(`object`)
        if (index < 0) {
            index = PagerAdapter.POSITION_NONE
        }
        return index
    }

    override fun getCount(): Int {
        return mFragments!!.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mFragmentTitles?.get(position)
    }

    override fun saveState(): Parcelable? {
        return null
    }


    fun clearFragments() {
        mFragments!!.clear()
        mFragmentTitles!!.clear()
    }

    fun setFragments(fragments: List<Fragment>) {
        mFragments = fragments as ArrayList<Fragment>
        notifyDataSetChanged()
    }

    fun addFragment(fragment: Fragment, title: String) {
        mFragments!!.add(fragment)
        mFragmentTitles!!.add(title)
    }

    // Here we can finally safely save a reference to the created
    // Fragment, no matter where it came from (either getItem() or
    // FragmentManger). Simply save the returned Fragment from
    // super.instantiateItem() into an appropriate reference depending
    // on the ViewPager position.
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val createdFragment = super.instantiateItem(container, position) as Fragment
        // save the appropriate reference depending on position
        when (position) {
            0 ->  createdFragment as VPBeehousesFragment
            1 ->  createdFragment as VPApiaryFragment
            2 ->  createdFragment as VPObjectsFragment
            3 ->  createdFragment as VPEventsFragment
            4 ->  createdFragment as VPArchiveFragment
        }
        return createdFragment
    }

}