package com.kingslayer.whatsappclone.call

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kingslayer.whatsappclone.R
import com.kingslayer.whatsappclone.model.Call
import kotlinx.android.synthetic.main.call_list.view.*

class CallRecyclerView(var calls: List<Call>) : RecyclerView.Adapter<CallRecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.call_list, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(calls[position])
    }

    override fun getItemCount(): Int {
        return calls.size
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(call: Call) {
            itemView.mCallDp.setImageDrawable(call.mImage)
            itemView.mCallTime.text = call.mTime
            itemView.mCallerName.text = call.mName
            itemView.mCallTime.setCompoundDrawables(call.mCallResult, null, null, null)
            itemView.mTypeOfCall.setImageDrawable(call.mTypeOfCall)
        }

    }
}