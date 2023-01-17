package dev.swapnil.notetaker.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.swapnil.notetaker.databinding.FragmentCreateNewBinding


class CreateNewFragment : Fragment() {

    lateinit var binding: FragmentCreateNewBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCreateNewBinding.inflate(layoutInflater , container , false)

        binding.doneBtn.setOnClickListener {  }

        return binding.root
    }
}