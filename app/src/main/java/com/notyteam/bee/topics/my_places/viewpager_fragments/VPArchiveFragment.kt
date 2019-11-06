package com.notyteam.bee.topics.my_places.viewpager_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.notyteam.bee.R
import com.notyteam.bee.topics.my_places.adapter.VPArchiveRecycleViewAdapter

class VPArchiveFragment : Fragment() {

    private var recycler_view_vp_archive: RecyclerView? = null
    lateinit var adapter: VPArchiveRecycleViewAdapter
    var dataList: ArrayList<String> = ArrayList()
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var btn_fragment_vp_archive_choose_objects: Button? = null
    private var btn_fragment_vp_archive_choose_events: Button? = null
    private var btnVPObjectTrueEventFalseClick: Boolean? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View? = inflater.inflate(R.layout.fragment_vp_archive, container, false);

        btnVPObjectTrueEventFalseClick = false
        isButtonVPObjectsTrueEventFalsClick()

        btn_fragment_vp_archive_choose_objects =
            view?.findViewById(R.id.btn_fragment_vp_archive_choose_objects)
        btn_fragment_vp_archive_choose_events =
            view?.findViewById(R.id.btn_fragment_vp_archive_choose_events)

        btn_fragment_vp_archive_choose_objects?.setOnClickListener({
            btnVPObjectTrueEventFalseClick = true
            isButtonVPObjectsTrueEventFalsClick()
        })

        btn_fragment_vp_archive_choose_events?.setOnClickListener({
            btnVPObjectTrueEventFalseClick = false
            isButtonVPObjectsTrueEventFalsClick()
        })

        recycler_view_vp_archive = view?.findViewById(R.id.recycler_view_vp_archive)
        adapter = VPArchiveRecycleViewAdapter(activity!!.applicationContext, dataList)

        layoutManager = LinearLayoutManager(activity)

        //Set up recyclerview with Vertical LayoutManager and the adapter
        recycler_view_vp_archive?.layoutManager = layoutManager

        addText();
        recycler_view_vp_archive?.adapter = adapter


        return view
    }

    private fun addText() {
        dataList.add("Мы - некоммерческая общественная организация \"Гранд Эксперт\". Цель нашей деятельности")
    }

    private fun isButtonVPObjectsTrueEventFalsClick(){
        if(btnVPObjectTrueEventFalseClick!!){
            btn_fragment_vp_archive_choose_events?.setBackgroundResource(R.drawable.ed_border_grey)
            btn_fragment_vp_archive_choose_events?.setTextColor(getResources().getColor(R.color.black))
            btn_fragment_vp_archive_choose_objects?.setBackgroundResource(R.drawable.button_orange)
            btn_fragment_vp_archive_choose_objects?.setTextColor(getResources().getColor(R.color.white))
        } else {
            btn_fragment_vp_archive_choose_events?.setBackgroundResource(R.drawable.button_orange)
            btn_fragment_vp_archive_choose_events?.setTextColor(getResources().getColor(R.color.white))
            btn_fragment_vp_archive_choose_objects?.setBackgroundResource(R.drawable.ed_border_grey)
            btn_fragment_vp_archive_choose_objects?.setTextColor(getResources().getColor(R.color.black))
        }
    }
}