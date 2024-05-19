package com.example.turn.common

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.turn.new_habit_feature.data.local.PartialHabit
import com.example.turn.composables.HabitDetailScreen
import com.example.turn.new_habit_feature.presentations.habit_details.HabitDetailsViewModel
import com.example.turn.composables.HomeScreen
import com.example.turn.new_habit_feature.presentations.leave_habit.LeaveHabitScreen
import com.example.turn.composables.AddNewHabitScreen
import com.example.turn.new_habit_feature.presentations.new_habits.NewHabitViewModel
import com.example.turn.composables.NewHabitsScreen

@Composable
fun Navigation(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = Constants.HOME_SCREEN
    ){
        composable(route= Constants.HOME_SCREEN){
            HomeScreen(){id ->
                when(id){
                    1->navHostController.navigate(Constants.NEW_HABITS_SCREEN)
                    2->navHostController.navigate(Constants.LEAVE_HABITS_SCREEN)
                    3->navHostController.navigate(Constants.PROFILE_SCREEN)
                    4->navHostController.navigate(Constants.VIEW_PEERS_SCREEN)
                }
            }
        }
        composable(route = Constants.NEW_HABITS_SCREEN){
            val vm : NewHabitViewModel = hiltViewModel()
            NewHabitsScreen(vm.state.value, onClick = {
                navHostController.navigate(Constants.ADD_NEW_HABITS_SCREEN)
            }){id->
               navHostController.navigate("${Constants.NEW_HABITS_SCREEN}/$id")
            }
        }
        composable(route = "${Constants.NEW_HABITS_SCREEN}/{id}",
            arguments = listOf(navArgument("id"){
                type= NavType.IntType
            })
        ){
            val vm : HabitDetailsViewModel = hiltViewModel()
            HabitDetailScreen(habitDetailsState = vm.state.value ){
                id,day,numberOfDays->

                vm.updateHabit(partialHabit = PartialHabit(id, daysCount = day, isComplete = false))
            }
        }
        composable(route= Constants.LEAVE_HABITS_SCREEN){
            LeaveHabitScreen()
        }
        composable(route = Constants.ADD_NEW_HABITS_SCREEN){
            val vm : NewHabitViewModel = hiltViewModel()
            AddNewHabitScreen(viewModel =vm){it->
                vm.addNewHabit(it)
            }
        }
        composable(route = Constants.PROFILE_SCREEN){
            //todo: make composable with the same
        }
        composable(route = Constants.VIEW_PEERS_SCREEN){
            //todo: make composable with the same
        }
    }
}