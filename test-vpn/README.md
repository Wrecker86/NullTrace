# NullTrace Test VPN

This is an emulator-only VPN provider for testing NullTrace's background VPN detection.

It establishes a local `tun0` interface with a catch-all route and does not read, forward, or encrypt packets. Traffic is intentionally non-functional while it is active. Do not install it on a real device or use it outside testing.

Build and install from the NullTrace project root:

```sh
./gradlew :test-vpn:assembleDebug
adb install -r test-vpn/build/outputs/apk/debug/test-vpn-debug.apk
adb shell monkey -p org.pqcrypto.testvpn 1
```

Open the app, select **Start test VPN**, approve Android's VPN consent dialog, then launch NullTrace. Android should report `org.pqcrypto.testvpn` as an active VPN transport on `tun0`.
