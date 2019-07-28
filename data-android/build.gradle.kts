plugins {
    id("com.android.library")
    id("SamplePlugin")
}

android {
    defaultConfig {
        javaCompileOptions {
            annotationProcessorOptions {
                arguments = mapOf(
                        "room.schemaLocation" to "$projectDir/schemas",
                        "room.incremental" to "true",
                        "room.expandProjection" to "true"
                )
            }
        }
    }
}

dependencies {
    implementation(project(Modules.base))
    implementation(project(Modules.data))

    implementation(Libs.AndroidX.Room.runtime)
    implementation(Libs.AndroidX.Room.rxjava2)
    implementation(Libs.AndroidX.Room.ktx)
    kapt(Libs.AndroidX.Room.compiler)

    implementation(Libs.AndroidX.Room.runtime)

    kapt(Libs.Dagger.compiler)
}
