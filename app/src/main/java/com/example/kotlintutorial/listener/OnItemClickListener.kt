package com.example.kotlintutorial.listener

import android.view.View

interface OnItemClickListener {
    fun onItemClick(item: View, position:Int)
}