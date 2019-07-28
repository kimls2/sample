package app.sample.inject

import android.app.Application
import app.sample.SampleApplication
import app.sample.appinitializers.AppInitializer
import app.sample.appinitializers.EpoxyInitializer
import app.sample.appinitializers.RxAndroidInitializer
import app.sample.appinitializers.StethoInitializer
import app.sample.appinitializers.TimberInitializer
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoSet

@Module
abstract class AppModuleBinds {
    @Binds
    abstract fun provideApplication(bind: SampleApplication): Application

    @Binds
    @IntoSet
    abstract fun provideEpoxyInitializer(bind: EpoxyInitializer): AppInitializer

    @Binds
    @IntoSet
    abstract fun provideRxAndroidInitializer(bind: RxAndroidInitializer): AppInitializer

    @Binds
    @IntoSet
    abstract fun provideTimberInitializer(bind: TimberInitializer): AppInitializer

    @Binds
    @IntoSet
    abstract fun provideStethoInitializer(bind: StethoInitializer): AppInitializer
}