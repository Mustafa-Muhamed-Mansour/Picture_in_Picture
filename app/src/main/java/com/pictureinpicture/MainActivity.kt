package com.pictureinpicture

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            UpdatePictureInPicture(packageName, applicationContext)
        }
    }


    override fun onUserLeaveHint() {
        super.onUserLeaveHint()

        val pic = Pic(applicationContext)

        pic.updatePictureInPicture()?.apply {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                enterPictureInPictureMode(this)
            }
        }

    }
}