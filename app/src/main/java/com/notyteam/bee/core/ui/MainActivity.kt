package com.notyteam.bee.core.ui

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.RelativeLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.notyteam.bee.R
import com.notyteam.bee.core.ui.drawer.DrawerItemsViewModel
import com.notyteam.bee.databinding.ActivityMainBinding
import com.notyteam.bee.google_map_controls.GoogleMapControlsFragment
import com.notyteam.bee.topics.aboutus.fragment.InstructionFragment
import com.notyteam.bee.topics.feedback.FeedbackFragment
import com.notyteam.bee.topics.google_map.fragment.GoogleMapsFragment
import com.notyteam.bee.topics.my_places.MyPlacesFragment
import com.notyteam.bee.topics.my_places.controls.MyPlacesControlsBeehousesFragment
import com.notyteam.bee.topics.profile.fragment.ProfileFragment
import com.notyteam.bee.topics.settings.fragment.SettingsFragment
import com.notyteam.bee.topics_beehouses_online.beehouses_online_gadgets_grafs.GadgetsGrafsFragment
import com.notyteam.bee.topics_beehouses_online.beehouses_online_settings.fragment.BeehousesOnlineSettingsFragment
import com.notyteam.bee.utils.AppBarCustom
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.dialog_exit.*
import com.notyteam.bee.utils.OnBackPressed


class MainActivity : AppCompatActivity(), View.OnClickListener {

