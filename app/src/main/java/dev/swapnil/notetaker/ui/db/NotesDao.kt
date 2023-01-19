package dev.swapnil.notetaker.ui.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NotesDao {

    @Insert()
    suspend fun insertData(notes: Notes)

    @Query("SELECT * FROM Notes")
    suspend fun getNotes():LiveData<List<Notes>>

    @Query("DELETE FROM Notes WHERE id=:id")
    suspend fun DeleteData(id: Int)

    @Update
    suspend fun updateNotes(notes:Notes)
}