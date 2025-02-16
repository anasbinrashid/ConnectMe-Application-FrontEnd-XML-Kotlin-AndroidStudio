package com.anasbinrashid.i220907

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SearchAdapter(private val searchList: MutableList<String>) :
    RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {

    private var filteredList: MutableList<String> = searchList.toMutableList()

    inner class SearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvSearchItem: TextView = itemView.findViewById(R.id.item)
        val ivDelete: ImageView = itemView.findViewById(R.id.close)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.search, parent, false)
        return SearchViewHolder(view)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val searchItem = filteredList[position]
        holder.tvSearchItem.text = searchItem

        holder.ivDelete.setOnClickListener {
            val pos = holder.adapterPosition
            if (pos != RecyclerView.NO_POSITION) {
                searchList.removeAt(pos)
                filter("")
            }
        }

    }

    override fun getItemCount(): Int {
        return filteredList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun filter(query: String) {
        filteredList.clear()
        if (query.isEmpty()) {
            filteredList.addAll(searchList)
        } else {
            filteredList.addAll(searchList.filter { it.contains(query, ignoreCase = true) })
        }
        notifyDataSetChanged()
    }

}