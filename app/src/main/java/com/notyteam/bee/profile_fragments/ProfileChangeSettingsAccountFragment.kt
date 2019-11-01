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

        val imgbtn_profile_change_settings_account_back =  view.findViewById<ImageButton>(R.id.imgbtn_profile_change_settings_account_back)
        val btn_fragment_profile_change_settings_account_change_password = view.findViewById<Button>(R.id.btn_fragment_profile_change_settings_account_change_password)
        val btn_fragment_profile_change_settings_account_save = view.findViewById<Button>(R.id.btn_fragment_profile_change_settings_account_save)

        imgbtn_profile_change_settings_account_back?.setOnClickListener( {
            fragmentManager?.beginTransaction()?.replace(
                R.id.fragment_container_main_activity,
                ProfileSettingsAccountFragment()
            )?.commit()
        })
        btn_fragment_profile_change_settings_account_change_password?.setOnClickListener( {
            fragmentManager?.beginTransaction()?.replace(
                R.id.fragment_container_main_activity,
                ProfileChangePasswordFragment()
            )?.commit()
        })
        btn_fragment_profile_change_settings_account_save?.setOnClickListener( {
            fragmentManager?.beginTransaction()?.replace(
                R.id.fragment_container_main_activity,
                ProfileSettingsAccountFragment()
            )?.commit()
        })

        return view
    }
}