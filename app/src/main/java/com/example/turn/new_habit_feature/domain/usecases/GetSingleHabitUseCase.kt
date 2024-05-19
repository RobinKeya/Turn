package com.example.turn.new_habit_feature.domain.usecases

import com.example.turn.di.IODispatcher
import com.example.turn.new_habit_feature.domain.model.Habit
import com.example.turn.new_habit_feature.domain.repository.HabitRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetSingleHabitUseCase @Inject constructor(
    private val repository: HabitRepository,
    @IODispatcher private val dispatcher : CoroutineDispatcher
) {
    suspend operator fun invoke(id: Int): Habit {
        return withContext(dispatcher){
            return@withContext repository.getHabit(id)
        }
    }
}