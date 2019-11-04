package com.notyteam.bee.registration

import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
<<<<<<< HEAD
import com.notyteam.bee.utils.AppBarCustom
=======
import com.notyteam.bee.R
import com.notyteam.bee.utils.OnBackPressed
>>>>>>> test-master

class RegistrationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.notyteam.bee.R.layout.activity_registration)

<<<<<<< HEAD
        AppBarCustom.makeStatusBarTransparent(RegistrationActivity@this)

        supportFragmentManager.beginTransaction().replace(com.notyteam.bee.R.id.fragment_container_registration,
            RegistrationFragment()).commit()
=======
        window.statusBarColor = getResources().getColor(R.color.orange_light)
        supportFragmentManager.beginTransaction().replace(
            R.id.fragment_container_registration,
            RegistrationFragment()
        ).commit()
    }
>>>>>>> test-master

    override fun onBackPressed() {
        val fragment =
            this.supportFragmentManager.findFragmentById(R.id.fragment_container_registration)
        (fragment as? OnBackPressed)?.onBackPressed()?.let {
            super.onBackPressed()
        }
    }
}