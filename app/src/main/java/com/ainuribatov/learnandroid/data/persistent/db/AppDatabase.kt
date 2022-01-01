package com.ainuribatov.learnandroid.data.persistent.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ainuribatov.learnandroid.entity.Post

@Database(
    entities = [
        Post::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun postDao(): PostDao
}