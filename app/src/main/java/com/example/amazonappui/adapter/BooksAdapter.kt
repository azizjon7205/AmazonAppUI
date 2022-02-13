package com.example.amazonappui.adapter

import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.amazonappui.R
import com.example.amazonappui.model.Books

class BooksAdapter(val context: Context, var items: ArrayList<Books>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return BookViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_books_view, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var item = items[position]

        if (holder is BookViewHolder){
            holder.iv_book_image.setImageResource(item.image)
            holder.tv_book_name.text = item.name
            holder.tv_book_price_entire.text = item.price.subSequence(0,item.price.indexOf('.',0))
            holder.tv_book_price_fraction.text = item.price.subSequence(item.price.indexOf('.',0)+1, item.price.length)
            if (item.price == item.oldPrice){
                holder.tv_book_price_old.visibility = View.INVISIBLE
            } else{
                holder.tv_book_price_old.text = "$${item.oldPrice}"
                holder.tv_book_price_old.paintFlags= holder.tv_book_price_old.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            }
        }
    }

    override fun getItemCount() = items.size

    inner class BookViewHolder(view: View): RecyclerView.ViewHolder(view){
        val iv_book_image = view.findViewById<ImageView>(R.id.iv_book)
        val tv_book_name = view.findViewById<TextView>(R.id.tv_book_name)
        val tv_book_price_entire = view.findViewById<TextView>(R.id.tv_book_price_entire)
        val tv_book_price_fraction = view.findViewById<TextView>(R.id.tv_book_price_fraction)
        val tv_book_price_old = view.findViewById<TextView>(R.id.tv_book_price_old)


    }
}