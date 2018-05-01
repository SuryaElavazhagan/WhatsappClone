package com.kingslayer.whatsappclone.settings.account.privacy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.NavUtils
import android.view.MenuItem
import com.kingslayer.whatsappclone.R

class PrivacyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_privacy)

        if(actionBar != null)
            actionBar.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if(item?.itemId == R.id.home)
            NavUtils.navigateUpFromSameTask(this@PrivacyActivity)

        return super.onOptionsItemSelected(item)
    }
}
