package com.example.criminalintent

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.Date
import java.util.UUID

class CrimeListViewModel : ViewModel() {
    private val crimeRepository = CrimeRepository.get()
    val crimes = mutableListOf<Crime>()
    init {
        viewModelScope.launch {
            crimes += loadCrimes()
        }
    }
    suspend fun loadCrimes(): List<Crime> {
        return crimeRepository.getCrimes()
    }
}
