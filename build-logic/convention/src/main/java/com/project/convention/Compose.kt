package com.project.convention

import com.android.build.gradle.BaseExtension
import com.project.convention.libs
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.project

@Suppress("UnstableApiUsage")
internal fun Project.configureCompose(commonExtension: BaseExtension) {
    commonExtension.apply {
        buildFeatures.apply {
            compose = true
        }

        composeOptions {
            kotlinCompilerExtensionVersion =
                libs.findVersion("androidxComposeCompiler").get().toString()
        }

        dependencies {
            add("implementation", platform(libs.findLibrary("androidx.compose.bom").get()))
            add(
                "androidTestImplementation",
                libs.findLibrary("androidx.compose.ui.test.junit4").get()
            )
            add("androidTestImplementation", project(":core:testing"))
        }
    }
}
