package com.example.turn.data.local

import androidx.room.ColumnInfo

data class PartialHabit(
    val id : Int,
    @ColumnInfo("days_count")
    val daysCount : Int,
    val isComplete : Boolean,
    //todo: Update this on the next iteration
//    @ColumnInfo("share_with_others")
//    val shareWithOthers : Boolean,
)
