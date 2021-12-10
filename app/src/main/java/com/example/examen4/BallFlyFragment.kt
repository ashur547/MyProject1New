package com.example.examen4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView

private const val LAST_BALL_IMAGE = "image"

class BallFlyFragment() : Fragment() {

    lateinit var flyImageView: ImageView
    lateinit var ballButton: Button

    private val flyImageList :List<Int> = listOf(
        R.drawable.ball1,
        R.drawable.ball2,
        R.drawable.ball3,
        R.drawable.ball4,
        R.drawable.ball5,
        R.drawable.ball6,

    )
    var lastRolledImageRes=0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_ball_fly, container, false)

        flyImageView = view.findViewById(R.id.fly_image_view)
        ballButton = view.findViewById(R.id.ball_button)

        if (savedInstanceState != null)
            flyImageView.setImageResource(savedInstanceState.getInt(LAST_BALL_IMAGE))

        ballButton.setOnClickListener {
            lastRolledImageRes = flyImageList.random()
            flyImageView.setImageResource(flyImageList.random())
        }

        return view
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(LAST_BALL_IMAGE,lastRolledImageRes)
    }



}
