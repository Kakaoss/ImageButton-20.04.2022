package com.example.imagebutton_20042022

import android.content.Context
import android.graphics.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ToggleButton
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var mojprzycisk = findViewById<ImageButton>(R.id.imgBtn)
        var kolorRed = findViewById<Button>(R.id.btnCzerwony)
        var kolorGreen = findViewById<ToggleButton>(R.id.tglBtnZielony)

        mojprzycisk.setOnClickListener {
            mojprzycisk.setImageResource(R.drawable.jablko)
        }

        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.banan)
        val bitmapCzerwony = BitmapFactory.decodeResource(resources, R.drawable.czerwony)
        val filterbitmap = Bitmap.createBitmap(bitmap.width, bitmap.height, Bitmap.Config.ARGB_8888)

        kolorRed.setOnClickListener {
            val paint = Paint()
            paint.alpha = 100
            val canvas = Canvas(filterbitmap)
            canvas.drawARGB(0,0,0,0);
            canvas.drawBitmap(bitmapCzerwony, null , RectF(0f , 0f, bitmap.width.toFloat(), bitmap.height.toFloat()) , paint)
            canvas.drawBitmap(bitmap, 0f ,0f, paint)
            mojprzycisk.setImageBitmap(filterbitmap)
        }

        kolorGreen.setOnClickListener {
            if(kolorGreen.isChecked){
                mojprzycisk.setColorFilter(R.color.green)
                kolorGreen.background = (ContextCompat.getDrawable(kolorGreen.context, R.color.green))
            }
            else {
                mojprzycisk.setColorFilter(null)
                kolorGreen.background = (ContextCompat.getDrawable(kolorGreen.context, R.color.darkgreen))
            }
        }
    }
}