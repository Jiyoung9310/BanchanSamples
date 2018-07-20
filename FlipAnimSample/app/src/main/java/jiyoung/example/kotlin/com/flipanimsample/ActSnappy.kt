package jiyoung.example.kotlin.com.flipanimsample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.act_snappy.*



class ActSnappy : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_snappy)

        rvSnappy.addItemDecoration(SnappyItemDecoration(rvSnappy.orientation))
        rvSnappy.adapter = SnappyAdapter()
    }


}
