package com.example.amazonappui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.amazonappui.R
import com.example.amazonappui.model.Department

class DepartmentAdapter(val context: Context, var items: ArrayList<Department>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_department, parent, false)
        return DepartmentViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]

        if (holder is DepartmentViewHolder){
            holder.iv_department_image.setImageResource(item.image)
            holder.tv_department_name.text = item.name
        }
    }

    override fun getItemCount() = items.size

    inner class DepartmentViewHolder(view: View): RecyclerView.ViewHolder(view){
        val iv_department_image = view.findViewById<ImageView>(R.id.iv_department_image)
        val tv_department_name = view.findViewById<TextView>(R.id.tv_department_name)
    }
}