package com.example.turn.new_habit_feature.presentations.habit_details

import com.example.turn.new_habit_feature.domain.model.Habit

data class HabitScreenState(
    val habit: Habit? =null,
    val isLoading: Boolean,
    val error : String? = null
)
