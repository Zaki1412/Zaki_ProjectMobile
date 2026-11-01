package com.example.zaki_yasri_3tib

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.zaki_yasri_3tib.databinding.ActivityDetailBinding
import com.google.android.material.snackbar.Snackbar

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarDetail)
        supportActionBar?.title = "Detail Karya"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val judul = intent.getStringExtra("EXTRA_JUDUL")
        val kreator = intent.getStringExtra("EXTRA_KREATOR")
        val deskripsi = intent.getStringExtra("EXTRA_DESKRIPSI")
        val gambarUrl = intent.getStringExtra("EXTRA_GAMBAR")


        if (judul != null) {
            binding.txtJudulProyek.text = judul
        }
        if (kreator != null) {
            binding.txtSubJudul.text = kreator
        }
        if (deskripsi != null) {
            binding.txtDeskripsi.text = deskripsi
        }

        if (gambarUrl != null) {
            Glide.with(this)
                .load(gambarUrl)
                .placeholder(R.drawable.moon)
                .into(binding.imgProyek)
        }

        binding.btnKembaliDetail.setOnClickListener {
            Snackbar.make(
                binding.root,
                "${binding.txtJudulProyek.text} tersimpan di koleksi",
                Snackbar.LENGTH_LONG
            )
                .setAction("BATAL") { }
                .show()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}