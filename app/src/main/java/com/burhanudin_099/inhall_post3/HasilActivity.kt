package com.burhanudin_099.inhall_post3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.burhanudin_099.inhall_post3.databinding.ActivityHasilBinding

class HasilActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHasilBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHasilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val namaLengkap = intent.getStringExtra(MainActivity.EKSTRA_NAMA_LENGKAP)
        val username = intent.getStringExtra(MainActivity.EKSTRA_USERNAME)
        val umur = intent.getStringExtra(MainActivity.EKSTRA_UMUR)
        val email = intent.getStringExtra(MainActivity.EKSTRA_EMAIL)
        val jenisKelamin = intent.getStringExtra(MainActivity.EKSTRA_JENIS_KELAMIN)

        binding.tvHasilNamaLengkap.text = "Nama Lengkap: $namaLengkap"
        binding.tvHasilUsername.text = "Username: $username"
        binding.tvHasilUmur.text = "Umur: $umur"
        binding.tvHasilEmail.text = "Email: $email"
        binding.tvHasilJenisKelamin.text = "Jenis Kelamin: $jenisKelamin"
    }
}