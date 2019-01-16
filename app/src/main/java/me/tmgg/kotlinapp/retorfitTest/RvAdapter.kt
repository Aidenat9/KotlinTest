package me.tmgg.kotlinapp.retorfitTest

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.item_category_rv.view.*
import me.tmgg.kotlinapp.R

/**
 * @author sunwei
 *邮箱：tianmu19@gmail.com
 *时间：2019/1/16 14:20
 *包名：me.tmgg.kotlinapp.retorfitTest
 *<p>description:            </p>
 */
class RvAdapter(private val datasList: MutableList<Result>,private val itemClick:OnItemClickListener) : RecyclerView.Adapter<RvAdapter.MyViewHolder>() {
    private var ctx :Context? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        ctx = parent.context
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category_rv,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return datasList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val category = datasList[position]
        with(category){
            holder.tv.text = title
            GlideApp.with(ctx!!).load(icon)
                    .override(120, 120)
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                    .centerCrop().into(holder.iv)
            holder.itemView.setOnClickListener { itemClick.invoke(title) }
        }

    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val tv = view.tv_title!!
        var iv = view.iv_header!!
    }
    interface OnItemClickListener{
        operator fun invoke(item:String)
    }
}