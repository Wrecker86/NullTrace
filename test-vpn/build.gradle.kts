plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "org.pqcrypto.testvpn"
    compileSdk = 36

    defaultConfig {
        applicationId = "org.pqcrypto.testvpn"
        minSdk = 34
        targetSdk = 36
        versionCode = 1
        versionName = "1.0-test"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    kotlinOptions { jvmTarget = "21" }
}
