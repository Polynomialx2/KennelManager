package com.polynomialx2.kennelmanager.database

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull

@Entity(
        foreignKeys = [
                ForeignKey(entity = Breed::class, parentColumns = ["BreedID"], childColumns = ["BreedID"]),
                ForeignKey(entity = Owner::class, parentColumns = ["OwnerID"], childColumns = ["OwnerID"])
        ]
)
data class Dog(
        @PrimaryKey(autoGenerate = true) @NonNull @ColumnInfo(name = "DogID") val dogID: Int,
        @ColumnInfo(name = "Name") val name: String,
        @ColumnInfo(name = "BreedID") val breedID: Int,
        @ColumnInfo(name = "Present") val present: Boolean,
        @ColumnInfo(name = "OwnerID") val ownerID: Int,
        @ColumnInfo(name = "ToyAggressive") val toyAggressive: Boolean,
        @ColumnInfo(name = "FoodAggressive") val foodAggressive: Boolean,
        @ColumnInfo(name = "Frisky") val frisky: Boolean,
        @ColumnInfo(name = "HardToCatch") val hardToCatch: Boolean,
        @ColumnInfo(name = "FamilyGroupOnly") val familyGroupOnly: Boolean,
        @ColumnInfo(name = "ExcludedFromGroup") val excludedFromGroup: Boolean
)