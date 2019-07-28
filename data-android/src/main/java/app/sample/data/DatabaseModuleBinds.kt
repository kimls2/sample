package app.sample.data

import app.sample.data.daos.EntityInserter
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class DatabaseModuleBinds {
    @Binds
    abstract fun bindTiviDatabase(db: SampleRoomDatabase): SampleDatabase

    @Singleton
    @Binds
    abstract fun provideDatabaseTransactionRunner(runner: RoomTransactionRunner): DatabaseTransactionRunner

    @Singleton
    @Binds
    abstract fun provideEntityInserter(inserter: SampleEntityInserter): EntityInserter
}