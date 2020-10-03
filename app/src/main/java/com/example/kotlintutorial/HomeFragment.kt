package com.example.kotlintutorial

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        action()
    }

    fun action() {
        btn_ad.setOnClickListener{
            var b = AlertDialog.Builder(activity)
            b.setTitle("Test")
            b.setMessage("Are you sure")
            b.setPositiveButton("Yes", {dialog: DialogInterface?, which: Int ->
                var i = Intent(activity, MovieDetailActivity::class.java)
                startActivity(i)
            })

            b.setNegativeButton("No", {dialog: DialogInterface?, which: Int -> })
            b.show()
        }

        btn_toast.setOnClickListener{
            Toast.makeText(activity, "Hello Toast", Toast.LENGTH_LONG).show()
        }
    }

}
