package com.example.turn.presentations.new_habits

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.turn.di.MainDispatcher
import com.example.turn.domain.model.Habit
import com.example.turn.domain.usecases.AddNewHabitUseCase
import com.example.turn.domain.usecases.GetAllHabitsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class NewHabitViewModel @Inject constructor(
    private val addNewHabitUseCase: AddNewHabitUseCase,
    @MainDispatcher private val dispatcher: CoroutineDispatcher,
    private val getAllHabitsUseCase: GetAllHabitsUseCase
): ViewModel() {
     val title = mutableStateOf("")
     val description = mutableStateOf("")
     val shareWithOthers = mutableStateOf(false)
    val numberOfDays = mutableStateOf("")

    private val _state = mutableStateOf(AddNewHabitScreenState(
        habits = emptyFlow(),
        isLoading = true
    ))
    val state get() = _state
    val exception = CoroutineExceptionHandler{_, exception->
        _state.value = _state.value.copy(
            habits = emptyFlow(),
            isLoading = false,
            error = exception.localizedMessage
        )
    }

    init {
        viewModelScope.launch (dispatcher){
            val habits = getAllHabits()
            _state.value = _state.value.copy(
                habits = habits,
                isLoading = false
            )
        }
    }
     fun addNewHabit(habit: Habit){
        viewModelScope.launch (dispatcher){
            addNewHabitUseCase(habit)
        }
    }
    private suspend fun getAllHabits(): Flow<List<Habit>> {
        return withContext(dispatcher){
            return@withContext getAllHabitsUseCase()
        }
    }
}