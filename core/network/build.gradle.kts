plugins {
    id("com.example.drugapp.android.library")
    id("com.example.drugapp.android.hilt")
    id("com.example.drugapp.android.navigation")
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
    id ("kotlin-kapt")
}

android {
    namespace = "com.example.core.network"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        buildConfig = true
    }

    buildTypes {
        debug {
            buildConfigField(
                "String",
                "BASE_URL",
                "\"https://run.mocky.io/v3/\"",
            )
        }

        release {
            buildConfigField(
                "String",
                "BASE_URL",
                "\"https://run.mocky.io/v3/\"",
            )

            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }
}

dependencies {

    implementation(project(":core:common"))
    implementation(project(":core:model"))
    //implementation(project(":data"))

    // retrofit
    api(libs.com.squareup.retrofit2)
    implementation(libs.com.google.code.gson)
    implementation(libs.com.squareup.retrofit2.converter.gson)
    implementation(libs.com.squareup.okhttp3.logging.interceptor)

    //room
    implementation(libs.androidx.room.ktx)
    implementation(libs.androidx.room.runtime)
    annotationProcessor(libs.androidx.room.compiler)
    //annotationProcessor ("android.arch.persistence.room:compiler:2.5.2")
    kapt(libs.androidx.room.compiler)

    // util
    debugImplementation(libs.com.github.chuckerteam.chucker.library)
    releaseImplementation(libs.com.github.chuckerteam.chucker.library.no.op)

    //testImplementation(projects.core.test)
    testImplementation(libs.junit4)
    testImplementation(libs.com.squareup.okhttp3.mockwebserver)
    testImplementation(libs.io.mockk.android)
    testImplementation(libs.io.mockk.agent)

    //androidTestImplementation(projects.core.test)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.androidx.test.espresso.core)
}



