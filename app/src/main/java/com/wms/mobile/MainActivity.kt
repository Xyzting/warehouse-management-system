package com.wms.mobile

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.wms.mobile.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener { handleLogin() }
    }

    private fun handleLogin() {
        val username = binding.etUsername.text.toString().trim()
        val password = binding.etPassword.text.toString().trim()

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, getString(R.string.error_empty_credentials), Toast.LENGTH_SHORT).show()
            return
        }

        val role = authenticate(username, password)
        if (role != null) {
            Toast.makeText(this, getString(R.string.login_success, role), Toast.LENGTH_SHORT).show()
            val intent = Intent(this, DashboardActivity::class.java).apply {
                putExtra(EXTRA_USERNAME, username)
                putExtra(EXTRA_ROLE, role)
            }
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, getString(R.string.error_invalid_credentials), Toast.LENGTH_SHORT).show()
        }
    }

    private fun authenticate(username: String, password: String): String? {
        val users = mapOf(
            "operator" to ("123" to "Operator"),
            "supervisor" to ("123" to "Supervisor"),
            "admin" to ("123" to "Admin")
        )
        val user = users[username.lowercase()] ?: return null
        return if (user.first == password) user.second else null
    }

    companion object {
        const val EXTRA_USERNAME = "extra_username"
        const val EXTRA_ROLE = "extra_role"
    }
}
