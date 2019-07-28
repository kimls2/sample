package app.sample.data.daos

import app.sample.data.entities.SampleEntity

interface EntityInserter {
    suspend fun <E : SampleEntity> insertOrUpdate(dao: EntityDao<E>, entities: List<E>)
    suspend fun <E : SampleEntity> insertOrUpdate(dao: EntityDao<E>, entity: E): Long
}