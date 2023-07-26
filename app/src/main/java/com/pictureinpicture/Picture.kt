package com.pictureinpicture

import android.content.Context
import android.net.Uri
import android.widget.VideoView
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toAndroidRect
import androidx.compose.ui.layout.boundsInWindow
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun UpdatePictureInPicture(packageName: String, context: Context) {

    val pic = Pic(context)

    AndroidView(
        factory = {
            VideoView(it, null).apply {
                setVideoURI(Uri.parse("android.resource://${packageName}/${R.raw.musics}"))
                start()
            }
        }, modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .onGloballyPositioned {
                pic.videoBound = it
                    .boundsInWindow()
                    .toAndroidRect()
            }
    )

}