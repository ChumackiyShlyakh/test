package com.notyteam.bee.topics.my_places.viewpager_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.notyteam.bee.R
import com.notyteam.bee.topics.my_places.adapter.MyPlacesRecycleViewAdapter

class VPBeehousesFragment : Fragment() {


    lateinit var recyclerView: RecyclerView
    lateinit var adapter: MyPlacesRecycleViewAdapter
    var dataList: ArrayList<String> = ArrayList();

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View? = inflater.inflate(R.layout.fragment_vp_beehouses, container, false);

        var textView: TextView = view!!.findViewById(R.id.text)
        textView!!.text = "2"

        //Initializing RecyclerView
        recyclerView = view.findViewById(R.id.recycler_view)
        adapter = MyPlacesRecycleViewAdapter(activity!!.applicationContext, dataList)

        //Set up recyclerview with Vertical LayoutManager and the adapter
        recyclerView.layoutManager = LinearLayoutManager(activity!!.applicationContext, LinearLayoutManager.VERTICAL, false)

        addAnimals();

        // Notify the adapter for data change.
        adapter.notifyDataSetChanged()

        return view
    }

    private fun addAnimals() {
        dataList.add("Dog")
        dataList.add("Cat")
        dataList.add("Monkey")
        dataList!!.add("lion")
        dataList!!.add("Elephent")
        dataList!!.add("Cheetah")
        dataList!!.add("Snake")
        dataList!!.add("Cow")
        dataList!!.add("Ant")
        dataList!!.add("Tiger")
        dataList!!.add("Lizard")

    }
}