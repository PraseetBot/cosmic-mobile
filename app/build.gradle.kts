plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.hilt.android)
}

android {
    namespace = "com.cosmic.mobile"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.cosmic.mobile"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.8"
    }

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // Core Android
    implementation(libs.coreKtx)
    implementation(libs.lifecycleRuntimeKtx)
    implementation(libs.activityCompose)

    // Compose
    implementation(platform(libs.composeBom))
    implementation(libs.composeUi)
    implementation(libs.composeUiGraphics)
    implementation(libs.composeUiToolingPreview)
    implementation(libs.composeMaterial3)
    implementation(libs.composeFoundation)
    implementation(libs.composeAnimation)
    debugImplementation(libs.composeUiTooling)
    debugImplementation(libs.composeUiTestManifest)

    // Navigation
    implementation(libs.navigationCompose)

    // Room
    implementation(libs.room)
    implementation(libs.roomKtx)
    kapt(libs.roomCompiler)

    // DataStore
    implementation(libs.datastore)

    // Hilt
    implementation(libs.hilt)
    kapt(libs.hiltCompiler)
    implementation(libs.hiltNavigationCompose)

    // Testing
    testImplementation(libs.junit)
    testImplementation(libs.mockitoCore)
    testImplementation(libs.mockitoKotlin)
    androidTestImplementation(platform(libs.composeBom))
    androidTestImplementation(libs.junitCompose)
    androidTestImplementation(libs.espressoCore)
}
