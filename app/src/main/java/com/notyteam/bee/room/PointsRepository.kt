package com.notyteam.bee.room

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData


class PointsRepository(application: Application) {

    private var pointDao: PointDao
    private var allPoints: List<RoomPointData>
//    private var allPoints: LiveData<List<RoomPointData>>

    init {
//        val db: RoomDB = RoomDB.getDatabase(application.applicationContext)!!
        val db: RoomDB = RoomDB.getDatabase(application.applicationContext)!!
        pointDao = db.pointDao()
        allPoints = pointDao.getAllPoints()
    }

    //    fun insert(points: List<RoomPointData>) {
    fun insert(points: RoomPointData) {
        InsertAsyncTask(pointDao).execute(points)
    }

//    fun getAllRepos(): LiveData<List<RoomPointData>> {
    fun getAllRepos(): List<RoomPointData> {
        return allPoints
    }

    //    fun delete() {
//        pointDao.deleteAll()
//    }
    fun deleteAllPoints() {
        val deleteAllNotesAsyncTask = DeleteAllPointsAsyncTask(pointDao).execute()
    }

    private class InsertAsyncTask(pointDao: PointDao) : AsyncTask<RoomPointData, Unit, Unit>() {

        val pointDao = pointDao
        override fun doInBackground(vararg params: RoomPointData?) {
            pointDao.insertPoint(params[0]!!)
        }
    }

    private class DeleteAllPointsAsyncTask(val pointDao: PointDao) : AsyncTask<Unit, Unit, Unit>() {

        override fun doInBackground(vararg p0: Unit?) {
            pointDao.deleteAll()
        }
    }
}