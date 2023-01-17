package com.example.lab3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

const val EXTRA_SOMEDATA = "com.example.lab3.lab3.SOMEDATA"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setColor();
    }
    fun setColor(){
        val myTextView = findViewById<TextView>(R.id.textView_main)
        val songButton1 = findViewById<Button>(R.id.songButton_1)
        val songButton2 = findViewById<Button>(R.id.songButton_2)
        myTextView.setTextColor(getColor(R.color.navy))
        songButton1.setBackgroundColor(getColor(R.color.orange))
        songButton2.setBackgroundColor(getColor(R.color.yellow))
    }

    fun goToSongList_1(view: View){
        val intent = Intent(this, SongsActivity::class.java)
        intent.putExtra(EXTRA_SOMEDATA, R.array.song_set_1 )
        startActivity(intent)
    }
    fun goToSongList_2(view: View){
        val intent = Intent(this, SongsActivity::class.java)
        intent.putExtra(EXTRA_SOMEDATA, R.array.song_set_2 )
        startActivity(intent)
    }
}