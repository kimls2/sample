package app.sample.data

import androidx.room.Database
import androidx.room.RoomDatabase
import app.sample.data.entities.Comic

@Database(
        entities = [
            Comic::class
        ],
        version = 1
)
abstract class SampleRoomDatabase : RoomDatabase(), SampleDatabase