package com.polynomialx2.kennelmanager.database

import android.app.Application
import android.arch.lifecycle.LiveData
import android.os.AsyncTask

class KennelManagerRepository(application: Application) {

    private val dogDao: DogDao
    private val allDogs: LiveData<Array<Dog>>

    init {
        val db: KennelDatabase = KennelDatabase.getInstance(application)!!
        dogDao = db.dogDao()
        allDogs = dogDao.getAllDogs()
    }

    fun getAllDogs(): LiveData<Array<Dog>> {
        return allDogs
    }

    fun insert(dog: Dog) = insertAsyncTask(dogDao).execute(dog)

    private class insertAsyncTask(dao: DogDao): AsyncTask<Dog, Void, Void>() {

        private val dogDao = dao

        override fun doInBackground(vararg dogs: Dog?): Void? {
            dogDao.insert(dogs[0]!!)
            return null
        }


    }
}