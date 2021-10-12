package com.ainuribatov.learnandroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop

class ListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var userList: List<Item> = emptyList()

    class UserHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val avatarImageView = itemView.findViewById<ImageView>(R.id.avatarImageView)
        val userNameTextView = itemView.findViewById<TextView>(R.id.userNameTextView)
        val groupNameTextView = itemView.findViewById<TextView>(R.id.groupNameTextView)
    }

    class SeparatorHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val separatorView = itemView.findViewById<View>(R.id.separatorView)
    }

    override fun getItemViewType(position: Int): Int {
        return when (userList[position]) {
            is UserData -> 0
            is SeparatorData -> 1
            else -> {
                assert(false)
                2
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            0 -> {
                val itemView =
                    LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
                UserHolder(itemView)
            }
            else -> {
                val itemView =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_separator, parent, false)
                SeparatorHolder(itemView)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            0 -> {
                holder as UserHolder
                val userData = userList[position] as UserData
                holder.userNameTextView.text = userData.userName
                holder.groupNameTextView.text = userData.groupName
                Glide.with(holder.avatarImageView)
                    .load(userData.avatarUrl)
                    .transform(CircleCrop())
                    .into(holder.avatarImageView)
            }
            else -> {
                holder as SeparatorHolder
            }
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}