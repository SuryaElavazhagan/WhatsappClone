package com.kingslayer.whatsappclone.settings.account

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.NavUtils
import android.view.MenuItem
import com.kingslayer.whatsappclone.*
import com.kingslayer.whatsappclone.settings.account.changenumber.ChangeNumberActivity
import com.kingslayer.whatsappclone.settings.account.deleteaccount.DeleteAccountActivity
import com.kingslayer.whatsappclone.settings.account.privacy.PrivacyActivity
import com.kingslayer.whatsappclone.settings.account.security.SecurityActivity
import com.kingslayer.whatsappclone.settings.account.twostepverification.TwoStepVerificationActivity
import kotlinx.android.synthetic.main.activity_account.*

class AccountActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        if(actionBar != null)
        {
            actionBar.setDisplayHomeAsUpEnabled(true)
        }

        mPrivacySettings.setOnClickListener{
            startActivity(Intent(this@AccountActivity, PrivacyActivity::class.java))
        }

        mSecuritySettings.setOnClickListener {
            startActivity(Intent(this@AccountActivity, SecurityActivity::class.java))
        }

        mTwoStepVerificationSettings.setOnClickListener {
            startActivity(Intent(this@AccountActivity, TwoStepVerificationActivity::class.java))
        }

        mChangeNumberSettings.setOnClickListener {
            startActivity(Intent(this@AccountActivity, ChangeNumberActivity::class.java))
        }

        mDeleteMyAccountSettings.setOnClickListener {
            startActivity(Intent(this@AccountActivity, DeleteAccountActivity::class.java))
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if(item?.itemId == R.id.home)
            NavUtils.navigateUpFromSameTask(this@AccountActivity)

        return super.onOptionsItemSelected(item)
    }
}
