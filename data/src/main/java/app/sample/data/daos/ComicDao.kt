package app.sample.data.daos

import androidx.room.Dao
import androidx.room.Query
import app.sample.data.entities.Comic
import io.reactivex.Observable

@Dao
abstract class ComicDao : EntityDao<Comic> {
    @Query("SELECT * from comics")
    abstract fun comicsObservable(): Observable<List<Comic>>

    @Query("SELECT id from comics WHERE marvel_comic_id=:id")
    abstract fun entityIdByMarvelId(id: Int):Long?
}