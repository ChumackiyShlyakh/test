package com.notyteam.bee.registration

import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.notyteam.bee.utils.AppBarCustom
import com.notyteam.bee.R
import com.notyteam.bee.utils.OnBackPressed
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T




class RegistrationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        AppBarCustom.makeStatusBarTransparent(RegistrationActivity@this)

        supportFragmentManager.beginTransaction().replace(R.id.fragment_container_registration,
            RegistrationFragment()).addToBackStack(null).commit()

    }

    override fun onBackPressed() {
        val count = supportFragmentManager.backStackEntryCount

        if (count == 0) {
            super.onBackPressed()
            //additional code
        } else {
            supportFragmentManager.popBackStack()
        }
    }
}