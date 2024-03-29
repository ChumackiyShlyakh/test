package com.notyteam.bee.core.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.notyteam.bee.R
import com.notyteam.bee.registration.RegistrationActivity
import com.notyteam.bee.utils.AppBarCustom


class SplashActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT: Long = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        AppBarCustom.makeStatusBarTransparent(SplashActivity@ this)

        Handler().postDelayed({
            startActivity(Intent(this@SplashActivity, RegistrationActivity::class.java))
        this.finish()
        }, SPLASH_TIME_OUT)
    }
}
