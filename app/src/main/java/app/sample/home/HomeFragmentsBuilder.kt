package app.sample.home

import app.sample.home.main.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class HomeFragmentsBuilder {
    @ContributesAndroidInjector
    abstract fun mainFragment(): MainFragment
}