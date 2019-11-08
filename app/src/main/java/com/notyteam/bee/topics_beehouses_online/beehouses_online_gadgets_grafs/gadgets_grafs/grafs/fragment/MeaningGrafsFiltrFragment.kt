package com.notyteam.bee.topics_beehouses_online.beehouses_online_gadgets_grafs.gadgets_grafs.grafs.fragment

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.util.Log
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
import com.notyteam.bee.utils.DatePickerFragment
import com.notyteam.bee.utils.OnBackPressed
import kotlinx.android.synthetic.main.app_bar_main.*
import java.text.SimpleDateFormat
import java.util.*

class MeaningGrafsFiltrFragment : Fragment(), OnBackPressed, View.OnClickListener {

    var imgbtn_fragment_meaning_grafs_filtr_back: ImageButton? = null
    var fragment_meaning_grafs_filtr_period_build: Button? = null

    private var btn_fragment_meaning_grafs_filtr_hours: Button? = null
    private var btn_fragment_meaning_grafs_filtr_day: Button? = null
    private var btn_fragment_meaning_grafs_filtr_weak: Button? = null
    private var btn_fragment_meaning_grafs_filtr_month: Button? = null
    private var btnGrafsHoursTrueDayFalseClick: Boolean? = true
    private var btnGrafsWeakTrueMonthFalseClick: Boolean? = null
    private var datePickerInput: Int? = null
    var btn_fragment_meaning_grafs_filtr_from_date: Button? = null
    var btn_fragment_meaning_grafs_filtr_to_date: Button? = null
    var btn_fragment_meaning_grafs_filtr_from_time: Button? = null
    var btn_fragment_meaning_grafs_filtr_to_time: Button? = null
    private var toast: Toast? = null
    private var dateFrom: Int? = null
    private var dateTo: Int? = null
    private var timeFrom: Int? = null
    private var timeTo: Int? = null
    private var isPressedDataFrom: Boolean? = false
    private var isPressedDataTo: Boolean? = false
    private var isPressedTimeFrom: Boolean? = false
    private var isPressedTimeTo: Boolean? = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.fragment_meaning_grafs_filtr, container, false)

        imgbtn_fragment_meaning_grafs_filtr_back =
            view?.findViewById(R.id.imgbtn_fragment_meaning_grafs_filtr_back)
        fragment_meaning_grafs_filtr_period_build =
            view?.findViewById(R.id.fragment_meaning_grafs_filtr_period_build)

        btn_fragment_meaning_grafs_filtr_hours =
            view?.findViewById(R.id.btn_fragment_meaning_grafs_filtr_hours)
        btn_fragment_meaning_grafs_filtr_day =
            view?.findViewById(R.id.btn_fragment_meaning_grafs_filtr_day)
        btn_fragment_meaning_grafs_filtr_weak =
            view?.findViewById(R.id.btn_fragment_meaning_grafs_filtr_weak)
        btn_fragment_meaning_grafs_filtr_month =
            view?.findViewById(R.id.btn_fragment_meaning_grafs_filtr_month)

        btn_fragment_meaning_grafs_filtr_from_date =
            view?.findViewById(R.id.btn_fragment_meaning_grafs_filtr_from_date)
        btn_fragment_meaning_grafs_filtr_to_date =
            view?.findViewById(R.id.btn_fragment_meaning_grafs_filtr_to_date)
        btn_fragment_meaning_grafs_filtr_from_date?.setOnClickListener(this)
        btn_fragment_meaning_grafs_filtr_to_date?.setOnClickListener(this)

        btn_fragment_meaning_grafs_filtr_from_time =
            view?.findViewById(R.id.btn_fragment_meaning_grafs_filtr_from_time)
        btn_fragment_meaning_grafs_filtr_to_time =
            view?.findViewById(R.id.btn_fragment_meaning_grafs_filtr_to_time)
        btn_fragment_meaning_grafs_filtr_from_time?.setOnClickListener(this)
        btn_fragment_meaning_grafs_filtr_to_time?.setOnClickListener(this)

        btn_fragment_meaning_grafs_filtr_hours?.setOnClickListener({
            btnGrafsHoursTrueDayFalseClick = true
            isButtonGrafsHoursTrueDayFalseClick()
        })

        btn_fragment_meaning_grafs_filtr_day?.setOnClickListener({
            btnGrafsHoursTrueDayFalseClick = false
            isButtonGrafsHoursTrueDayFalseClick()
        })

        btn_fragment_meaning_grafs_filtr_weak?.setOnClickListener({
            btnGrafsWeakTrueMonthFalseClick = true
            isButtonWeakTrueMonthFalseClick()
        })

        btn_fragment_meaning_grafs_filtr_month?.setOnClickListener({
            btnGrafsWeakTrueMonthFalseClick = false
            isButtonWeakTrueMonthFalseClick()
        })

        imgbtn_fragment_meaning_grafs_filtr_back?.setOnClickListener({
            fragmentManager?.beginTransaction()?.replace(
                R.id.fragment_container_main_activity,
                MeaningGrafsFragment()
            )?.commit()
        })

        fragment_meaning_grafs_filtr_period_build?.setOnClickListener({

            if (btn_fragment_meaning_grafs_filtr_from_date?.hint?.equals("Date")!! || btn_fragment_meaning_grafs_filtr_to_date?.hint?.equals(
                    "Date"
                )!!
            ) {
                toast = Toast.makeText(view?.context, "Wrong date!", Toast.LENGTH_LONG)
                toast?.setGravity(Gravity.CENTER, 0, 0)
                toast?.show()
            } else if (btn_fragment_meaning_grafs_filtr_from_date?.text?.equals("__.__.____")!! || btn_fragment_meaning_grafs_filtr_to_date?.text?.equals(
                    "__.__.____"
                )!!
            ) {
                toast = Toast.makeText(view?.context, "Wrong date!", Toast.LENGTH_LONG)
                toast?.setGravity(Gravity.CENTER, 0, 0)
                toast?.show()
            } else if (dateFrom!! < dateTo!!) {
                if (btn_fragment_meaning_grafs_filtr_from_time?.hint?.equals("Time")!! || btn_fragment_meaning_grafs_filtr_to_time?.hint?.equals(
                        "Time"
                    )!!
                ) {
                    toast = Toast.makeText(view?.context, "Wrong time!", Toast.LENGTH_LONG)
                    toast?.setGravity(Gravity.CENTER, 0, 0)
                    toast?.show()
                } else if (btn_fragment_meaning_grafs_filtr_from_time?.text?.equals("__.__.____")!! || btn_fragment_meaning_grafs_filtr_to_time?.text?.equals(
                        "__.__.____"
                    )!!
                ) {
                    toast = Toast.makeText(view?.context, "Wrong time!", Toast.LENGTH_LONG)
                    toast?.setGravity(Gravity.CENTER, 0, 0)
                    toast?.show()
                } else {
                    fragmentManager?.beginTransaction()?.replace(
                        R.id.fragment_container_main_activity,
                        MeaningGrafsFragment()
                    )?.commit()
                }
            } else {
                if (btn_fragment_meaning_grafs_filtr_from_date?.text?.equals(
                        btn_fragment_meaning_grafs_filtr_to_date?.text
                    )!!
                ) {
                    if (btn_fragment_meaning_grafs_filtr_from_time?.hint?.equals("Time")!! || btn_fragment_meaning_grafs_filtr_to_time?.hint?.equals(
                            "Time"
                        )!!
                    ) {
                        toast = Toast.makeText(view?.context, "Wrong time!", Toast.LENGTH_LONG)
                        toast?.setGravity(Gravity.CENTER, 0, 0)
                        toast?.show()
                    } else if (btn_fragment_meaning_grafs_filtr_from_time?.text?.equals("__.__.____")!! || btn_fragment_meaning_grafs_filtr_to_time?.text?.equals(
                            "__.__.____"
                        )!!
                    ) {
                        toast = Toast.makeText(view?.context, "Wrong time!", Toast.LENGTH_LONG)
                        toast?.setGravity(Gravity.CENTER, 0, 0)
                        toast?.show()
                    } else {
                        fragmentManager?.beginTransaction()?.replace(
                            R.id.fragment_container_main_activity,
                            MeaningGrafsFragment()
                        )?.commit()
                    }
                }
            }
        })

        return view
    }

    private fun isButtonGrafsHoursTrueDayFalseClick() {
        if (btnGrafsHoursTrueDayFalseClick!!) {
            btn_fragment_meaning_grafs_filtr_hours?.setBackgroundResource(R.drawable.button_orange)
            btn_fragment_meaning_grafs_filtr_hours?.setTextColor(getResources().getColor(R.color.white))
            btn_fragment_meaning_grafs_filtr_day?.setBackgroundResource(R.drawable.ed_border_grey)
            btn_fragment_meaning_grafs_filtr_day?.setTextColor(getResources().getColor(R.color.black))
        } else {
            btn_fragment_meaning_grafs_filtr_hours?.setBackgroundResource(R.drawable.ed_border_grey)
            btn_fragment_meaning_grafs_filtr_hours?.setTextColor(getResources().getColor(R.color.black))
            btn_fragment_meaning_grafs_filtr_day?.setBackgroundResource(R.drawable.button_orange)
            btn_fragment_meaning_grafs_filtr_day?.setTextColor(getResources().getColor(R.color.white))
        }
    }

    private fun isButtonWeakTrueMonthFalseClick() {
        if (btnGrafsWeakTrueMonthFalseClick!!) {
            btn_fragment_meaning_grafs_filtr_weak?.setBackgroundResource(R.drawable.button_orange)
            btn_fragment_meaning_grafs_filtr_weak?.setTextColor(getResources().getColor(R.color.white))
            btn_fragment_meaning_grafs_filtr_month?.setBackgroundResource(R.drawable.ed_border_grey)
            btn_fragment_meaning_grafs_filtr_month?.setTextColor(getResources().getColor(R.color.black))
        } else {
            btn_fragment_meaning_grafs_filtr_weak?.setBackgroundResource(R.drawable.ed_border_grey)
            btn_fragment_meaning_grafs_filtr_weak?.setTextColor(getResources().getColor(R.color.black))
            btn_fragment_meaning_grafs_filtr_month?.setBackgroundResource(R.drawable.button_orange)
            btn_fragment_meaning_grafs_filtr_month?.setTextColor(getResources().getColor(R.color.white))
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
                R.id.btn_fragment_meaning_grafs_filtr_from_date -> {
                    btn_fragment_meaning_grafs_filtr_from_date?.text =
                        dayOfMonth.toString() + "." + (monthOfYear + 1).toString() + "." + year.toString()
                    btn_fragment_meaning_grafs_filtr_from_date?.hint = ""
                    isPressedDataFrom = true
                    dateFrom = year + (monthOfYear + 1) + dayOfMonth

                    if (isPressedDataFrom!! && isPressedDataTo!!) {
                        if (dateFrom!! > dateTo!!) {
                            btn_fragment_meaning_grafs_filtr_from_date?.text = "__.__.____"
                            toast = Toast.makeText(view.context, "Wrong date!", Toast.LENGTH_LONG)
                            toast?.setGravity(Gravity.CENTER, 0, 0)
                            toast?.show()
                            dateFrom = 1
                        }
                    }
                }
                R.id.btn_fragment_meaning_grafs_filtr_to_date -> {
                    btn_fragment_meaning_grafs_filtr_to_date?.text =
                        dayOfMonth.toString() + "." + (monthOfYear + 1).toString() + "." + year.toString()
                    btn_fragment_meaning_grafs_filtr_to_date?.hint = ""
                    isPressedDataTo = true
                    dateTo = year + (monthOfYear + 1) + dayOfMonth

                    if (isPressedDataFrom!! && isPressedDataTo!!) {
                        if (dateFrom!! > dateTo!!) {
                            btn_fragment_meaning_grafs_filtr_to_date?.text = "__.__.____"
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
            R.id.btn_fragment_meaning_grafs_filtr_from_date -> {
                datePickerInput = view.id
                showDatePicker()
            }
            R.id.btn_fragment_meaning_grafs_filtr_to_date -> {
                datePickerInput = view.id
                showDatePicker()
            }
            R.id.btn_fragment_meaning_grafs_filtr_from_time -> {
                isPressedTimeFrom = true
                val cal = Calendar.getInstance()
                val timeSetListener =
                    TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                        cal.set(Calendar.HOUR_OF_DAY, hour)
                        cal.set(Calendar.MINUTE, minute)
//                        btn_fragment_meaning_grafs_filtr_from_time?.text =
//                            SimpleDateFormat("HH:mm").format(cal.time)
                        timeFrom = hour + minute


                        if (dateFrom == null || dateTo == null) {
                            toast = Toast.makeText(view.context, "Wrong date!", Toast.LENGTH_LONG)
                            toast?.setGravity(Gravity.CENTER, 0, 0)
                            toast?.show()
                            timeFrom = 1
                        } else if (btn_fragment_meaning_grafs_filtr_from_date?.text?.equals("__.__.____")!! || btn_fragment_meaning_grafs_filtr_to_date?.text?.equals(
                                "__.__.____"
                            )!!
                        ) {
                            toast = Toast.makeText(view?.context, "Wrong date!", Toast.LENGTH_LONG)
                            toast?.setGravity(Gravity.CENTER, 0, 0)
                            toast?.show()
                            timeFrom = 1
                        } else if (dateFrom!! < dateTo!!) {
                            btn_fragment_meaning_grafs_filtr_from_time?.text =
                                SimpleDateFormat("HH:mm").format(cal.time)
                            timeFrom = hour + minute
                        } else if (dateFrom!! == dateTo!!) {
                            if (isPressedTimeTo!!) {
                                Log.d("dateTo", "dateTo 1 " + timeTo + " dateFrom " + timeFrom)
                                if (timeFrom!! >= timeTo!!) {
                                    btn_fragment_meaning_grafs_filtr_from_time?.text = "__.__.____"
                                    toast =
                                        Toast.makeText(
                                            view.context,
                                            "Wrong time!",
                                            Toast.LENGTH_LONG
                                        )
                                    toast?.setGravity(Gravity.CENTER, 0, 0)
                                    toast?.show()
                                    timeFrom = 1
                                } else {
                                    btn_fragment_meaning_grafs_filtr_from_time?.text =
                                        SimpleDateFormat("HH:mm").format(cal.time)
                                    timeFrom = hour + minute
                                }
                            } else {
                                btn_fragment_meaning_grafs_filtr_from_time?.text =
                                    SimpleDateFormat("HH:mm").format(cal.time)
                                timeFrom = hour + minute
                            }
                            btn_fragment_meaning_grafs_filtr_from_time?.hint = ""
                        }
                    }

                TimePickerDialog(
                    context,
                    R.style.DialogTheme,
                    timeSetListener,
                    cal.get(Calendar.HOUR_OF_DAY),
                    cal.get(
                        Calendar.MINUTE
                    ),
                    true
                ).show()

            }
            R.id.btn_fragment_meaning_grafs_filtr_to_time -> {
                isPressedTimeTo = true
                val cal = Calendar.getInstance()
                val timeSetListener =
                    TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                        cal.set(Calendar.HOUR_OF_DAY, hour)
                        cal.set(Calendar.MINUTE, minute)
//                        btn_fragment_meaning_grafs_filtr_to_time?.text =
//                            SimpleDateFormat("HH:mm").format(cal.time)
                        timeTo = hour + minute

                        if (dateFrom == null || dateTo == null) {
                            toast = Toast.makeText(view.context, "Wrong date!", Toast.LENGTH_LONG)
                            toast?.setGravity(Gravity.CENTER, 0, 0)
                            toast?.show()
                            timeTo = 999999999
                        } else if (btn_fragment_meaning_grafs_filtr_from_date?.text?.equals("__.__.____")!! || btn_fragment_meaning_grafs_filtr_to_date?.text?.equals(
                                "__.__.____"
                            )!!
                        ) {
                            toast = Toast.makeText(view?.context, "Wrong date!", Toast.LENGTH_LONG)
                            toast?.setGravity(Gravity.CENTER, 0, 0)
                            toast?.show()
                            timeTo = 999999999
                        } else if (dateFrom!! < dateTo!!) {
                            btn_fragment_meaning_grafs_filtr_to_time?.text =
                                SimpleDateFormat("HH:mm").format(cal.time)
                            timeTo = hour + minute
                        } else if (dateFrom!! == dateTo!!) {
                            if (isPressedTimeFrom!!) {
                                if (timeFrom!! >= timeTo!!) {
                                    btn_fragment_meaning_grafs_filtr_to_time?.text = "__.__.____"
                                    toast =
                                        Toast.makeText(
                                            view.context,
                                            "Wrong time!",
                                            Toast.LENGTH_LONG
                                        )
                                    toast?.setGravity(Gravity.CENTER, 0, 0)
                                    toast?.show()
                                    timeTo = 999999999
                                } else {
                                    Log.d("dateTo", "dateTo 2 " + timeTo + " dateFrom " + timeFrom)
                                    btn_fragment_meaning_grafs_filtr_to_time?.text =
                                        SimpleDateFormat("HH:mm").format(cal.time)
                                    timeTo = hour + minute
                                }
                            } else {
                                btn_fragment_meaning_grafs_filtr_to_time?.text =
                                    SimpleDateFormat("HH:mm").format(cal.time)
                                timeTo = hour + minute
                            }
                            btn_fragment_meaning_grafs_filtr_to_time?.hint = ""
                        }
                    }
                TimePickerDialog(
                    context,
                    R.style.DialogTheme,
                    timeSetListener,
                    cal.get(Calendar.HOUR_OF_DAY),
                    cal.get(
                        Calendar.MINUTE
                    ),
                    true
                ).show()


            }
        }
    }

    override fun onBackPressed() {
        fragmentManager?.beginTransaction()?.replace(
            R.id.fragment_container_main_activity,
            MeaningGrafsFragment()
        )?.commit()
    }
}