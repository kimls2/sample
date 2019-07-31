package app.sample.interactors

import app.sample.data.repositories.comic.ComicRepository
import app.sample.util.AppCoroutineDispatchers
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class UpdateComics @Inject constructor(
    dispatchers: AppCoroutineDispatchers,
    private val comicRepository: ComicRepository
) : Interactor<Unit> {
    override val dispatcher: CoroutineDispatcher = dispatchers.io

    override suspend fun invoke(params: Unit) {
        comicRepository.updateComics()
    }
}