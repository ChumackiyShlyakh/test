package com.notyteam.bee.room

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import android.os.AsyncTask
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.room.Room


@Database(entities = [RoomPointData::class], version = 1, exportSchema = true)
abstract class RoomDB : RoomDatabase() {

    abstract fun pointDao(): PointDao

    companion object {

            @Volatile
        private var instance: RoomDB? = null

        fun getDatabase(context: Context): RoomDB? {
            if (instance == null) {
                synchronized(RoomDB::class) {
                    if (instance == null) {
                        // create database here
                        instance = Room.databaseBuilder(
                            context.applicationContext,
                            RoomDB::class.java, "points_database"
                        ).addCallback(sRoomDatabaseCallback).build()
                    }
                }
            }
            return instance
        }

        private val sRoomDatabaseCallback = object : RoomDatabase.Callback() {

            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                PopulateDbAsync(instance!!).execute()
            }
        }
    }

    private class PopulateDbAsync(db: RoomDB?) : AsyncTask<Unit, Unit, Unit>() {

        private val roomDao = db?.pointDao()

        override fun doInBackground(vararg params: Unit): Unit? {
            roomDao?.deleteAll();
//            roomDao?.insertPoint()
            return null
        }
    }
}