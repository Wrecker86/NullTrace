# NullTrace Security Policy

## Supported versions

NullTrace currently supports Android 14, Android 15, and Android 16 on devices that meet the app's minimum SDK requirement (API 34).

| Version | Security fixes |
| --- | --- |
| Beta v2.2 | Yes |
| Older beta releases | No |

Android versions newer than Android 16 may work, but they are not considered supported until they pass the project acceptance checks. Older Android versions are are supported down to Android 14.

Beta builds are experimental. The custom messaging protocol has not received an independent security audit or FIPS module validation. Do not use NullTrace beta builds as the sole protection for high-risk or life-critical communications.

## Reporting a vulnerability

Please report suspected vulnerabilities privately through GitHub:

1. Open the repository's **Security** tab.
2. Select **Report a vulnerability** under **Private vulnerability reporting**.
3. Include the affected release, device model, Android version, and a concise reproduction case.

Do not open a public issue for an undisclosed vulnerability. If private vulnerability reporting is unavailable, contact the repository maintainer through their GitHub profile and request a private reporting channel. Do not include private keys, PINs, invitation contents, conversation contents, signing credentials, or other secrets in the initial message.

### What to include

- Affected NullTrace version and installation source
- Device model, ABI, Android version, and security patch level
- Whether the issue occurs in a debug or release build
- Exact steps to reproduce, including required permissions and settings
- Expected and actual behavior
- Logs, stack traces, screenshots, or a minimal proof of concept with secrets removed
- Security impact and any practical mitigation

### Response targets

The maintainers aim to acknowledge a private report within 3 business days, provide an initial assessment within 14 days, and communicate material changes to the timeline. These are targets rather than guarantees.

Confirmed issues will be assessed for severity, affected releases, disclosure timing, and whether a patched release or mitigation is required. Reporter credit will be given when requested and appropriate.

## Authorized security testing

Testing is welcome on devices, emulators, networks, identities, and conversations that you own or are explicitly authorized to test. Use the latest beta and follow the checks in `BETA_TEST_PLAN.md`.

Safe testing includes:

- Installing and exercising the APK on Android 14–16 devices or emulators
- Testing onboarding, locking, purge, permissions, QR invitations, safety-number verification, messaging, media expiry, VPN policy, and direct transport
- Inspecting local application behavior, logs, network failures, storage handling, and crash output from disposable test identities
- Testing malformed invitations, invalid peer data, unreachable routes, replay conditions, and permission transitions without targeting third-party systems

Do not:

- Access another person's account, device, identity, messages, keys, or network without explicit authorization
- Attack third-party endpoints, relay traffic through systems you do not control, or perform denial-of-service or load testing
- Attempt to obtain, publish, or retain real users' private data or signing credentials
- Bypass Android, VPN, TLS pinning, authentication, or authorization controls against systems you do not own
- Submit intentionally destructive payloads or test data that could affect other users
- Include live secrets or private user data in reports, commits, issues, APKs, logs, or screenshots

Testing that affects availability, privacy, or data integrity should use an isolated emulator or disposable device and disposable NullTrace identities. Stop testing and report privately if you encounter data belonging to another user.

## Scope notes

The Android app, its local storage, authentication and lock behavior, QR invitation flow, direct transport, VPN policy enforcement, and release packaging are in scope. Third-party operating-system, VPN-provider, hosting, network, and dependency vulnerabilities should be reported to their respective maintainers as well as described here when they materially affect NullTrace.
