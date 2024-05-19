package com.example.turn.new_habit_feature.domain.usecases

import com.example.turn.di.IODispatcher
import com.example.turn.new_habit_feature.domain.model.Habit
import com.example.turn.new_habit_feature.domain.repository.HabitRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AddNewHabitUseCase @Inject constructor(
    @IODispatcher private val dispatcher: CoroutineDispatcher,
    private val repository: HabitRepository
) {
    suspend operator fun invoke(habit: Habit){
        withContext(dispatcher){
            repository.addHabit(habit)
        }
    }
}