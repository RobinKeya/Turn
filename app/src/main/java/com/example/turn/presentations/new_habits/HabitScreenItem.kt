package com.example.turn.presentations.new_habits

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.turn.domain.model.Habit

@Composable
fun HabitScreenItem(habit: Habit,onCardClick: (id: Int)->Unit) {
    Card(
        modifier = Modifier.fillMaxWidth().height(60.dp).padding(4.dp)
            .clickable { onCardClick(habit.id!!) }
    ) {

        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(text = habit.title)
            Text(text= "Day ${habit.dayCount} of ${habit.numberOfDays}")
        }
    }
}