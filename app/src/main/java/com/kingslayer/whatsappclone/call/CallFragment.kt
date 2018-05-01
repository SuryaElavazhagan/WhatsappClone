package com.kingslayer.whatsappclone.call

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kingslayer.whatsappclone.R
import com.kingslayer.whatsappclone.model.Call
import kotlinx.android.synthetic.main.call_fragment.view.*

class CallFragment : Fragment() {

    private lateinit var callMadeGreen: Drawable
    private lateinit var callMadeRed: Drawable
    private lateinit var callReceivedGreen: Drawable
    private lateinit var callReceivedRed: Drawable
    private lateinit var tyrionDp: Drawable
    private lateinit var jonSnowDp: Drawable
    private lateinit var jorahDp: Drawable
    private lateinit var voiceCall: Drawable
    private lateinit var videoCall: Drawable

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root =  inflater.inflate(R.layout.call_fragment, container, false)

        callMadeGreen = ResourcesCompat.getDrawable(resources, R.drawable.ic_call_made_green, null)!!
        callMadeRed = ResourcesCompat.getDrawable(resources, R.drawable.ic_call_made_red, null)!!
        callReceivedGreen = ResourcesCompat.getDrawable(resources, R.drawable.ic_call_received_green, null)!!
        callReceivedRed = ResourcesCompat.getDrawable(resources, R.drawable.ic_call_received_red, null)!!
        tyrionDp = ResourcesCompat.getDrawable(resources, R.drawable.tyrion, null)!!
        jonSnowDp = ResourcesCompat.getDrawable(resources, R.drawable.jonsnow, null)!!
        jorahDp = ResourcesCompat.getDrawable(resources, R.drawable.jorah, null)!!
        voiceCall = ResourcesCompat.getDrawable(resources, R.drawable.ic_call, null)!!
        videoCall = ResourcesCompat.getDrawable(resources, R.drawable.ic_videocall, null)!!

        val calls = listOf(
                Call("Tyrion Lannister", "(2) Today, 11:44 PM", callMadeGreen, tyrionDp, voiceCall),
                Call("Jon Snow", "Today, 9:00 PM", callMadeGreen, jonSnowDp, videoCall),
                Call("Tyrion Lannister", "(10) Today, 8:00 PM", callMadeRed, jorahDp, voiceCall)
        )

        root.mCallRecyclerView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        root.mCallRecyclerView.adapter = CallRecyclerView(calls)
        return root
    }

}