package com.example.turn.presentations.new_habits

import com.example.turn.domain.model.Habit
import kotlinx.coroutines.flow.Flow

data class AddNewHabitScreenState(
    val habits : Flow<List<Habit>>,
    val isLoading : Boolean,
    val error : String ? = null
)
