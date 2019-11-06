package com.notyteam.bee.topics_beehouses_online.beehouses_online_gadgets_grafs.gadgets_grafs.grafs.fragment

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.notyteam.bee.R
import com.notyteam.bee.topics_beehouses_online.beehouses_online_gadgets_grafs.GadgetsGrafsFragment
import com.notyteam.bee.utils.OnBackPressed
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.dialog_exit.*
import kotlinx.android.synthetic.main.fragment_meaning_grafs.*
import lecho.lib.hellocharts.animation.ChartAnimationListener
import lecho.lib.hellocharts.gesture.ContainerScrollType
import lecho.lib.hellocharts.gesture.ZoomType
import lecho.lib.hellocharts.listener.LineChartOnValueSelectListener
import lecho.lib.hellocharts.model.*
import lecho.lib.hellocharts.util.ChartUtils
import lecho.lib.hellocharts.view.Chart
import lecho.lib.hellocharts.view.LineChartView
import java.util.ArrayList

class MeaningGrafsFragment : Fragment(), OnBackPressed {

    var imgbtn_fragment_meaning_grafs_back: ImageButton? = null
    var imgbtn_fragment_meaning_grafs_controls: ImageButton? = null

    private var chart: LineChartView? = null
    private var data: LineChartData? = null

    private var numberOfLines = 1
    private val maxNumberOfLines = 4

    var time = arrayListOf("08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00")

    internal var randomNumbersTab = Array(maxNumberOfLines) { FloatArray(time.size) }


    private var hasLines = true
    private var hasPoints = true
    private var shape = ValueShape.CIRCLE
    private var isFilled = false
    private var hasLabels = false
    private var isCubic = false
    private var hasLabelForSelected = false


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_meaning_grafs, container, false)

        imgbtn_fragment_meaning_grafs_back = view?.findViewById(R.id.imgbtn_fragment_meaning_grafs_back)
        imgbtn_fragment_meaning_grafs_controls = view?.findViewById(R.id.imgbtn_fragment_meaning_grafs_controls)

        imgbtn_fragment_meaning_grafs_back?.setOnClickListener({
            fragmentManager?.beginTransaction()?.replace(
                R.id.fragment_container_main_activity,
                GadgetsGrafsFragment()
            )?.commit()
            (activity as AppCompatActivity).toolbar_main_drawer?.visibility = View.VISIBLE
        })
        imgbtn_fragment_meaning_grafs_controls?.setOnClickListener({
            fragmentManager?.beginTransaction()?.replace(
                R.id.fragment_container_main_activity,
                MeaningGrafsFiltrFragment()
            )?.commit()
        })

        chart = view.findViewById<View>(R.id.chart) as LineChartView

        generateData()

        // Disable viewport recalculations, see toggleCubic() method for more info.
        chart!!.isViewportCalculationEnabled = true
        chart!!.setZoomType(ZoomType.HORIZONTAL)
        chart!!.setContainerScrollEnabled(true,ContainerScrollType.HORIZONTAL)


        return view
    }

    fun showDialog(activity: Activity) {
        val dialog = Dialog(activity)
        dialog.setCanceledOnTouchOutside(true)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.dialog_graf_point_information)
        dialog.show()

        val window = dialog.getWindow()
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        window?.setLayout(
            RelativeLayout.LayoutParams.MATCH_PARENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT
        )
        window?.setGravity(Gravity.CENTER)

        var btn_dialog_exit_application =
            dialog.btn_dialog_exit_application.findViewById<Button>(R.id.btn_dialog_exit_application)
        var btn_dialog_exit_account =
            dialog.btn_dialog_exit_account.findViewById<Button>(R.id.btn_dialog_exit_account)

        btn_dialog_exit_application.setOnClickListener { dialog.dismiss() }
        btn_dialog_exit_account.setOnClickListener { dialog.dismiss() }
    }


    private fun generateData() {

        val lines = ArrayList<Line>()
        val axisValues = ArrayList<AxisValue>()

        for (i in 0 until numberOfLines) {

            val values = ArrayList<PointValue>()
            for (j in 0 until time.size) {
                values.add(PointValue(j.toFloat(), randomNumbersTab[i][j]))
                axisValues.add(AxisValue(j.toFloat()).setLabel(time[j]))
            }

            val line = Line(values)
            line.color = ChartUtils.COLORS[3]
            line.shape = shape
            line.isCubic = isCubic
            line.isFilled = isFilled
            line.setHasLabels(hasLabels)
            line.setHasLabelsOnlyForSelected(hasLabelForSelected)
            line.setHasLines(hasLines)
            line.setHasPoints(hasPoints)
            lines.add(line)

        }

        data = LineChartData(lines)


        data!!.axisXBottom = Axis(axisValues).setHasLines(true).setHasTiltedLabels(true).setTextColor(R.color.black).setTextSize(10).setName("Time")
        data!!.axisYLeft = Axis().setHasLines(true).setHasTiltedLabels(true).setTextSize(10).setName("%").setTextColor(R.color.black)

        data!!.baseValue = java.lang.Float.NEGATIVE_INFINITY
        chart!!.lineChartData = data

    }

    override fun onBackPressed() {
        fragmentManager?.beginTransaction()?.replace(
            R.id.fragment_container_main_activity,
            GadgetsGrafsFragment()
        )?.commit()
        (activity as AppCompatActivity).toolbar_main_drawer?.visibility = View.VISIBLE
    }
}