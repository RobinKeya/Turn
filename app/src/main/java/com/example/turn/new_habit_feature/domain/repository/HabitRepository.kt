package com.example.turn.new_habit_feature.domain.repository

import com.example.turn.new_habit_feature.data.local.PartialHabit
import com.example.turn.new_habit_feature.domain.model.Habit
import kotlinx.coroutines.flow.Flow

interface HabitRepository {
    suspend fun getAllHabits():Flow<List<Habit>>
    suspend fun getHabit(id:Int): Habit
    suspend fun addHabit(habit: Habit)
    suspend fun deleteHabit(id: Int)

    suspend fun updateHabit(partialHabit: PartialHabit)
}