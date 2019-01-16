package me.tmgg.kotlinapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import me.tmgg.kotlinapp.retorfitTest.RetrofitDemoActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_retrofit2.setOnClickListener({ testRetrofit() })
    }


    private fun testRetrofit() {
        val intent = Intent()
        intent.setClass(this, RetrofitDemoActivity::class.java)
        startActivity(intent)
    }
}
