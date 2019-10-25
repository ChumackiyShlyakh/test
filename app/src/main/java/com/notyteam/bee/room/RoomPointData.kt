package com.notyteam.bee.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "points_table")
data class RoomPointData(
    var latitude: Double,
    var longitude: Double
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}

