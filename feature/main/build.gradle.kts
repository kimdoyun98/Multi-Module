import com.project.convention.implementation
import org.gradle.kotlin.dsl.implementation

plugins {
    alias(libs.plugins.module.feature)
}

android {
    namespace = "com.project.feature.main"

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    implementation(projects.feature.home)
    implementation(projects.feature.second)
}
