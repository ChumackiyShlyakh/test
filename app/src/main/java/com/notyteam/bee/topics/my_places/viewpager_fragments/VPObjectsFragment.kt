package com.notyteam.bee.topics.my_places.viewpager_fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.notyteam.bee.R
import com.notyteam.bee.topics.my_places.adapter.VPObjectsRecycleViewAdapter

class VPObjectsFragment : Fragment() {

    private var recycler_view_vp_objects: RecyclerView? = null
    lateinit var adapter: VPObjectsRecycleViewAdapter
    var dataList: ArrayList<String> = ArrayList()
    private var layoutManager: RecyclerView.LayoutManager? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View? = inflater.inflate(R.layout.fragment_vp_objects, container, false);


        recycler_view_vp_objects = view?.findViewById(R.id.recycler_view_vp_objects)
        adapter = VPObjectsRecycleViewAdapter(activity!!.applicationContext, dataList)

        layoutManager = LinearLayoutManager(activity)

        //Set up recyclerview with Vertical LayoutManager and the adapter
        recycler_view_vp_objects?.layoutManager = layoutManager

        addText();
        recycler_view_vp_objects?.adapter = adapter

        return view
    }

    private fun addText() {
        dataList.add("Мы - некоммерческая общественная организация \"Гранд Эксперт\". Цель нашей деятельности")
    }
}