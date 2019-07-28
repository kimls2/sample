plugins {
    id("com.android.application")
    id("SamplePlugin")
    id("androidx.navigation.safeargs.kotlin")
}

val publicKey by extra(findProperty("MARVEL_CLIENT_PUBLIC_KEY") ?: "NO_PUBLIC_KEY")
val privateKey by extra(findProperty("MARVEL_CLIENT_PRIVATE_KEY") ?: "NO_PRIVATE_KEY")

android {
    defaultConfig {
        buildConfigField("String", "MARVEL_API_PUBLIC_KEY", "\"" + publicKey + "\"")
        buildConfigField("String", "MARVEL_API_PRIVATE_KEY", "\"" + privateKey + "\"")
    }
}
dependencies {
    implementation(project(Modules.base))
    implementation(project(Modules.data))
    implementation(project(Modules.dataAndroid))
    implementation(project(Modules.interactors))
    implementation(project(Modules.remote))
    implementation(project(Modules.dto))

    testImplementation("junit:junit:4.12")

    androidTestImplementation("androidx.test.ext:junit:1.1.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.2.0")

    implementation(Libs.Kotlin.stdlib)
    implementation(Libs.AndroidX.appcompat)
    implementation(Libs.AndroidX.constraintlayout)

    implementation(Libs.AndroidX.Navigation.fragment)
    implementation(Libs.AndroidX.Navigation.ui)

    implementation(Libs.Google.material)

    implementation(Libs.timber)
    implementation(Libs.Stetho.stetho)
    implementation(Libs.Stetho.stethoOkhttp3)

    implementation(Libs.Dagger.dagger)
    implementation(Libs.Dagger.daggerAndroid)
    implementation(Libs.Dagger.androidSupport)
    kapt(Libs.Dagger.compiler)
    kapt(Libs.Dagger.androidProcessor)

    implementation(Libs.RxJava.rxKotlin)
    implementation(Libs.RxJava.rxJava)
    implementation(Libs.RxJava.rxAndroid)

    implementation(Libs.OkHttp.okhttp)
    implementation(Libs.OkHttp.loggingInterceptor)

    implementation(Libs.Retrofit.retrofit)
    implementation(Libs.Retrofit.gsonConverter)

    implementation(Libs.AndroidX.Lifecycle.extensions)
    implementation(Libs.AndroidX.Lifecycle.reactivestreams)
    kapt(Libs.AndroidX.Lifecycle.compiler)

    implementation(Libs.Coroutines.core)
    implementation(Libs.Coroutines.rx2)
    implementation(Libs.Coroutines.android)

    compileOnly(Libs.AssistedInject.annotationDagger2)
    kapt(Libs.AssistedInject.processorDagger2)

    implementation(Libs.mvrx)

    implementation(Libs.Epoxy.epoxy)
    implementation(Libs.Epoxy.dataBinding)
    kapt(Libs.Epoxy.processor)

    implementation(Libs.AndroidX.Room.common)
    implementation(Libs.AndroidX.Room.runtime)
    implementation(Libs.AndroidX.Room.rxjava2)
    implementation(Libs.AndroidX.Room.ktx)
    kapt(Libs.AndroidX.Room.compiler)

    implementation(Libs.Glide.glide)
    kapt(Libs.Glide.compiler)
}

sample {
    appName = "Sample App"
    applicationId = "app.sample"
}