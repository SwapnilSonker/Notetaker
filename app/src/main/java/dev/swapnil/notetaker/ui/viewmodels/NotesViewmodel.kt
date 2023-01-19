package dev.swapnil.notetaker.ui.viewmodels

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dev.swapnil.notetaker.ui.db.Notes
import dev.swapnil.notetaker.ui.db.NotesDatabase
import dev.swapnil.notetaker.ui.db.NotesRepository

class NotesViewmodel(application: Application):ViewModel() {

    val repository: NotesRepository
    init {
        val dao = NotesDatabase.getDatabaseInstance(application).myNotesDao()
        repository = NotesRepository(dao)
    }

    suspend fun addNotes(notes: Notes){
        return repository.insertNotes(notes)
    }

    suspend fun getNotes(): LiveData<List<Notes>> = repository.getAllNotes()


    suspend fun deleteNotes(id:Int){
        return repository.deleteNotes(id)
    }

    suspend fun updateNotes(notes: Notes){
        return repository.updateNotes(notes)
    }
}