package com.notyteam.bee.topics_beehouses_online.beehouses_online_gadgets_grafs.gadgets_grafs.grafs.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.notyteam.bee.R
import com.notyteam.bee.utils.OnBackPressed
import kotlinx.android.synthetic.main.app_bar_main.*

class MeaningGrafsFiltrFragment : Fragment(), OnBackPressed {

    var imgbtn_fragment_meaning_grafs_filtr_back: ImageButton? = null
    var fragment_meaning_grafs_filtr_period_build: Button? = null

    private var btn_fragment_meaning_grafs_filtr_hours: Button? = null
    private var btn_fragment_meaning_grafs_filtr_day: Button? = null
    private var btn_fragment_meaning_grafs_filtr_weak: Button? = null
    private var btn_fragment_meaning_grafs_filtr_month: Button? = null
    private var btnGrafsHoursTrueDayFalseClick: Boolean? = null
    private var btnGrafsWeakTrueMonthFalseClick: Boolean? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.fragment_meaning_grafs_filtr, container,false)

        imgbtn_fragment_meaning_grafs_filtr_back = view?.findViewById(R.id.imgbtn_fragment_meaning_grafs_filtr_back)
        fragment_meaning_grafs_filtr_period_build = view?.findViewById(R.id.fragment_meaning_grafs_filtr_period_build)

        btn_fragment_meaning_grafs_filtr_hours =
            view?.findViewById(R.id.btn_fragment_meaning_grafs_filtr_hours)
        btn_fragment_meaning_grafs_filtr_day =
            view?.findViewById(R.id.btn_fragment_meaning_grafs_filtr_day)
        btn_fragment_meaning_grafs_filtr_weak =
            view?.findViewById(R.id.btn_fragment_meaning_grafs_filtr_weak)
        btn_fragment_meaning_grafs_filtr_month =
            view?.findViewById(R.id.btn_fragment_meaning_grafs_filtr_month)

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
            fragmentManager?.beginTransaction()?.replace(
                R.id.fragment_container_main_activity,
                MeaningGrafsFragment()
            )?.commit()
        })

        return view
    }

    private fun isButtonGrafsHoursTrueDayFalseClick(){
        if(btnGrafsHoursTrueDayFalseClick!!){
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

    private fun isButtonWeakTrueMonthFalseClick(){
        if(btnGrafsWeakTrueMonthFalseClick!!){
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

    override fun onBackPressed() {
        fragmentManager?.beginTransaction()?.replace(
            R.id.fragment_container_main_activity,
            MeaningGrafsFragment()
        )?.commit()
    }
}