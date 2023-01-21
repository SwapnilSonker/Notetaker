package dev.swapnil.notetaker.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.swapnil.notetaker.databinding.FragmentHomeBinding
import dev.swapnil.notetaker.ui.db.Notes

class NotesAdapter(requiesContext: Context,val notesList: List<Notes>) : RecyclerView.Adapter<NotesAdapter.notesViewholder>() {

    inner class notesViewholder(val binding: FragmentHomeBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): notesViewholder {
        return notesViewholder(FragmentHomeBinding.inflate(LayoutInflater.from(parent.context)
            ,parent,false))
    }



    override fun onBindViewHolder(holder: notesViewholder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount() : Int = notesList.size
}