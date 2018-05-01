package com.kingslayer.whatsappclone.chats

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.kingslayer.whatsappclone.R
import com.kingslayer.whatsappclone.model.Chat

class ChatRecyclerAdapter(var contacts: List<Chat>, var context : Context) : RecyclerView.Adapter<ChatRecyclerAdapter.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.chat_list, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(contacts[position])

        holder.itemView.setOnClickListener {
            val intent = Intent(context, ChatActivity::class.java)
            val bundle = Bundle()
            bundle.putString("NAME", contacts[position].mName)
            intent.putExtra("DATA", bundle)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        private var mProfilePicture = itemView.findViewById<ImageView>(R.id.mProfilePicture)
        private var mName = itemView.findViewById<TextView>(R.id.mContactName)
        private var mLastText = itemView.findViewById<TextView>(R.id.mLastText)
        private var mTime = itemView.findViewById<TextView>(R.id.mTime)

        fun bindView(chat: Chat) {
            mProfilePicture.setImageDrawable(chat.mProfilePic)
            mName.text = chat.mName
            mLastText.text = chat.mLastMessage
            mTime.text = chat.mTime
        }
    }

}