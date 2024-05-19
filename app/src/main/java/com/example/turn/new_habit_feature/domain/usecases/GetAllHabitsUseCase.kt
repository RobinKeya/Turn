package com.example.turn.new_habit_feature.domain.usecases

import com.example.turn.di.IODispatcher
import com.example.turn.new_habit_feature.domain.model.Habit
import com.example.turn.new_habit_feature.domain.repository.HabitRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.combineTransform
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toCollection
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetAllHabitsUseCase @Inject constructor(
    private val repository: HabitRepository,
    @IODispatcher private val dispatcher : CoroutineDispatcher
) {
    suspend operator fun invoke(): Flow<List<Habit>>{
        return withContext(dispatcher){
            return@withContext repository.getAllHabits()
        }
    }
}