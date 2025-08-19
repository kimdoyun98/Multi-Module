plugins {
    alias(libs.plugins.module.android.library)
}

android {
    namespace = "com.project.feature.main"
}

dependencies {
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
}
