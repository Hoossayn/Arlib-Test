plugins {
    id("com.example.drugapp.android.library")
    id("com.example.drugapp.android.hilt")
    id ("kotlin-kapt")
}

android {
    namespace = "com.example.data"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}


dependencies {

    implementation(project(":core:common"))
    implementation(project(":core:model"))
    implementation(project(":core:network"))

    //room
    implementation(libs.androidx.room.ktx)
    implementation(libs.androidx.room.runtime)
    //annotationProcessor ("android.arch.persistence.room:compiler:2.5.2")
    annotationProcessor(libs.androidx.room.compiler)
    kapt("androidx.room:room-compiler:2.5.2")
    //kapt(libs.androidx.room.compiler)

}
