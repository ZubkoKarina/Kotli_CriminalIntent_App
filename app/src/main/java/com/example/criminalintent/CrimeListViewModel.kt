package com.example.criminalintent

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.util.Date
import java.util.UUID

class CrimeListViewModel : ViewModel() {
    val crimes = mutableListOf<Crime>()
    init {
        viewModelScope.launch {
            for (i in 0 until 100) {
                val crime = Crime(
                    id = UUID.randomUUID(),
                    title = "Crime #$i",
                    date = Date(),
                    isSolved = i % 2 == 0,
                    requiresPolice = i % 5 == 0
                )
                crimes += crime
            }
        }
    }
}