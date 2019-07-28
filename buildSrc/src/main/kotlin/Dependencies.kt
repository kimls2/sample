object SampleBuildConfigs {
    const val compileSdk = 28
    const val minSdk = 21
    const val targetSdk = 28
    const val buildtoolsVersion = "29.0.0"
}

object SampleRelease {
    const val versionCode = 1
    const val versionName = "0.0.1"
}

object Modules {
    const val base = ":base"
    const val data = ":data"
    const val dataAndroid = ":data-android"
    const val interactors = ":interactors"
    const val dto = ":dto"
    const val remote = ":remote"
}

object Libs {
    const val androidGradlePlugin = "com.android.tools.build:gradle:3.6.0-alpha05"
    const val gradleVersionsPlugin = "com.github.ben-manes:gradle-versions-plugin:0.21.0"
    const val timber = "com.jakewharton.timber:timber:4.7.1"
    const val junit = "junit:junit:4.12"
    const val mockitoCore = "org.mockito:mockito-core:3.0.0"
    const val mvrx = "com.airbnb.android:mvrx:1.0.2"
    const val jodaMoney = "org.joda:joda-money:1.0.1"

    object Google {
        const val material = "com.google.android.material:material:1.1.0-alpha08"
    }

    object Kotlin {
        private const val version = "1.3.41"
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
        const val extensions = "org.jetbrains.kotlin:kotlin-android-extensions:$version"
    }

    object Coroutines {
        private const val version = "1.3.0-RC"
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        const val rx2 = "org.jetbrains.kotlinx:kotlinx-coroutines-rx2:$version"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
    }

    object AndroidX {
        const val appcompat = "androidx.appcompat:appcompat:1.1.0-rc01"
        const val recyclerview = "androidx.recyclerview:recyclerview:1.1.0-beta01"
        const val constraintlayout = "androidx.constraintlayout:constraintlayout:1.1.3"
        const val coreKtx = "androidx.core:core-ktx:1.2.0-alpha02"

        object Navigation {
            private const val version = "2.1.0-beta02"
            const val fragment = "androidx.navigation:navigation-fragment-ktx:$version"
            const val ui = "androidx.navigation:navigation-ui-ktx:$version"
            const val safeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:$version"
        }

        object Test {
            const val core = "androidx.test:core:1.2.1-alpha02"
            const val coreKtx = "androidx.test:core:1.2.0"
            const val ext = "androidx.test.ext:junit-ktx:1.1.2-alpha02"
            const val runner = "androidx.test:runner:1.3.0-alpha02"
            const val rules = "androidx.test:rules:1.3.0-alpha02"

            const val espressoCore = "androidx.test.espresso:espresso-core:3.3.0-alpha01"
            const val espressoIntents = "androidx.test.espresso:espresso-intents:3.3.0-alpha01"

            const val uiAutomator = "androidx.test.uiautomator:uiautomator:2.2.0"
        }

        object Lifecycle {
            private const val version = "2.2.0-alpha02"
            const val extensions = "androidx.lifecycle:lifecycle-extensions:$version"
            const val reactivestreams = "androidx.lifecycle:lifecycle-reactivestreams:$version"
            const val compiler = "androidx.lifecycle:lifecycle-compiler:$version"
        }

        object Room {
            private const val version = "2.2.0-alpha01"
            const val common = "androidx.room:room-common:$version"
            const val runtime = "androidx.room:room-runtime:$version"
            const val rxjava2 = "androidx.room:room-rxjava2:$version"
            const val compiler = "androidx.room:room-compiler:$version"
            const val ktx = "androidx.room:room-ktx:$version"
        }
    }

    object RxJava {
        const val rxJava = "io.reactivex.rxjava2:rxjava:2.2.10"
        const val rxKotlin = "io.reactivex.rxjava2:rxkotlin:2.4.0-RC3"
        const val rxAndroid = "io.reactivex.rxjava2:rxandroid:2.1.1"
    }

    object Dagger {
        private const val version = "2.24"
        const val dagger = "com.google.dagger:dagger:$version"
        const val daggerAndroid = "com.google.dagger:dagger-android:$version"
        const val androidSupport = "com.google.dagger:dagger-android-support:$version"
        const val compiler = "com.google.dagger:dagger-compiler:$version"
        const val androidProcessor = "com.google.dagger:dagger-android-processor:$version"
    }

    object Retrofit {
        private const val version = "2.6.0"
        const val retrofit = "com.squareup.retrofit2:retrofit:$version"
        const val retrofit_rxjava_adapter = "com.squareup.retrofit2:adapter-rxjava2:$version"
        const val gsonConverter = "com.squareup.retrofit2:converter-gson:$version"
    }

    object OkHttp {
        private const val version = "4.0.1"
        const val okhttp = "com.squareup.okhttp3:okhttp:$version"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:$version"
    }

    object Stetho {
        private const val version = "1.5.1"
        const val stetho = "com.facebook.stetho:stetho:$version"
        const val stethoOkhttp3 = "com.facebook.stetho:stetho-okhttp3:$version"
    }

    object AssistedInject {
        private const val version = "0.4.0"
        const val annotationDagger2 =
                "com.squareup.inject:assisted-inject-annotations-dagger2:$version"
        const val processorDagger2 =
                "com.squareup.inject:assisted-inject-processor-dagger2:$version"
    }

    object Epoxy {
        private const val version = "3.7.0"
        const val epoxy = "com.airbnb.android:epoxy:$version"
        const val dataBinding = "com.airbnb.android:epoxy-databinding:$version"
        const val processor = "com.airbnb.android:epoxy-processor:$version"
    }

    object Glide {
        private const val version = "4.9.0"
        const val glide = "com.github.bumptech.glide:glide:$version"
        const val compiler = "com.github.bumptech.glide:compiler:$version"
    }
}
