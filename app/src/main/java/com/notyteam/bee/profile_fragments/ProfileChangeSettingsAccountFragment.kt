package com.notyteam.bee.profile_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.notyteam.bee.R
import com.notyteam.bee.topics.profile.fragment.ProfileFragment
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.fragment_profile_change_settings_account.*

class ProfileChangeSettingsAccountFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile_change_settings_account, container, false)

//        val viewModel = ViewModelProviders.of(this)[ProfileViewModel::class.java]
//        val binding: FragmentProfileBinding = FragmentProfileBinding().inflate(inflater, container, false)
//        binding.model

        val imgbtn_profile_change_settings_account_back =  view.findViewById<ImageButton>(R.id.imgbtn_profile_change_settings_account_back)
        val btn_profile_settings_account_edit = view.findViewById<Button>(R.id.btn_profile_settings_account_edit)
        val btn_profile_settings_change_password = view.findViewById<Button>(R.id.btn_profile_settings_change_password)

        imgbtn_profile_change_settings_account_back.setOnClickListener(View.OnClickListener {
            fragmentManager?.beginTransaction()?.replace(
                R.id.fragment_container_main_activity,
                ProfileSettingsAccountFragment()
            )?.commit()
        })
        btn_profile_settings_account_edit.setOnClickListener(View.OnClickListener {
            fragmentManager?.beginTransaction()?.replace(
                R.id.fragment_container_main_activity,
                ProfileChangePasswordFragment()
            )?.commit()
        })
        btn_profile_settings_change_password.setOnClickListener(View.OnClickListener {
            fragmentManager?.beginTransaction()?.replace(
                R.id.fragment_container_main_activity,
                ProfileChangePasswordFragment()
            )?.commit()
        })

        return view
//        return binding.root
    }
}