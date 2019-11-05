package com.notyteam.bee.schedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

import com.notyteam.bee.R

import java.util.ArrayList

import lecho.lib.hellocharts.animation.ChartAnimationListener
import lecho.lib.hellocharts.gesture.ZoomType
import lecho.lib.hellocharts.listener.LineChartOnValueSelectListener
import lecho.lib.hellocharts.model.Axis
import lecho.lib.hellocharts.model.Line
import lecho.lib.hellocharts.model.LineChartData
import lecho.lib.hellocharts.model.PointValue
import lecho.lib.hellocharts.model.ValueShape
import lecho.lib.hellocharts.model.Viewport
import lecho.lib.hellocharts.util.ChartUtils
import lecho.lib.hellocharts.view.Chart
import lecho.lib.hellocharts.view.LineChartView

class LineChartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_line_chart)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().add(R.id.container, PlaceholderFragment())
                .commit()
        }
    }

    /**
     * A fragment containing a line chart.
     */
    class PlaceholderFragment : Fragment() {

        private var chart: LineChartView? = null
        private var data: LineChartData? = null
        private var numberOfLines = 1
        private val maxNumberOfLines = 4
        private val numberOfPoints = 12

        internal var randomNumbersTab = Array(maxNumberOfLines) { FloatArray(numberOfPoints) }

        private var hasAxes = true
        private var hasAxesNames = true
        private var hasLines = true
        private var hasPoints = true
        private var shape = ValueShape.CIRCLE
        private var isFilled = false
        private var hasLabels = false
        private var isCubic = false
        private var hasLabelForSelected = false
        private var pointsHaveDifferentColor: Boolean = false
        private var hasGradientToTransparent = false

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            setHasOptionsMenu(true)
            val rootView = inflater.inflate(R.layout.fragment_line_chart, container, false)

            chart = rootView.findViewById<View>(R.id.chart) as LineChartView
            chart!!.onValueTouchListener = ValueTouchListener()

            // Generate some random values.
            generateValues()

            generateData()

            // Disable viewport recalculations, see toggleCubic() method for more info.
            chart!!.isViewportCalculationEnabled = false

            resetViewport()

            return rootView
        }


        private fun generateValues() {
            for (i in 0 until maxNumberOfLines) {
                for (j in 0 until numberOfPoints) {
                    randomNumbersTab[i][j] = Math.random().toFloat() * 100f
                }
            }
        }

        private fun reset() {
            numberOfLines = 1

            hasAxes = true
            hasAxesNames = true
            hasLines = true
            hasPoints = true
            shape = ValueShape.CIRCLE
            isFilled = false
            hasLabels = false
            isCubic = false
            hasLabelForSelected = false
            pointsHaveDifferentColor = false

            chart!!.isValueSelectionEnabled = hasLabelForSelected
            resetViewport()
        }

        private fun resetViewport() {
            // Reset viewport height range to (0,100)
            val v = Viewport(chart!!.maximumViewport)
            v.bottom = 0f
            v.top = 100f
            v.left = 0f
            v.right = (numberOfPoints - 1).toFloat()
            chart!!.maximumViewport = v
            chart!!.currentViewport = v
        }

        private fun generateData() {

            val lines = ArrayList<Line>()
            for (i in 0 until numberOfLines) {

                val values = ArrayList<PointValue>()
                for (j in 0 until numberOfPoints) {
                    values.add(PointValue(j.toFloat(), randomNumbersTab[i][j]))
                }

                val line = Line(values)
                line.color = ChartUtils.COLORS[i]
                line.shape = shape
                line.isCubic = isCubic
                line.isFilled = isFilled
                line.setHasLabels(hasLabels)
                line.setHasLabelsOnlyForSelected(hasLabelForSelected)
                line.setHasLines(hasLines)
                line.setHasPoints(hasPoints)
                if (pointsHaveDifferentColor) {
                    line.pointColor = ChartUtils.COLORS[(i + 1) % ChartUtils.COLORS.size]
                }
                lines.add(line)
            }

            data = LineChartData(lines)

            if (hasAxes) {
                val axisX = Axis()
                val axisY = Axis().setHasLines(true)
                if (hasAxesNames) {
                    axisX.name = "Axis X"
                    axisY.name = "Axis Y"
                }
                data!!.axisXBottom = axisX
                data!!.axisYLeft = axisY
            } else {
                data!!.axisXBottom = null
                data!!.axisYLeft = null
            }

            data!!.baseValue = java.lang.Float.NEGATIVE_INFINITY
            chart!!.lineChartData = data

        }

        /**
         * Adds lines to data, after that data should be set again with
         * [LineChartView.setLineChartData]. Last 4th line has non-monotonically x values.
         */
        private fun addLineToData() {
            if (data!!.lines.size >= maxNumberOfLines) {
                Toast.makeText(activity, "Samples app uses max 4 lines!", Toast.LENGTH_SHORT).show()
                return
            } else {
                ++numberOfLines
            }

            generateData()
        }

        private fun toggleLines() {
            hasLines = !hasLines

            generateData()
        }

        private fun togglePoints() {
            hasPoints = !hasPoints

            generateData()
        }

        private fun toggleGradient() {
            hasGradientToTransparent = !hasGradientToTransparent

            generateData()
        }

        private fun toggleCubic() {
            isCubic = !isCubic

            generateData()

            if (isCubic) {
                // It is good idea to manually set a little higher max viewport for cubic lines because sometimes line
                // go above or below max/min. To do that use Viewport.inest() method and pass negative value as dy
                // parameter or just set top and bottom values manually.
                // In this example I know that Y values are within (0,100) range so I set viewport height range manually
                // to (-5, 105).
                // To make this works during animations you should use Chart.setViewportCalculationEnabled(false) before
                // modifying viewport.
                // Remember to set viewport after you call setLineChartData().
                val v = Viewport(chart!!.maximumViewport)
                v.bottom = -5f
                v.top = 105f
                // You have to set max and current viewports separately.
                chart!!.maximumViewport = v
                // I changing current viewport with animation in this case.
                chart!!.setCurrentViewportWithAnimation(v)
            } else {
                // If not cubic restore viewport to (0,100) range.
                val v = Viewport(chart!!.maximumViewport)
                v.bottom = 0f
                v.top = 100f

                // You have to set max and current viewports separately.
                // In this case, if I want animation I have to set current viewport first and use animation listener.
                // Max viewport will be set in onAnimationFinished method.
                chart!!.setViewportAnimationListener(object : ChartAnimationListener {

                    override fun onAnimationStarted() {
                        // TODO Auto-generated method stub

                    }

                    override fun onAnimationFinished() {
                        // Set max viewpirt and remove listener.
                        chart!!.maximumViewport = v
                        chart!!.setViewportAnimationListener(null)

                    }
                })
                // Set current viewpirt with animation;
                chart!!.setCurrentViewportWithAnimation(v)
            }

        }

        private fun toggleFilled() {
            isFilled = !isFilled

            generateData()
        }

        private fun togglePointColor() {
            pointsHaveDifferentColor = !pointsHaveDifferentColor

            generateData()
        }

        private fun setCircles() {
            shape = ValueShape.CIRCLE

            generateData()
        }

        private fun setSquares() {
            shape = ValueShape.SQUARE

            generateData()
        }

        private fun setDiamonds() {
            shape = ValueShape.DIAMOND

            generateData()
        }

        private fun toggleLabels() {
            hasLabels = !hasLabels

            if (hasLabels) {
                hasLabelForSelected = false
                chart!!.isValueSelectionEnabled = hasLabelForSelected
            }

            generateData()
        }

        private fun toggleLabelForSelected() {
            hasLabelForSelected = !hasLabelForSelected

            chart!!.isValueSelectionEnabled = hasLabelForSelected

            if (hasLabelForSelected) {
                hasLabels = false
            }

            generateData()
        }

        private fun toggleAxes() {
            hasAxes = !hasAxes

            generateData()
        }

        private fun toggleAxesNames() {
            hasAxesNames = !hasAxesNames

            generateData()
        }

        /**
         * To animate values you have to change targets values and then call [Chart.startDataAnimation]
         * method(don't confuse with View.animate()). If you operate on data that was set before you don't have to call
         * [LineChartView.setLineChartData] again.
         */
        private fun prepareDataAnimation() {
            for (line in data!!.lines) {
                for (value in line.values) {
                    // Here I modify target only for Y values but it is OK to modify X targets as well.
                    value.setTarget(value.x, Math.random().toFloat() * 100)
                }
            }
        }

        private inner class ValueTouchListener : LineChartOnValueSelectListener {

            override fun onValueSelected(lineIndex: Int, pointIndex: Int, value: PointValue) {
                Toast.makeText(activity, "Selected: $value", Toast.LENGTH_SHORT).show()
            }

            override fun onValueDeselected() {
                // TODO Auto-generated method stub

            }

        }
    }
}