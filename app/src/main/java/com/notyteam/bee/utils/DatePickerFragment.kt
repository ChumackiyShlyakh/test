package com.notyteam.bee.utils

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class DatePickerFragment : DialogFragment() {

    internal lateinit var ondateSet: DatePickerDialog.OnDateSetListener
    private var year: Int = 0
    private var month: Int = 0
    private var day: Int = 0

//    private var yearFrom: Int = 0
//    private var monthFrom: Int = 0
//    private var dayFrom: Int = 0

    fun setCallBack(ondate: DatePickerDialog.OnDateSetListener) {
        ondateSet = ondate
    }

    @SuppressLint("NewApi")
    override fun setArguments(args: Bundle?) {
        super.setArguments(args)
        year = args!!.getInt("year")
        month = args.getInt("month")
        day = args.getInt("day")

//        yearFrom = args.getInt("yearFrom")
//        monthFrom = args.getInt("monthFrom")
//        dayFrom = args.getInt("dayFrom")
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return DatePickerDialog(activity!!, ondateSet, year, month, day)
    }
}