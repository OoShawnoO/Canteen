package com.example.canteen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CateenAdapter(val Cateens:ArrayList<Cateen>):RecyclerView.Adapter<CateenAdapter.CateenViewHolder>(){
    inner class CateenViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val name = itemView.findViewById<TextView>(R.id.cateenName)
        val content = itemView.findViewById<TextView>(R.id.cateenContent)
        val state = itemView.findViewById<TextView>(R.id.cateenState)
        val img =  itemView.findViewById<ImageView>(R.id.cateenImage)
        val distance = itemView.findViewById<TextView>(R.id.cateenDistance)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CateenViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cateen_item,parent,false)
        val holder = CateenViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: CateenViewHolder, position: Int) {
        val cateen = Cateens[position]
        holder.content.text = cateen.content
        holder.name.text = cateen.name
        holder.state.text = cateen.state
        holder.distance.text = cateen.distance
        holder.img.setImageResource(cateen.Image)
    }

    override fun getItemCount(): Int {
        return Cateens.size
    }
}