package dev.swapnil.notetaker.ui.db

import androidx.lifecycle.LiveData

class NotesRepository(val Dao : NotesDao) {

    suspend fun getAllNotes(): LiveData<List<Notes>>{
        return Dao.getNotes()
    }

    suspend fun insertNotes(notes: Notes){
        return Dao.insertData(notes)
    }

    suspend fun deleteNotes(id:Int){
        return Dao.DeleteData(id)
    }

    suspend fun updateNotes(notes: Notes){
        return Dao.updateNotes(notes)
    }
}