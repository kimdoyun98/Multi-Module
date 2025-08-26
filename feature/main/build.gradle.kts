import com.project.convention.implementation
import org.gradle.kotlin.dsl.implementation

plugins {
    alias(libs.plugins.module.android.library)
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

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(projects.core.navigation)
    implementation(projects.core.ui)
    implementation(projects.feature.home)
    implementation(projects.feature.second)

    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
}
