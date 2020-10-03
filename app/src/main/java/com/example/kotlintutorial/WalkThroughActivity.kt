package com.example.kotlintutorial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.example.kotlintutorial.adapter.WalkThroughAdapter
import com.example.kotlintutorial.util.SharedPreferences
import kotlinx.android.synthetic.main.activity_walk_through.*

class WalkThroughActivity : AppCompatActivity() {

    lateinit var wkAdapter:WalkThroughAdapter
    val dots = arrayOfNulls<TextView>(3)
    var currentpage: Int = 0
    lateinit var pre: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_walk_through)

        pre = SharedPreferences(this)
        wkAdapter = WalkThroughAdapter(this)
        vp_walkthrough.adapter = wkAdapter
        dotIndicator(currentpage)
        initAction()
    }

    fun initAction() {
        vp_walkthrough.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {
                Log.e("scrolled", state.toString())
            }
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                dotIndicator(position)
                currentpage = position
            }
        })
        tv_lanjutkan.setOnClickListener{
            if(vp_walkthrough.currentItem +1 < dots.size) {
                vp_walkthrough.currentItem += 1
            } else {
                pre.firstInstall = true
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        tv_lewati.setOnClickListener{
            pre.firstInstall = true
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun dotIndicator(p: Int){
        ll_dots.removeAllViews()

        for (i in 0..dots.size-1){
            dots[i]=TextView(this)
            dots[i]?.textSize= 35f
            dots[i]?.setTextColor(resources.getColor(R.color.grey))
            dots[i]?.text = Html.fromHtml("&#8226;")

            ll_dots.addView(dots[i])
        }

        if (dots.size > 0) {
            dots[p]?.setTextColor(resources.getColor(R.color.colorPrimary))
        }
    }
}
