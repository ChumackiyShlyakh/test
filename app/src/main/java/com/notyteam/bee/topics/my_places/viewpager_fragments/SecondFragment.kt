package com.notyteam.bee.topics.my_places.viewpager_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.notyteam.bee.R

class SecondFragment  : Fragment() {

//    fun TwoFragment() {
//
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View? = inflater.inflate(R.layout.fragment_home, container, false);

        var textView: TextView = view!!.findViewById(R.id.text)
        textView!!.text = "2"

        return view
    }
}