package com.example.mobiledeviceprogramming.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mobiledeviceprogramming.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener {
            if (binding.loginUsername.editText!!.text.toString() == "admin" && binding.loginPassword.editText!!.text.toString() == "admin"
            ) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                binding.loginUsername.error = ""
                binding.loginPassword.error = ""
                if (binding.loginUsername.editText!!.text.toString() != "admin") {
                    binding.loginUsername.error = "Username salah"
                }
                if (binding.loginPassword.editText!!.text.toString() != "admin") {
                    binding.loginPassword.error = "Password salah"
                }
            }
        }
    }
}