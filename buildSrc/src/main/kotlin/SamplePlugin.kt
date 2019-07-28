import com.android.build.gradle.AppExtension
import com.android.build.gradle.AppPlugin
import com.android.build.gradle.BaseExtension
import com.android.build.gradle.LibraryPlugin
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.internal.AndroidExtensionsExtension
import org.jetbrains.kotlin.gradle.plugin.KaptExtension

@Suppress("unused")
class SamplePlugin : Plugin<Project> {
    override fun apply(project: Project) {
        val sampleExtension =
                project.extensions.create("sample", SampleExtension::class.java, project)

        project.configureKotlin()
        project.plugins.all { plugin: Plugin<*>? ->
            when (plugin) {
                is AppPlugin -> {
                    project.extensions.getByType<AppExtension>().apply {
                        configureApplicationOptions(project, sampleExtension)
                    }
                }

                is LibraryPlugin -> {
                    project.extensions.getByType<BaseExtension>().apply {
                        configureCommonAndroidOptions()
                    }
                }
            }
            true
        }
    }

    private fun Project.configureKotlin() {
        apply(plugin = "kotlin-android")
        apply(plugin = "kotlin-kapt")
        configure<KaptExtension> {
            correctErrorTypes = true
            useBuildCache = true
            arguments {
                arg("dagger.formatGeneratedSource", "disabled")
            }
        }
        apply(plugin = "kotlin-android-extensions")
        configure<AndroidExtensionsExtension> {
            isExperimental = true
        }
    }

    private fun AppExtension.configureApplicationOptions(
            project: Project,
            sampleExtension: SampleExtension
    ) {

        configureCommonAndroidOptions()
        defaultConfig.apply {
            applicationId = sampleExtension.applicationId
            versionName = SampleRelease.versionName
            versionCode = SampleRelease.versionCode
            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }

        dataBinding {
            isEnabled = true
        }

        buildTypes {
            getByName("debug") {

            }
            getByName("release") {
                isMinifyEnabled = true
            }
        }
    }

    private fun BaseExtension.configureCommonAndroidOptions() {

        compileSdkVersion(SampleBuildConfigs.compileSdk)
        buildToolsVersion(SampleBuildConfigs.buildtoolsVersion)
        defaultConfig.apply {
            minSdkVersion(SampleBuildConfigs.minSdk)
            targetSdkVersion(SampleBuildConfigs.targetSdk)
        }

        compileOptions.apply {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }
    }
}