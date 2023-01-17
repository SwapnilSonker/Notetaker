package dev.swapnil.notetaker.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import dev.swapnil.notetaker.R
import dev.swapnil.notetaker.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(layoutInflater,container ,false)

        binding.addBtn.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_createNewFragment)
        }

        return binding.root
    }
}