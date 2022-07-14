package com.tugbaozaydin.retrofitexample

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tugbaozaydin.retrofitexample.databinding.UserItemBinding

class UserItemAdapter(val data: List<User>) :
    RecyclerView.Adapter<UserItemAdapter.UserItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = UserItemBinding.inflate(layoutInflater, parent, false)

        return UserItemViewHolder(binding)
    }


    override fun onBindViewHolder(holder: UserItemViewHolder, position: Int) {
        val item = data[position]
        holder.userName.text = item.name
        holder.userPhone.text = item.phone
        Glide.with(holder.itemView.context).load(item.avatar).into(holder.userAvatar)
        holder.userCardView.setOnClickListener{ view ->
            val userDetailNavigate = UserFragmentDirections.actionUserFragmentToUserDetailFragment(item)
            Navigation.findNavController(view).navigate(userDetailNavigate)
            //view.findNavController().navigate(R.id.action_userFragment_to_userDetailFragment)
        }
    }

    override fun getItemCount() = data.size

    class UserItemViewHolder(binding: UserItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val userName: TextView = binding.userName
        val userPhone: TextView = binding.userPhone
        val userAvatar: ImageView = binding.userAvatar
        val userCardView : CardView = binding.userCardView

    }
}

