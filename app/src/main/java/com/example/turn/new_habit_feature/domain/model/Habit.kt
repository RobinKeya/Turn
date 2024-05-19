package com.example.turn.new_habit_feature.domain.model

data class Habit(
    val id : Int ? =0,
    val title : String,
    val dayCount : Int,
    val description : String,
    val shareWithOthers : Boolean,
    val numberOfDays : Int,
    val complete : Boolean = false
)
