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
import androidx.navigation.fragment.navArgs
import com.example.mynotes.ui.Fragments.EditFragmentArgs
import dev.swapnil.notetaker.R
import dev.swapnil.notetaker.databinding.FragmentCreateNewBinding
import dev.swapnil.notetaker.databinding.FragmentEditBinding
import dev.swapnil.notetaker.ui.db.Notes
import dev.swapnil.notetaker.ui.viewmodels.NotesViewmodel
import kotlinx.coroutines.launch
import java.util.*


class EditFragment : Fragment() {

    val notes1 by navArgs<EditFragmentArgs>()
    lateinit var binding: FragmentEditBinding

    var priority: String = "1"


    val viewmodel: NotesViewmodel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentEditBinding.inflate(layoutInflater , container , false)

        binding.EditTitle.setText(notes1.data.title)
        binding.EditSubtitle.setText(notes1.data.subtitle)
        binding.EditNotes.setText(notes1.data.notes)

        when(notes1.data.priority){
            "1"->{
                priority = "1"
                binding.greenDotEdit.setImageResource(R.drawable.ic_baseline_done_24)
                binding.pinkDotEdit.setImageResource(0)
                binding.redDotEdit.setImageResource(0)
            }
            "2"->{
                priority = "2"
                binding.pinkDotEdit.setImageResource(R.drawable.ic_baseline_done_24)
                binding.greenDotEdit.setImageResource(0)
                binding.redDotEdit.setImageResource(0)
            }
            "3"->{
                priority = "1"
                binding.redDotEdit.setImageResource(R.drawable.ic_baseline_done_24)
                binding.pinkDotEdit.setImageResource(0)
                binding.greenDotEdit.setImageResource(0)
            }
        }

        binding.doneBtnEdit.setOnClickListener {
            updateNotes(it)
        }

        return binding.root
    }

    private fun updateNotes(it: View?) {

        val title = binding.EditTitle.text
        val subtitle = binding.EditSubtitle.text
        val notes = binding.EditNotes.text

        val d = Date()
        val notesDate: CharSequence = android.text.format.DateFormat.format(
            "MMMM d , yyyy",
            d.time
        )

        //when notes are updated they are immediately added to the database
        val data = Notes(
            notes1.data.id,
            title = title.toString(),
            subtitle = subtitle.toString(),
            notes = notes.toString(),
            date = notesDate.toString(),
            priority = priority
        )
        viewmodel.viewModelScope.launch {
            viewmodel.updateNotes(data)
        }
        Toast.makeText(requireContext(), "note updated successfully", Toast.LENGTH_SHORT).show()

        Navigation.findNavController(it!!).navigate(R.id.action_editFragment_to_homeFragment)
    }
}