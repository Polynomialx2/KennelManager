package com.polynomialx2.kennelmanager.database

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull

data class Breed(
        @PrimaryKey(autoGenerate = true) @NonNull @ColumnInfo(name = "BreedID") val breedID: Int,
        @ColumnInfo(name = "BreedName") val breedName: String
)