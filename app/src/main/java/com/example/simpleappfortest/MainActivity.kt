package com.example.simpleappfortest

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calculateImt(view: View) {
        val intent = Intent(this, RezultActivity::class.java)

        val height = Integer.parseInt(editTextHeight.text.toString())
        val weight = Integer.parseInt(editTextWeight.text.toString())

        intent.putExtra(RezultActivity.HEIGHT, height)
        intent.putExtra(RezultActivity.WEIGHT, weight)

        startActivity(intent)
    }
}
