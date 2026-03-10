import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.compose.reload.gradle.lifecycle
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    //alias(libs.plugins.koin.android)
}

kotlin {
    jvmToolchain(21)
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }

    sourceSets {
        androidMain.dependencies {
            implementation(libs.ui.tooling.preview)
            implementation(libs.androidx.activity.compose)
        }
        commonMain.dependencies {
            implementation(libs.components.resources)
            //implementation(libs.lifecycle.viewmodel.compose)
            implementation(libs.runtime)
            implementation(libs.foundation)
            implementation(libs.material3)
            implementation(libs.material3.adaptive.navigation.suite)
            implementation(libs.ui)
            implementation(libs.ui.tooling.preview)
            //implementation(libs.androidx.lifecycle.runtimeCompose)
            implementation(projects.shared)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "com.guzzardo.jj3tictactoe"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.guzzardo.jj3tictactoe"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    buildFeatures {
        compose = true
    }
}

dependencies {
    androidTestImplementation(libs.androidx.ui.test.junit4)
    //androidTestImplementation(libs.androidx.lifecycle.bom)

    //val composeBom = platform("androidx.compose:compose-bom:2026.01.01") // Use the latest version
    //implementation(composeBom)
    //androidTestImplementation(composeBom)

    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation(libs.androidx.annotation)
    implementation(libs.androidx.material.icons.core)
    implementation(libs.androidx.compose.material.icons.extended)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.foundation)
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.tooling.preview)
    //implementation(libs.androidx.adaptive)
    implementation(libs.androidx.runtime.livedata)
    implementation(libs.androidx.runtime.rxjava2)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.splashscreen)

    implementation(libs.androidx.appcompat.v1xx)

    // Import the Koin BOM
    implementation(libs.koin.bom) // Use the latest version from the Koin website

    // Koin Core & Android dependencies (no version needed when using the BOM)
    implementation(libs.koin.core)
    implementation(libs.koin.android)
    implementation(libs.koin.annotations)  // For annotation support


    // Optional: for Android Architecture Components (ViewModel, etc.)
    // implementation("io.insert-koin:koin-androidx-viewmodel") // Note: Check official docs for current status

    // Optional: for Jetpack Compose integration
    // implementation("io.insert-koin:koin-androidx-compose")



// Use the latest version number
}

