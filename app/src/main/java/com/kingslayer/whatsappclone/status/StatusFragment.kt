package com.kingslayer.whatsappclone.status

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kingslayer.whatsappclone.R
import com.kingslayer.whatsappclone.model.Status
import kotlinx.android.synthetic.main.status_fragment.view.*

class StatusFragment : Fragment() {

    lateinit var tyrionDp : Drawable
    lateinit var jorahDp : Drawable
    lateinit var jonSnowDp : Drawable

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.status_fragment, container, false)

        tyrionDp = ResourcesCompat.getDrawable(resources, R.drawable.tyrion, null)!!
        jorahDp = ResourcesCompat.getDrawable(resources, R.drawable.jorah, null)!!
        jonSnowDp = ResourcesCompat.getDrawable(resources, R.drawable.jonsnow, null)!!

        val status = listOf(
                Status("Tyrion Lannister", "Today, 2:45 PM", tyrionDp),
                Status("Jon Snow", "Today, 1:45 PM", jonSnowDp),
                Status("Jorah Mormont", "Today, 12:23 PM", jorahDp)
        )

        root.mStatusRecyclerView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        root.mStatusRecyclerView.adapter = StatusRecyclerAdapter(status)
        return root
    }
}