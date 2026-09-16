package org.pqcrypto.testvpn

import android.app.Activity
import android.content.Intent
import android.net.VpnService
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {
    private val requestCode = 7001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val status = TextView(this).apply {
            text = "NullTrace Test VPN\nLocal-only test provider; no traffic is forwarded."
            textSize = 18f
            setPadding(32, 48, 32, 32)
        }
        val start = Button(this).apply {
            text = "Start test VPN"
            setOnClickListener { requestVpnPermission() }
        }
        val stop = Button(this).apply {
            text = "Stop test VPN"
            setOnClickListener {
                stopService(Intent(this@MainActivity, TestVpnService::class.java))
                status.text = "NullTrace Test VPN\nStopped"
            }
        }
        setContentView(LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            addView(status)
            addView(start)
            addView(stop)
        })
    }

    private fun requestVpnPermission() {
        val intent = VpnService.prepare(this)
        if (intent != null) {
            startActivityForResult(intent, requestCode)
        } else {
            startService(Intent(this, TestVpnService::class.java))
        }
    }

    @Deprecated("Activity result callback retained for API 34 test harness")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == this.requestCode && resultCode == RESULT_OK) {
            startService(Intent(this, TestVpnService::class.java))
        }
    }
}
