package com.linetndau.postapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView

class PostDetailsAdapter (var postList: List<Post>): RecyclerView.Adapter<PostViewHolder>(){
    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
      val itemView = LayoutInflater.from(parent.context)
          .inflate(R.layout.main_details,parent,false)
        return PostViewHolder(itemView)
    }

    override fun getItemCount(): Int {
     return postList.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
       var post  = postList[position]
        holder.body.text = post.body
        holder.id.text = "ID: ${post.id}"
        holder.title.text = post.title
        holder.username.text = "UserID :${post.userId}"
    }

}




class PostViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
    var id =itemView.findViewById<TextView>(R.id.tvId)
    var username= itemView.findViewById<TextView>(R.id.tvUserId)
    var body= itemView.findViewById<TextView>(R.id.tvBody)
    var title = itemView.findViewById<TextView>(R.id.tvTitle)
}

//fun View(): View {
//    val body = String
//    val id = Int
//}
