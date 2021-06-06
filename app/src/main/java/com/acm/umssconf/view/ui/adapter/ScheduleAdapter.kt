package com.acm.umssconf.view.ui.adapter

import android.telecom.Conference
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.acm.umssconf.R

class ScheduleAdapter() : RecyclerView.Adapter<ScheduleAdapter.ViewHolder>() {
    var listConference = ArrayList<Conference>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(parent.context).inflate(
        R.layout.item_schedule,parent,false))

    override fun onBindViewHolder(holder: ScheduleAdapter.ViewHolder, position: Int) {
    }

    override fun getItemCount() = listConference.size
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val itemScheduleHour =itemView.findViewById<TextView>(R.id.itemScheduleHour)
        val itemScheduleDate =itemView.findViewById<TextView>(R.id.itemScheduleDate)
        val itemScheduleTitle =itemView.findViewById<TextView>(R.id.itemScheduleTitle)
        val itemScheduleSubtitle =itemView.findViewById<TextView>(R.id.itemScheduleSubtitle)
        val itemScheduleTag =itemView.findViewById<TextView>(R.id.itemScheduleTag)
    }
}