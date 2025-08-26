import com.project.convention.implementation

plugins {
    alias(libs.plugins.module.feature)
}

android {
    namespace = "com.project.feature.home"
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
}
