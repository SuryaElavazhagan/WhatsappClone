package com.kingslayer.whatsappclone.chats

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.kingslayer.whatsappclone.R

class ChatActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        val bundle = intent.extras.getBundle("DATA")
        val name = bundle?.getString("NAME")

        Log.i("CHAT ACTIVITY", name)
    }
}
