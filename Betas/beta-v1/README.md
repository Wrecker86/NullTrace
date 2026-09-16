# NullTrace beta v1

Release artifact for manual installation and testing.

- APK: `NullTrace-beta-v1.apk`
- Application ID: `org.pqcrypto.messenger`
- Version: `0.0.1-beta.1` (version code 11)
- SHA-256: see `NullTrace-beta-v1.apk.sha256`

This build includes the authenticated Android Keystore vault-key migration and the theme-change persistence fix. It contains no synthetic test contacts or test-group controls.

Security notes:

- Vault access requires Android system authentication and an authenticated Android Keystore key.
- Existing v2/v3 vault keys migrate to the v4 authenticated key after successful authentication.
- Direct sessions require the NullTrace v2 hybrid PQ protocol with ML-KEM-768 and ML-DSA-65 parameters.
- VPN provider cipher suites are not verified by Android; the app's own message protocol is the PQ protection boundary.
- Purge performs best-effort local cleanup, but Android cannot guarantee removal of immutable heap copies, flash wear-leveling remnants, or recipient copies.
- This beta has not received an independent cryptographic audit.
