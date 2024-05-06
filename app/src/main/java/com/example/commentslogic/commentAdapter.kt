package com.example.commentslogic

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class commentAdapter(var data:List<Comment>, var onclick:((Comment) -> Unit)?):RecyclerView.Adapter<commentAdapter.ViewHolder>() {
    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {

        var text:TextView = view.findViewById(R.id.textView)
        var button:Button = view.findViewById(R.id.button2)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        var view = LayoutInflater.from(parent.context).inflate(R.layout.comment, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.text.text = data[position].name

        holder.button.setOnClickListener {
            onclick?.invoke(data[position])
        }

    }
}