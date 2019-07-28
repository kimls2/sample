package app.sample.data.repositories.comic

import app.sample.data.DatabaseTransactionRunner
import app.sample.data.daos.ComicDao
import app.sample.data.daos.EntityInserter
import app.sample.data.entities.Comic
import javax.inject.Inject

class ComicStore @Inject constructor(
        private val entityInserter: EntityInserter,
        private val transactionRunner: DatabaseTransactionRunner,
        private val comicDao: ComicDao
) {
    fun observeComics() = comicDao.comicsObservable()
    suspend fun save(comics: List<Comic>) = transactionRunner {
        comics.forEach {
            val id = comicDao.entityIdByMarvelId(it.marvelComicId) ?: 0
            val entity = it.copy(id = id)
            entityInserter.insertOrUpdate(comicDao, entity)
        }

    }
}