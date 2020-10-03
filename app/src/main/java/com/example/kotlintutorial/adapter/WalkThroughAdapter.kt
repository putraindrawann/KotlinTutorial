package com.example.kotlintutorial.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.PagerAdapter
import com.example.kotlintutorial.R

class WalkThroughAdapter(val context: Context): PagerAdapter() {

    val imgArray: IntArray = intArrayOf(R.drawable.camera,R.drawable.popcorn,R.drawable.drink)
    val titleArray: Array<String> = arrayOf("Camera", "Popcorn", "Drink")
    val descArray: Array<String> = arrayOf("Jangan lewatkan video terbaru dan selalu up to date", "Siapkan makanan kecil untuk menonton", "Siapkan minuman untuk menonton")

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view ==`object`
    }

    override fun getCount(): Int {
        return imgArray.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view: View = LayoutInflater.from(context).inflate(R.layout.slide_walkthrough, container, false)

        val txtTitle: TextView = view.findViewById(R.id.tv_title)
        val txtDesc: TextView = view.findViewById(R.id.tv_description)
        val img: ImageView = view.findViewById(R.id.iv_img)

        txtTitle.text = titleArray[position]
        txtDesc.text = descArray[position]
        img.setImageDrawable(ContextCompat.getDrawable(context, imgArray[position]))
        container.addView(view)

        return view

    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val view: View = `object` as View
        container.removeView(view)
    }

}