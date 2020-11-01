package com.example.starwarsapp

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.numeroPantalla2
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        numeroPantalla2.setOnClickListener {
            val intent:Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        botonFilms.setOnClickListener {
            val intent: Intent = Intent(this, filmsPnt::class.java)
            startActivity(intent)
        }
        botonSpecies.setOnClickListener {
            val intent: Intent = Intent(this, speciesPnt::class.java)
            startActivity(intent)
        }

        val mp = MediaPlayer.create(this, R.raw.musicadefondo)
        reproductor2.setOnCheckedChangeListener { compoundButton: CompoundButton, b: Boolean ->
            if (reproductor2.isChecked) {
                mp.start();
                reproductor2.setSaveEnabled(true);
            } else {
                mp.stop();
                reproductor2.setChecked(false);
            }
        }
    }
}