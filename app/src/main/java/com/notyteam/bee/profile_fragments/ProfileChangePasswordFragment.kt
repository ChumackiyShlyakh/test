package com.notyteam.bee.profile_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.notyteam.bee.R
import kotlinx.android.synthetic.main.fragment_profile_change_password.*

class ProfileChangePasswordFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile_change_password, container, false)

//        val viewModel = ViewModelProviders.of(this)[ProfileViewModel::class.java]
//        val binding: FragmentProfileBinding = FragmentProfileBinding().inflate(inflater, container, false)
//        binding.model

        val imgbtn_profile_change_password_back = view.findViewById<ImageButton>(R.id.imgbtn_profile_change_password_back)
        val btn_profile_change_password =  view.findViewById<Button>(R.id.btn_profile_change_password)

        imgbtn_profile_change_password_back.setOnClickListener(View.OnClickListener {
            fragmentManager?.beginTransaction()?.replace(
                R.id.fragment_container_main_activity,
                ProfileChangeSettingsAccountFragment()
            )?.commit()
        })
        btn_profile_change_password.setOnClickListener(View.OnClickListener {
            fragmentManager?.beginTransaction()?.replace(
                R.id.fragment_container_main_activity,
                ProfileChangeSettingsAccountFragment()
            )?.commit()
        })

        return view
//        return binding.root
    }

}