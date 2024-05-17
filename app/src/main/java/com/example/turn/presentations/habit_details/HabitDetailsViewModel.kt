package com.example.turn.presentations.habit_details

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.turn.data.local.PartialHabit
import com.example.turn.di.MainDispatcher
import com.example.turn.domain.usecases.GetSingleHabitUseCase
import com.example.turn.domain.usecases.UpdateHabitUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HabitDetailsViewModel @Inject constructor(
    private val getSingleHabitUseCase: GetSingleHabitUseCase,
    @MainDispatcher private val dispatcher: CoroutineDispatcher,
    savedStateHandle: SavedStateHandle,
    private val updateHabitUseCase: UpdateHabitUseCase
): ViewModel() {
    private val _state = mutableStateOf(HabitScreenState(
        isLoading = true,
    ))
    val state get() = _state
    private val exception = CoroutineExceptionHandler{_, exception->
            _state.value = _state.value.copy(
                habit = null,
                isLoading = false,
                error = exception.localizedMessage
            )
    }
    init {
       val id = savedStateHandle.get<Int>("id") ?: 0
        viewModelScope.launch(dispatcher + exception) {
            val habit = getSingleHabitUseCase(id)
            _state.value = _state.value.copy(
                habit = habit,
                isLoading = false
            )
        }
    }
    fun updateHabit(partialHabit: PartialHabit){
        viewModelScope.launch(dispatcher){
            updateHabitUseCase(partialHabit)
        }
    }
}