package com.burhanudin_099.inhall_post3
import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.burhanudin_099.inhall_post3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    companion object {
        const val EKSTRA_NAMA_LENGKAP = "ekstra_nama_lengkap"
        const val EKSTRA_USERNAME = "ekstra_username"
        const val EKSTRA_UMUR = "ekstra_umur"
        const val EKSTRA_EMAIL = "ekstra_email"
        const val EKSTRA_JENIS_KELAMIN = "ekstra_jenis_kelamin"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnKirim.setOnClickListener {
            val namaLengkap = binding.etNamaLengkap.text.toString().trim()
            val username = binding.etUsername.text.toString().trim()
            val umur = binding.etUmur.text.toString().trim()
            val email = binding.etEmail.text.toString().trim()
            val kataSandi = binding.etKataSandi.text.toString()
            val konfirmasiKataSandi = binding.etKonfirmasiKataSandi.text.toString()

            val idJenisKelaminTerpilih = binding.rgJenisKelamin.checkedRadioButtonId
            val jenisKelamin: String = if (idJenisKelaminTerpilih != -1) {
                findViewById<RadioButton>(idJenisKelaminTerpilih).text.toString()
            } else {
                ""
            }

            if (namaLengkap.isEmpty() || username.isEmpty() || umur.isEmpty() || email.isEmpty() ||
                kataSandi.isEmpty() || konfirmasiKataSandi.isEmpty() || jenisKelamin.isEmpty()) {
                Toast.makeText(this, "Mohon lengkapi semua kolom ", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (kataSandi != konfirmasiKataSandi) {
                Toast.makeText(this, "Kata sandi tidak cocok", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, HasilActivity::class.java).apply {
                putExtra(EKSTRA_NAMA_LENGKAP, namaLengkap)
                putExtra(EKSTRA_USERNAME, username)
                putExtra(EKSTRA_UMUR, umur)
                putExtra(EKSTRA_EMAIL, email)
                putExtra(EKSTRA_JENIS_KELAMIN, jenisKelamin)
            }
            startActivity(intent)
        }
    }
}