package com.anasbinrashid.i220907

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val list: MutableList<Model>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        var v = LayoutInflater.from(parent.context).inflate(R.layout.post, parent, false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        holder.name.text= list[position].name
        holder.username.text= list[position].username
        holder.caption.text= list[position].caption
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var name : TextView = itemView.findViewById(R.id.name) as TextView
        var username : TextView = itemView.findViewById(R.id.username) as TextView
        var caption : TextView = itemView.findViewById(R.id.caption) as TextView
    }
}