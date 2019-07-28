plugins {
    id("kotlin")
}

dependencies {
    api(Libs.Kotlin.stdlib)

    api(Libs.Coroutines.core)
    api(Libs.Coroutines.rx2)

    api(Libs.Dagger.dagger)

    api(Libs.Retrofit.retrofit)
    api(Libs.OkHttp.loggingInterceptor)
}
