package jiyoung.example.kotlin.com.flipanimsample

import android.animation.Animator
import android.animation.ObjectAnimator
import android.app.Activity
import android.os.Bundle
import android.view.View
import com.markjmind.propose.Propose
import com.markjmind.propose.listener.JwAnimatorListener
import kotlinx.android.synthetic.main.act_propose.*


class ActPropose : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_propose)

        /** Layout init  */
        flip_lyt!!.cameraDistance = Propose.getCameraDistanceX(this) * 2

        /** create animator  */
        val frontRight = ObjectAnimator.ofFloat(flip_lyt, View.ROTATION_Y, 0F, 90F)
        frontRight.duration = 500
        val frontLeft = ObjectAnimator.ofFloat(flip_lyt, View.ROTATION_Y, 0F, -90F)
        frontLeft.duration = 500
        /** "duration" use to onClick  */
        val backRight = ObjectAnimator.ofFloat(flip_lyt, View.ROTATION_Y, -90F, 0F)
        backRight.duration = 500
        val backLeft = ObjectAnimator.ofFloat(flip_lyt, View.ROTATION_Y, 90F, 0F)
        backLeft.duration = 500
        /** "duration" use to onClick  */

        /** Propose create  */
        val propose = Propose(this)
        propose.motionRight.play(frontRight).next(backRight)
        propose.motionLeft.play(frontLeft).next(backLeft)
        /** set right move Animator  */
        propose.motionRight.motionDistance = 200 * Propose.getDensity(this)
        propose.motionLeft.motionDistance = 200 * Propose.getDensity(this)
        /** set Drag Distance  */
        flip_lyt!!.setOnTouchListener(propose)
        /** set touch listener  */


        /** set AnimatorListener for flip  */
        frontRight.addListener(object : JwAnimatorListener() {
            override fun onStart(arg0: Animator) {}
            override fun onEnd(arg0: Animator) {
                front_img!!.visibility = View.INVISIBLE
                X_img!!.visibility = View.VISIBLE
                flip_lyt!!.setBackgroundResource(R.drawable.shape_alpha2)
            }

            override fun onReverseStart(arg0: Animator) {
                front_img!!.visibility = View.VISIBLE
                X_img!!.visibility = View.INVISIBLE
                flip_lyt!!.setBackgroundResource(R.drawable.shape_alpha1)
            }

            override fun onReverseEnd(arg0: Animator) {}
        })

        frontLeft.addListener(object : JwAnimatorListener() {
            override fun onStart(arg0: Animator) {}
            override fun onEnd(arg0: Animator) {
                front_img!!.visibility = View.INVISIBLE
                O_img!!.visibility = View.VISIBLE
                flip_lyt!!.setBackgroundResource(R.drawable.shape_alpha2)
            }

            override fun onReverseStart(arg0: Animator) {
                front_img!!.visibility = View.VISIBLE
                O_img!!.visibility = View.INVISIBLE
                flip_lyt!!.setBackgroundResource(R.drawable.shape_alpha1)
            }

            override fun onReverseEnd(arg0: Animator) {}
        })

        btnX.setOnClickListener { propose.motionRight.play(frontRight).next(backRight) }
        btnO.setOnClickListener { propose.motionLeft.play(frontLeft).next(backLeft) }


        /** set Down Motion  */
        /*val down = ObjectAnimator.ofFloat(flip_lyt, View.ROTATION_X, 180F, -180F)
        down.duration = 500
        propose.motionDown.play(down)*/
        propose.motionDown.motionDistance = 500 * Propose.getDensity(this)
        propose.motionDown.enableFling(false).enableTabUp(false)
        propose.motionDown.move(propose.motionDown.motionDistance / 2)// vertical center
    }


}
