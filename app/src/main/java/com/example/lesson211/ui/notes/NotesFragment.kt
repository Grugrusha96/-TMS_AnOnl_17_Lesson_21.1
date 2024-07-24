package com.example.lesson211.ui.notes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.lesson211.databinding.FragmentNotesBinding
private const val ID_NOTES_ARG = "idNotes"
class NotesFragment: Fragment(){

    private var  binding: FragmentNotesBinding? = null

    private val viewModel : NotesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentNotesBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.notes.observe(viewLifecycleOwner){notes->
            binding?.userName?.text = notes.name
            binding?.textMessage?.text = notes.text
            binding?.textMessageData?.text = notes.date
        }
        arguments?.getInt(ID_NOTES_ARG)?.let {id ->
            viewModel.getNotesById(id)
        }
    }
    companion object{
        fun getFragment(id: Int): NotesFragment {
            return NotesFragment().apply {
                arguments = bundleOf(ID_NOTES_ARG to id)
            }
        }
    }
}