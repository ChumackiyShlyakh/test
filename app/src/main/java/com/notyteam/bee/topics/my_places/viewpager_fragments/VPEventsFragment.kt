package com.notyteam.bee.topics.my_places.viewpager_fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.notyteam.bee.R
import com.notyteam.bee.topics.my_places.adapter.ExpandableLayout
import com.notyteam.bee.topics.my_places.adapter.VPEventsRecycleViewAdapter

class VPEventsFragment : Fragment(), View.OnClickListener {

    private var recycler_view_vp_events: RecyclerView? = null
    lateinit var adapter: VPEventsRecycleViewAdapter
    var dataList: ArrayList<String> = ArrayList()
    private var layoutManager: RecyclerView.LayoutManager? = null

//    private var expandableLayout0: ExpandableLayout? = null
//    private var expandableLayout1: ExpandableLayout? = null
//    var expand_button: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View? = inflater.inflate(R.layout.fragment_vp_events, container, false);


        recycler_view_vp_events = view?.findViewById(R.id.recycler_view_vp_events)
        adapter = VPEventsRecycleViewAdapter(activity!!.applicationContext, dataList)

        layoutManager = LinearLayoutManager(activity)

        //Set up recyclerview with Vertical LayoutManager and the adapter
        recycler_view_vp_events?.layoutManager = layoutManager

        addText();
        recycler_view_vp_events?.adapter = adapter
        adapter.notifyDataSetChanged()


//        expandableLayout0 = view?.findViewById(R.id.expandable_layout_0)
//        expandableLayout1 = view?.findViewById(R.id.expandable_layout_1)

//        expandableLayout0?.setOnExpansionUpdateListener(object :
//            ExpandableLayout.OnExpansionUpdateListener {
//            override fun onExpansionUpdate(expansionFraction: Float, state: Int) {
//                Log.d("ExpandableLayout0", "State: " + state)
//            }
//        })
//
//        expandableLayout1?.setOnExpansionUpdateListener(object :
//            ExpandableLayout.OnExpansionUpdateListener {
//            override fun onExpansionUpdate(expansionFraction: Float, state: Int) {
//                Log.d("ExpandableLayout1", "State: " + state)
//            }
//        })

//        expand_button = view?.findViewById(R.id.expand_button)
//        expand_button?.setOnClickListener(this)

        return view
    }

    override fun onClick(view: View) {
//        if (expandableLayout0!!.isExpanded) {
//            expandableLayout0!!.collapse()
//        } else if (expandableLayout1!!.isExpanded) {
//            expandableLayout1!!.collapse()
//        } else {
//            expandableLayout0!!.expand()
//            expandableLayout1!!.expand()
//        }
    }

    private fun addText() {
        dataList.add("Мы - некоммерческая общественная организация \"Гранд Эксперт\". Цель нашей деятельности")
    }
}