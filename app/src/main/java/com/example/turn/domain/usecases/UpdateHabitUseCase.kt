package com.example.turn.domain.usecases

import com.example.turn.data.local.PartialHabit
import com.example.turn.di.IODispatcher
import com.example.turn.domain.repository.HabitRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UpdateHabitUseCase @Inject constructor(
    private val repository: HabitRepository,
    @IODispatcher private val dispatcher: CoroutineDispatcher
) {
    suspend operator fun invoke(partialHabit: PartialHabit){
        withContext(dispatcher){
            repository.updateHabit(partialHabit)
        }
    }
}