package com.example.caculator

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        val cdt : CountDownTimer = object: CountDownTimer(2000,1000){
            override fun onTick(p0: Long) {
            }

            override fun onFinish() {

                startActivity(Intent(this@SplashActivity, MainActivity::class.java));
            }

        }.start();
    }
}