package com.polynomialx2.kennelmanager.database

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull

@Entity
data class Owner(
        @PrimaryKey(autoGenerate = true) @NonNull @ColumnInfo(name = "OwnerID") val ownerID: Int,
        @ColumnInfo(name = "FirstName") val firstName: String,
        @ColumnInfo(name = "LastName") val lastName: String
)