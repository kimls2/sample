package app.sample.appinitializers

import android.app.Application

interface AppInitializer {
    fun init(application: Application)
}