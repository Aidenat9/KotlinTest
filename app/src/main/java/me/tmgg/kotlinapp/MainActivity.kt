package me.tmgg.kotlinapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import me.tmgg.kotlinapp.retorfitTest.RetrofitDemoActivity
import me.tmgg.kotlinapp.ui.ReboundTestActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_retrofit2.setOnClickListener({ testRetrofit() })
        btn_rebound.setOnClickListener({ testRebound() })
        testFold()
        val a :Int? = null
//        val str :String = a?.toString()?:"a为null，"
        try {
            println(""+a!!)
        }catch (e:NullPointerException){
            e.printStackTrace()
        }
    }

    private fun testRebound() {
        val intent = Intent()
        intent.setClass(this, ReboundTestActivity::class.java)
        startActivity(intent)
    }

    private fun testFold() {
        val list = listOf(1, 2, 3, 4, 5, 6)
        var i:Int = list.fold(0){total,next-> total+next}
        Log.e(Constants.TAG,i.toString())
    }


    private fun testRetrofit() {
        val intent = Intent()
        intent.setClass(this, RetrofitDemoActivity::class.java)
        startActivity(intent)
    }
}
