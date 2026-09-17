# Beta acceptance checklist

Use disposable test identities and messages. Record device model, Android version, APK SHA-256, policy, addresses and result for each run. Do not submit private keys, PINs or conversation contents in a bug report.

## Automated gate

Run unit tests, release lint, signed release build and connected Android tests. Verify the APK signature and SHA-256. Install and launch the actual minified release APK; debug-only validation is insufficient.

## Two physical devices (required before wider distribution)

- [ ] Install on Android 14, 15 and 16 representatives; complete onboarding with 4- and 8-digit PINs. Restart and confirm identities and contacts persist.
- [ ] Set reachable LAN addresses, start receiving, pair both ways with animated QR and with pasted invitations. Confirm all safety-number digits match and verification survives restart.
- [ ] Send text in both directions, including simultaneous first messages. Restart both apps and resume the same conversation. Confirm queued, failed and delivered labels reflect real acceptance.
- [ ] Disconnect the receiver, queue messages, restart the sender and reconnect. Confirm delivery once, without duplicate rows. Delete a queued message/chat and confirm it never retries later.
- [ ] Import portrait/landscape photos and cancel the picker. Check previews on both devices and graceful handling of invalid/oversized images.
- [ ] Deny then grant microphone permission; record 1- and 30-second voice messages, play once, navigate away during recording/playback, and confirm expiry removes access. Verify no recording continues after leaving the screen.
- [ ] Verify image/voice expiry while the viewer is open. Restart and confirm volatile received media is unavailable, with an understandable placeholder.
- [ ] Connect an actual VPN under strict policy; send successfully, then disconnect during queue flush. Verify no direct fallback using network observation. Test Wi-Fi/cellular handoffs and Android always-on VPN with block-without-VPN enabled.
- [ ] Verify app lock after inactivity and background timeout, and biometric success/cancellation/lockout. Incorrect PINs must rate-limit without erasing the primary vault.
- [ ] In Settings → Privacy & security → Auto-lock, verify the 5-minute default and choose a different delay. Restart and confirm it is saved. Confirm interaction restarts the timer, returning before the delay keeps the vault open, returning after it requires the PIN, and Lock vault still locks immediately.
- [ ] With disposable data, trigger duress and explicit whole-vault purge. Confirm queued deliveries stop and a new launch creates a different identity. Confirm screenshots/task previews are protected on the device.
- [ ] Confirm clear error behavior when a route is unreachable or an invitation/peer pin is wrong. Do not bypass TLS pin verification to make a test pass.

## Release decision

A small supervised beta may use this candidate after the automated gate. Widen distribution only after the physical-device checks pass and operational support/bug reporting is arranged. Commission independent review of the custom handshake, ratchet, key lifecycle and threat model before presenting it as suitable for sensitive operational communications.

- [ ] Upgrade a disposable vault that previously required an authenticator. Confirm correct PIN unlock (plus biometrics if enabled), no authenticator controls, and preserved settings and identity.
- [ ] Open NullShield: check contact counts, network status, Contacts/Settings shortcuts and the expandable Technical details.
