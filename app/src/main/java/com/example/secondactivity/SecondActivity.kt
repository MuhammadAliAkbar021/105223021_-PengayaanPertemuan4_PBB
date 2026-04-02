package com.example.secondactivity

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val nama = intent.getStringExtra(MainActivity.EXTRA_NAMA) ?: "Tidak ada"
        val nim = intent.getIntExtra(MainActivity.EXTRA_NIM, 0)
        val aktif = intent.getBooleanExtra(MainActivity.EXTRA_AKTIF, false)

        val tvInfo = findViewById<TextView>(R.id.tvInfo)
        tvInfo.text = """
            Nama : $nama
            NIM : $nim
            Aktif : $aktif
        """.trimIndent()
    }
}