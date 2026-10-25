package com.example.zaki_yasri_3tib

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.zaki_yasri_3tib.databinding.ActivityMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setSupportActionBar(binding.toolbarMain)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)
        val user = intent.getStringExtra("username") ?: sharedPref.getString("username", "User")
        val pass = intent.getStringExtra("password") ?: sharedPref.getString("password", "-")
        val umur = intent.getIntExtra("umur", 0)

        Log.e("hasil", "umur $umur")

        binding.txtusername.text = "Username: $user"
        binding.txtupassword.text = "Password: $pass"

        binding.btn2.setOnClickListener {
            Snackbar.make(
                binding.root, "Item dihapus",
                Snackbar.LENGTH_LONG
            )
                .setAction("BATAL") {
                }
                .show()
        }

        binding.btn.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Hapus data")
                .setMessage("Data yang dihapus tidak bisa dikembalikan.")
                .setNegativeButton("Batal", null)
                .setPositiveButton("Hapus") { dialog, _ ->
                    dialog.dismiss()
                }
                .setCancelable(false)
                .show()
        }

        binding.btnDetail.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            startActivity(intent)
        }


        binding.btnkembali.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Konfirmasi LogOut")
                .setMessage("Apakah kamu yakin ingin keluar dan kembali ke halaman Login?")
                .setNegativeButton("Tidak", null)
                .setPositiveButton("Ya") { _, _ ->

                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.apply()


                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                .setCancelable(false)
                .show()
        }
    }
}