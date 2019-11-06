package com.notyteam.bee.topics.my_places.adapter

import android.os.Parcelable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter

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

}