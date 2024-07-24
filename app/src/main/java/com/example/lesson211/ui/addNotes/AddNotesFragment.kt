package com.example.lesson211.ui.addNotes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.lesson211.databinding.FragmentAddNotesBinding

class AddNotesFragment : Fragment() {

private var binding: FragmentAddNotesBinding? = null

private val viewModel: AddNotesViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
       return FragmentAddNotesBinding.inflate(inflater, container, false).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.notesAdded.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), "Заметка добавлена", Toast.LENGTH_SHORT).show()
            parentFragmentManager.popBackStack()
        }
        viewModel.error = {
            Toast.makeText(requireContext(), "Заметка не добавлена", Toast.LENGTH_SHORT).show()
        }
        binding?.run {
            addNotesButton.setOnClickListener {
                viewModel.addNotes(
                    name =  nameEditText.text.toString(),
                    text = textEditText.text.toString(),
                    data = dateEditText.text.toString()
                )

            }
        }
    }
}