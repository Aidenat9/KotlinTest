package me.tmgg.kotlinapp.retorfitTest

import android.os.Bundle
import android.support.v4.widget.ContentLoadingProgressBar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import kotlinx.android.synthetic.main.activity_retrofit_demo.*
import me.tmgg.kotlinapp.Constants
import me.tmgg.kotlinapp.R
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitDemoActivity : AppCompatActivity() {
    var mRv: RecyclerView? = null
    private var  datasList: MutableList<Result> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit_demo)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        mRv= this.rv
        mRv!!.layoutManager = LinearLayoutManager(this)
        mRv!!.adapter = RvAdapter(datasList,object :RvAdapter.OnItemClickListener{
            override fun invoke(item: String) {
                toast(item)
            }

        })

        val pbar : ContentLoadingProgressBar = this.content_pb
        pbar.show()
        val gankService = IGankService.retrofit().create(IGankService::class.java)
        gankService.category().enqueue(object : Callback<Category> {
            override fun onFailure(call: Call<Category>?, t: Throwable?) {
                t!!.printStackTrace()
            }

            override fun onResponse(call: Call<Category>?, response: Response<Category>?) {
                val category: Category? = response!!.body()
                val isError = category!!.error
                val list:List<Result> = category.results
                if(!isError){
                    list.map { Log.e(Constants.TAG,it.toString()) }
                    datasList.addAll(list)
                }
                pbar.hide()
            }

        })
    }
}
