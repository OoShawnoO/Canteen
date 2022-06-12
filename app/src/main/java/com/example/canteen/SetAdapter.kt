package com.example.canteen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class SetAdapter(val Sets:ArrayList<Set>):RecyclerView.Adapter<SetAdapter.SetViewHolder>(){
    inner class SetViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val name = itemView.findViewById<TextView>(R.id.SetName)
        val count = itemView.findViewById<TextView>(R.id.SetCount)
        val price = itemView.findViewById<TextView>(R.id.SetPrice)
        val img =  itemView.findViewById<ImageView>(R.id.SetImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SetViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.set_item,parent,false)
        val holder = SetViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: SetViewHolder, position: Int) {
        val Set = Sets[position]
        holder.count.text = Set.count.toString()
        holder.name.text = Set.name
        holder.price.text = Set.price
        holder.img.setImageResource(Set.Image)
    }

    override fun getItemCount(): Int {
        return Sets.size
    }
}