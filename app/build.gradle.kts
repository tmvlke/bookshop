plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("de.mannodermaus.android-junit5")
}

dependencies {

    implementation("androidx.core:core-ktx:1.10.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    implementation("androidx.compose.ui:ui:1.5.0-alpha03")
    implementation("androidx.compose.material:material:1.5.0-alpha03")
    implementation("androidx.compose.ui:ui-tooling:1.5.0-alpha03")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.activity:activity-compose:1.7.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.5.0-alpha03")

    implementation("androidx.activity:activity-ktx:1.7.1")
    implementation("androidx.fragment:fragment-ktx:1.6.0-beta01")

    // Coil Image Loading
    implementation("io.coil-kt:coil-compose:2.3.0")

    // Flow Layout
    implementation("com.google.accompanist:accompanist-flowlayout:0.14.0")

    // compose navigation
    implementation("androidx.navigation:navigation-compose:2.6.0-beta01")
    implementation("androidx.hilt:hilt-navigation-compose:1.1.0-alpha01")

    implementation("com.squareup.retrofit2:converter-gson:2.9.0")


    // Dagger Hilt
    implementation("com.google.dagger:hilt-android:2.46")
    kapt("com.google.dagger:hilt-android-compiler:2.46")
}

android {
    namespace = "wskim.bookshop"
    compileSdk = 33
    buildToolsVersion = "33.0.0 rc2"
    ndkVersion = "25.1.8937393"

    defaultConfig {
        applicationId = "wskim.bookshop"
        minSdk = 28
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

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
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
    buildFeatures {
        // AGP 9.0 이전까지만 사용하기
        buildConfig = true

        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.1"
    }
}