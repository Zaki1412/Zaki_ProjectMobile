package com.example.zaki_yasri_3tib

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.zaki_yasri_3tib.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private val cekSama: (String, String) -> Boolean = { u, p -> u.isNotEmpty() && u == p }

    private fun validasiKredensial(
        user: String,
        pass: String,
        aturan: (String, String) -> Boolean
    ): Boolean {
        return aturan(user, pass)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btn.setOnClickListener {
            val user = binding.username.text.toString().trim()
            val pass = binding.password.text.toString().trim()

            // Penerapan Exception Handling try-catch-finally (Modul Pertemuan 2 Hal. 17)
            try {
                if (user.isEmpty() || pass.isEmpty()) {
                    throw Exception("Nama Pengguna dan Password tidak boleh kosong!")
                }

                // Memanggil Higher-Order Function dengan parameter Lambda
                val isBerhasil = validasiKredensial(user, pass, cekSama)

                if (isBerhasil) {
                    val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)
                    val editor = sharedPref.edit()
                    editor.putBoolean("isLogin", true)
                    editor.putString("username", user)
                    editor.putString("password", pass)
                    editor.apply()
                    // Toast disini untuk menampilkan pop up singkat sekitar 2 detikkan
                    Toast.makeText(this, "Login Berhasil! Selamat datang $user", Toast.LENGTH_SHORT)
                        .show()

                    val intent = Intent(this, BaseActivity::class.java)
                    intent.putExtra("username", user)
                    intent.putExtra("password", pass)
                    startActivity(intent)
                    finish()
                } else {
                    AlertDialog.Builder(this)
                        .setTitle("Login Gagal")
                        .setMessage("Username dan Password harus bernilai sama! Silakan coba lagi.")
                        .setPositiveButton("OK") { dialog, _ ->
                            dialog.dismiss()
                        }
                        .show()
                }
            } catch (e: Exception) {
                AlertDialog.Builder(this)
                    .setTitle("Peringatan Input")
                    .setMessage(e.message)
                    .setPositiveButton("OK") { dialog, _ ->
                        dialog.dismiss()
                    }
                    .show()
            } finally {
                Log.d("LOGIN_CHECK", "Proses pengecekan login selesai untuk input: $user")
            }
        }
    }
}