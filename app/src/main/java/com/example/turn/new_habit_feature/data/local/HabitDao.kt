package com.example.turn.new_habit_feature.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.turn.new_habit_feature.data.local.Habit
import kotlinx.coroutines.flow.Flow

@Dao
interface HabitDao {
    @Query("SELECT * FROM habit_table")
    suspend fun getAll(): Flow<List<Habit>>
    @Query("SELECT * FROM  habit_table WHERE id == :id")
    suspend fun getHabit(id: Int): Habit
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addHabit(habit: Habit)

    @Query("DELETE FROM habit_table WHERE id == :id")
    suspend fun deleteHabit(id: Int)

    @Insert(entity = Habit::class)
    suspend fun updateHabit(partialHabit: PartialHabit)
}