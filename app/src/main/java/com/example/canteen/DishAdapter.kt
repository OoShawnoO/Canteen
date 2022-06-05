package com.example.canteen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DishAdapter(val Dishs:ArrayList<Dish>):RecyclerView.Adapter<DishAdapter.DishViewHolder>(){
    inner class DishViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val name = itemView.findViewById<TextView>(R.id.DishName)
        val content = itemView.findViewById<TextView>(R.id.DishContent)
        val description = itemView.findViewById<TextView>(R.id.DishDescription)
        val img =  itemView.findViewById<ImageView>(R.id.DishImage)
        val price = itemView.findViewById<TextView>(R.id.DishPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.dish_item,parent,false)
        val holder = DishViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: DishViewHolder, position: Int) {
        val Dish = Dishs[position]
        holder.content.text = Dish.content
        holder.name.text = Dish.name
        holder.description.text = Dish.description
        holder.price.text = Dish.price
        holder.img.setImageResource(Dish.Image)
    }

    override fun getItemCount(): Int {
        return Dishs.size
    }
}