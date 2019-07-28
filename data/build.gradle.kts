plugins {
    id("kotlin")
}

dependencies {
    implementation(project(Modules.base))
    implementation(project(Modules.dto))
    implementation(project(Modules.remote))

    implementation(Libs.AndroidX.Room.common)
    implementation(Libs.AndroidX.Room.ktx)
    implementation(Libs.AndroidX.Room.common)

    implementation(Libs.RxJava.rxJava)
    implementation(Libs.RxJava.rxKotlin)
}
