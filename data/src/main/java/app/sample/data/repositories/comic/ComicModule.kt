package app.sample.data.repositories.comic

import dagger.Binds
import dagger.Module

@Module
abstract class ComicModule {
    @Binds
    abstract fun bind(source: ComicRepositoryImpl): ComicRepository
}