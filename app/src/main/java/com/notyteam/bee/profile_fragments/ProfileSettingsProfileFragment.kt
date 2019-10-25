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
import androidx.fragment.app.Fragment
import com.notyteam.bee.R
import com.notyteam.bee.core.arch.DialogCustomListView
import com.notyteam.bee.core.arch.DialogDataAdapter
import com.notyteam.bee.topics.profile.fragment.ProfileFragment
import kotlinx.android.synthetic.main.dialog_custom_layout.*
import kotlinx.android.synthetic.main.fragment_profile_settings_profile.*

class ProfileSettingsProfileFragment : Fragment(), View.OnClickListener, DialogDataAdapter.RecyclerViewItemClickListener {

    internal var customDialog: DialogCustomListView? = null
    private var meaning: String = "meaning"
    private var textItems = arrayOf("Beekeeper", "Agrarian", "Beekeeper + Agrarian")
    private var imagesItems = intArrayOf(
        R.drawable.beekeeper,
        R.drawable.agrarian,
        R.drawable.beekeeper_agrarian
    )

    lateinit var btn_fragment_profile_settings_profile_meaning: Button
    lateinit var imgbtn_fragment_profile_settings_profile_back: ImageButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile_settings_profile, container, false)

//        val viewModel = ViewModelProviders.of(this)[ProfileViewModel::class.java]
//        val binding: FragmentProfileBinding = FragmentProfileBinding().inflate(inflater, container, false)
//        binding.model

        imgbtn_fragment_profile_settings_profile_back = view.findViewById<ImageButton>(R.id.imgbtn_fragment_profile_settings_profile_back)
        btn_fragment_profile_settings_profile_meaning =  view.findViewById<Button>(R.id.btn_fragment_profile_settings_profile_meaning)
        var btn_profile_settings_save = btn_fragment_profile_settings_save

        btn_fragment_profile_settings_profile_meaning.setOnClickListener(View.OnClickListener {
            tv_dialogcustom?.setText(R.string.choose_meaning)
            showItems(this)
        })

        imgbtn_fragment_profile_settings_profile_back.setOnClickListener(View.OnClickListener {
            fragmentManager?.beginTransaction()?.replace(
                R.id.fragment_container_main_activity,
                ProfileFragment()
            )?.commit()
        })

//        imgbtn_fragment_profile_settings_profile_back.setOnClickListener(this)
//        btn_fragment_profile_settings_profile_meaning?.setOnClickListener(this)
        btn_profile_settings_save?.setOnClickListener(this)

        return view
//        return binding.root
    }

    override fun onClick(v: View?) {
        when (v?.id) {
//            R.id.btn_fragment_profile_settings_profile_meaning -> {
//                showItems(this)
//        }
            R.id.btn_fragment_profile_settings_save -> {

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
}