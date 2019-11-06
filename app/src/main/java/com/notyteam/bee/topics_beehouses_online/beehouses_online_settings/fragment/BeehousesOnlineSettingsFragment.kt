package com.notyteam.bee.topics_beehouses_online.beehouses_online_settings.fragment

import android.app.TimePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.notyteam.bee.R
import com.notyteam.bee.topics_beehouses_online.beehouses_online_gadgets_grafs.GadgetsGrafsFragment
import com.notyteam.bee.utils.OnBackPressed
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.fragment_beehouses_online_settings.*
import kotlinx.android.synthetic.main.fragment_settings.*
import java.text.SimpleDateFormat
import java.util.*

class BeehousesOnlineSettingsFragment : Fragment() {

    var rl_fragment_beehouses_online_settings_choose_time: RelativeLayout? = null
    var ll_fragment_gadgets_grafs_settings_exit_from_account: LinearLayout? = null
    var txt_fragment_beehouses_online_settings_choose_time: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_beehouses_online_settings, container, false)

        rl_fragment_beehouses_online_settings_choose_time = view.findViewById(R.id.rl_fragment_beehouses_online_settings_choose_time)
        ll_fragment_gadgets_grafs_settings_exit_from_account = view.findViewById(R.id.ll_fragment_gadgets_grafs_settings_exit_from_account)
        txt_fragment_beehouses_online_settings_choose_time = view.findViewById(R.id.btn_fragment_beehouses_online_settings_choose_time)

        rl_fragment_beehouses_online_settings_choose_time?.setOnClickListener( {
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)
                txt_fragment_beehouses_online_settings_choose_time?.text = SimpleDateFormat("HH:mm").format(cal.time)
            }
            TimePickerDialog(context, R.style.DialogTheme, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(
                Calendar.MINUTE), true).show()
        })

        ll_fragment_gadgets_grafs_settings_exit_from_account?.setOnClickListener( {
            this.activity?.finish()
        })

        return view
    }
}