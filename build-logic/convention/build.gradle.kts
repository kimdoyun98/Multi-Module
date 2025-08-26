plugins {
    `kotlin-dsl`
}

group = "com.project.convention"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    compileOnly(libs.android.tools.build.gradle.plugin)
    compileOnly(libs.kotlin.gradle.plugin)
}

gradlePlugin {
    plugins {
        plugins {
            register("AndroidApplication") {
                id = "module.android.application"
                implementationClass = "AndroidApplicationConventionPlugin"
            }
            register("AndroidLibrary") {
                id = "module.android.library"
                implementationClass = "AndroidLibraryConventionPlugin"
            }
            register("AndroidTest") {
                id = "module.android.test"
                implementationClass = "AndroidTestConventionPlugin"
            }
            register("Compose") {
                id = "module.compose"
                implementationClass = "ComposeConventionPlugin"
            }

            register("Hilt") {
                id = "module.hilt"
                implementationClass = "HiltPlugin"
            }
        }
    }
}
