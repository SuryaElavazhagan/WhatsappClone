package com.kingslayer.whatsappclone.chats

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kingslayer.whatsappclone.R
import com.kingslayer.whatsappclone.model.Chat
import kotlinx.android.synthetic.main.chat_fragment.view.*

class ChatFragment : Fragment() {

    val TAG = "CHAT_FRAGMENT"
    lateinit var tyrionDp : Drawable
    lateinit var jorahDp : Drawable
    lateinit var jonSnowDp : Drawable

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.chat_fragment, container, false)
        try {
            tyrionDp = ResourcesCompat.getDrawable(resources, R.drawable.tyrion, null)!!
            jorahDp = ResourcesCompat.getDrawable(resources, R.drawable.jorah, null)!!
            jonSnowDp = ResourcesCompat.getDrawable(resources, R.drawable.jonsnow, null)!!

            val chats = listOf(
                    Chat("Tyrion Lannister", "Let's kill Cersei Lannister", "12:51 PM", tyrionDp),
                    Chat("Jorah Mormont", "When will I get a chance?", "12:15 PM", jorahDp),
                    Chat("Jon Snow", "We never should have done that", "12:00 PM", jonSnowDp)
            )
            root.ChatRecyclerView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
            root.ChatRecyclerView.adapter = ChatRecyclerAdapter(chats, context!!)
        } catch (e: Exception)
        {
            Log.e(TAG, e.localizedMessage)
        }
        return root
    }
}