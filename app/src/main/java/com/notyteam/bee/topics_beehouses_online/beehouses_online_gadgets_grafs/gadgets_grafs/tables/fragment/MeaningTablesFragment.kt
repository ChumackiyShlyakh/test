package com.notyteam.bee.topics_beehouses_online.beehouses_online_gadgets_grafs.gadgets_grafs.tables.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.notyteam.bee.R
import com.notyteam.bee.topics_beehouses_online.beehouses_online_gadgets_grafs.fragment.GadgetsGrafsFragment
import com.notyteam.bee.topics_beehouses_online.beehouses_online_gadgets_grafs.gadgets_grafs.tables.fragment.adapter.MeaningTablesRecycleViewAdapter
import com.notyteam.bee.topics_beehouses_online.beehouses_online_gadgets_table.gadgets_table.tables.fragment.MeaningTableFiltrFragment
import kotlinx.android.synthetic.main.app_bar_main.*


class MeaningTablesFragment : Fragment() {

    private var recycler_view_fragment_meaning_tables: RecyclerView? = null
    lateinit var adapter: MeaningTablesRecycleViewAdapter
    var dataList: ArrayList<String> = ArrayList()
    private var layoutManager: RecyclerView.LayoutManager? = null
    var imgbtn_fragment_meaning_tables_back: ImageButton? = null
    var imgbtn_fragment_meaning_tables_controls: ImageButton? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_meaning_tables, container, false)

        imgbtn_fragment_meaning_tables_back = view?.findViewById(R.id.imgbtn_fragment_meaning_tables_back)
        imgbtn_fragment_meaning_tables_controls = view?.findViewById(R.id.imgbtn_fragment_meaning_tables_controls)

        imgbtn_fragment_meaning_tables_back?.setOnClickListener({
            fragmentManager?.beginTransaction()?.replace(
                R.id.fragment_container_main_activity,
                GadgetsGrafsFragment()
            )?.commit()
        })

        imgbtn_fragment_meaning_tables_controls?.setOnClickListener({
            fragmentManager?.beginTransaction()?.replace(
                R.id.fragment_container_main_activity,
                MeaningTableFiltrFragment()
            )?.commit()
        })

        recycler_view_fragment_meaning_tables = view?.findViewById(R.id.recycler_view_fragment_meaning_tables)
        adapter = MeaningTablesRecycleViewAdapter(activity!!.applicationContext, dataList)

        layoutManager = LinearLayoutManager(activity)
        recycler_view_fragment_meaning_tables?.layoutManager = layoutManager

        addAnimals();
        recycler_view_fragment_meaning_tables?.adapter = adapter
        adapter.notifyDataSetChanged()

        return view
    }

    private fun addAnimals() {
        dataList.add("Cat")
        dataList.add("Monkey")
        dataList.add("lion")
        dataList.add("Elephent")
        dataList.add("Cheetah")
        dataList.add("Snake")
        dataList.add("Cow")
        dataList.add("Ant")
        dataList.add("Tiger")
        dataList.add("Lizard")
        dataList.add("Dog")
        dataList.add("Cat")
        dataList.add("Monkey")
        dataList.add("lion")
        dataList.add("Elephent")
        dataList.add("Cheetah")
        dataList.add("Snake")
        dataList.add("Cow")
        dataList.add("Ant")
        dataList.add("Tiger")
        dataList.add("Lizard")
    }
}