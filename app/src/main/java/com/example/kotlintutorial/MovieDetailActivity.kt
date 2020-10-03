package com.example.kotlintutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetailActivity : AppCompatActivity() {

    var b : Bundle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        initView()
    }

    fun initView(){
        b = intent.extras

        tv_title.text = b?.getString("title")
        tv_description.text = b?.getString("description")
    }
}
