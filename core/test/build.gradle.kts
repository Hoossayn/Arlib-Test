plugins {
    id("com.example.drugapp.android.library")
    id("com.example.drugapp.android.hilt")
    id("com.example.drugapp.android.library.compose")
}

android {
    namespace = "com.example.test"
}

dependencies {

    implementation(project(":core:common"))
    implementation(project(":core:model"))
    implementation(project(":data"))
    implementation(project(":core:network"))


    // retrofit
    api(libs.com.squareup.retrofit2)
    api(libs.com.google.code.gson)
    api(libs.com.squareup.retrofit2.converter.gson)
    api(libs.com.squareup.okhttp3.logging.interceptor)
    api(libs.com.squareup.okhttp3.mockwebserver)

    api(libs.junit4)
    api(libs.androidx.test.core)
    api(libs.androidx.test.core.ktx)
    api(libs.androidx.test.rules)
    api(libs.androidx.test.runner)

    api(libs.app.cash.turbine)
    api(libs.com.google.truth)
    api(libs.androidx.hilt.android.testing)
    api(libs.org.jetbrains.kotlinx.coroutines.test)
    api(libs.androidx.navigation.testing)
    api(libs.androidx.compose.ui.test.junit4)
    debugApi(libs.androidx.compose.ui.test.manifest)

    api(libs.io.mockk.android)
    api(libs.io.mockk.agent)

    api(libs.androidx.test.uiautomator)
    api(libs.org.robolectric)
    api(libs.org.robolectric.shadows)
    api(libs.io.github.takahirom.roborazzi)

    api(libs.androidx.test.ext.junit)
    api(libs.androidx.test.ext.truth)
    api(libs.androidx.test.espresso.core)
    api(libs.androidx.test.espresso.intents)
}