package com.kingslayer.whatsappclone.settings.chats

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.NavUtils
import android.view.MenuItem
import com.kingslayer.whatsappclone.R
import kotlinx.android.synthetic.main.activity_chat_setting.*

class ChatSettingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_setting)

        if(actionBar != null)
        {
            actionBar.setDisplayHomeAsUpEnabled(true)
        }

        mWallpaper.setOnClickListener {
            val imageIntent = Intent(Intent.ACTION_GET_CONTENT)
            imageIntent.type = "image/*"

            val anyOtherGalleryAppsIntent = Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            anyOtherGalleryAppsIntent.type = "image/*"

            val chooserIntent = Intent.createChooser(imageIntent, "Wallpaper")
            chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, arrayOf(anyOtherGalleryAppsIntent))

            startActivityForResult(chooserIntent, 200)
        }

        
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if(item?.itemId == R.id.home)
            NavUtils.navigateUpFromSameTask(this@ChatSettingActivity)
        return super.onOptionsItemSelected(item)
    }
}
