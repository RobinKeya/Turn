package com.example.turn.domain.repository

import com.example.turn.data.local.PartialHabit
import com.example.turn.domain.model.Habit
import kotlinx.coroutines.flow.Flow

interface HabitRepository {
    suspend fun getAllHabits():Flow<List<Habit>>
    suspend fun getHabit(id:Int):Habit
    suspend fun addHabit(habit: Habit)
    suspend fun deleteHabit(id: Int)

    suspend fun updateHabit(partialHabit: PartialHabit)
}