package com.example.core.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.core.network.model.response.Drug

@Dao
interface DrugsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDrug(vararg drug: Drug)


    @Query("SELECT * FROM drugs_table")
    fun getAllDrugs(): List<Drug>


    @Query("DELETE FROM drugs_table")
    fun deleteAllDrugs()
}