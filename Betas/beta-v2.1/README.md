# NullTrace beta v2.1

Release artifact for manual installation and testing.

- APK: `NullTrace-beta-v2.1.apk`
- Application ID: `org.pqcrypto.messenger`
- Version: `0.0.3-beta.2.1` (version code 13)
- SHA-256: see `NullTrace-beta-v2.1.apk.sha256`

Changes in beta v2.1:

- Removed mesh terminology and mesh/radio UI from the active app.
- Removed mesh discovery and mesh transport choices from the active repository and UI.
- Direct secure peer transport is the supported connection path.
- Beta v2 immediate locking and contact-gated local group conversations remain included.

Security notes:

- Vault access requires Android system authentication and an authenticated Android Keystore key.
- Direct sessions use the NullTrace v2 hybrid PQ protocol with ML-KEM-768 and ML-DSA-65 parameters.
- VPN provider cipher suites are not verified by Android; NullTrace's message protocol is the PQ protection boundary.
- Purge performs best-effort local cleanup, but Android cannot guarantee removal of immutable heap copies, flash wear-leveling remnants, or recipient copies.
- This beta has not received an independent cryptographic audit.
