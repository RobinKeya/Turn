package com.example.turn.data.mappers


import com.example.turn.domain.model.Habit
import kotlinx.coroutines.flow.Flow

fun com.example.turn.data.local.Habit.toHabit(): Habit {
    return Habit(
        id = id!!,
        title = title,
        dayCount = dayCount,
        description= description,
        shareWithOthers = shareWithOthers,
        numberOfDays = numberOfDays
    )
}
 fun Habit.toLocalHabit(): com.example.turn.data.local.Habit{
    return com.example.turn.data.local.Habit(
        id, title,description,dayCount,shareWithOthers,numberOfDays
    )
}
