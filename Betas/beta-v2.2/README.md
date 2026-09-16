# NullTrace beta v2.2

Release artifact for manual installation and device testing.

- APK: `NullTrace-beta-v2.2.apk`
- Application ID: `org.pqcrypto.messenger`
- Version: `0.0.3-beta.2.2` (version code 14)
- SHA-256: see `NullTrace-beta-v2.2.apk.sha256`
- APK signing: Android APK Signature Scheme v3

Changes in beta v2.2:

- QR invitation frames rotate continuously and wrap back to the first frame.
- QR scanning accepts frames in any order and completes after all frames are collected.
- Chats header branding is left-aligned and the ML-KEM-768 badge is removed.
- Contacts header uses title case.
- Pair a contact actions are aligned at the bottom of the dialog.
- Launcher icons use adaptive foreground/background layers with monochrome variants for Android 13+ launchers.

Validation:

- Debug unit tests passed.
- Release lint passed.
- Release APK assembled with R8 minification.
- APK signature verification passed with APK Signature Scheme v3.

Security notes:

- Vault access requires Android system authentication and an authenticated Android Keystore key.
- Direct sessions use the NullTrace v2 hybrid PQ protocol with ML-KEM-768 and ML-DSA-65 parameters.
- VPN provider cipher suites are not verified by Android; NullTrace's message protocol is the PQ protection boundary.
- Purge performs best-effort local cleanup, but Android cannot guarantee removal of immutable heap copies, flash wear-leveling remnants, or recipient copies.
- This beta has not received an independent cryptographic audit.
