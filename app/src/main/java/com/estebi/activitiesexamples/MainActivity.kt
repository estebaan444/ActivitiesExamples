package com.estebi.activitiesexamples

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button2)
        val imgButon :ImageButton = findViewById(R.id.plusBut)


        var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                if(data != null){
                    Toast.makeText(this, "La teva categoria es:  ${data.getStringExtra("categorie")}", Toast.LENGTH_SHORT).show()
                }

            }
        }

        button.setOnClickListener() {
            val intent = Intent(this, ThirdActivity::class.java)
            resultLauncher.launch(intent)
        }

        imgButon.setOnClickListener() {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }


    }
}