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

//        val viewModel = ViewModelProviders.of(this)[ProfileViewModel::class.java]
//        val binding: FragmentProfileBinding = FragmentProfileBinding().inflate(inflater, container, false)
//        binding.model

        val imgbtn_profile_account_detail_fragment_back = view.findViewById<ImageButton>(R.id.imgbtn_profile_account_detail_fragment_back)

        imgbtn_profile_account_detail_fragment_back.setOnClickListener(View.OnClickListener {
            fragmentManager?.beginTransaction()?.replace(
                R.id.fragment_container_main_activity,
                ProfilePaymentsFragment()
            )?.commit()
        })

        return view
//        return binding.root
    }
}