package jiyoung.example.kotlin.com.flipanimsample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import kotlinx.android.synthetic.main.act_snappy.*

class ActSnappy : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_snappy)

        val mAdapter = object : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
            override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
                return
            }


            override fun getItemCount(): Int {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }
        rvSnappy.adapter = mAdapter
    }


}
