package com.estebi.activitiesexamples

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.secondactivity)

        val btnTlf: Button = findViewById(R.id.btnTlf)
        val btnMap: Button = findViewById(R.id.btnMap)
        val btnWeb: Button = findViewById(R.id.btnWeb)
        val btnMail: Button = findViewById(R.id.btnMail)

        btnTlf.setOnClickListener() {
            val callIntent: Intent = Uri.parse("tel:777888999").let { number ->
                Intent(Intent.ACTION_DIAL, number)
            }

            startActivity(callIntent)
        }

        btnMap.setOnClickListener() {
            val mapIntent: Intent = Uri.parse(
                "geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,+California"
            ).let { location ->
                Intent(Intent.ACTION_VIEW, location)
            }

            startActivity(mapIntent)
        }

        btnWeb.setOnClickListener() {
            val webIntent: Intent = Uri.parse("https://www.android.com").let { webpage ->
                Intent(Intent.ACTION_VIEW, webpage)
            }

            startActivity(webIntent)
        }

        btnMail.setOnClickListener() {
            val correuIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_EMAIL, arrayOf("int@example.com")) // recipients
                putExtra(Intent.EXTRA_SUBJECT, "Email subject")
                putExtra(Intent.EXTRA_TEXT, "Email message text")
                putExtra(Intent.EXTRA_STREAM, Uri.parse("content://path/to/email/attachment"))
            }

            startActivity(correuIntent)
        }
    }
}