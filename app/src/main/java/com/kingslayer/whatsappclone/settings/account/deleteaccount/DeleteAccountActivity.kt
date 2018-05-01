package com.kingslayer.whatsappclone.settings.account.deleteaccount

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.NavUtils
import android.view.MenuItem
import com.kingslayer.whatsappclone.R
import com.kingslayer.whatsappclone.settings.account.changenumber.ChangeNumberActivity
import kotlinx.android.synthetic.main.activity_delete_account.*

class DeleteAccountActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete_account)

        if(actionBar != null)
        {
            actionBar.setDisplayHomeAsUpEnabled(true)
        }

        mChangeNumber?.setOnClickListener {
            startActivity(Intent(this@DeleteAccountActivity, ChangeNumberActivity::class.java))
        }

        mPhoneNumber?.requestFocus()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if(item?.itemId == R.id.home)
            NavUtils.navigateUpFromSameTask(this@DeleteAccountActivity)

        return super.onOptionsItemSelected(item)
    }
}
