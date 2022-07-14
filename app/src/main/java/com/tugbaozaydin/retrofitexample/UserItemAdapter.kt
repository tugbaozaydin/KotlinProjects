package com.tugbaozaydin.retrofitexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class UserItemAdapter(val data: List<User>) :
    RecyclerView.Adapter<UserItemAdapter.UserItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)

        return UserItemViewHolder(view)
    }


    override fun onBindViewHolder(holder: UserItemViewHolder, position: Int) {
        val item = data[position]
        holder.userName.text = item.name
        holder.userPhone.text = item.phone
        Glide.with(holder.itemView.context).load(item.avatar).into(holder.userAvatar);
    }

    override fun getItemCount() = data.size

    class UserItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        val userName: TextView = view.findViewById(R.id.user_name)
        val userPhone: TextView = view.findViewById(R.id.user_phone)
        val userAvatar: ImageView = view.findViewById(R.id.user_avatar)

    }
}

