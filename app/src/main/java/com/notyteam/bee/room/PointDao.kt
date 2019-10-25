package com.notyteam.bee.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
public interface PointDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPoint(point: RoomPointData)

//    @Query("SELECT * FROM points_table WHERE id = (SELECT MAX(id) FROM points_table)")
    @Query("SELECT * FROM points_table")
    fun getAllPoints(): List<RoomPointData>
//    fun getAllPoints(): LiveData<List<RoomPointData>>

    @Query("DELETE FROM points_table")
    fun deleteAll()

//    @Update
//    fun updateGender(gender: Gender)
//
//    @Query("SELECT * FROM Gender WHERE name == :name")
//    fun getGenderByName(name: String): List<Gender>
}