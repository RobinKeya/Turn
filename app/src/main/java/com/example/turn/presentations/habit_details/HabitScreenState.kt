package com.example.turn.presentations.habit_details

import com.example.turn.domain.model.Habit

data class HabitScreenState(
    val habit: Habit ? =null,
    val isLoading: Boolean,
    val error : String? = null
)
