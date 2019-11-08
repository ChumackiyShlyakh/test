package com.notyteam.bee.google_map_controls

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.notyteam.bee.R
import com.notyteam.bee.topics.google_map.fragment.GoogleMapsFragment
import com.notyteam.bee.topics.my_places.MyPlacesFragment
import com.notyteam.bee.utils.DatePickerFragment
import com.notyteam.bee.utils.OnBackPressed
import kotlinx.android.synthetic.main.app_bar_main.*
import java.util.*

class GoogleMapControlsFragment : Fragment(), OnBackPressed, View.OnClickListener {

    private var imgbtn_fragment_google_maps_controls_back: ImageButton? = null
    private var btn_fragment_google_maps_controls_objects: Button? = null
    private var btn_fragment_google_maps_controls_events: Button? = null
    private var btn_fragment_google_maps_controls_apply: Button? = null
    private var btnGoogleObjectsTrueEventFalseClick: Boolean? = true
    private var datePickerInput: Int? = null
    var btn_fragment_google_maps_controls_date_from: Button? = null
    var btn_fragment_google_maps_controls_date_to: Button? = null
    private var toast: Toast? = null
    private var dateFrom: Int? = null
    private var dateTo: Int? = null
    private var isPressedDataFrom: Boolean? = false
    private var isPressedDataTo: Boolean? = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_google_maps_controls, container, false)

        imgbtn_fragment_google_maps_controls_back =
            view.findViewById(R.id.imgbtn_fragment_google_maps_controls_back)
        btn_fragment_google_maps_controls_objects =
            view.findViewById(R.id.btn_fragment_google_maps_controls_objects)
        btn_fragment_google_maps_controls_events =
            view.findViewById(R.id.btn_fragment_google_maps_controls_events)
        btn_fragment_google_maps_controls_apply =
            view.findViewById(R.id.btn_fragment_google_maps_controls_apply)

        btn_fragment_google_maps_controls_date_from =
            view?.findViewById(R.id.btn_fragment_google_maps_controls_date_from)
        btn_fragment_google_maps_controls_date_to =
            view?.findViewById(R.id.btn_fragment_google_maps_controls_date_to)

        btn_fragment_google_maps_controls_date_from?.setOnClickListener(this)
        btn_fragment_google_maps_controls_date_to?.setOnClickListener(this)

        imgbtn_fragment_google_maps_controls_back?.setOnClickListener({
            fragmentManager?.beginTransaction()?.replace(
                R.id.fragment_container_main_activity,
                GoogleMapsFragment()
            )?.commit()
            (activity as AppCompatActivity).toolbar_main_drawer?.visibility = View.VISIBLE
        })

        btn_fragment_google_maps_controls_objects?.setOnClickListener({
            btnGoogleObjectsTrueEventFalseClick = true
            isButtonObjectsTrueEventFalsClick()
        })

        btn_fragment_google_maps_controls_events?.setOnClickListener({
            btnGoogleObjectsTrueEventFalseClick = false
            isButtonObjectsTrueEventFalsClick()
        })

        btn_fragment_google_maps_controls_apply?.setOnClickListener({
            if (btn_fragment_google_maps_controls_date_from?.hint?.equals("From")!! || btn_fragment_google_maps_controls_date_to?.hint?.equals(
                    "To"
                )!!
            ) {
                toast = Toast.makeText(view.context, "Wrong date!", Toast.LENGTH_LONG)
                toast?.setGravity(Gravity.CENTER, 0, 0)
                toast?.show()
            } else if (btn_fragment_google_maps_controls_date_from?.text?.equals("__.__.____")!! || btn_fragment_google_maps_controls_date_to?.text?.equals(
                    "__.__.____"
                )!!
            ) {
                toast = Toast.makeText(view.context, "Wrong date!", Toast.LENGTH_LONG)
                toast?.setGravity(Gravity.CENTER, 0, 0)
                toast?.show()
            } else {
                fragmentManager?.beginTransaction()?.replace(
                    R.id.fragment_container_main_activity,
                    GoogleMapsFragment()
                )?.commit()
                (activity as AppCompatActivity).toolbar_main_drawer?.visibility = View.VISIBLE
            }
        })

        return view
    }

    private fun isButtonObjectsTrueEventFalsClick() {
        if (btnGoogleObjectsTrueEventFalseClick!!) {
            btn_fragment_google_maps_controls_events?.setBackgroundResource(R.drawable.ed_border_grey)
            btn_fragment_google_maps_controls_events?.setTextColor(getResources().getColor(R.color.black))
            btn_fragment_google_maps_controls_objects?.setBackgroundResource(R.drawable.button_orange)
            btn_fragment_google_maps_controls_objects?.setTextColor(getResources().getColor(R.color.white))
        } else {
            btn_fragment_google_maps_controls_events?.setBackgroundResource(R.drawable.button_orange)
            btn_fragment_google_maps_controls_events?.setTextColor(getResources().getColor(R.color.white))
            btn_fragment_google_maps_controls_objects?.setBackgroundResource(R.drawable.ed_border_grey)
            btn_fragment_google_maps_controls_objects?.setTextColor(getResources().getColor(R.color.black))
        }
    }

    private fun showDatePicker() {
        val date = DatePickerFragment()
        val calender = Calendar.getInstance()
        val args = Bundle()
        args.putInt("year", calender.get(Calendar.YEAR))
        args.putInt("month", calender.get(Calendar.MONTH))
        args.putInt("day", calender.get(Calendar.DAY_OF_MONTH))
        date.arguments = args
        date.setCallBack(ondate)
        date.show(fragmentManager!!, "Date Picker")
    }

    var ondate: DatePickerDialog.OnDateSetListener = object : DatePickerDialog.OnDateSetListener {
        override fun onDateSet(
            view: DatePicker, year: Int, monthOfYear: Int,
            dayOfMonth: Int
        ) {
            when (datePickerInput) {
                R.id.btn_fragment_google_maps_controls_date_from -> {
                    btn_fragment_google_maps_controls_date_from?.text =
                        dayOfMonth.toString() + "." + (monthOfYear + 1).toString() + "." + year.toString()
                    btn_fragment_google_maps_controls_date_from?.hint = ""
                    isPressedDataFrom = true
                    dateFrom = year + (monthOfYear + 1) + dayOfMonth

                    if (isPressedDataFrom!! && isPressedDataTo!!) {
                        if (dateFrom!! >= dateTo!!) {
                            btn_fragment_google_maps_controls_date_from?.text = "__.__.____"

                            toast = Toast.makeText(view.context, "Wrong date!", Toast.LENGTH_LONG)
                            toast?.setGravity(Gravity.CENTER, 0, 0)
                            toast?.show()
                            dateFrom = 1
                        }
                    }
                }
                R.id.btn_fragment_google_maps_controls_date_to -> {
                    btn_fragment_google_maps_controls_date_to?.text =
                        dayOfMonth.toString() + "." + (monthOfYear + 1).toString() + "." + year.toString()
                    btn_fragment_google_maps_controls_date_to?.hint = ""
                    isPressedDataTo = true
                    dateTo = year + (monthOfYear + 1) + dayOfMonth

                    if (isPressedDataFrom!! && isPressedDataTo!!) {
                        if (dateFrom!! >= dateTo!!) {
                            btn_fragment_google_maps_controls_date_to?.text = "__.__.____"
                            toast = Toast.makeText(view.context, "Wrong date!", Toast.LENGTH_LONG)
                            toast?.setGravity(Gravity.CENTER, 0, 0)
                            toast?.show()
                            dateTo = 999999999
                        }
                    }
                }
            }
            datePickerInput = null
        }
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btn_fragment_google_maps_controls_date_from -> {
                datePickerInput = view.id
            }
            R.id.btn_fragment_google_maps_controls_date_to -> {
                datePickerInput = view.id
            }
        }
        showDatePicker()
    }

    override fun onBackPressed() {
        fragmentManager?.beginTransaction()?.replace(
            R.id.fragment_container_main_activity,
            GoogleMapsFragment()
        )?.commit()
        (activity as AppCompatActivity).toolbar_main_drawer?.visibility = View.VISIBLE
    }
}