import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import com.project.convention.configureAndroid
import com.project.convention.getLibrary
import com.project.convention.implementation
import com.project.convention.ksp
import com.project.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.assign
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.provideDelegate
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinTopLevelExtension

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
                apply("com.google.devtools.ksp")
                apply("dagger.hilt.android.plugin")
            }

            extensions.configure<BaseAppModuleExtension> {
                configureAndroid(commonExtension = this)
            }

            configureKotlin<KotlinAndroidProjectExtension>()

            dependencies {
                implementation(libs.getLibrary("hilt.android"))
                ksp(libs.getLibrary("hilt.compiler"))
            }
        }
    }

    private inline fun <reified T : KotlinTopLevelExtension> Project.configureKotlin() = configure<T> {
        val warningsAsErrors: String? by project
        when (this) {
            is KotlinAndroidProjectExtension -> compilerOptions
            is KotlinJvmProjectExtension -> compilerOptions
            else -> TODO("Unsupported project extension $this ${T::class}")
        }.apply {
            jvmTarget = JvmTarget.JVM_17
            allWarningsAsErrors = warningsAsErrors.toBoolean()
            freeCompilerArgs.add(
                "-opt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
            )
        }
    }
}
