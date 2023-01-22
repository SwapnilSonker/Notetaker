package dev.swapnil.notetaker.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.swapnil.notetaker.R
import dev.swapnil.notetaker.databinding.FragmentHomeBinding
import dev.swapnil.notetaker.databinding.ItemListBinding
import dev.swapnil.notetaker.ui.db.Notes

class NotesAdapter(requiesContext: Context,val notesList: List<Notes>) : RecyclerView.Adapter<NotesAdapter.notesViewholder>() {

    inner class notesViewholder(val binding: ItemListBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): notesViewholder {
        return notesViewholder(
            ItemListBinding.inflate(LayoutInflater.from(parent.context)
            ,parent,false))
    }



    override fun onBindViewHolder(holder: notesViewholder, position: Int) {
        val data = notesList[position]
        with(holder) {
            binding.titleofnotes.text = data.title
            binding.notestext.text= data.notes
            binding.dateView.text=data.date
        }
        when(data.priority){
            "1"->{
                holder.binding.viewPriority.setBackgroundResource(R.drawable.green_dot)
            }
            "2"->{
                holder.binding.viewPriority.setBackgroundResource(R.drawable.pink_dot)
            }
            "3"->{
                holder.binding.viewPriority.setBackgroundResource(R.drawable.red_dot)
            }
        }
    }

    override fun getItemCount() : Int = notesList.size
}