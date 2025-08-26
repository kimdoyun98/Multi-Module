plugins {
    alias(libs.plugins.module.feature)
}

android {
    namespace = "com.project.feature.second"
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
}
