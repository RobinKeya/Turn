package com.example.turn.new_habit_feature.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "habit_table")
data class Habit(
    @PrimaryKey(autoGenerate = true)
    val id  : Int ?,
    val title : String,
    val description : String,
    @ColumnInfo("day_count")
    val dayCount : Int =0,
    @ColumnInfo("share_with_others")
    val shareWithOthers : Boolean,
    @ColumnInfo("number_of_days")
    val numberOfDays : Int,
    val complete : Boolean = false
)
