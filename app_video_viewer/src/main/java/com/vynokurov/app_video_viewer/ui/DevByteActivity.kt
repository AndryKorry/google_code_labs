
package com.vynokurov.app_video_viewer.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.vynokurov.app_video_viewer.R

/**
 * This is a single activity application that uses the Navigation library. Content is displayed
 * by Fragments.
 */
class DevByteActivity : AppCompatActivity() {

    /**
     * Called when the activity is starting.  This is where most initialization
     * should go
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dev_byte_viewer)
    }
}
