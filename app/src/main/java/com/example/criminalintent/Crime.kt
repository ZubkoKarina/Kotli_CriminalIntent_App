package com.example.criminalintent

import java.util.Date
import java.util.UUID

data class Crime(
    val id: UUID,
    val titleval: String,
    val date: Date,
    val isSolved: Boolean
)
