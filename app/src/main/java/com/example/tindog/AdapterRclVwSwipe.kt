package com.example.tindog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView


class AdapterRclVwSwipe(private val SwipeList: List<RclVwSwipe>) : RecyclerView.Adapter<AdapterRclVwSwipe.ViewHolderSwipe>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderSwipe {

        val itemView2 = LayoutInflater.from(parent.context).inflate(R.layout.rclvwswipe,
            parent, false)

        return ViewHolderSwipe(itemView2)
    }

    override fun getItemCount() = SwipeList.size

    override fun onBindViewHolder(holder: ViewHolderSwipe, position: Int) {
        val currentItem2 = SwipeList[position]

        holder.imageViewAnimal.setImageDrawable(ContextCompat.getDrawable(holder.itemView.context,currentItem2.imageResourceAnimal))
        holder.textViewNom.text = currentItem2.textnom
    }

    class ViewHolderSwipe(itemView2 : View) : RecyclerView.ViewHolder(itemView2) {
        val imageViewAnimal: ImageView = itemView2.findViewById(R.id.image_view_animal)
        val imageViewCross: ImageView = itemView2.findViewById(R.id.no_button)
        val imageViewYes: ImageView = itemView2.findViewById(R.id.yes_button)
        val textViewNom : TextView = itemView2.findViewById(R.id.name_animal)

    }
}