package com.android.enciphermessenger.models

import android.content.Context
import com.android.enciphermessenger.helpers.formatAsHeader
import java.util.*

interface ChatEvent {
    val sentAt: Date
}

data class Message(
    var msg: String,
    val senderId: String,
    val msgId: String,
    val type: String = "TEXT",
    val status: Int = 1,
    val liked: Boolean = false,
    override val sentAt: Date = Date()
) : ChatEvent {

    constructor() : this("", "", "", "", 1, false, Date(0L))
}

data class DateHeader(override val sentAt: Date, val context: Context) :
    ChatEvent {
    val date: String = sentAt.formatAsHeader(context)
}