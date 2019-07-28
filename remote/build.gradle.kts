plugins {
    id("kotlin")
    id("kotlin-kapt")
}

dependencies {
    implementation(project(Modules.base))
    implementation(project(Modules.dto))

    implementation(Libs.OkHttp.okhttp)
    implementation(Libs.Retrofit.gsonConverter)


    kapt(Libs.Dagger.compiler)
}
