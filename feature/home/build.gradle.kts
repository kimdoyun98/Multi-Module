import com.project.convention.implementation

plugins {
    alias(libs.plugins.module.android.library)
}

android {
    namespace = "com.project.feature.home"
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    implementation(projects.core.navigation)
    implementation(projects.core.ui)

    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
}
