package com.android.enciphermessenger.helpers

import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.android.enciphermessenger.R
import com.android.enciphermessenger.models.Inbox
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_chat.view.*

class ChatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(item: Inbox, onClick: (name: String, photo: String, id: String) -> Unit) =
        with(itemView) {

            countTv.isVisible = item.count > 0
            countTv.text = item.count.toString()
            timeTv.text = item.time.formatAsListItem(context)

            titleTv.text = item.name
            subTitleTv.text = item.msg
            Picasso.get()
                .load(item.image)
                .placeholder(R.drawable.defaultuser)
                .error(R.drawable.defaultuser)
                .into(ivUser)
            setOnClickListener {
                onClick.invoke(item.name, item.image, item.from)
            }

        }
}