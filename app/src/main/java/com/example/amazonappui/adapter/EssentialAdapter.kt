package com.example.amazonappui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.amazonappui.R
import com.example.amazonappui.model.Essential

class EssentialAdapter(val context: Context, var items: ArrayList<Essential>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val  view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_essential, parent, false)
        return EssentialViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val feed = items[position]

        if (holder is EssentialViewHolder){
            holder.tv_title.text = feed.title
            holder.iv_image.setImageResource(feed.image)
        }
    }

    override fun getItemCount() = items.size

    inner class EssentialViewHolder(view: View): RecyclerView.ViewHolder(view){
        val tv_title: TextView
        val iv_image: ImageView

        init {
            tv_title = view.findViewById(R.id.tv_title)
            iv_image = view.findViewById(R.id.iv_image)
        }
    }

}