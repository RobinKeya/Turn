package com.example.turn.new_habit_feature.data.repository

import com.example.turn.new_habit_feature.data.local.HabitDao
import com.example.turn.new_habit_feature.data.local.PartialHabit
import com.example.turn.new_habit_feature.data.mappers.toHabit
import com.example.turn.new_habit_feature.data.mappers.toLocalHabit
import com.example.turn.new_habit_feature.domain.model.Habit
import com.example.turn.new_habit_feature.domain.repository.HabitRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class HabitRepositoryImpl @Inject constructor(
    private val habitDao: HabitDao
) : HabitRepository {
    override suspend fun getAllHabits(): Flow<List<Habit>> {
       return habitDao.getAll().map { habitDtoList->
           habitDtoList.map { it.toHabit() }
       }
    }

    override suspend fun getHabit(id: Int): Habit {
        return habitDao.getHabit(id).toHabit()
    }

    override suspend fun addHabit(habit: Habit) {
        habitDao.addHabit(habit.toLocalHabit())
    }

    override suspend fun deleteHabit(id: Int) {
        habitDao.deleteHabit(id)
    }

    override suspend fun updateHabit(partialHabit: PartialHabit) {
        habitDao.updateHabit(partialHabit)
    }

}