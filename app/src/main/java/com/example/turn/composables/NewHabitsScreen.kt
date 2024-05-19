package com.example.turn.composables

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.turn.R
import com.example.turn.new_habit_feature.presentations.new_habits.AddNewHabitScreenState

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NewHabitsScreen(
    newHabitScreenState: AddNewHabitScreenState,
    onClick: () -> Unit,
    onCardClick : (id: Int)->Unit
) {
    Scaffold(
        floatingActionButton = { FloatingActionButton(onClick) },
        floatingActionButtonPosition = FabPosition.End) {
        val habits = newHabitScreenState.habits.collectAsState(initial =listOf() ).value
        LazyColumn(contentPadding = PaddingValues(vertical = 4.dp)){
            items(habits){habit->
               HabitScreenItem(habit = habit, onCardClick={ habit.id?.let { it1 -> onCardClick(it1) } } )
            }
        }
    }
}

@Composable
fun FloatingActionButton(onClick : ()->Unit) {
    Box(modifier = Modifier
        .size(40.dp)
        .clip(CircleShape)
        .background(color = Color.Blue)
        .padding(8.dp)
        .clickable { onClick() }
    ) {
        Image(
            painter = painterResource(id = R.drawable.baseline_add_24),
            contentDescription = stringResource(id = R.string.add_btn)
        )
    }
}