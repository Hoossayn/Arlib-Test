import com.example.convention.androidTestImplementation
import com.example.convention.implementation
import com.example.convention.testImplementation
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.kotlin
import org.gradle.kotlin.dsl.project

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.example.drugapp.android.library")
                apply("com.example.drugapp.android.hilt")
            }

            dependencies {
                implementation(project(":core:common"))
                implementation(project(":core:ds"))
                implementation(project(":core:ui"))
                implementation(project(":data"))
                implementation(project(":core:network"))
                implementation(project(":core:model"))

                testImplementation(kotlin("test"))
                androidTestImplementation(kotlin("test"))
            }
        }
    }
}
