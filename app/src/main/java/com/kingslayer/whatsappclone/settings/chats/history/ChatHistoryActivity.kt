package com.kingslayer.whatsappclone.settings.chats.history

import android.app.Dialog
import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.NavUtils
import android.support.v7.app.AlertDialog
import android.view.MenuItem
import com.kingslayer.whatsappclone.R
import kotlinx.android.synthetic.main.activity_chat_history.*
import kotlinx.android.synthetic.main.clear_chat_dialog.*
import kotlinx.android.synthetic.main.clear_chat_dialog.view.*

class ChatHistoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_history)

        if(actionBar != null)
            actionBar.setDisplayHomeAsUpEnabled(true)

        mArchiveAllChats.setOnClickListener {
            val builder = AlertDialog.Builder(this@ChatHistoryActivity)

            builder.setMessage("Are you sure you want to archive ALL chats?")
            builder.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->
                dialog.dismiss()
            })
            builder.setNegativeButton("CANCEL", DialogInterface.OnClickListener { dialog, which ->
                dialog.dismiss()
            })
            builder.create()
        }

        mClearAllChats.setOnClickListener {
            val dialog = Dialog(this@ChatHistoryActivity)
            dialog.setContentView(R.layout.clear_chat_dialog)

            dialog.mClearAllMessages.setOnClickListener {
                dialog.dismiss()
            }

            dialog.mCancel.setOnClickListener {
                dialog.dismiss()
            }

            dialog.clearAllExceptStarred.setOnClickListener {
                dialog.dismiss()
            }
        }

        mDeleteAllChats.setOnClickListener {
            val builder = AlertDialog.Builder(this@ChatHistoryActivity)
            val inflater = this@ChatHistoryActivity.layoutInflater

            builder.setView(inflater.inflate(R.layout.delete_chat_dialog, null))
                    .setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->
                        dialog.dismiss()
                    })
                    .setNegativeButton("CANCEL", DialogInterface.OnClickListener { dialog, which ->
                        dialog.dismiss()
                    })
                    .create()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if(item?.itemId == R.id.home)
            NavUtils.navigateUpFromSameTask(this)

        return super.onOptionsItemSelected(item)
    }
}
