package jiyoung.example.kotlin.com.flipanimsample

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*


class SnappyViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.cell_layout, parent, false)) {

    fun setDate(date: Date) {
        (itemView.findViewById(R.id.date_text) as TextView).text = SimpleDateFormat("EEE d").format(date)
        (itemView.findViewById(R.id.month_text) as TextView).text = SimpleDateFormat("MMM").format(date)
    }
}