package com.notyteam.bee.core.ui

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProviders
import com.notyteam.bee.R
import com.notyteam.bee.core.ui.drawer.DrawerItemsViewModel
import com.notyteam.bee.databinding.ActivityMainBinding
import com.notyteam.bee.google_map_controls.GoogleMapControlsFragment
import com.notyteam.bee.topics.aboutus.fragment.AboutUsFragment
import com.notyteam.bee.topics.feedback.FeedbackFragment
import com.notyteam.bee.topics.google_map.fragment.GoogleMapsFragment
import com.notyteam.bee.topics.my_places.controls.MyPlacesControlsApiaryFragment
import com.notyteam.bee.topics.my_places.MyPlacesFragment
import com.notyteam.bee.topics.profile.fragment.ProfileFragment
import com.notyteam.bee.topics.settings.fragment.SettingsFragment
import com.notyteam.bee.topics_beehouses_online.beehouses_online_gadgets_grafs.fragment.GadgetsGrafsFragment
import com.notyteam.bee.topics_beehouses_online.beehouses_online_settings.fragment.BeehousesOnlineSettingsFragment
import kotlinx.android.synthetic.main.activity_main.*
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

        val scrollView_beehouses_online = bindingMainActivity?.scrollViewBeehousesOnline

        val ll_grandExpert_profile = bindingMainActivity?.llGrandExpertProfile
        val ll_grandExpert_my_places = bindingMainActivity?.llGrandExpertMyPlaces
        val ll_grandExpert_google_maps = bindingMainActivity?.llGrandExpertGoogleMaps
        val ll_grandExpert_instructions = bindingMainActivity?.llGrandExpertInstructions
        val ll_grandExpert_feedback = bindingMainActivity?.llGrandExpertFeedback
        val ll_grandExpert_settings = bindingMainActivity?.llGrandExpertSettings
        val ll_grandExpert_beehouse_online = bindingMainActivity?.llGrandExpertBeehouseOnline
        val ll_grandExpert_beekeepers_ukraine = bindingMainActivity?.llGrandExpertBeekeepersUkraine
        val ll_grandExpert_about_us = bindingMainActivity?.llGrandExpertAboutUs
        val ll_beehouses_online_gadgets_grafs = bindingMainActivity?.llBeehousesOnlineGadgetsGrafs
        val ll_beehouses_online_settings = bindingMainActivity?.llBeehousesOnlineSettings
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
        ll_beehouses_online_gadgets_grafs?.setOnClickListener(this)
        ll_beehouses_online_settings?.setOnClickListener(this)
        ll_grandExpert_exit?.setOnClickListener(this)

        toolbar = bindingMainActivity?.appBarLayout?.toolbarMainDrawer
        setSupportActionBar(toolbar)
        val imgbtn_download_google_maps =
            bindingMainActivity?.appBarLayout?.imgbtnDownloadGoogleMaps
        val imgbtn_controls_my_places = bindingMainActivity?.appBarLayout?.imgbtnControlsMyPlaces
        val imgbtn_controls_google_maps =
            bindingMainActivity?.appBarLayout?.imgbtnControlsGoogleMaps

        imgbtn_controls_my_places?.setOnClickListener({
            supportFragmentManager.beginTransaction().replace(
                R.id.fragment_container_main_activity,
                MyPlacesControlsApiaryFragment()
            ).commit()
        })

        imgbtn_controls_google_maps?.setOnClickListener({
            supportFragmentManager.beginTransaction().replace(
                R.id.fragment_container_main_activity,
                GoogleMapControlsFragment()
            ).commit()
            toolbar?.visibility = View.GONE
        })
        drawer = bindingMainActivity?.drawerLayoutMain
        val toggle = ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer!!.addDrawerListener(toggle)
        toggle.syncState()

        supportFragmentManager.beginTransaction().replace(R.id.fragment_container_main_activity,
            ProfileFragment()).commit()
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.ll_grandExpert_profile -> {
                supportActionBar?.title = getString(R.string.profile)
                supportFragmentManager.beginTransaction().replace(
                    R.id.fragment_container_main_activity,
                    ProfileFragment()
                ).commit()
                imgbtn_controls_google_maps.visibility = View.GONE
                imgbtn_download_google_maps.visibility = View.GONE
                imgbtn_controls_my_places.visibility = View.GONE
            }
            R.id.ll_grandExpert_my_places -> {
                supportActionBar?.title = getString(R.string.my_places)
                supportFragmentManager.beginTransaction().replace(
                    R.id.fragment_container_main_activity,
                    MyPlacesFragment()
                ).commit()
                imgbtn_controls_google_maps.visibility = View.GONE
                imgbtn_download_google_maps.visibility = View.GONE
                imgbtn_controls_my_places.visibility = View.VISIBLE
            }
            R.id.ll_grandExpert_google_maps -> {
                supportActionBar?.title = getString(R.string.google_map)
                supportFragmentManager.beginTransaction().replace(
                    R.id.fragment_container_main_activity,
                    GoogleMapsFragment()
                ).commit()
                imgbtn_controls_google_maps.visibility = View.VISIBLE
                imgbtn_download_google_maps.visibility = View.VISIBLE
                imgbtn_controls_my_places.visibility = View.GONE
            }
            R.id.ll_grandExpert_instructions -> {
            }
            R.id.ll_grandExpert_feedback -> {
                supportActionBar?.title = getString(R.string.feedback)
                supportFragmentManager.beginTransaction().replace(
                    R.id.fragment_container_main_activity,
                    FeedbackFragment()
                ).commit()
                imgbtn_controls_google_maps.visibility = View.GONE
                imgbtn_download_google_maps.visibility = View.GONE
                imgbtn_controls_my_places.visibility = View.GONE
            }
            R.id.ll_grandExpert_settings -> {
                supportActionBar?.title = getString(R.string.settings)
                supportFragmentManager.beginTransaction().replace(
                    R.id.fragment_container_main_activity,
                    SettingsFragment()
                ).commit()
                imgbtn_controls_google_maps.visibility = View.GONE
                imgbtn_download_google_maps.visibility = View.GONE
                imgbtn_controls_my_places.visibility = View.GONE
            }
            R.id.ll_grandExpert_beehouse_online -> {
                supportActionBar?.title = getString(R.string.my_gadgets)
                scrollView_main.visibility = View.GONE
                scrollView_beehouses_online.visibility = View.VISIBLE
                supportFragmentManager.beginTransaction().replace(
                    R.id.fragment_container_main_activity,
                    GadgetsGrafsFragment()
                ).commit()
            }
            R.id.ll_beehouses_online_gadgets_grafs -> {
                supportActionBar?.title = getString(R.string.my_gadgets)
                supportFragmentManager.beginTransaction().replace(
                    R.id.fragment_container_main_activity,
                    GadgetsGrafsFragment()
                ).commit()
            }
            R.id.ll_beehouses_online_settings -> {
//                drawer!!.isDrawerOpen(GravityCompat.START)
                supportActionBar?.title = getString(R.string.settings)
                supportFragmentManager.beginTransaction().replace(
                    R.id.fragment_container_main_activity,
                    BeehousesOnlineSettingsFragment()
                ).commit()
            }
            R.id.ll_grandExpert_beekeepers_ukraine -> {
            }
            R.id.ll_grandExpert_about_us -> {
                supportActionBar?.title = getString(R.string.about_us)
                supportFragmentManager.beginTransaction().replace(
                    R.id.fragment_container_main_activity,
                    AboutUsFragment()
                ).commit()
                imgbtn_controls_google_maps.visibility = View.GONE
                imgbtn_download_google_maps.visibility = View.GONE
                imgbtn_controls_my_places.visibility = View.GONE
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
