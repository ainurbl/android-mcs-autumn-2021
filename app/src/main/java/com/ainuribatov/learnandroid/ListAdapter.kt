package com.ainuribatov.learnandroid

import android.graphics.drawable.Drawable
import android.provider.ContactsContract.CommonDataKinds.Website.URL
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.io.InputStream
import java.lang.Exception
import java.net.URL
import java.util.concurrent.SynchronousQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit
import kotlin.concurrent.thread

class ListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var userList: List<Item> = emptyList()
    var pool: ThreadPoolExecutor =
        ThreadPoolExecutor(5, 15, 1000, TimeUnit.SECONDS, SynchronousQueue())

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
                val url = URL(userData.avatarUrl)

                pool.submit {
                    val content = url.content as InputStream
                    holder.avatarImageView.setImageDrawable(
                        Drawable.createFromStream(
                            content,
                            "src"
                        )
                    )
                }

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