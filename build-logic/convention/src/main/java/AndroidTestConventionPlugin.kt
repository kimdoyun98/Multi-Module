import com.android.build.gradle.TestExtension
import com.project.convention.configureAndroid
import com.project.convention.getLibrary
import com.project.convention.implementation
import com.project.convention.ksp
import com.project.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidTestConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.test")
                apply("org.jetbrains.kotlin.android")
                apply("com.google.devtools.ksp")
            }

            extensions.configure<TestExtension> {
                configureAndroid(this)
            }

            dependencies {
                implementation(libs.getLibrary("androidx.test.core"))
                implementation(libs.getLibrary("androidx.compose.ui.test.junit4"))
                implementation(libs.getLibrary("hilt.android"))
                implementation(libs.getLibrary("hilt.android.testing"))
                ksp(libs.getLibrary("hilt.compiler"))
            }
        }
    }
}
