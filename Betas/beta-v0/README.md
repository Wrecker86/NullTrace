# NullTrace beta v0

Release artifact for manual installation and testing.

- APK: `NullTrace-beta-v0.apk`
- Application ID: `org.pqcrypto.messenger`
- Version: `0.0.0-beta.0` (version code 10)
- SHA-256: see `NullTrace-beta-v0.apk.sha256`

This build contains no synthetic test contacts or test-group controls. The separate emulator-only test VPN remains outside this release folder.

Security notes:

- Direct message sessions require the NullTrace v2 hybrid PQ protocol with ML-KEM-768 and ML-DSA-65 parameters.
- Vault access requires Android system authentication and an authenticated Android Keystore key.
- VPN provider cipher suites are not verified by Android; the app's own message protocol is the PQ protection boundary.
- Purge performs best-effort local cleanup, but Android cannot guarantee removal of immutable heap copies, flash wear-leveling remnants, or recipient copies.
- This beta has not received an independent cryptographic audit.
