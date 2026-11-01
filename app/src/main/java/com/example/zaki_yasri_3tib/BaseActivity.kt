package com.example.zaki_yasri_3tib

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.zaki_yasri_3tib.databinding.ActivityBaseBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class BaseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }

        replaceFragment(HomeFragment())

        binding.bottomNavView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_galeri -> {
                    replaceFragment(HomeFragment())
                    true
                }

                R.id.nav_cari -> {
                    replaceFragment(MoreFragment())
                    true
                }

                R.id.nav_tersimpan -> {
                    replaceFragment(MessageFragment())
                    true
                }

                else -> false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainer.id, fragment)
            .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_web -> {
                startActivity(Intent(this, WebViewActivity::class.java))
                true
            }

            R.id.action_info -> {
                Toast.makeText(this, "NIRMANA - Katalog Karya Visual Digital", Toast.LENGTH_SHORT)
                    .show()
                true
            }

            R.id.action_logout -> {
                MaterialAlertDialogBuilder(this)
                    .setTitle("Konfirmasi Logout")
                    .setMessage("Apakah kamu yakin ingin keluar?")
                    .setNegativeButton("Batal", null)
                    .setPositiveButton("Ya") { dialog, _ ->
                        val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)
                        sharedPref.edit().clear().apply()
                        dialog.dismiss()
                        val intent = Intent(this, LoginActivity::class.java)
                        intent.flags =
                            Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(intent)
                    }
                    .setCancelable(false)
                    .show()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}