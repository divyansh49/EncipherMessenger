package com.android.enciphermessenger.helpers

import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.android.enciphermessenger.R
import com.android.enciphermessenger.models.User
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_chat.view.*


class UsersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(user: User, onClick: (name: String, photo: String, id: String) -> Unit) =
        with(itemView) {

            countTv.isVisible = false
            timeTv.isVisible = false

            titleTv.text = user.name
            subTitleTv.text = user.status
            Picasso.get()
                .load(user.thumbImage)
                .placeholder(R.drawable.defaultuser)
                .error(R.drawable.defaultuser)
                .into(ivUser)
            setOnClickListener {
                onClick.invoke(user.name, user.thumbImage, user.uid)
            }

        }
}

class EmptyViewHolder(view: View) : RecyclerView.ViewHolder(view)