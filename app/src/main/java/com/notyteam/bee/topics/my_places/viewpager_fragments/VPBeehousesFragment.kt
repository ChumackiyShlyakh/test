package com.notyteam.bee.topics.my_places.viewpager_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.notyteam.bee.R
import com.notyteam.bee.topics.my_places.adapter.VPBeehousesRecycleViewAdapter

class VPBeehousesFragment() : Fragment() {

    private var recyclerView: RecyclerView? = null
    lateinit var adapter: VPBeehousesRecycleViewAdapter
    var dataList: ArrayList<String> = ArrayList()
    private var layoutManager: RecyclerView.LayoutManager? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View? = inflater.inflate(R.layout.fragment_vp_beehouses, container, false);

        recyclerView = view?.findViewById(R.id.recycler_view_vp_beehouses)
        adapter = VPBeehousesRecycleViewAdapter(activity!!.applicationContext, dataList)

        layoutManager = LinearLayoutManager(activity)

        //Set up recyclerview with Vertical LayoutManager and the adapter
        recyclerView?.layoutManager = layoutManager

        addAnimals();
        recyclerView?.adapter = adapter
        adapter.notifyDataSetChanged()

        return view
    }

    private fun addAnimals() {
        dataList.add("Мы - некоммерческая общественная организация \"Гранд Эксперт\". Цель нашей деятельности")
    }
}