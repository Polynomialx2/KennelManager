package com.polynomialx2.kennelmanager.database

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

interface DogDao {

    @Insert
    fun insert(dog: Dog)

    @Query("SELECT * FROM Dog WHERE Present = 1 ORDER BY Name ASC")
    fun getBoardedDogs(): Array<Dog>

    @Query("SELECT * FROM Dog " +
            "LEFT JOIN Breed " +
            "ON Dog.BreedID = Breed.BreedID " +
            "LEFT JOIN Owner " +
            "ON Dog.OwnerID = Owner.OwnerID " +
            "ORDER BY Attributes.Name ASC")
    fun getAllDogs(): LiveData<Array<DogWithBreedAndOwner>>
}