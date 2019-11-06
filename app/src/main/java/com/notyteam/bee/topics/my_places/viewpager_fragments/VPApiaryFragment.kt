package com.notyteam.bee.topics.my_places.viewpager_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.notyteam.bee.R
import com.notyteam.bee.topics.my_places.adapter.VPApiaryRecycleViewAdapter


class VPApiaryFragment : Fragment() {

    private var rv_fragment_vp_apiary: RecyclerView? = null
    lateinit var adapter: VPApiaryRecycleViewAdapter
    var dataList: ArrayList<String> = ArrayList()
    private var layoutManager: RecyclerView.LayoutManager? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View? = inflater.inflate(R.layout.fragment_vp_apiary, container, false);

        rv_fragment_vp_apiary = view?.findViewById(R.id.rv_fragment_vp_apiary)
        adapter = VPApiaryRecycleViewAdapter(activity!!.applicationContext, dataList)

        layoutManager = LinearLayoutManager(activity)
        rv_fragment_vp_apiary?.layoutManager = layoutManager

        addText()
        rv_fragment_vp_apiary?.adapter = adapter


        return view
    }

    private fun addText() {
        dataList.add("Не рабочее")
    }
}