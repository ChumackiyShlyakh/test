package com.notyteam.bee.registration

import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.notyteam.bee.utils.AppBarCustom
import com.notyteam.bee.R





class RegistrationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        AppBarCustom.makeStatusBarTransparent(RegistrationActivity@ this)


        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction()
            .replace(R.id.fragment_container_registration, RegistrationFragment())
            .commitAllowingStateLoss()

    }

    override fun onBackPressed() {

        if (supportFragmentManager.backStackEntryCount > 0) run { supportFragmentManager.popBackStack() } else { super.onBackPressed() }
    }
}