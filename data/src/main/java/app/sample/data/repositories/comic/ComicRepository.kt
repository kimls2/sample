package app.sample.data.repositories.comic

import app.sample.data.entities.Comic
import io.reactivex.Observable

interface ComicRepository {
    fun observeComics(): Observable<List<Comic>>
    suspend fun updateComics()
}