# NullTrace beta v2

Release artifact for manual installation and testing.

- APK: `NullTrace-beta-v2.apk`
- Application ID: `org.pqcrypto.messenger`
- Version: `0.0.2-beta.2` (version code 12)
- SHA-256: see `NullTrace-beta-v2.apk.sha256`

Changes in beta v2:

- The vault locks immediately when the app is minimized or its activity stops.
- Group chat creation appears only after more than one real contact is present.
- Group conversations are explicitly local-only in this beta; multi-recipient network delivery is not enabled.
- Synthetic test contacts and test-group controls are not included.

Security notes:

- Vault access requires Android system authentication and an authenticated Android Keystore key.
- Direct sessions use the NullTrace v2 hybrid PQ protocol with ML-KEM-768 and ML-DSA-65 parameters.
- VPN provider cipher suites are not verified by Android; NullTrace's message protocol is the PQ protection boundary.
- Purge performs best-effort local cleanup, but Android cannot guarantee removal of immutable heap copies, flash wear-leveling remnants, or recipient copies.
- This beta has not received an independent cryptographic audit.
