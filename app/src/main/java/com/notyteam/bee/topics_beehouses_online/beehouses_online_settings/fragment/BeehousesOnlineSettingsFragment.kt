package com.notyteam.bee.topics_beehouses_online.beehouses_online_settings.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.notyteam.bee.R
import kotlinx.android.synthetic.main.fragment_beehouses_online_settings.*

class BeehousesOnlineSettingsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_beehouses_online_settings, container, false)

        val ll_fragment_gadgets_grafs_settings_exit_from_account = ll_fragment_gadgets_grafs_settings_exit_from_account

        ll_fragment_gadgets_grafs_settings_exit_from_account?.setOnClickListener(View.OnClickListener {
            this.activity?.finish()
        })

        return view
    }
}