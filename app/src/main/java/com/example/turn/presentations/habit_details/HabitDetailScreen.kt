package com.example.turn.presentations.habit_details

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.turn.ui.theme.Typography

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HabitDetailScreen(
    habitDetailsState: HabitScreenState,
    onDayClick: (id: Int,day: Int,numberOfDays: Int) -> Unit
) {
    Scaffold(topBar = { habitDetailsState.habit?.let { TopAppBar(title = it.title) } }) {
        Column {
           val habit = habitDetailsState.habit
            if (habit != null) {
                val countArray = mutableListOf<Int>()
                for (i in 1 .. habit.numberOfDays){
                    countArray.add(i)
                }
                LazyHorizontalGrid(rows = GridCells.Fixed(7)){
                    items(countArray){id->
                        Day(
                            day = id,
                            dayCount = habit.dayCount,
                            onDayClick = { habit.id?.let { it1 -> onDayClick(it1,id + 1,habit.numberOfDays) } }
                        )
                    }
                }

            }
        }
    }
}
@Composable
fun TopAppBar(title: String){
    Row(horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()){
        Text(text = title,style = Typography.titleLarge)
    }
}

@Composable
fun Day(day: Int, dayCount: Int, onDayClick : (day: Int)->Unit) {
    Box(
        modifier = Modifier
            .size(40.dp)
            .clip(CircleShape)
            .background(if (day <= dayCount) Color.LightGray else Color.White)
            .clickable { onDayClick(day) }
            .padding(4.dp)
    ) {
        Text(text = day.toString(), style = Typography.bodyLarge)
    }
}