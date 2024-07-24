package com.example.lesson211.ui.mainactivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lesson211.R
import com.example.lesson211.ui.mainFragment.MainFragment


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .add(R.id.conteiner, MainFragment())
            .commit()
    }
}