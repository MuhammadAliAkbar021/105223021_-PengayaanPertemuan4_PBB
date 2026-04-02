package com.example.secondactivity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class FormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        val etNama = findViewById<EditText>(R.id.etNama)
        val btnKirim = findViewById<Button>(R.id.btnKirim)

        btnKirim.setOnClickListener {
            val resultIntent = Intent().apply {
                putExtra("HASIL_NAMA", etNama.text.toString())
            }
            // Kirim result ke pemanggil
            setResult(Activity.RESULT_OK, resultIntent)
            finish() // Tutup FormActivity
        }
    }
}