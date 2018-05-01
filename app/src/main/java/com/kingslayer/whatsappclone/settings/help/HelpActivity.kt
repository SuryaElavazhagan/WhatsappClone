package com.kingslayer.whatsappclone.settings.help

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.NavUtils
import android.view.MenuItem
import com.kingslayer.whatsappclone.R
import kotlinx.android.synthetic.main.activity_help.*

class HelpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help)

        if(actionBar != null)
            actionBar.setDisplayHomeAsUpEnabled(true)

        mFaq.setOnClickListener {
            startActivity(Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://faq.whatsapp.com")
            ))
        }

        mTermsAndConditions.setOnClickListener {
            startActivity(Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.whatsapp.com/legal")
            ))
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if(item?.itemId == R.id.home)
            NavUtils.navigateUpFromSameTask(this@HelpActivity)

        return super.onOptionsItemSelected(item)
    }
}
