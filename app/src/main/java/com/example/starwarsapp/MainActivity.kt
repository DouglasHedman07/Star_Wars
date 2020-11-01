package com.example.starwarsapp

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.reproductor1

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numeroPantalla1.setOnClickListener {
            val intent: Intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
        botonSpaceships.setOnClickListener {
            val intent: Intent = Intent(this, spaceshipsPnt::class.java)
            startActivity(intent)
        }
        botonPeople.setOnClickListener {
            val intent: Intent = Intent(this, peoplePnt::class.java)
            startActivity(intent)
        }
        botonVehicles.setOnClickListener {
            val intent: Intent = Intent(this, vehiclesPnt::class.java)
            startActivity(intent)
        }
        botonPlanets.setOnClickListener {
            val intent: Intent = Intent(this, planetsPnt::class.java)
            startActivity(intent)
        }

        val mp = MediaPlayer.create(this, R.raw.musicadefondo)

        reproductor1.setOnCheckedChangeListener { _, isChecked ->
            if (reproductor1.isChecked) {
                mp.start()
                reproductor1.setSaveEnabled(true)
            } else {
                mp.stop()
                reproductor1.setChecked(false)

            }
        }
    }

}

