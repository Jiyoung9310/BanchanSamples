package jiyoung.example.kotlin.com.flipanimsample

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


class SnappyAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return SnappyViewHolder(parent!!)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as SnappyViewHolder).setDate(dates[position])
    }

    private var startDate: Date? = null
    private var endDate: Date? = null

    private var dates: MutableList<Date>

    init {
        val formatter = SimpleDateFormat("yyyy-MM-dd")

        try {
            startDate = formatter.parse("2017-01-01")
        } catch (ex: ParseException) {
        }

        try {
            endDate = formatter.parse("2018-12-31")
        } catch (ex: ParseException) {
        }

        val start = Calendar.getInstance()
        start.time = startDate

        val end = Calendar.getInstance()
        end.time = endDate

        dates = ArrayList()
        var date = start.time
        while (start.before(end)) {
            dates.add(date)
            start.add(Calendar.DATE, 1)
            date = start.time
        }
    }

    override fun getItemCount(): Int {
        return dates.size
    }



}