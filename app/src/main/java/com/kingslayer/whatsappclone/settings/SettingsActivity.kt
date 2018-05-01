package com.kingslayer.whatsappclone.settings

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.NavUtils
import android.view.MenuItem
import com.kingslayer.whatsappclone.settings.account.AccountActivity
import com.kingslayer.whatsappclone.R
import com.kingslayer.whatsappclone.settings.chats.ChatSettingActivity
import com.kingslayer.whatsappclone.settings.datastorage.DataAndStorageActivity
import com.kingslayer.whatsappclone.settings.help.HelpActivity
import com.kingslayer.whatsappclone.settings.notifications.NotificationSettingsActivity
import kotlinx.android.synthetic.main.activity_help.*
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        if(actionBar != null)
        {
            actionBar.setDisplayHomeAsUpEnabled(true)
        }

        account.setOnClickListener{
            startActivity(Intent(this@SettingsActivity, AccountActivity::class.java))
        }

        chats.setOnClickListener {
            startActivity(Intent(this@SettingsActivity, ChatSettingActivity::class.java))
        }

        notifications.setOnClickListener {
            startActivity(Intent(this@SettingsActivity, NotificationSettingsActivity::class.java))
        }

        data_and_storage.setOnClickListener {
            startActivity(Intent(this@SettingsActivity, DataAndStorageActivity::class.java))
        }

        help.setOnClickListener {
            startActivity(Intent(this@SettingsActivity, HelpActivity::class.java))
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if(item?.itemId == R.id.home)
        {
            NavUtils.navigateUpFromSameTask(this@SettingsActivity)
        }

        return super.onOptionsItemSelected(item)
    }
}
