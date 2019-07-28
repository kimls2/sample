plugins {
    id("com.android.library")
    id("SamplePlugin")
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
