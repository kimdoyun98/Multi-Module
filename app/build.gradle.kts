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

    implementation(libs.androidx.core.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(projects.feature.main)
}
