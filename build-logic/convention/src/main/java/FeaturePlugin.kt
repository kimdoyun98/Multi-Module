import com.project.convention.getLibrary
import com.project.convention.implementation
import com.project.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class FeaturePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("module.android.library")
                apply("module.hilt")
            }

            dependencies {
                implementation(project(":core:ui"))
                implementation(project(":core:navigation"))

                implementation(libs.getLibrary("androidx.navigation.fragment.ktx"))
                implementation(libs.getLibrary("androidx.navigation.ui.ktx"))
            }
        }
    }
}
