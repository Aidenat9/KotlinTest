package me.tmgg.kotlinapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initViews()

        val s = getDatas(str)
        Log.e(Constants.TAG,s)
        for (c in str){
            println(c)
        }

    }
    val str = "张三"
    private fun getDatas(str:String): String {
        when(str){
            "张三"  ->return "yes"
            "李四" ->return "no"
        }
        return "$str 你是一个大好人吗？"
    }

    private fun initViews() {

    }
}
