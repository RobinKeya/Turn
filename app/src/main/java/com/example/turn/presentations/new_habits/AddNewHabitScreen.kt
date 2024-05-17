package com.example.turn.presentations.new_habits

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.turn.R
import com.example.turn.domain.model.Habit
import java.lang.Integer.parseInt

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AddNewHabitScreen(
    viewModel: NewHabitViewModel,
    addHabit: (
        habit: Habit
    )->Unit) {
    Scaffold(topBar = { TopAppBar()}) {
        Column {
            Spacer(modifier = Modifier.height(40.dp))
            OutlinedTextField(
                value = viewModel.title.value,
                onValueChange = { newValue ->
                    viewModel.title.value = newValue
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                singleLine=true,
                maxLines = 1
            )
           Spacer(modifier = Modifier.height(8.dp))
            
            OutlinedTextField(
                value = viewModel.description.value,
                onValueChange = { newValue ->
                    viewModel.description.value = newValue
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                singleLine=false,
                maxLines = 6
            )
            Spacer(modifier = Modifier.height(8.dp))
            
            Row(horizontalArrangement = Arrangement.Start) {
                Checkbox(
                    checked = viewModel.shareWithOthers.value,
                    onCheckedChange = {
                        viewModel.shareWithOthers.value = !viewModel.shareWithOthers.value
                    }
                )
                Text(text = stringResource(id = R.string.share_with))
            }
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Row(horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = stringResource(id = R.string.days_num))
                OutlinedTextField(
                    value = viewModel.numberOfDays.value,
                    onValueChange = { newValue->
                        viewModel.numberOfDays.value = newValue
                    }
                )
            }
            val title = viewModel.title.value
            val description = viewModel.description.value
            val shareWithPeers = viewModel.shareWithOthers.value
            //todo: Check on this, can be a source of bug
            val numberOfDays =parseInt( viewModel.numberOfDays.value)

            val habit = Habit(
                title = title,
                description = description,
                dayCount = 0,
                shareWithOthers = shareWithPeers,
                numberOfDays = numberOfDays
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                onClick = { addHabit(habit) }
            ) {
                Text(text = stringResource(id = R.string.create_habit_btn))
            }
        }
    }
}

@Composable
fun TopAppBar() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(text = stringResource(id = R.string.new_habit))
    }
}