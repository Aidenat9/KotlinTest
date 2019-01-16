package me.tmgg.kotlinapp.retorfitTest

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * @author sunwei
 *邮箱：tianmu19@gmail.com
 *时间：2019/1/16 12:12
 *包名：me.tmgg.kotlinapp.retorfitTest
 *<p>description:            </p>
 */
interface IGankService {
    @GET("xiandu/category/wow")
    fun category(): Call<Category>

    companion object {
        fun retrofit(): Retrofit {
            val retrofit = Retrofit.Builder().baseUrl("https://gank.io/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            return retrofit
        }
    }
}
