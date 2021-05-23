package com.example.tindog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView


class AdapterRclVwOptions(private val ListRclVwOptions: List<RclVwOptions>) : RecyclerView.Adapter<AdapterRclVwOptions.ViewHolderOptions>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderOptions {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.rclvw1,
            parent, false)

        return ViewHolderOptions(itemView)
    }



    override fun getItemCount() = ListRclVwOptions.size


    override fun onBindViewHolder(holder: ViewHolderOptions, position: Int) {
        val currentItem = ListRclVwOptions[position]

        holder.imageView.setImageDrawable(ContextCompat.getDrawable(holder.itemView.context,currentItem.imageResource))
        holder.textView.text = currentItem.text1
    }

    class ViewHolderOptions(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView : ImageView = itemView.findViewById(R.id.image_view)
        val textView : TextView = itemView.findViewById(R.id.text_view)

    }
}