package app.sample.inject

import app.sample.SampleApplication
import app.sample.data.DataModule
import app.sample.data.DatabaseModule
import app.sample.home.HomeBuilder
import app.sample.remote.RemoteModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    AppAssistedModule::class,
    DatabaseModule::class,
    DataModule::class,
    RemoteModule::class,
    HomeBuilder::class
])
interface AppComponent : AndroidInjector<SampleApplication> {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: SampleApplication): AppComponent
    }
}