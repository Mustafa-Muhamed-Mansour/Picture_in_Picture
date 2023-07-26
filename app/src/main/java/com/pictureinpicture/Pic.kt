package com.pictureinpicture

import android.app.PendingIntent
import android.app.PictureInPictureParams
import android.app.RemoteAction
import android.content.Context
import android.content.Intent
import android.graphics.Rect
import android.graphics.drawable.Icon
import android.os.Build
import android.util.Rational

class Pic(private val context: Context) {

    var videoBound = Rect()


    fun updatePictureInPicture(): PictureInPictureParams? {

        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            PictureInPictureParams.Builder()
                .setSourceRectHint(videoBound)
                .setAspectRatio(Rational(15, 7)) // el-gawanep
                .setActions(
                    listOf(
                        RemoteAction(
                            Icon.createWithResource(
                                context, R.drawable.ic_setting
                            ),
                            "My action",
                            "This is a description my action",
                            PendingIntent.getBroadcast(
                                context, 0, Intent(context, BroadCast::class.java), PendingIntent.FLAG_IMMUTABLE
                            )
                        )
                    )
                )
                .build()
        } else {
            return null
        }
    }
}