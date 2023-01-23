package dev.swapnil.notetaker.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.viewModelScope
import androidx.navigation.Navigation
import dev.swapnil.notetaker.R
import dev.swapnil.notetaker.databinding.FragmentCreateNewBinding
import dev.swapnil.notetaker.ui.db.Notes
import dev.swapnil.notetaker.ui.viewmodels.NotesViewmodel
import kotlinx.coroutines.launch
import java.text.DateFormat
import java.util.*


class CreateNewFragment : Fragment() {

    lateinit var binding: FragmentCreateNewBinding
    var priority: String = "1"

    val viewmodel: NotesViewmodel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCreateNewBinding.inflate(layoutInflater , container , false)

        //by default
        binding.greenDotCreate.setImageResource(R.drawable.ic_baseline_done_24)

        binding.greenDotCreate.setOnClickListener {
            priority = "1"
            binding.greenDotCreate.setImageResource(R.drawable.ic_baseline_done_24)
            binding.pinkDotCreate.setImageResource(0)
            binding.redDotCreate.setImageResource(0)

        }

        binding.pinkDotCreate.setOnClickListener {

            priority = "2"
            binding.pinkDotCreate.setImageResource(R.drawable.ic_baseline_done_24)
            binding.greenDotCreate.setImageResource(0)
            binding.redDotCreate.setImageResource(0)

        }

        binding.redDotCreate.setOnClickListener {

            priority = "3"
            binding.redDotCreate.setImageResource(R.drawable.ic_baseline_done_24)
            binding.pinkDotCreate.setImageResource(0)
            binding.greenDotCreate.setImageResource(0)

        }


        binding.doneBtn.setOnClickListener {
            createNotes(it)
        }

        return binding.root
    }

    private fun createNotes(it: View?) {

        val title=binding.createTitle.text
        val subtitle = binding.createSubtitle.text
        val notes = binding.createNotes.text

        val d = Date()
        val notesDate: CharSequence = android.text.format.DateFormat.format("MMMM d , yyyy",
            d.time)

        //when notes are created they are immediately added to the database
        val data=Notes(
            null,
            title = title.toString(),
            subtitle = subtitle.toString(),
            notes = notes.toString(),
            date = notesDate.toString(),
            priority = priority
        )
        viewmodel.viewModelScope.launch {
            viewmodel.addNotes(data)
        }
        Toast.makeText(requireContext(),"note created successfully",Toast.LENGTH_SHORT).show()

        Navigation.findNavController(it!!).navigate(R.id.action_createNewFragment_to_homeFragment)
    }
}