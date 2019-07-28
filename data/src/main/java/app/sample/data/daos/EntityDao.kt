package app.sample.data.daos

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import app.sample.data.entities.SampleEntity

interface EntityDao<in E : SampleEntity> {
    @Insert
    suspend fun insert(entity: E): Long

    @Insert
    suspend fun insertAll(vararg entity: E)

    @Insert
    suspend fun insertAll(entities: List<E>)

    @Update
    suspend fun update(entity: E)

    @Delete
    suspend fun delete(entity: E): Int
}