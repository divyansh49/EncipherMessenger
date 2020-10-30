package com.android.enciphermessenger.models

import java.util.*

data class Inbox(
    var msg: String,
    var from: String,
    var name: String,
    var image: String,
    val time: Date = Date(),
    var count: Int = 0
) {
    constructor() : this("", "", "", "", Date(), 0)
}