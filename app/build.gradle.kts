plugins {
    alias(libs.plugins.module.android.application)
}

android {
    namespace = "com.project.multi_module"

    defaultConfig {
        applicationId = "com.project.multi_module"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    implementation(projects.feature.main)
    implementation(projects.core.navigation)
}
