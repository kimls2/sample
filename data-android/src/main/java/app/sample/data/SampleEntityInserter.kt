package app.sample.data

import android.database.sqlite.SQLiteException
import app.sample.data.daos.EntityDao
import app.sample.data.daos.EntityInserter
import app.sample.data.entities.SampleEntity
import javax.inject.Inject

class SampleEntityInserter @Inject constructor(
    private val transactionRunner: DatabaseTransactionRunner
) : EntityInserter {
    override suspend fun <E : SampleEntity> insertOrUpdate(dao: EntityDao<E>, entities: List<E>) {
        transactionRunner {
            entities.forEach {
                insertOrUpdate(dao, it)
            }
        }
    }

    override suspend fun <E : SampleEntity> insertOrUpdate(dao: EntityDao<E>, entity: E): Long {
        return if (entity.id == 0L) {
            try {
                dao.insert(entity)
            } catch (e: SQLiteException) {
                throw SQLiteException("Error while inserting entity: $entity").apply {
                    initCause(e)
                }
            }
        } else {
            try {
                dao.update(entity)
                entity.id
            } catch (e: SQLiteException) {
                throw SQLiteException("Error while updating entity: $entity").apply {
                    initCause(e)
                }
            }
        }
    }
}