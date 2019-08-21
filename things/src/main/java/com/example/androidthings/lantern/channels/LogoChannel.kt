package com.example.androidthings.lantern.channels

import android.net.Uri
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.VideoView
import com.example.androidthings.lantern.Channel
import com.example.androidthings.lantern.R


class LogoChannel : Channel() {
    var refreshError: Exception? = null
    var videoUri: Uri? =null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return VideoView(context).apply{
            //keep as looping
            setOnPreparedListener({
                it.isLooping = true
            })
            //set the path
            val uriPath = "android.resource://com.example.androidthings.lantern.channels/" + R.raw.logo
            videoUri = Uri.parse(uriPath)
            setVideoURI(videoUri)
            start()
        }
    }
}