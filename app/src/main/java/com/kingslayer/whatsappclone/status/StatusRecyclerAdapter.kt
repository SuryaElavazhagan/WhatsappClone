package com.kingslayer.whatsappclone.status

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kingslayer.whatsappclone.R
import com.kingslayer.whatsappclone.model.Status
import kotlinx.android.synthetic.main.status_list.view.*

class StatusRecyclerAdapter(var status: List<Status>) : RecyclerView.Adapter<StatusRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.status_list, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(status[position])
    }

    override fun getItemCount(): Int {
        return status.size
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(status: Status) {
            itemView.mContactDp.setImageDrawable(status.mImage)
            itemView.mStatusContactName.text = status.mName
            itemView.mStatusTime.text = status.mTime
        }

    }
}