package com.estebi.activitiesexamples

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.thirdactivity)

        val btnAfegir: Button = findViewById(R.id.btnTlf)
        val input: TextInputEditText = findViewById(R.id.inputThird)



        btnAfegir.setOnClickListener() {
            val text = input.text.toString()
            val intent = Intent(this, MainActivity::class.java)

            if (!text.isNullOrBlank()) {
                intent.putExtra("categorie", text)
                setResult(Activity.RESULT_OK, intent)
            } else {
                intent.putExtra("categorie", "buida")
                setResult(Activity.RESULT_CANCELED, intent)
            }

            finish()
        }
    }
}