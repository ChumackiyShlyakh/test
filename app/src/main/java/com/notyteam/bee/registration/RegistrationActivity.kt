package com.notyteam.bee.registration

import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.notyteam.bee.R
import com.notyteam.bee.utils.OnBackPressed

class RegistrationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.notyteam.bee.R.layout.activity_registration)

        window.statusBarColor = getResources().getColor(R.color.orange_light)
        supportFragmentManager.beginTransaction().replace(
            R.id.fragment_container_registration,
            RegistrationFragment()
        ).commit()
    }

    override fun onBackPressed() {
        val fragment =
            this.supportFragmentManager.findFragmentById(R.id.fragment_container_registration)
        (fragment as? OnBackPressed)?.onBackPressed()?.let {
            super.onBackPressed()
        }
    }
}