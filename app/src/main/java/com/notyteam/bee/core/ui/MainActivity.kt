package com.notyteam.bee.core.ui

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.core.view.isGone
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProviders
import com.notyteam.bee.R
import com.notyteam.bee.core.ui.drawer.DrawerItemsViewModel
import com.notyteam.bee.databinding.ActivityMainBinding
import com.notyteam.bee.topics.aboutus.fragment.AboutUsFragment
import com.notyteam.bee.topics.feedback.FeedbackFragment
import com.notyteam.bee.topics.google_map.fragment.GoogleMapsFragment
import com.notyteam.bee.topics.my_places.MyPlacesFragment
import com.notyteam.bee.topics.profile.fragment.ProfileFragment
import com.notyteam.bee.topics.settings.fragment.SettingsFragment
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.dialog_exit.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var bindingMainActivity: ActivityMainBinding? = null
    var viewmodelDrawerItemsViewModel: DrawerItemsViewModel? = null
    private var drawer: DrawerLayout? = null
    private var toolbar: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMainActivity = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewmodelDrawerItemsViewModel =
            ViewModelProviders.of(this).get(DrawerItemsViewModel::class.java)

        val ll_grandExpert_profile = bindingMainActivity?.llGrandExpertProfile
        val ll_grandExpert_my_places = bindingMainActivity?.llGrandExpertMyPlaces
        val ll_grandExpert_google_maps = bindingMainActivity?.llGrandExpertGoogleMaps
        val ll_grandExpert_instructions = bindingMainActivity?.llGrandExpertInstructions
        val ll_grandExpert_feedback = bindingMainActivity?.llGrandExpertFeedback
        val ll_grandExpert_settings = bindingMainActivity?.llGrandExpertSettings
        val ll_grandExpert_beehouse_online = bindingMainActivity?.llGrandExpertBeehouseOnline
        val ll_grandExpert_beekeepers_ukraine = bindingMainActivity?.llGrandExpertBeekeepersUkraine
        val ll_grandExpert_about_us = bindingMainActivity?.llGrandExpertAboutUs
        val ll_grandExpert_exit = bindingMainActivity?.llGrandExpertExit

        ll_grandExpert_profile?.setOnClickListener(this)
        ll_grandExpert_my_places?.setOnClickListener(this)
        ll_grandExpert_google_maps?.setOnClickListener(this)
        ll_grandExpert_instructions?.setOnClickListener(this)
        ll_grandExpert_feedback?.setOnClickListener(this)
        ll_grandExpert_settings?.setOnClickListener(this)
        ll_grandExpert_beehouse_online?.setOnClickListener(this)
        ll_grandExpert_beekeepers_ukraine?.setOnClickListener(this)
        ll_grandExpert_about_us?.setOnClickListener(this)
        ll_grandExpert_exit?.setOnClickListener(this)

        toolbar = bindingMainActivity?.appBarLayout?.toolbarMainDrawer
        setSupportActionBar(toolbar)
        val imgbtn_controls = bindingMainActivity?.appBarLayout?.imgbtnControls
        val imgbtn_download = bindingMainActivity?.appBarLayout?.imgbtnDownload
        drawer = bindingMainActivity?.drawerLayoutMain
        val toggle = ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer!!.addDrawerListener(toggle)
        toggle.syncState()
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.ll_grandExpert_profile -> {
                supportFragmentManager.beginTransaction().replace(
                    R.id.fragment_container_main_activity,
                    ProfileFragment()
                ).commit()
                imgbtn_controls.visibility = View.GONE
                imgbtn_download.visibility = View.GONE
            }
            R.id.ll_grandExpert_my_places -> {
                supportFragmentManager.beginTransaction().replace(
                    R.id.fragment_container_main_activity,
                    MyPlacesFragment()
                ).commit()
                imgbtn_controls.visibility = View.VISIBLE
                imgbtn_download.visibility = View.GONE
            }
            R.id.ll_grandExpert_google_maps -> {
                supportFragmentManager.beginTransaction().replace(
                    R.id.fragment_container_main_activity,
                    GoogleMapsFragment()
                ).commit()
                imgbtn_controls.visibility = View.VISIBLE
                imgbtn_download.visibility = View.VISIBLE
            }
            R.id.ll_grandExpert_instructions -> {
//                supportFragmentManager.beginTransaction().replace(
//                    R.id.fragment_container_main_activity,
//                    AboutUsFragment()
//                ).commit()
            }
            R.id.ll_grandExpert_feedback -> {
                supportFragmentManager.beginTransaction().replace(
                    R.id.fragment_container_main_activity,
                    FeedbackFragment()
                ).commit()
                imgbtn_controls.visibility = View.GONE
                imgbtn_download.visibility = View.GONE
            }
            R.id.ll_grandExpert_settings -> {
                supportFragmentManager.beginTransaction().replace(
                    R.id.fragment_container_main_activity,
                    SettingsFragment()
                ).commit()
                imgbtn_controls.visibility = View.GONE
                imgbtn_download.visibility = View.GONE
            }
            R.id.ll_grandExpert_beehouse_online -> {
//                supportFragmentManager.beginTransaction().replace(
//                    R.id.fragment_container_main_activity,
//                    SettingsFragment()
//                ).commit()
            }
            R.id.ll_grandExpert_beekeepers_ukraine -> {
//                supportFragmentManager.beginTransaction().replace(
//                    R.id.fragment_container_main_activity,
//                    SettingsFragment()
//                ).commit()
            }
            R.id.ll_grandExpert_about_us -> {
                supportFragmentManager.beginTransaction().replace(
                    R.id.fragment_container_main_activity,
                    AboutUsFragment()
                ).commit()
            }
            R.id.ll_grandExpert_exit -> {
                showDialog(this)
            }
        }
        drawer?.closeDrawer(GravityCompat.START)
    }

    fun showDialog(activity: Activity) {
        val dialog = Dialog(activity)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.dialog_exit)
        dialog.show()

        val window = dialog.getWindow()
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        window?.setLayout(
            RelativeLayout.LayoutParams.MATCH_PARENT,
            RelativeLayout.LayoutParams.MATCH_PARENT
        )

        var btn_dialog_exit_application =
            dialog.btn_dialog_exit_application.findViewById<Button>(R.id.btn_dialog_exit_application)
        var btn_dialog_exit_account =
            dialog.btn_dialog_exit_account.findViewById<Button>(R.id.btn_dialog_exit_account)

        btn_dialog_exit_application.setOnClickListener { dialog.dismiss() }
        btn_dialog_exit_account.setOnClickListener { dialog.dismiss() }
    }

    override fun onBackPressed() {
        drawer = bindingMainActivity?.drawerLayoutMain
        if (drawer!!.isDrawerOpen(GravityCompat.START)) {
            drawer!!.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
