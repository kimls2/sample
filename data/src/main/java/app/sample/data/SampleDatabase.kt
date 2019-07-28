package app.sample.data

import app.sample.data.daos.ComicDao

interface SampleDatabase {
    fun comicDao(): ComicDao
}