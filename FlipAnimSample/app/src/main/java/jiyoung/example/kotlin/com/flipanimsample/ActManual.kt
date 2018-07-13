package jiyoung.example.kotlin.com.flipanimsample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.act_manual.*

class ActManual : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_manual)
        main_activity_card_face.setOnClickListener { _ -> onCardClick() }
        main_activity_card_back.setOnClickListener { _ -> onCardClick() }
    }

    fun onCardClick() {
        flipCard()
    }

    private fun flipCard() {

        val flipAnimation = FlipAnimation(main_activity_card_face, main_activity_card_back)

        if (main_activity_card_face.visibility == View.GONE) {
            flipAnimation.reverse()
        }
        main_activity_root.startAnimation(flipAnimation)
    }
}
