package dev.swapnil.notetaker.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import dev.swapnil.notetaker.R
import dev.swapnil.notetaker.databinding.FragmentHomeBinding
import dev.swapnil.notetaker.ui.viewmodels.NotesViewmodel
import kotlinx.coroutines.launch


class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    val viewmodel: NotesViewmodel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(layoutInflater,container ,false)


        viewmodel.viewModelScope.launch {
            viewmodel.getNotes().observe(viewLifecycleOwner) { notesList ->
                binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
                binding.recyclerView.adapter
            }
        }
        binding.addBtn.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_createNewFragment)
        }

        return binding.root
    }
}