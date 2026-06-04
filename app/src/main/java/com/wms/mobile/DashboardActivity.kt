package com.wms.mobile

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.wms.mobile.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra(MainActivity.EXTRA_USERNAME) ?: "User"
        val role = intent.getStringExtra(MainActivity.EXTRA_ROLE) ?: "Unknown"

        binding.tvWelcome.text = getString(R.string.dashboard_welcome, username, role)

        // Wiring tiap modul — implementasi belum, baru placeholder Toast.
        binding.btnMasterData.setOnClickListener { openModule("Master Data") }
        binding.btnInbound.setOnClickListener { openModule("Goods Receipt") }
        binding.btnOutbound.setOnClickListener { openModule("Goods Issue") }
        binding.btnInventory.setOnClickListener { openModule("Stock") }
        binding.btnReporting.setOnClickListener { openModule("Reporting") }

        binding.btnLogout.setOnClickListener {
            finish()
        }
    }

    private fun openModule(name: String) {
        Toast.makeText(this, getString(R.string.module_placeholder, name), Toast.LENGTH_SHORT).show()
    }
}
