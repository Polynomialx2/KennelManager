package com.polynomialx2.kennelmanager.database

import android.arch.persistence.room.Embedded

data class DogWithBreedAndOwner(
        @Embedded val dog: Dog,
        @Embedded val breed: Breed,
        @Embedded val owner: Owner
)