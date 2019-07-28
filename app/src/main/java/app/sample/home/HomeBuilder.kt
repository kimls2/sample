package app.sample.home

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class HomeBuilder {
    @ContributesAndroidInjector(modules = [
        HomeFragmentsBuilder::class
    ])
    internal abstract fun homeActivity(): HomeActivity
}