    var bindingMainActivity: ActivityMainBinding? = null
    var viewmodelDrawerItemsViewModel: DrawerItemsViewModel? = null
    private var drawer: DrawerLayout? = null
    private var toolbar: Toolbar? = null
    companion object {
        @JvmStatic
        var imgbtn_controls_my_places_beehouses: ImageButton? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AppBarCustom.makeStatusBarTransparent(MainActivity@ this)

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
        val ll_beehouses_online_back_to_main = bindingMainActivity?.llBeehousesOnlineBackToMain
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
        ll_beehouses_online_back_to_main?.setOnClickListener(this)
        ll_grandExpert_exit?.setOnClickListener(this)

        toolbar = bindingMainActivity?.appBarLayout?.toolbarMainDrawer
        setSupportActionBar(toolbar)

        val imgbtn_download_google_maps =
            bindingMainActivity?.appBarLayout?.imgbtnDownloadGoogleMaps
        imgbtn_controls_my_places_beehouses = bindingMainActivity?.appBarLayout?.imgbtnControlsMyPlaces
        val imgbtn_controls_google_maps =
            bindingMainActivity?.appBarLayout?.imgbtnControlsGoogleMaps

        imgbtn_controls_my_places_beehouses?.setOnClickListener({
            supportFragmentManager.beginTransaction().replace(
                R.id.fragment_container_main_activity,
                MyPlacesControlsBeehousesFragment()
            ).commit()
            toolbar?.visibility = View.GONE
        })

//        imgbtn_controls_my_places_beehouses?.setOnClickListener({
////            if(MyPlacesFragment().adapter?.equals(VPBeehousesFragment())!!) {
//            supportFragmentManager.beginTransaction().replace(
//                R.id.fragment_container_main_activity,
//                MyPlacesControlsBeehousesFragment()
//            ).commit()
//            toolbar?.visibility = View.GONE
////            }
//        })

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

        toggle.getDrawerArrowDrawable().setColor(Color.BLACK);
        drawer!!.addDrawerListener(toggle)

        toggle.syncState()

        supportActionBar?.title = getString(R.string.google_map)
        replaceFragment(GoogleMapsFragment())
        imgbtn_controls_google_maps?.visibility = View.VISIBLE
        imgbtn_download_google_maps?.visibility = View.VISIBLE
        imgbtn_controls_my_places_beehouses?.visibility = View.GONE

    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.ll_grandExpert_profile -> {
                supportActionBar?.title = getString(R.string.profile)
                replaceFragment(ProfileFragment())
                imgbtn_controls_google_maps.visibility = View.GONE
                imgbtn_download_google_maps.visibility = View.GONE
//                imgbtn_controls_my_places.visibility = View.GONE
            }
            R.id.ll_grandExpert_my_places -> {
                supportActionBar?.title = getString(R.string.my_places)
                replaceFragment(MyPlacesFragment())
                imgbtn_controls_google_maps.visibility = View.GONE
                imgbtn_download_google_maps.visibility = View.GONE
                imgbtn_controls_my_places.visibility = View.VISIBLE
            }
            R.id.ll_grandExpert_google_maps -> {
                supportActionBar?.title = getString(R.string.google_map)
                replaceFragment(GoogleMapsFragment())
                imgbtn_controls_google_maps.visibility = View.VISIBLE
                imgbtn_download_google_maps.visibility = View.VISIBLE
//                imgbtn_controls_my_places.visibility = View.GONE
            }
            R.id.ll_grandExpert_instructions -> {
                supportActionBar?.title = getString(R.string.instructions)
                replaceFragment(InstructionFragment())
                imgbtn_controls_google_maps.visibility = View.GONE
                imgbtn_download_google_maps.visibility = View.GONE
                imgbtn_controls_my_places.visibility = View.GONE
            }
            R.id.ll_grandExpert_feedback -> {
                supportActionBar?.title = getString(R.string.feedback)
                replaceFragment(FeedbackFragment())
                imgbtn_controls_google_maps.visibility = View.GONE
                imgbtn_download_google_maps.visibility = View.GONE
//                imgbtn_controls_my_places.visibility = View.GONE
            }
            R.id.ll_grandExpert_settings -> {
                supportActionBar?.title = getString(R.string.settings)
                replaceFragment(SettingsFragment())
                imgbtn_controls_google_maps.visibility = View.GONE
                imgbtn_download_google_maps.visibility = View.GONE
//                imgbtn_controls_my_places.visibility = View.GONE
            }
            R.id.ll_grandExpert_beehouse_online -> {
                supportActionBar?.title = getString(R.string.my_gadgets)
                scrollView_main.visibility = View.GONE
                imgbtn_controls_google_maps.visibility = View.GONE
                imgbtn_download_google_maps.visibility = View.GONE
                scrollView_beehouses_online.visibility = View.VISIBLE
                replaceFragment(GadgetsGrafsFragment())
            }
            R.id.ll_grandExpert_beekeepers_ukraine -> {
            }
            R.id.ll_grandExpert_about_us -> {
                supportActionBar?.title = getString(R.string.about_us_drawer)
                replaceFragment(InstructionFragment())
                imgbtn_controls_google_maps.visibility = View.GONE
                imgbtn_download_google_maps.visibility = View.GONE
            }
            R.id.ll_beehouses_online_gadgets_grafs -> {
                supportActionBar?.title = getString(R.string.my_gadgets)
                replaceFragment(GadgetsGrafsFragment())
            }
            R.id.ll_beehouses_online_settings -> {
//                drawer!!.isDrawerOpen(GravityCompat.START)
                supportActionBar?.title = getString(R.string.settings)
                replaceFragment(BeehousesOnlineSettingsFragment())
            }
            R.id.ll_beehouses_online_back_to_main -> {
                supportActionBar?.title = getString(R.string.google_map)
                imgbtn_controls_google_maps.visibility = View.VISIBLE
                imgbtn_download_google_maps.visibility = View.VISIBLE
                scrollView_main.visibility = View.VISIBLE
                scrollView_beehouses_online.visibility = View.GONE
                replaceFragment(GoogleMapsFragment())
            }
            R.id.ll_grandExpert_exit -> {
                showDialog(this)
            }
        }
        drawer?.closeDrawer(GravityCompat.START)
    }


    fun replaceFragment(fragment: Fragment?) {

        if (fragment != null) {
            val fragmentManager = supportFragmentManager
            fragmentManager.beginTransaction()
                .replace(R.id.fragment_container_main_activity, fragment).commitAllowingStateLoss()
        } else {
            // error in creating fragment
            Log.e("ActivityMain", "Error in creating fragment")
        }
    }

    fun showDialog(activity: Activity) {
        val dialog = Dialog(activity)
        dialog.setCanceledOnTouchOutside(true)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.dialog_exit)
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

    override fun onBackPressed() {

        drawer = bindingMainActivity?.drawerLayoutMain
        val fm = supportFragmentManager
        var backPressedListener: OnBackPressed? = null

        for (fragment in fm.fragments) {
            if (fragment is OnBackPressed) {
                backPressedListener = fragment
                break
            }
        }

        if (drawer!!.isDrawerOpen(GravityCompat.START)) {
            drawer!!.closeDrawer(GravityCompat.START)
        } else {
            if (backPressedListener != null) {
                backPressedListener.onBackPressed()
            } else {
                super.onBackPressed()
            }
        }
    }
}
