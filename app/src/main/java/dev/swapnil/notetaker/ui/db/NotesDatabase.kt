package dev.swapnil.notetaker.ui.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Notes::class] , version = 1)
abstract class NotesDatabase:RoomDatabase() {

    abstract fun myNotesDao() : NotesDao

    companion object{
        @Volatile
        var INSTANCE : NotesDatabase?= null

        fun getDatabaseInstance(context: Context): NotesDatabase{
            val tempInstace = INSTANCE
            if(tempInstace != null){
                return tempInstace
            }
            synchronized(this)
            {
                val roomDatabaseInstance =
                    Room.databaseBuilder(context , NotesDatabase::class.java, "Notes").build()
                INSTANCE = roomDatabaseInstance
                return roomDatabaseInstance
            }
        }
    }
}