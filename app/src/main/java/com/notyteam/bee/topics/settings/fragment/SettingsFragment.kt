package com.notyteam.bee.topics.settings.fragment

import android.app.TimePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.notyteam.bee.R
import com.notyteam.bee.profile_fragments.ProfileAccountDetailFragment
import com.notyteam.bee.profile_fragments.ProfileRefillFragment
import com.notyteam.bee.topics.profile.fragment.ProfileFragment
import kotlinx.android.synthetic.main.fragment_settings.*
import java.text.SimpleDateFormat
import java.util.*

class SettingsFragment : Fragment() {

    var btn_fragment_settings_choose_time: Button? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_settings, container, false)

        btn_fragment_settings_choose_time = view.findViewById(R.id.btn_fragment_settings_choose_time)
        val ll_fragment_settings_exit_from_account = ll_fragment_settings_exit_from_account

        btn_fragment_settings_choose_time?.setOnClickListener( {
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)
                btn_fragment_settings_choose_time?.text = SimpleDateFormat("HH:mm").format(cal.time)
            }
            TimePickerDialog(context, R.style.DialogTheme, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true).show()
        })

        ll_fragment_settings_exit_from_account?.setOnClickListener(View.OnClickListener {
//            fragmentManager?.beginTransaction()?.replace(
//                R.id.fragment_container_main_activity,  R.style.DialogTheme,
//                ProfileAccountDetailFragment()
//            )?.commit()
        })

        return view
    }
}