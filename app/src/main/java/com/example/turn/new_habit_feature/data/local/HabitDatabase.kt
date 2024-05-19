package com.example.turn.new_habit_feature.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Habit::class],
    version=1,
    exportSchema = false
)
abstract class HabitDatabase : RoomDatabase() {
    abstract val dao : HabitDao
}