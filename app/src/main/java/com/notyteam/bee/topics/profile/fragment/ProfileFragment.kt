package com.notyteam.bee.topics.profile.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.notyteam.bee.R
import com.notyteam.bee.core.ui.MainActivity
import com.notyteam.bee.profile_fragments.ProfilePaymentsFragment
import com.notyteam.bee.profile_fragments.ProfileSettingsAccountFragment
import com.notyteam.bee.profile_fragments.ProfileSettingsProfileFragment
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        var ll_fragment_profile_profile_settings = view.findViewById(R.id.ll_fragment_profile_profile_settings) as LinearLayout
        var ll_profile_payments_refill_account = view.findViewById(R.id.ll_profile_payments_refill_account) as LinearLayout
        var ll_profile_cash = view.findViewById(R.id.ll_profile_cash) as LinearLayout

        ll_fragment_profile_profile_settings.setOnClickListener(this)
        ll_profile_payments_refill_account.setOnClickListener(this)
        ll_profile_cash.setOnClickListener(this)

        return view
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.ll_fragment_profile_profile_settings -> {
                fragmentManager?.beginTransaction()?.replace(
                    R.id.fragment_container_main_activity,
                    ProfileSettingsProfileFragment()
                )?.commit()
            }
            R.id.ll_profile_payments_refill_account -> {
                fragmentManager?.beginTransaction()?.replace(
                    R.id.fragment_container_main_activity,
                    ProfileSettingsAccountFragment(), "ProfileSettingsAccountFragment"
                )?.commit()
            }
            R.id.ll_profile_cash -> {
                fragmentManager?.beginTransaction()?.replace(
                    R.id.fragment_container_main_activity,
                    ProfilePaymentsFragment()
                )?.commit()
            }
        }
            (activity as AppCompatActivity).toolbar_main_drawer?.visibility = View.GONE
    }
}
