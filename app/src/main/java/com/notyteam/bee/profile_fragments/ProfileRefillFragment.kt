package com.notyteam.bee.profile_fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.notyteam.bee.R
import com.notyteam.bee.profile_fragments.adapter.model.SectionModel
import com.notyteam.bee.profile_fragments.adapter.SectionRecyclerViewAdapter
import kotlinx.android.synthetic.main.fragment_profile_refill.*
import java.util.*

class ProfileRefillFragment : Fragment() {


    val LOG_TAG: String = "myLogs";

    lateinit var adapter: SectionRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile_refill, container, false)

        val imgbtn_fragment_profile_refill_back =  view.findViewById<ImageButton>(R.id.imgbtn_fragment_profile_refill_back)

        imgbtn_fragment_profile_refill_back.setOnClickListener({
            fragmentManager?.beginTransaction()?.replace(
                R.id.fragment_container_main_activity,
                ProfilePaymentsFragment()
            )?.commit()
        })

        return view
    }

    override fun onStart() {
        super.onStart()
        setUpRecyclerView()
        populateRecyclerView()
    }

    //setup recycler view
    private fun setUpRecyclerView() {
//        sectioned_recycler_view.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(activity)
        sectioned_recycler_view.layoutManager = linearLayoutManager
    }

    //populate recycler view
    private fun populateRecyclerView() {
        val sectionModelArrayList = ArrayList<SectionModel>()
        //for loop for sections
        for (i in 1..5) {
            val itemArrayList = ArrayList<String>()
            //for loop for items
            for (j in 1..10) {
                itemArrayList.add("Item $j")
            }
            Log.d(LOG_TAG, "ProfileRefillFragment for (i in 1..5): " + " " + i);
            //add the section and items to array list
            sectionModelArrayList.add(
                SectionModel(
                    "Section $i",
                    itemArrayList
                )
            )
        }
        context?.let {
            adapter = SectionRecyclerViewAdapter(it, sectionModelArrayList)
            Log.d(LOG_TAG, "ProfileRefillFragment for (i in 1..5): " + " " )
        }

        Log.d(LOG_TAG, "ProfileRefillFragment populateRecyclerView: " + " " + adapter);
        sectioned_recycler_view.adapter = adapter
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
//        android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }

    //set toolbar title and set back button
    private fun setUpToolbarTitle() {
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true)
//        when (recyclerViewType) {
//            LINEAR_HORIZONTAL -> getSupportActionBar().setTitle(getResources().getString(R.string.linear_sectioned_recyclerview_horizontal))
//            LINEAR_VERTICAL -> getSupportActionBar().setTitle(getResources().getString(R.string.linear_sectioned_recyclerview_vertical))
//            GRID -> getSupportActionBar().setTitle(getResources().getString(R.string.grid_sectioned_recyclerview))
//        }
    }
}