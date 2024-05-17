package com.example.turn.domain.usecases

import com.example.turn.di.IODispatcher
import com.example.turn.domain.model.Habit
import com.example.turn.domain.repository.HabitRepository
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