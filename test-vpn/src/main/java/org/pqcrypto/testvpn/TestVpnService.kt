package org.pqcrypto.testvpn

import android.content.Intent
import android.net.VpnService
import android.os.IBinder
import android.os.ParcelFileDescriptor

/** A local-only VPN interface used to test NullTrace VPN detection. */
class TestVpnService : VpnService() {
    private var interfaceFd: ParcelFileDescriptor? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (interfaceFd == null) {
            interfaceFd = Builder()
                .setSession("NullTrace Test PQ VPN")
                .addAddress("10.77.0.2", 32)
                .addRoute("0.0.0.0", 0)
                .establish()
        }
        return START_STICKY
    }

    override fun onDestroy() {
        interfaceFd?.close()
        interfaceFd = null
        super.onDestroy()
    }

    override fun onBind(intent: Intent): IBinder? = super.onBind(intent)
}
