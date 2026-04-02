package com.example.secondactivity

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NAMA = "com.intentlab.EXTRA_NAMA"
        const val EXTRA_NIM = "com.intentlab.EXTRA_NIM"
        const val EXTRA_AKTIF = "com.intentlab.EXTRA_AKTIF"
    }

    private lateinit var tvHasil: TextView

    // Daftarkan launcher (di luar onCreate, sebagai property class)
    private val formLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val nama = result.data?.getStringExtra("HASIL_NAMA")
            tvHasil.text = "Nama dari form: $nama"
        } else {
            tvHasil.text = "Pengguna membatalkan form"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvHasil = findViewById(R.id.tvHasil)
        val btnGo = findViewById<Button>(R.id.btnGo)
        val btnOpenUrl = findViewById<Button>(R.id.btnOpenUrl)
        val btnDialPhone = findViewById<Button>(R.id.btnDialPhone)
        val btnShare = findViewById<Button>(R.id.btnShare)
        val btnIsiForm = findViewById<Button>(R.id.btnIsiForm)

        // Praktik 1 & 2: Explicit Intent
        btnGo.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra(EXTRA_NAMA, "Budi Santoso")
                putExtra(EXTRA_NIM, 20220001)
                putExtra(EXTRA_AKTIF, true)
            }
            startActivity(intent)
        }

        // Praktik 3: Implicit Intent
        btnOpenUrl.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.pertamina-university.ac.id"))
            startActivity(intent)
        }

        btnDialPhone.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:+62211234567"))
            startActivity(intent)
        }

        btnShare.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_SUBJECT, "Info Perkuliahan")
                putExtra(Intent.EXTRA_TEXT, "Halo! Ini pesan dari IntentLab App.")
            }
            startActivity(Intent.createChooser(intent, "Bagikan melalui..."))
        }

        // Praktik 4: ActivityResultLauncher
        btnIsiForm.setOnClickListener {
            val intent = Intent(this, FormActivity::class.java)
            formLauncher.launch(intent)
        }
    }
}