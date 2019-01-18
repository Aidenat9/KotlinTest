package me.tmgg.kotlinapp.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.facebook.rebound.SpringSystem
import kotlinx.android.synthetic.main.activity_rebound_test.*
import me.tmgg.kotlinapp.R

class ReboundTestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rebound_test)
        imageView.setOnClickListener { test() }
    }

    private fun test() {
        val springSystem:SpringSystem  = SpringSystem.create()
        val spring = springSystem.createSpring()
    }
}
