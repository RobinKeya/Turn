package com.example.turn.presentations.home_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.turn.R
import com.example.turn.ui.theme.Typography

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(onClick : (id: Int)->Unit) {
    Scaffold(modifier = Modifier.fillMaxSize()) {
        LazyVerticalGrid(columns = GridCells.Fixed(2)){
            item {
                Card(
                    elevation = CardDefaults.cardElevation(4.dp),
                    modifier = Modifier
                        .padding(4.dp)
                        .clickable { onClick(0) }
                ) {
                    Column {
                        Image(imageVector = Icons.Default.Place,
                            contentDescription ="placeHolder" )
                        Text(text = stringResource(id = R.string.new_routine),
                            style = Typography.titleLarge)
                    }
                }
                Card(
                    modifier = Modifier.padding(4.dp).clickable { onClick(1) },
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Column {
                        Image(imageVector = Icons.Default.Place,
                            contentDescription ="placeHolder" )
                        Text(text = stringResource(id = R.string.leave_habit),
                            style = Typography.titleLarge)
                    }
                }
                Card(
                    modifier = Modifier.padding(4.dp).clickable { onClick(2) },
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Column {
                        Image(imageVector = Icons.Default.Place,
                            contentDescription ="placeHolder" )
                        Text(text = stringResource(id = R.string.new_routine),
                            style = Typography.titleLarge)
                    }
                }
                Card(
                    modifier = Modifier.padding(4.dp).clickable { onClick(3) },
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Column {
                        Image(imageVector = Icons.Default.Place,
                            contentDescription ="placeHolder" )
                        Text(text = stringResource(id = R.string.new_routine),
                            style = Typography.titleLarge)
                    }
                }

            }
        }
    }
}