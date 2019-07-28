package app.sample.data.repositories.comic

import app.sample.data.entities.Comic
import app.sample.data.entities.Success
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ComicRepositoryImpl @Inject constructor(
        private val comicStore: ComicStore,
        private val remoteComicDataSource: RemoteComicDataSource
) : ComicRepository {
    override fun observeComics(): Observable<List<Comic>> = comicStore.observeComics()

    override suspend fun updateComics() {
        val result = remoteComicDataSource.getComics()
        if (result is Success) {
            comicStore.save(result.data)
        }
    }
}