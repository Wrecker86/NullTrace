# NullTrace — Android beta

NullTrace is a direct peer-to-peer messenger for Android 14 and later. This beta supports text, photos, and short voice messages over pinned HTTPS, with hybrid authenticated session establishment and a post-quantum ratchet. It has no central message relay or push delivery service.

## Try the beta

Use the signed APK and checksum in `Betas/beta-v2.2/`. This is a **closed beta candidate**; use test conversations while completing the physical-device acceptance checks in `BETA_TEST_PLAN.md`. The custom protocol has not received an independent security audit or FIPS module validation.

1. Install on two Android 14+ devices and create separate identities with a 4–8 digit PIN. The optional, different duress PIN erases the primary vault and opens a decoy. There is no default PIN.
2. In Settings, choose your network policy. Strict VPN mode requires a detected Android VPN for outbound delivery; additionally configure Android always-on VPN and “Block connections without VPN” for system-level protection. NullTrace cannot determine the VPN's cryptographic algorithms.
3. Enter each device's reachable LAN or VPN address as `host:port` (for example `192.168.1.10:8443`) and save it. Start receiving on that port. Both devices must be reachable from each other; cellular NAT commonly prevents direct inbound connections.
4. In Contacts, exchange complete beta invitations using the animated QR or copy/paste. Import each other's invitation on both devices. Invitations contain public signed keys, endpoint and TLS fingerprint; they are not secret credentials.
5. Compare every safety-number digit through a trusted channel and mark the contact verified. Send a test message in both directions. Keep both apps open during this beta.

A queued message has not yet been accepted by the recipient. Delivered means its authenticated envelope was accepted; there are no remote read receipts. A message without a configured route is marked failed. After changing an address, exchange new invitations. Receiving must be started again after restarting the app.

## Beta behavior and limits

- Full signed identity and prekey bundles; stable identity, pinned TLS certificate, contacts, settings, ratchet sessions, text history and encrypted outbox persist across restart.
- Finalized ML-KEM-768 and ML-DSA-65 primitives from Bouncy Castle, combined with X25519, Ed25519, HKDF and AES-GCM in a custom protocol. Primitive names do not imply that the whole protocol is audited or certified.
- Persistent records use an atomically replaced AES-GCM vault under Android Keystore, excluded from Android backup. The PIN controls app access; the Keystore key itself is not derived from the PIN. A compromised running device is outside the protection offered by the app lock.
- Photos are resized and re-encoded before sending. Audio is PCM, mono, 16 kHz, limited to 30 seconds. Received media remains in memory; it becomes unavailable after restart. Encrypted outbound media may persist until delivered or expired.
- Voice and disappearing messages use a sender-selected absolute expiry; devices should have automatic time enabled. Expiration and deletion cannot erase recipient-made copies. Android immutable strings, memory copies and flash storage prevent guaranteed forensic erasure.
- Deleting a message/chat removes its queued deliveries and cancels pending connections. Data already transmitted cannot be recalled. Whole-vault purge stops transport, deletes the vault and removes its master key. Close the app using the purge screen before creating a new identity.
- Storage is bounded to 32 MiB, outbox to 1,000 entries, sessions to 256 and replay receipts to 100,000. The beta does not provide archival history, automatic session/receipt compaction, cloud recovery, or background delivery guarantees.
- Mesh radio and optical vault migration code remain experimental and are not exposed in beta navigation.

**Alpha compatibility:** beta protocol v2 creates a fresh encrypted vault and requires new pairing. Alpha invitations, sessions and migration workflows are incompatible. Old alpha data is not imported automatically; preserve the old installation if you need its history. Existing historical alpha packages in this project are not the beta distribution.

## Build and signing

Use JDK 21 and Android SDK 36, then run:

```sh
./gradlew :app:testDebugUnitTest :app:lintRelease :app:assembleRelease
./gradlew :app:connectedDebugAndroidTest
```

The second command requires an attached Android 14+ device or emulator. Release lint aborts on errors. R8 shrinks and obfuscates release builds.

Signing credentials are external to source. Set `NULLTRACE_SIGNING_PROPERTIES` to a private properties file based on `signing.properties.example`. On the development Mac, the default is `~/Library/Application Support/NullTraceSigning/signing.properties`; existing signing keys were preserved there. Without that file the release artifact is unsigned. Never distribute a keystore, signing properties, local backups, or the entire development directory.

See `BETA_RELEASE_NOTES.md` for the remediation record, `BETA_TEST_PLAN.md` for acceptance checks, and [SECURITY.md](SECURITY.md) for supported Android versions, vulnerability reporting, and authorized testing rules.
