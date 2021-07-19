package com.bakharaalief.requetapisederhana

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bakharaalief.requetapisederhana.model.Post

class ListAdapter : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    var listPost = listOf<Post>()
    set(value) {
        field = value
        notifyDataSetChanged() //ngasih tahu kalau ada data yg berubah
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val postTitle = itemView.findViewById<TextView>(R.id.postTitle)
        private val postBody = itemView.findViewById<TextView>(R.id.postBody)

        fun bind(post: Post){
            postTitle.text = post.title
            postBody.text = post.body
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val item = inflater.inflate(R.layout.post_item, parent, false)
        return ViewHolder(item)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val postData = listPost[position]
        holder.bind(postData)
    }

    override fun getItemCount(): Int {
        return listPost.size
    }
}