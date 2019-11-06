package com.notyteam.bee.profile_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.notyteam.bee.R
import com.notyteam.bee.utils.OnBackPressed
import kotlinx.android.synthetic.main.fragment_profile_change_password.*

class ProfileChangePasswordFragment : Fragment(), OnBackPressed {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile_change_password, container, false)

        val imgbtn_profile_change_password_back = view.findViewById<ImageButton>(R.id.imgbtn_profile_change_password_back)
        val btn_profile_change_password_save =  view.findViewById<Button>(R.id.btn_profile_change_password_save)

        imgbtn_profile_change_password_back.setOnClickListener( {

            fragmentManager?.beginTransaction()?.replace(
                R.id.fragment_container_main_activity,
                ProfileChangeSettingsAccountFragment()
            )?.commit()
        })
        btn_profile_change_password_save.setOnClickListener( {

            fragmentManager?.beginTransaction()?.replace(
                R.id.fragment_container_main_activity,
                ProfileChangeSettingsAccountFragment()
            )?.commit()
        })

        return view
    }

    override fun onBackPressed() {
        fragmentManager?.beginTransaction()?.replace(
            R.id.fragment_container_main_activity,
            ProfileChangeSettingsAccountFragment()
        )?.commit()
    }
}