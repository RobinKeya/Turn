package com.example.turn.new_habit_feature.presentations.new_habits

import com.example.turn.new_habit_feature.domain.model.Habit
import kotlinx.coroutines.flow.Flow

data class AddNewHabitScreenState(
    val habits : Flow<List<Habit>>,
    val isLoading : Boolean,
    val error : String ? = null
)
