package com.example.kotlintutorial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.kotlintutorial.util.SharedPreferences

class SplashActivity : AppCompatActivity() {
    lateinit var pre: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        pre = SharedPreferences(this)

        Handler().postDelayed({
            var i = Intent()

            if (!pre.firstInstall) {
                i = Intent(this, WalkThroughActivity::class.java)
            } else {
                i = Intent(this, MainActivity::class.java)
            }
            startActivity(i)
            finish()
        }, 3000)
    }
}
