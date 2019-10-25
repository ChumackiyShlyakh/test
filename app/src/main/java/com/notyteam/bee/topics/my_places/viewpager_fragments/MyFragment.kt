package com.notyteam.bee.topics.my_places.viewpager_fragments

import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.notyteam.bee.R

class MyFragment : Fragment() {

    companion object {
        fun newInstance(message: String): MyFragment {

            val myFrament = MyFragment()
            val bdl = Bundle(1)
            bdl.putString(EXTRA_MESSAGE, message)
            myFrament.setArguments(bdl)
            return myFrament
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View? = inflater.inflate(R.layout.fragment_myplaces_adapter, container, false);

        val message = arguments!!.getString(EXTRA_MESSAGE)

        var textView: TextView = view!!.findViewById(R.id.text)
        textView!!.text = message

        return view
    }
}