package com.example.whac_a_mole.repository

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.whac_a_mole.databinding.ActivityMainBinding
import com.example.whac_a_mole.presentation.TransitionScreen
import java.util.*
import kotlin.collections.ArrayList

class Game : AppCompatActivity() {

    private var score = 0
    private var imageArray = ArrayList<ImageView>()
    private var handler = Handler(Looper.getMainLooper())
    private var runnable = Runnable { }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            imageArray.add(imageView)
            imageArray.add(imageView2)
            imageArray.add(imageView3)
            imageArray.add(imageView4)
            imageArray.add(imageView5)
            imageArray.add(imageView6)
            imageArray.add(imageView7)
            imageArray.add(imageView8)
            imageArray.add(imageView9)

            hideImages()

            object : CountDownTimer(30000, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    timeText.text = "Time " + millisUntilFinished / 1000
                }

                override fun onFinish() {
                    timeText.text = "Time: 0"
                    handler.removeCallbacks(runnable)
                    for (image in imageArray) {
                        image.visibility = View.INVISIBLE
                    }
                    val intent = Intent(this@Game, TransitionScreen::class.java)
                    intent.putExtra("key", score.toString())
                    startActivity(intent)
                }
            }.start()
        }
    }


    private fun hideImages() {

        runnable = Runnable {
            for (image in imageArray) {
                image.visibility = View.INVISIBLE
            }

            val random = Random()
            val randomIndex = random.nextInt(9)
            imageArray[randomIndex].visibility = View.VISIBLE

            handler.postDelayed(runnable, 500)
        }
        handler.post(runnable)
    }

    fun increaseScore(view: View) {
        score += 1
        binding.scoreText.text = "Score $score"

    }
}