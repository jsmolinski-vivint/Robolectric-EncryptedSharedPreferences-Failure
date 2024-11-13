plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.jsmolinski.robolectric.encryptedsharedpreferences.test"

    compileSdk = 34

    defaultConfig {
        minSdk = 30
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

// NOTE: Uncomment this and the test will fail with `AndroidKeyStore not found`
//    testOptions.unitTests.apply {
//        isIncludeAndroidResources = true
//    }
}

dependencies {
    testImplementation(project(":storage"))

    testImplementation(libs.security.crypto)

    testImplementation(libs.junit)
    testImplementation(libs.androidx.junit)
    testImplementation(libs.androidx.runner)
    testImplementation(libs.robolectric)
}