package app.sample.interactors

import app.sample.data.entities.Comic
import app.sample.data.repositories.comic.ComicRepository
import app.sample.util.AppRxSchedulers
import io.reactivex.Observable
import javax.inject.Inject

class ObserveComics @Inject constructor(
    private val schedulers: AppRxSchedulers,
    private val comicRepository: ComicRepository
) : SubjectInteractor<Unit, List<Comic>>() {
    override fun createObservable(params: Unit): Observable<List<Comic>> {
        return comicRepository.observeComics()
                .subscribeOn(schedulers.io)
    }
}