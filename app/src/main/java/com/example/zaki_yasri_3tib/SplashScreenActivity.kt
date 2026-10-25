package com.example.zaki_yasri_3tib

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.zaki_yasri_3tib.databinding.ActivitySplashScreenBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding
    private var isNavigated = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        binding.btnJelajahi.setOnClickListener {
            lanjutKeHalamanBerikutnya()
        }


        lifecycleScope.launch {
            delay(2500)
            lanjutKeHalamanBerikutnya()
        }
    }

    private fun lanjutKeHalamanBerikutnya() {
        if (isNavigated) return
        isNavigated = true

        val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)
        val isLogin = sharedPref.getBoolean("isLogin", false)

        val targetActivity = if (isLogin) {
            BaseActivity::class.java
        } else {
            LoginActivity::class.java
        }

        startActivity(Intent(this@SplashScreenActivity, targetActivity))
        finish()
    }
}