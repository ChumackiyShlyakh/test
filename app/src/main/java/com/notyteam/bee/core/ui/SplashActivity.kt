package com.notyteam.bee.core.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.notyteam.bee.R
import com.notyteam.bee.registration.RegistrationActivity


class SplashActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT: Long = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        window.statusBarColor = getResources().getColor(R.color.white)
        Handler().postDelayed({
//            if (!ApiGrantExpertApplication.getSharedPrefInstance().isAuth()) {
//                startActivity(Intent(this@SplashActivity, RegistrationActivity::class.java))
//                finish()
//            } else {
//                startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            startActivity(Intent(this@SplashActivity, RegistrationActivity::class.java))
                finish()
//            }
        }, SPLASH_TIME_OUT)
    }
}
