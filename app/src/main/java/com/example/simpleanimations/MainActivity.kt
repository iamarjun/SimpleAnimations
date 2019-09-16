package com.example.simpleanimations

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener
import android.view.animation.ScaleAnimation
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clockwise.setOnClickListener {
            clockWise()
        }

        anticlockwise.setOnClickListener {
            antiClockWise()
        }

        yRotation.setOnClickListener {
            yRotation()
        }

        xRotation.setOnClickListener {
            xRotation()
        }

        pop_in_out.setOnClickListener {
            shrinkAndGrow()
        }

    }


    private fun clockWise() {

//        val r = RotateAnimation(
//            ROTATE_TO,
//            ROTATE_FROM,
//            Animation.RELATIVE_TO_SELF,
//            0.5f,
//            Animation.RELATIVE_TO_SELF,
//            0.5f
//        )
//
//        r.duration = 2.toLong() * 1500
//        r.repeatCount = 0
//        wine.startAnimation(r)

        val rotation = ObjectAnimator.ofFloat(wine, "rotation", -10.0f * 360.0f, 0f)
        rotation.duration = 3600 // milliseconds
        rotation.interpolator = AccelerateDecelerateInterpolator()
        rotation.start()
    }


    private fun antiClockWise() {

//        val r = RotateAnimation(
//            ROTATE_FROM,
//            ROTATE_TO,
//            Animation.RELATIVE_TO_SELF,
//            0.5f,
//            Animation.RELATIVE_TO_SELF,
//            0.5f
//        )
//
//        r.duration = 2.toLong() * 1500
//        r.repeatCount = 0
//        wine.startAnimation(r)

        val rotation = ObjectAnimator.ofFloat(wine, "rotation", 0f, -10.0f * 360.0f)
        rotation.duration = 3600 // milliseconds
        rotation.interpolator = AccelerateDecelerateInterpolator()
        rotation.start()
    }

    private fun yRotation() {
        val animation = ObjectAnimator.ofFloat(wine, "rotationY", 0.0f, -10.0f * 360.0f)
        animation.duration = 3600
        animation.interpolator = AccelerateDecelerateInterpolator()
        animation.start()
    }

    private fun xRotation() {
        val animation = ObjectAnimator.ofFloat(wine, "rotationX", 0.0f, -10.0f * 360.0f)
        animation.duration = 3600
        animation.interpolator = AccelerateDecelerateInterpolator()
        animation.start()
    }

//    private fun popIn() {
//        val expandIn = AnimationUtils.loadAnimation(this, R.anim.pop_in)
//        wine.startAnimation(expandIn)
//    }
//
//    private fun scaleUp() {
//        val scaleUp = ScaleAnimation(
//            0f,
//            1f,
//            0f,
//            1f,
//            Animation.RELATIVE_TO_SELF,
//            0.5f,
//            Animation.RELATIVE_TO_SELF,
//            0.5f
//        )
//        scaleUp.duration = 1000     // animation duration in milliseconds
//        scaleUp.fillAfter =
//            true    // If fillAfter is true, the transformation that this animation performed will persist when it is finished.
//        wine.startAnimation(scaleUp)
//    }
//
//    private fun scaleDown() {
//
//        val scaleDown = ScaleAnimation(
//            1f,
//            0f,
//            1f,
//            0f,
//            Animation.RELATIVE_TO_SELF,
//            0.5f,
//            Animation.RELATIVE_TO_SELF,
//            0.5f
//        )
//        scaleDown.duration = 1000     // animation duration in milliseconds
//        scaleDown.fillAfter =
//            true    // If fillAfter is true, the transformation that this animation performed will persist when it is finished.
//        wine.startAnimation(scaleDown)
//
//    }
//
//    private fun scaleUpDown() {
//        val scaleDown = ObjectAnimator.ofPropertyValuesHolder(
//            wine,
//            PropertyValuesHolder.ofFloat("scaleX", 1.5f),
//            PropertyValuesHolder.ofFloat("scaleY", 1.5f)
//        )
//        scaleDown.duration = 900
//        scaleDown.repeatMode = ValueAnimator.RESTART
//        scaleDown.repeatCount = ValueAnimator.INFINITE
//        scaleDown.start()
//    }
//
//    private fun scale2() {
//        val scale = AnimationUtils.loadAnimation(this, R.anim.scale)
//        wine.startAnimation(scale)
//    }

    private fun shrinkAndGrow() {

        val growAnim = ScaleAnimation(
            1.0f,
            1.5f,
            1.0f,
            1.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        )
        val shrinkAnim = ScaleAnimation(
            1.5f,
            1.0f,
            1.5f, 1.0f,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        )

        growAnim.duration = 900
        shrinkAnim.duration = 900

        wine.startAnimation(growAnim)

        growAnim.setAnimationListener(object : AnimationListener {
            override fun onAnimationStart(animation: Animation) {}

            override fun onAnimationRepeat(animation: Animation) {}

            override fun onAnimationEnd(animation: Animation) {
                wine.startAnimation(shrinkAnim)
            }
        })

        shrinkAnim.setAnimationListener(object : AnimationListener {
            override fun onAnimationStart(animation: Animation) {}

            override fun onAnimationRepeat(animation: Animation) {}

            override fun onAnimationEnd(animation: Animation) {
                wine.startAnimation(growAnim)
            }
        })
    }

    companion object {
        private const val ROTATE_FROM = 0.0f
        private const val ROTATE_TO = -10.0f * 360.0f
    }
}
