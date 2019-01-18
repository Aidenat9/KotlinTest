package me.tmgg.kotlinapp

import android.app.Application
import kotlin.properties.Delegates

/**
 * @author sunwei
 *邮箱：tianmu19@gmail.com
 *时间：2019/1/16 17:31
 *包名：me.tmgg.kotlinapp
 *<p>description:            </p>
 */
class MApp: Application() {
    override fun onCreate() {
        super.onCreate()
        //委托单例
        instance = this
    }

    /**
     *如果你不担心多线程问题或者想提高更多的性能，你也可以使用 lazy(LazyThreadSafeMode.NONE){ ... }
     */
//    companion object {
        //lazy 操作符是线程安全的
//        val instance by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) { MApp() }
//    }
    /**
     * 委托单例
     */
    companion object {
        var instance :MApp by Delegates.notNull()
    }
}