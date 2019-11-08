package com.notyteam.bee.topics.my_places.controls

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
import com.notyteam.bee.topics.my_places.MyPlacesFragment
import com.notyteam.bee.utils.DatePickerFragment
import com.notyteam.bee.utils.OnBackPressed
import kotlinx.android.synthetic.main.app_bar_main.*
import java.util.*


class MyPlacesControlsObjectFragment : Fragment(), OnBackPressed {

    //    var cal = Calendar.getInstance()
    private var datePickerInput: Int? = null
    var imgbtn_fragment_myplaces_controls_object_back: ImageButton? = null
    var btn_fragment_myplaces_controls_objects_date_creation: Button? = null
    var btn_fragment_myplaces_controls_objects_date_from: Button? = null
    var btn_fragment_myplaces_controls_objects_date_to: Button? = null
    var btn_fragment_myplaces_controls_object_applay: Button? = null
    private var toast: Toast? = null
    private var dateFrom: Int? = null
    private var dateTo: Int? = null
    private var isPressedDataFrom: Boolean? = false
    private var isPressedDataTo: Boolean? = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View? =
            inflater.inflate(R.layout.fragment_myplaces_controls_objects, container, false)

        imgbtn_fragment_myplaces_controls_object_back =
            view?.findViewById(R.id.imgbtn_fragment_myplaces_controls_object_back)
        btn_fragment_myplaces_controls_objects_date_creation =
            view?.findViewById(R.id.btn_fragment_myplaces_controls_objects_date_creation)
        btn_fragment_myplaces_controls_objects_date_from =
            view?.findViewById(R.id.btn_fragment_myplaces_controls_objects_date_from)
        btn_fragment_myplaces_controls_objects_date_to =
            view?.findViewById(R.id.btn_fragment_myplaces_controls_objects_date_to)
        btn_fragment_myplaces_controls_object_applay =
            view?.findViewById(R.id.btn_fragment_myplaces_controls_object_applay)

        imgbtn_fragment_myplaces_controls_object_back?.setOnClickListener({
            fragmentManager?.beginTransaction()?.replace(
                R.id.fragment_container_main_activity,
                MyPlacesFragment()
            )?.commit()
            (activity as AppCompatActivity).toolbar_main_drawer?.visibility = View.VISIBLE
        })

        btn_fragment_myplaces_controls_objects_date_creation?.setOnClickListener(object :
            View.OnClickListener {
            override fun onClick(view: View) {
                showDatePicker()
                datePickerInput = view.id
            }
        })

        btn_fragment_myplaces_controls_objects_date_from?.setOnClickListener(object :
            View.OnClickListener {
            override fun onClick(view: View) {
                showDatePicker()
                datePickerInput = view.id
            }
        })

        btn_fragment_myplaces_controls_objects_date_to?.setOnClickListener(object :
            View.OnClickListener {
            override fun onClick(view: View) {
                showDatePicker()
                datePickerInput = view.id
            }

        })

        btn_fragment_myplaces_controls_object_applay?.setOnClickListener({
            if (btn_fragment_myplaces_controls_objects_date_from?.hint?.equals("From")!! || btn_fragment_myplaces_controls_objects_date_to?.hint?.equals(
                    "To"
                )!!
            ) {
                toast = Toast.makeText(view?.context, "Wrong date!", Toast.LENGTH_LONG)
                toast?.setGravity(Gravity.CENTER, 0, 0)
                toast?.show()
            } else if (btn_fragment_myplaces_controls_objects_date_from?.text?.equals("__.__.____")!! || btn_fragment_myplaces_controls_objects_date_to?.text?.equals(
                    "__.__.____"
                )!!
            ) {
                toast = Toast.makeText(view?.context, "Wrong date!", Toast.LENGTH_LONG)
                toast?.setGravity(Gravity.CENTER, 0, 0)
                toast?.show()
            } else {
                fragmentManager?.beginTransaction()?.replace(
                    R.id.fragment_container_main_activity,
                    MyPlacesFragment()
                )?.commit()
                (activity as AppCompatActivity).toolbar_main_drawer?.visibility = View.VISIBLE
            }
        })

        return view
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
                R.id.btn_fragment_myplaces_controls_objects_date_creation -> {
                    btn_fragment_myplaces_controls_objects_date_creation?.text =
                        dayOfMonth.toString() + "." + (monthOfYear + 1).toString() + "." + year.toString()
                }
                R.id.btn_fragment_myplaces_controls_objects_date_from -> {
                    btn_fragment_myplaces_controls_objects_date_from?.text =
                        dayOfMonth.toString() + "." + (monthOfYear + 1).toString() + "." + year.toString()
                    btn_fragment_myplaces_controls_objects_date_from?.hint = ""
                    isPressedDataFrom = true
                    dateFrom = year + (monthOfYear + 1) + dayOfMonth

                    if (isPressedDataFrom!! && isPressedDataTo!!) {
                        if (dateFrom!! >= dateTo!!) {
                            btn_fragment_myplaces_controls_objects_date_from?.text = "__.__.____"
                            toast = Toast.makeText(view.context, "Wrong date!", Toast.LENGTH_LONG)
                            toast?.setGravity(Gravity.CENTER, 0, 0)
                            toast?.show()
                            dateFrom = 1
                        }
                    }
                }
                R.id.btn_fragment_myplaces_controls_objects_date_to -> {
                    btn_fragment_myplaces_controls_objects_date_to?.text =
                        dayOfMonth.toString() + "." + (monthOfYear + 1).toString() + "." + year.toString()
                    btn_fragment_myplaces_controls_objects_date_to?.hint = ""
                    isPressedDataTo = true
                    dateTo = year + (monthOfYear + 1) + dayOfMonth

                    if (isPressedDataFrom!! && isPressedDataTo!!) {
                        if (dateFrom!! >= dateTo!!) {
                            btn_fragment_myplaces_controls_objects_date_to?.text = "__.__.____"
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

    override fun onBackPressed() {
        fragmentManager?.beginTransaction()?.replace(
            R.id.fragment_container_main_activity,
            MyPlacesFragment()
        )?.commit()
        (activity as AppCompatActivity).toolbar_main_drawer?.visibility = View.VISIBLE
    }
}