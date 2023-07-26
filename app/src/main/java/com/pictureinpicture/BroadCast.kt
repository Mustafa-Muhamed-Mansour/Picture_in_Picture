package com.pictureinpicture

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class BroadCast : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, "This is an setting", Toast.LENGTH_SHORT).show()
    }
}