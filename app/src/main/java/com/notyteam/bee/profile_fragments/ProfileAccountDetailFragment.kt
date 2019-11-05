package com.notyteam.bee.profile_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.notyteam.bee.R
import kotlinx.android.synthetic.main.fragment_profile_account_detail.*
import kotlinx.android.synthetic.main.fragment_profile_settings_profile.*

class ProfileAccountDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile_account_detail, container, false)

        val imgbtn_fragment_profile_account_detail_back = view.findViewById<ImageButton>(R.id.cl_fragment_profile_account_detail_back)

        imgbtn_fragment_profile_account_detail_back.setOnClickListener( {
            fragmentManager?.beginTransaction()?.replace(
                R.id.fragment_container_main_activity,
                ProfilePaymentsFragment()
            )?.commit()
        })

        return view
    }
}