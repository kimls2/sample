package app.sample.appinitializers

import android.app.Application
import android.os.Handler
import android.os.HandlerThread
import com.airbnb.epoxy.EpoxyController
import javax.inject.Inject

class EpoxyInitializer @Inject constructor() : AppInitializer {
    override fun init(application: Application) {
        // Make EpoxyController async
        val handlerThread = HandlerThread("epoxy")
        handlerThread.start()

        Handler(handlerThread.looper).also {
            EpoxyController.defaultDiffingHandler = it
            EpoxyController.defaultModelBuildingHandler = it
        }
    }
}