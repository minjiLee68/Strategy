package com.sophia.saveandshowmyactivitytoday.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "todo")
data class TodoEntity(
    @ColumnInfo(name = "content")
    var content: String,
    @ColumnInfo(name = "year")
    var year: Int,
    @ColumnInfo(name = "month")
    var month: Int,
    @ColumnInfo(name = "day")
    var day: Int,
    @ColumnInfo(name = "date")
    var date: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "check")
    var check: Boolean = false,
): Serializable
