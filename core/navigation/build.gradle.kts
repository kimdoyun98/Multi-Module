plugins {
    alias(libs.plugins.module.android.library)
}

android {
    namespace = "com.project.navigation"
}

dependencies {
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
}
