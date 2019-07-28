package app.sample.data

import android.content.Context
import android.os.Debug
import androidx.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [DatabaseModuleBinds::class])
object DatabaseModule {
    @JvmStatic
    @Singleton
    @Provides
    fun provideDatabase(context: Context): SampleRoomDatabase {
        val builder = Room.databaseBuilder(context, SampleRoomDatabase::class.java, "sample.db")
                .fallbackToDestructiveMigration()
        if (Debug.isDebuggerConnected()) {
            builder.allowMainThreadQueries()
        }
        return builder.build()
    }

    @JvmStatic
    @Provides
    fun provideComicDao(db: SampleDatabase) = db.comicDao()
}