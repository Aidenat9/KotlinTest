package me.tmgg.kotlinapp

import android.app.Application

/**
 * @author sunwei
 *邮箱：tianmu19@gmail.com
 *时间：2019/1/16 17:31
 *包名：me.tmgg.kotlinapp
 *<p>description:            </p>
 */
class MApp : Application() {
    companion object {
        private var instance :Application?= null
        fun instance() = instance!!
    }
    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}