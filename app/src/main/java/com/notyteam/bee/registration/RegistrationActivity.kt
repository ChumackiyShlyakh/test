package com.notyteam.bee.registration

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.notyteam.bee.utils.AppBarCustom

class RegistrationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.notyteam.bee.R.layout.activity_registration)

        AppBarCustom.makeStatusBarTransparent(RegistrationActivity@this)

        supportFragmentManager.beginTransaction().replace(com.notyteam.bee.R.id.fragment_container_registration,
            RegistrationFragment()).commit()

    }
}