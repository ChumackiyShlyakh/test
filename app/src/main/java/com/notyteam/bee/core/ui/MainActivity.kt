package com.notyteam.bee.core.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProviders
import com.notyteam.bee.R
import com.notyteam.bee.core.ui.drawer.DrawerItemsViewModel
import com.notyteam.bee.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var bindingMainActivity: ActivityMainBinding? = null
    var viewmodelDrawerItemsViewModel: DrawerItemsViewModel? = null
    private var drawer: DrawerLayout? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        bindingMainActivity = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewmodelDrawerItemsViewModel = ViewModelProviders.of(this).get(DrawerItemsViewModel::class.java)


        val toolbar = bindingMainActivity?.appBarLayout?.toolbarMainDrawer
        setSupportActionBar(toolbar)
        drawer = bindingMainActivity?.drawerLayoutMain
        val toggle = ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer!!.addDrawerListener(toggle)
        toggle.syncState()
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
