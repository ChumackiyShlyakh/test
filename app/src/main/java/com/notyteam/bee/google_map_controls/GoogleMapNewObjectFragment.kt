package com.notyteam.bee.google_map_controls

import android.app.DatePickerDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.notyteam.bee.R
import com.notyteam.bee.core.arch.DialogCustomListView
import com.notyteam.bee.core.arch.DialogDataAdapter
import com.notyteam.bee.topics.google_map.fragment.GoogleMapsFragment
import com.notyteam.bee.utils.DatePickerFragment
import com.notyteam.bee.utils.OnBackPressed
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.dialog_custom_layout.*
import kotlinx.android.synthetic.main.fragment_google_maps_new_object.*
import java.util.*

class GoogleMapNewObjectFragment : Fragment(), DialogDataAdapter.RecyclerViewItemClickListener,
    OnBackPressed, View.OnClickListener {

    internal var customDialog: DialogCustomListView? = null
    var meaning: String = "meaning"
    lateinit var imgbtn_fragment_google_maps_new_object_back: ImageButton
    lateinit var btn_fragment_google_maps_newobject: Button
    lateinit var btn_fragment_google_maps_new_object_save: Button
    private var datePickerInput: Int? = null
    var btn_fragment_google_maps_new_object_date_from: Button? = null
    var btn_fragment_google_maps_new_object_date_to: Button? = null
    private var dateFrom: Int? = null
    private var dateTo: Int? = null
    private var isPressedDataFrom: Boolean? = false
    private var isPressedDataTo: Boolean? = false
    private var toast: Toast? = null

    var textItems = arrayOf(
        "Beehouses",
        "People",
        "Animals",
        "Garden",
        "Biohasard",
        "Mushrooms",
        "Health plants",
        "Another"
    )
    var imagesItems = intArrayOf(
        R.drawable.object_beehouses,
        R.drawable.object_people,
        R.drawable.object_animals,
        R.drawable.object_garden,
        R.drawable.object_biohasard,
        R.drawable.object_mushrooms,
        R.drawable.object_plants_health,
        R.drawable.object_another
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_google_maps_new_object, container, false)

        (activity as AppCompatActivity).toolbar_main_drawer?.visibility = View.GONE

        imgbtn_fragment_google_maps_new_object_back =
            view.findViewById(R.id.imgbtn_fragment_google_maps_new_object_back)
        btn_fragment_google_maps_newobject =
            view.findViewById(R.id.btn_fragment_google_maps_newobject)
        btn_fragment_google_maps_new_object_save =
            view.findViewById(R.id.btn_fragment_google_maps_new_object_save)

        btn_fragment_google_maps_new_object_date_from =
            view?.findViewById(R.id.btn_fragment_google_maps_new_object_date_from)
        btn_fragment_google_maps_new_object_date_to =
            view?.findViewById(R.id.btn_fragment_google_maps_new_object_date_to)
        btn_fragment_google_maps_new_object_date_from?.setOnClickListener(this)
        btn_fragment_google_maps_new_object_date_to?.setOnClickListener(this)

        imgbtn_fragment_google_maps_new_object_back.setOnClickListener({
            fragmentManager?.beginTransaction()?.replace(
                R.id.fragment_container_main_activity,
                GoogleMapsFragment()
            )?.commit()
            (activity as AppCompatActivity).toolbar_main_drawer?.visibility = View.VISIBLE
        })

        btn_fragment_google_maps_newobject.setOnClickListener(View.OnClickListener {
            tv_dialogcustom?.setText(R.string.choose_object)
            showItems(this)
        })

        btn_fragment_google_maps_new_object_save.setOnClickListener({

            if (btn_fragment_google_maps_new_object_date_from?.hint?.equals("From")!! || btn_fragment_google_maps_new_object_date_to?.hint?.equals(
                    "To"
                )!!
            ) {
                toast = Toast.makeText(view.context, "Wrong date!", Toast.LENGTH_LONG)
                toast?.setGravity(Gravity.CENTER, 0, 0)
                toast?.show()
            } else if (btn_fragment_google_maps_new_object_date_from?.text?.equals("__.__.____")!! || btn_fragment_google_maps_new_object_date_to?.text?.equals(
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

    private fun showItems(view: GoogleMapNewObjectFragment) {
        val dataAdapter = DialogDataAdapter(meaning, textItems, imagesItems, this)
        customDialog = activity?.let { DialogCustomListView(it, dataAdapter) }
        customDialog?.show()
        val window = customDialog?.getWindow()
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        window?.setLayout(
            RelativeLayout.LayoutParams.MATCH_PARENT,
            RelativeLayout.LayoutParams.MATCH_PARENT
        )
        customDialog?.setCanceledOnTouchOutside(false)
    }

    override fun clickOnItem(data: String) {
        btn_fragment_google_maps_newobject.text = data
        if (customDialog != null) {
            customDialog?.dismiss()
        }
    }

    override fun clickOnItemLanguage(data: String) {
    }

    private fun showDatePicker() {
        val date = DatePickerFragment()
        val calender = Calendar.getInstance()
        val args = Bundle()
        args.putInt("year", calender.get(Calendar.YEAR))
        args.putInt("month", calender.get(Calendar.MONTH))
        args.putInt("day", calender.get(Calendar.DAY_OF_MONTH))

//        args.putInt("yearFrom", calender.get(Calendar.YEAR))
//        args.putInt("monthFrom", calender.get(Calendar.MONTH))
//        args.putInt("dayFrom", 22)

        date.arguments = args
        date.setCallBack(ondate)
        date.show(fragmentManager!!, "Date Picker")
    }

//    var datePicker: DatePicker? = null

    var ondate: DatePickerDialog.OnDateSetListener = object : DatePickerDialog.OnDateSetListener {

        override fun onDateSet(
            view: DatePicker, year: Int, monthOfYear: Int,
            dayOfMonth: Int
        ) {

            when (datePickerInput) {
                R.id.btn_fragment_google_maps_new_object_date_from -> {
                    btn_fragment_google_maps_new_object_date_from?.text =
                        dayOfMonth.toString() + "." + (monthOfYear + 1).toString() + "." + year.toString()
                    btn_fragment_google_maps_new_object_date_from?.hint = ""
                    isPressedDataFrom = true
                    dateFrom = year + (monthOfYear + 1) + dayOfMonth

//                    datePicker = DatePicker(context)
//                    datePicker?.init(year, monthOfYear + 1, 22, null)

                    if (isPressedDataFrom!! && isPressedDataTo!!) {
                        if (dateFrom!! >= dateTo!!) {
                            btn_fragment_google_maps_new_object_date_from?.text = "__.__.____"

                            toast = Toast.makeText(view.context, "Wrong date!", Toast.LENGTH_LONG)
                            toast?.setGravity(Gravity.CENTER, 0, 0)
                            toast?.show()
                            dateFrom = 1
                        }
                    }
                }
                R.id.btn_fragment_google_maps_new_object_date_to -> {
                    btn_fragment_google_maps_new_object_date_to?.text =
                        dayOfMonth.toString() + "." + (monthOfYear + 1).toString() + "." + year.toString()
                    btn_fragment_google_maps_new_object_date_to?.hint = ""
                    isPressedDataTo = true
                    dateTo = year + (monthOfYear + 1) + dayOfMonth

                    if (isPressedDataFrom!! && isPressedDataTo!!) {
                        if (dateFrom!! >= dateTo!!) {
                            btn_fragment_google_maps_new_object_date_to?.text = "__.__.____"
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
            R.id.btn_fragment_google_maps_new_object_date_from -> {
                datePickerInput = view.id
            }
            R.id.btn_fragment_google_maps_new_object_date_to -> {
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
