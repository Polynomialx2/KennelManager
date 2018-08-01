package com.polynomialx2.kennelmanager.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.polynomialx2.kennelmanager.helpers.KennelManagerConstants

@Database(entities = [Dog::class, Breed::class, Owner::class], version = 1)
abstract class KennelDatabase: RoomDatabase() {

    abstract fun dogDao(): DogDao

    companion object {
        private var INSTANCE: KennelDatabase? = null

        fun getInstance(context: Context): KennelDatabase? {
            if (INSTANCE == null) {
                synchronized(KennelDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            KennelDatabase::class.java,
                            KennelManagerConstants.DATABASE_NAME
                            ).build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}