package com.example.lab3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner

class SongsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_songs)

        setupSpinner()

    }
    fun setupSpinner(){
        val mySpinner = findViewById<Spinner>(R.id.spinner_main)
        val arrAdapter = ArrayAdapter.createFromResource(this, intent.getStringExtra(EXTRA_SOMEDATA),android.R.layout.simple_spinner_item )
        arrAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        mySpinner.adapter = arrAdapter
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp();
    }
}