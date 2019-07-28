package app.sample.data

import app.sample.data.repositories.comic.ComicModule
import dagger.Module

@Module(includes = [
    ComicModule::class
])
abstract class DataModule