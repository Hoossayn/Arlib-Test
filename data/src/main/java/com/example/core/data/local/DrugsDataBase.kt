package com.example.core.data.local


import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.core.network.model.response.Drug


@Database(entities = [Drug::class], version = 1, exportSchema = false)
abstract class DrugsDataBase : RoomDatabase() {

    abstract fun getDrugsDao(): DrugsDao

}