plugins {
    `kotlin-dsl`
}

kotlinDslPluginOptions {
    experimentalWarning.set(false)
}

repositories {
    jcenter()
    google()
}
dependencies {
    implementation("com.android.tools.build:gradle:3.4.2")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.41")
}

gradlePlugin {
    plugins {
        register("SamplePlugin") {
            id = "SamplePlugin"
            implementationClass = "SamplePlugin"
        }
    }
}