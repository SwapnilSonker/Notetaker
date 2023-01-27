package dev.swapnil.notetaker.ui.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NotesDao {

    @Insert()
     fun insertData(notes: Notes)

    @Query("SELECT * FROM Notes")
     fun getNotes():LiveData<List<Notes>>

    @Query("DELETE FROM Notes WHERE id=:id")
     fun DeleteData(id: Int)

    @Update
     fun updateNotes(notes:Notes)
}