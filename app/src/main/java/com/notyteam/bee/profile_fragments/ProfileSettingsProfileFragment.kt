package com.notyteam.bee.profile_fragments

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.notyteam.bee.R
import com.notyteam.bee.core.arch.DialogCustomListView
import com.notyteam.bee.core.arch.DialogDataAdapter
import com.notyteam.bee.topics.profile.fragment.ProfileFragment
import com.notyteam.bee.utils.OnBackPressed
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.dialog_custom_layout.*
import kotlinx.android.synthetic.main.fragment_profile_settings_profile.*

class ProfileSettingsProfileFragment : Fragment(), View.OnClickListener,
    DialogDataAdapter.RecyclerViewItemClickListener, OnBackPressed {

    internal var customDialog: DialogCustomListView? = null
    private var meaning: String = "meaning"
    private var textItems = arrayOf("Beekeeper", "Agrarian", "Beekeeper + Agrarian")
    private var imagesItems = intArrayOf(
        R.drawable.beekeeper,
        R.drawable.agrarian,
        R.drawable.beekeeper_agrarian
    )

    lateinit var imgbtn_fragment_profile_settings_profile_back: ImageButton
    lateinit var btn_fragment_profile_settings_profile_meaning: Button
    lateinit var btn_fragment_profile_settings_profile_save: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile_settings_profile, container, false)

        imgbtn_fragment_profile_settings_profile_back =
            view.findViewById<ImageButton>(R.id.imgbtn_fragment_profile_settings_profile_back)
        btn_fragment_profile_settings_profile_meaning =
            view.findViewById<Button>(R.id.btn_fragment_profile_settings_profile_meaning)
       btn_fragment_profile_settings_profile_save = view.findViewById<Button>(R.id.btn_fragment_profile_settings_profile_save)

        btn_fragment_profile_settings_profile_meaning.setOnClickListener({
            tv_dialogcustom?.setText(R.string.choose_meaning)
            showItems(this)
        })

        imgbtn_fragment_profile_settings_profile_back.setOnClickListener({
            fragmentManager?.beginTransaction()?.replace(
                R.id.fragment_container_main_activity,
                ProfileFragment()
            )?.commit()
            (activity as AppCompatActivity).toolbar_main_drawer?.visibility = View.GONE
        })

        btn_fragment_profile_settings_profile_save.setOnClickListener(this)

        return view
    }

    override fun onClick(v: View?) {
        when (v?.id) {
//            R.id.btn_fragment_profile_settings_profile_meaning -> {
//                showItems(this)
//        }
            R.id.btn_fragment_profile_settings_profile_save -> {
                fragmentManager?.beginTransaction()?.replace(
                    R.id.fragment_container_main_activity,
                    ProfileFragment()
                )?.commit()
                (activity as AppCompatActivity).toolbar_main_drawer?.visibility = View.GONE
            }
//            R.id.imgbtn_fragment_profile_settings_profile_back -> {
//                fragmentManager?.beginTransaction()?.replace(
//                    R.id.fragment_container_main_activity,
//                    ProfileFragment()
//                )?.commit()
//            }
        }
    }

    fun showItems(view: ProfileSettingsProfileFragment) {
        val dataAdapter = DialogDataAdapter(meaning, textItems, imagesItems, this) //
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
        btn_fragment_profile_settings_profile_meaning.text = data
        if (customDialog != null) {
            customDialog?.dismiss()
        }
    }

    override fun clickOnItemLanguage(data: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBackPressed() {
        fragmentManager?.beginTransaction()?.replace(
            R.id.fragment_container_main_activity,
            ProfileFragment()
        )?.commit()
        (activity as AppCompatActivity).toolbar_main_drawer?.visibility = View.GONE
    }
}