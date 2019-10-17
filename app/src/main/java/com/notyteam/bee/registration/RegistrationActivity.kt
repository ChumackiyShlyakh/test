package com.notyteam.bee.registration

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class RegistrationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.notyteam.bee.R.layout.activity_registration)

        supportFragmentManager.beginTransaction().replace(com.notyteam.bee.R.id.fragment_container_registration,
            RegistrationFragment()).commit()

    }
}